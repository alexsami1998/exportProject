package exportProject;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HistoryData {

    @SuppressWarnings("resource")
	public static void registerEntrada(String data, String ref, String op, String qntd, String frent, String tras, String silbor, String kamb, String sts) {
    	
    	File file = new File("dados.xlsx");
    	boolean fileExists = file.exists();
    	
    	try {
    		Workbook workbook;
    		Sheet sheet;
    		
    		if (fileExists) {
    			FileInputStream fis = new FileInputStream(file);
    			workbook = new XSSFWorkbook(fis);
    			sheet = workbook.getSheet("RegistroEntrada");
    		} else {
    			workbook = new XSSFWorkbook();
    			sheet = workbook.createSheet("RegistroEntrada");
    			Row headerRow = sheet.createRow(0);
				headerRow.createCell(0).setCellValue("DATA");
				headerRow.createCell(1).setCellValue("REFERENCIA");
				headerRow.createCell(2).setCellValue("OP");
				headerRow.createCell(3).setCellValue("QUANTIDADE");
				headerRow.createCell(4).setCellValue("FRENT");
				headerRow.createCell(5).setCellValue("TRAS");
				headerRow.createCell(6).setCellValue("SILBOR");
				headerRow.createCell(7).setCellValue("KAMBA");
				headerRow.createCell(8).setCellValue("STATUS");
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
    		dataRow.createCell(8).setCellValue(sts);
    		
    		try (FileOutputStream fileOut = new FileOutputStream("dados.xlsx")) {
    			workbook.write(fileOut);
    			System.out.println("Dados inseridos no registro do dados.xlsx");
    		}
    	} catch (IOException e) {
    		System.out.println("ERROR.: " + e.getMessage());
    	}
    }
    
    @SuppressWarnings("resource")
	public static void registerAloc(String ofi, String dtinicio, String ref, String op, String qntd, String dtfinal, String sts) {
    	
    	File file = new File("dados.xlsx");
    	boolean fileExists = file.exists();
    	
    	try {
    		Workbook workbook;
    		Sheet sheet;
    		
    		if (fileExists) {
    			FileInputStream fis = new FileInputStream(file);
    			workbook = new XSSFWorkbook(fis);
    			sheet = workbook.getSheet("RegistroAloc");
    		} else {
    			workbook = new XSSFWorkbook();
    			sheet = workbook.createSheet("RegistroAloc");
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
    			System.out.println("Dados inseridos no registro do dados.xlsx");
    		}
    	} catch (IOException e) {
    		System.out.println("ERROR.: " + e.getMessage());
    	}
    }
    
    @SuppressWarnings("resource")
	public static void registerEntrega(String data, String fac, String ref, String op, String qop, String qprod, String sts) {
    	File file = new File("dados.xlsx");
		boolean fileExists = file.exists();

		try {
			Workbook workbook;
			Sheet sheet;

			if (fileExists) {
				FileInputStream fis = new FileInputStream(file);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheet("RegistroEntrega");
			} else {
				workbook = new XSSFWorkbook();
				sheet = workbook.createSheet("RegistroEntrega");
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
				System.out.println("Dados exportados para o registroentrada");
			}
		} catch (IOException e) {
			System.out.println("Erro ao fechar o workbook: " + e.getMessage());
		}
    }
    }
