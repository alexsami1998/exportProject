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

public class ManagerDataEntrega {

	public static void addEntryEntrega(String ref, String op, String sts) {
		Scanner scanner = new Scanner(System.in);
		
		String data = null;
		String fac = null;
		String qop = null;
		String qprod = null;
		

		File file = new File("dados.xlsx");
		boolean fileExists = file.exists();

		try {
			Workbook workbook;
			Sheet sheet;

			if (fileExists) {
				FileInputStream fis = new FileInputStream(file);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheet("Entrega");
			} else {
				workbook = new XSSFWorkbook();
				sheet = workbook.createSheet("Entrega");
				Row headerRow = sheet.createRow(0);
				headerRow.createCell(0).setCellValue("DATA");
				headerRow.createCell(1).setCellValue("FACCAO");
				headerRow.createCell(2).setCellValue("REFERENCIA");
				headerRow.createCell(3).setCellValue("OP");
				headerRow.createCell(4).setCellValue("Q. OP.");
				headerRow.createCell(5).setCellValue("Q. PROD.");
				headerRow.createCell(6).setCellValue("STATUS");
			}

			int lastRowNum = sheet.getLastRowNum();
			Row dataRow = sheet.createRow(lastRowNum + 1);
			dataRow.createCell(0).setCellValue(data);
			dataRow.createCell(1).setCellValue(fac);
			dataRow.createCell(2).setCellValue(ref);
			dataRow.createCell(3).setCellValue(op);
			dataRow.createCell(4).setCellValue(qop);
			dataRow.createCell(5).setCellValue(qprod);
			dataRow.createCell(6).setCellValue(sts);

			try (FileOutputStream fileOut = new FileOutputStream("dados.xlsx")) {
				workbook.write(fileOut);
				System.out.println("Dados exportados para o arquivo dados.xlsx");
				HistoryData.registerEntrega(data, fac, ref, op, qop, qprod, sts);
			}
		} catch (IOException e) {
			System.out.println("Erro ao fechar o workbook: " + e.getMessage());
		}
	}
}