package exportProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HistoryData {

    public static void migrateOp(String op, String sourceSheetName, String targetSheetName) {
        try {
            FileInputStream fis = new FileInputStream(new File("dados.xlsx"));
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sourceSheet = workbook.getSheet(sourceSheetName);
            Sheet targetSheet = workbook.getSheet(targetSheetName);

            Iterator<Row> iterator = sourceSheet.iterator();

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Cell opCell = currentRow.getCell(2); // Coluna OP

                if (opCell != null && opCell.getCellType() == CellType.STRING) {
                    String opValue = opCell.getStringCellValue();

                    if (opValue.equals(op)) {
                        // Encontrou a OP na planilha de origem
                        // Mova a linha para a planilha de destino
                        Row newRow = targetSheet.createRow(targetSheet.getLastRowNum() + 1);
                        Iterator<Cell> cellIterator = currentRow.cellIterator();
                        int cellIndex = 0;
                        while (cellIterator.hasNext()) {
                            Cell cell = cellIterator.next();
                            Cell newCell = newRow.createCell(cellIndex++);
                            newCell.setCellValue(cell.getStringCellValue());
                        }

                        // Registre a migração no histórico
                        Sheet historySheet = workbook.getSheet("Historico");
                        Row historyRow = historySheet.createRow(historySheet.getLastRowNum() + 1);
                        historyRow.createCell(0).setCellValue(op);
                        historyRow.createCell(1).setCellValue(sourceSheetName);
                        historyRow.createCell(2).setCellValue(targetSheetName);
                        historyRow.createCell(3).setCellValue(new Date().toString());

                        // Remova a linha da planilha de origem
                        sourceSheet.removeRow(currentRow);

                        // Salve as alterações no arquivo Excel
                        FileOutputStream fos = new FileOutputStream(new File("dados.xlsx"));
                        workbook.write(fos);
                        fos.close();
                        workbook.close();
                        fis.close();
                        System.out.println("OP " + op + " movida de " + sourceSheetName + " para " + targetSheetName);
                        return;
                    }
                }
            }

            // Se não encontrou uma linha com a OP fornecida na planilha de origem
            System.out.println("Nenhuma entrada encontrada para a OP " + op + " na planilha " + sourceSheetName);

            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a OP desejada: ");
        String opDesejada = scanner.nextLine();
        
        // Suponha que você queira mover a OP para a planilha "Alocação"
        migrateOp(opDesejada, "Entrada", "Alocação");
    }
}
