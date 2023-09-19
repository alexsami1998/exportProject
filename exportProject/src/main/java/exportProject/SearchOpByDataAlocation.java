package exportProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SearchOpByDataAlocation {

	public static void searchAndDisplayDataByAlocation(String op) {
		String ref = null;
		String opN = op;
		String sts = null;
		try {
			FileInputStream fis = new FileInputStream(new File("dados.xlsx"));
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet("Alocacao");

			Iterator<Row> iterator = sheet.iterator();

			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				Cell opCell = currentRow.getCell(3); // Coluna OP

				if (opCell != null && opCell.getCellType() == CellType.STRING) {
					String opValue = opCell.getStringCellValue();

					if (opValue.equals(op)) {
						// Se a OP encontrada corresponder à OP fornecida
						ref = currentRow.getCell(2).getStringCellValue();
						sts = currentRow.getCell(6).getStringCellValue();
						System.out.println("Dados encontrados na Alocacao:");
						System.out.println("Oficina: " + currentRow.getCell(0));
						System.out.println("DT INICIO: " + currentRow.getCell(1));
						System.out.println("REFERENCIA: " + ref);
						System.out.println("OP: " + opValue);
						System.out.println("QUANTIDADE: " + currentRow.getCell(4));
						System.out.println("DT FINAL: " + currentRow.getCell(5));
						System.out.println("Status: " + sts);
						workbook.close();
						fis.close();
						ManagerDataEntrega.addEntryEntrega(ref, opN, sts);// manda os dados da planilha alocacao para
																			// entrega
						ManagerDeleteAloc.deleteEntryByEntrega(op); // Responsavel por deletar os dados que foram para a planilha
															// alocacao da planilha entrada
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
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite a OP desejada: ");
		String opDesejada = scanner.nextLine();

		searchAndDisplayDataByAlocation(opDesejada);
	}
}
