package exportProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ManagerDelete {

	public static void ManagerDelete(int rowNumber) {
        try (FileInputStream fis = new FileInputStream("dados.xlsx");
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet("Dados");

            if (sheet != null) {
                int lastRowNum = sheet.getLastRowNum();

                if (rowNumber >= 0 && rowNumber <= lastRowNum) {
                    sheet.removeRow(sheet.getRow(rowNumber));
                } else {
                    System.out.println("Número de linha fora do intervalo.");
                }

                sheet.shiftRows(rowNumber + 1, lastRowNum, -1);
            } else {
                System.out.println("A planilha 'Dados' não existe no arquivo.");
            }

            try (FileOutputStream fileOut = new FileOutputStream("dados.xlsx")) {
                workbook.write(fileOut);
                System.out.println("Linha removida com sucesso.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número da linha que deseja remover: ");
        int rowNumber = scanner.nextInt();
        ManagerDelete(rowNumber);
        scanner.close();
    }
}