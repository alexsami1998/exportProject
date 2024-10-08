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
						ManagerData.addEntryAloc(ref, opN, qntd, sts); // manda os dados da planilha entrada para alocacao
						ManagerDelete.deleteEntryByOp(op); // Responsavel por deletar os dados que foram para a planilha alocacao da planilha entrada
						return; 
					}
				}
			}

			System.out.println("Nenhuma entrada encontrada para a OP: " + op);

			workbook.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void searchAndDisplayDataByAlocation(String op) {
		String ofi = null;
		String dtInicio = null;
		String ref = null;
		String qntd = null;
		String dtfinal = null;
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
						ofi = currentRow.getCell(0).getStringCellValue();
						dtInicio = currentRow.getCell(1).getStringCellValue();
						ref = currentRow.getCell(2).getStringCellValue();
						qntd = currentRow.getCell(4).getStringCellValue();
						dtfinal = currentRow.getCell(5).getStringCellValue();
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
						ManagerData.addEntryEntrega(ref, opN, sts);// manda os dados da planilha alocacao para
																			// entrega
						HistoryData.registerAloc(ofi, dtInicio, ref, op, qntd, dtfinal, sts);
						ManagerDelete.deleteEntryByAloc(op); // Responsavel por deletar os dados que foram para a planilha
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
	
	public static void searchAndDisplayDataByRegisterEntrega(String op) {
		String data = null;
		String fac = null;
		String opN = op;
		String ref = null;
		String qop = null;
		String qprod = null;
		String sts = null;
		try {
			FileInputStream fis = new FileInputStream(new File("dados.xlsx"));
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet("Entrega");

			Iterator<Row> iterator = sheet.iterator();

			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				Cell opCell = currentRow.getCell(3); // Coluna OP

				if (opCell != null && opCell.getCellType() == CellType.STRING) {
					String opValue = opCell.getStringCellValue();

					if (opValue.equals(op)) {
						// Se a OP encontrada corresponder à OP fornecida
						data = currentRow.getCell(0).getStringCellValue();
						fac = currentRow.getCell(1).getStringCellValue();
						ref = currentRow.getCell(2).getStringCellValue();
						qop = currentRow.getCell(4).getStringCellValue();
						qprod = currentRow.getCell(5).getStringCellValue();
						sts = currentRow.getCell(6).getStringCellValue();
						System.out.println("Dados encontrados na Alocacao:");
						System.out.println("DATA: " + currentRow.getCell(0));
						System.out.println("FAC: " + currentRow.getCell(1));
						System.out.println("REFERENCIA: " + currentRow.getCell(2));
						System.out.println("OP: " + opValue);
						System.out.println("QUANTIDADE OP: " + currentRow.getCell(4));
						System.out.println("QUANTIDADE PROD: " + currentRow.getCell(5));
						System.out.println("Status: " + currentRow.getCell(6));
						workbook.close();
						fis.close();
					
						HistoryData.registerEntrega(data, fac, ref, opN, qop, qprod, sts);
						ManagerDelete.deleteEntryByEntrega(op); // Responsavel por deletar os dados que foram para a planilha
															// entrada para registro entrada
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
		searchAndDisplayDataByRegisterEntrega(opDesejada);
		searchAndDisplayDataByOP(opDesejada);
	}
}
