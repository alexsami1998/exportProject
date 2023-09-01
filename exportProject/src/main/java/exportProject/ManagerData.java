package exportProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ManagerData {

	public static void addEntry() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite a DATA:");
		String data = scanner.nextLine();

		System.out.println("Digite a REFERENCIA:");
		String ref = scanner.nextLine();

		System.out.println("Digite a OP:");
		String op = scanner.nextLine();

		System.out.println("Digite a QUANTIDADE:");
		String qntd = scanner.nextLine();

		System.out.println("Digite a FRENT:");
		String frent = scanner.nextLine();

		System.out.println("Digite a TRAS:");
		String tras = scanner.nextLine();

		System.out.println("Digite a SIL/BOR:");
		String silbor = scanner.nextLine();

		System.out.println("Digite a KAMB:");
		String kamb = scanner.nextLine();

		File file = new File("dados.xlsx");
		boolean fileExists = file.exists();

		try {
			Workbook workbook;
			Sheet sheet;

			if (fileExists) {
				FileInputStream fis = new FileInputStream(file);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheet("Dados");
			} else {
				workbook = new XSSFWorkbook();
				sheet = workbook.createSheet("Dados");
				Row headerRow = sheet.createRow(0);
				headerRow.createCell(0).setCellValue("Data");
				headerRow.createCell(1).setCellValue("Referencia");
				headerRow.createCell(2).setCellValue("OP");
				headerRow.createCell(3).setCellValue("Quantidade");
				headerRow.createCell(4).setCellValue("Frent");
				headerRow.createCell(5).setCellValue("Tras");
				headerRow.createCell(6).setCellValue("Sil/Bor");
				headerRow.createCell(7).setCellValue("Kamba");
			}

			int lastRowNum = sheet.getLastRowNum();
			Row dataRow = sheet.createRow(lastRowNum + 1);
			dataRow.createCell(0).setCellValue(data);
			dataRow.createCell(1).setCellValue(ref);
			dataRow.createCell(2).setCellValue(op);
			dataRow.createCell(3).setCellValue(qntd);
			dataRow.createCell(4).setCellValue(frent);
			dataRow.createCell(5).setCellValue(tras);
			dataRow.createCell(6).setCellValue(silbor);
			dataRow.createCell(7).setCellValue(kamb);

			try (FileOutputStream fileOut = new FileOutputStream("dados.xlsx")) {
				workbook.write(fileOut);
				System.out.println("Dados exportados para o arquivo dados.xlsx");
			}
		} catch (IOException e) {
			System.out.println("Erro ao fechar o workbook: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		addEntry();
	}
}