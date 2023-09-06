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

public class ManagerDataAloc {

    public static void addEntryAloc() {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite a oficina:");
		String ofc = scanner.nextLine();

		System.out.println("Digite a data inicio:");
		String dini = scanner.nextLine();

		System.out.println("Digite a referencia:");
		String ref = scanner.nextLine();

		System.out.println("Digite a OP:");
		String op = scanner.nextLine();

		System.out.println("Digite a Quantidade:");
		String qntd = scanner.nextLine();

		System.out.println("Digite a TRAS:");
		String dfin = scanner.nextLine();

		System.out.println("Digite a SIL/BOR:");
		String sts = scanner.nextLine();
		
		
		File file = new File("dados.xlsx");
		boolean fileExists = file.exists();

		try {
			Workbook workbook;
			Sheet sheet;

			if (fileExists) {
				FileInputStream fis = new FileInputStream(file);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheet("Alocacao");
			} else {
				workbook = new XSSFWorkbook();
				sheet = workbook.createSheet("Alocacao");
				Row headerRow = sheet.createRow(0);
				headerRow.createCell(0).setCellValue("Oficina");
				headerRow.createCell(1).setCellValue("DT inicio");
				headerRow.createCell(2).setCellValue("Referencia");
				headerRow.createCell(3).setCellValue("OP");
				headerRow.createCell(4).setCellValue("Quantidade");
				headerRow.createCell(5).setCellValue("DT final");
				headerRow.createCell(6).setCellValue("Status");
			}

			int lastRowNum = sheet.getLastRowNum();
			Row dataRow = sheet.createRow(lastRowNum + 1);
			dataRow.createCell(0).setCellValue(ofc);
			dataRow.createCell(1).setCellValue(dini);
			dataRow.createCell(2).setCellValue(ref);
			dataRow.createCell(3).setCellValue(op);
			dataRow.createCell(3).setCellValue(qntd);
			dataRow.createCell(4).setCellValue(dfin);
			dataRow.createCell(5).setCellValue(sts);

			try (FileOutputStream fileOut = new FileOutputStream("dados.xlsx")) {
				workbook.write(fileOut);
				System.out.println("Dados exportados para o arquivo dados.xlsx");
			}
		} catch (IOException e) {
			System.out.println("Erro ao fechar o workbook: " + e.getMessage());
		}
	}
}