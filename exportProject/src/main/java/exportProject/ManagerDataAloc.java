package exportProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ManagerDataAloc {

	public static void addEntryAloc(String ref, String op, String qntd, String sts) {

		String ofi = null;
		String dtinicio = null;
		String dtfinal = null;

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
				headerRow.createCell(0).setCellValue("OFICINA");
				headerRow.createCell(1).setCellValue("DT INICIO");
				headerRow.createCell(2).setCellValue("REFERENCIA");
				headerRow.createCell(3).setCellValue("OP");
				headerRow.createCell(4).setCellValue("QUANTIDADE");
				headerRow.createCell(5).setCellValue("DT FINAL");
				headerRow.createCell(6).setCellValue("STATUS");
			}

			int lastRowNum = sheet.getLastRowNum();
			Row dataRow = sheet.createRow(lastRowNum + 1);
			dataRow.createCell(0).setCellValue(ofi);
			dataRow.createCell(1).setCellValue(dtinicio);
			dataRow.createCell(2).setCellValue(ref);
			dataRow.createCell(3).setCellValue(op);
			dataRow.createCell(4).setCellValue(qntd);
			dataRow.createCell(5).setCellValue(dtfinal);
			dataRow.createCell(6).setCellValue(sts);

			try (FileOutputStream fileOut = new FileOutputStream("dados.xlsx")) {
				workbook.write(fileOut);
				System.out.println("Dados exportados para o arquivo dados.xlsx");
				HistoryData.registerAloc(ofi, dtinicio, ref, op, qntd, dtfinal, sts);
			}
		} catch (IOException e) {
			System.out.println("Erro ao fechar o workbook: " + e.getMessage());
		}
	}
}