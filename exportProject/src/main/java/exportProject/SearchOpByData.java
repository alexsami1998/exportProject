package exportProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SearchOpByData {

	public static void searchAndDisplayDataByOP(String op) {
		String ref = null;
		String opN = op;
		String qntd = null;
		String sts = null;
		try {
			FileInputStream fis = new FileInputStream(new File("dados.xlsx"));
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet("Entrada");

			Iterator<Row> iterator = sheet.iterator();

			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				Cell opCell = currentRow.getCell(2); // Coluna OP

				if (opCell != null && opCell.getCellType() == CellType.STRING) {
					String opValue = opCell.getStringCellValue();

					if (opValue.equals(op)) {
						// Se a OP encontrada corresponder à OP fornecida
						ref = currentRow.getCell(1).getStringCellValue();
						qntd = currentRow.getCell(3).getStringCellValue();
						sts = currentRow.getCell(8).getStringCellValue();
						System.out.println("Dados encontrados na Entrada:");
						System.out.println("Data: " + currentRow.getCell(0));
						System.out.println("Referencia: " + ref);
						System.out.println("OP: " + opValue);
						System.out.println("Quantidade: " + qntd);
						System.out.println("FRENT: " + currentRow.getCell(4));
						System.out.println("TRAS: " + currentRow.getCell(5));
						System.out.println("SIL/BOR: " + currentRow.getCell(6));
						System.out.println("Kamb: " + currentRow.getCell(7));
						System.out.println("Status: " + sts);
						workbook.close();
						fis.close();
						ManagerDataAloc.addEntryAloc(ref, opN, qntd, sts); // Exclui a linha da planilha "Entrada"
						
						//int nowOp = sheet.removeRow(null);
						return; // Encontrou a linha, não é necessário continuar a busca
					}
				}
			}

			// Se não encontrou uma linha com a OP fornecida
			System.out.println("Nenhuma entrada encontrada para a OP: " + op);

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

		searchAndDisplayDataByOP(opDesejada);
	}
}
