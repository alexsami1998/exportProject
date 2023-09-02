package exportProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ManagerEdit {

	public static void ManagerEdit(int rowNum) {
		try (FileInputStream fis = new FileInputStream("dados.xlsx"); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheet("Dados");

			if (sheet == null) {
				System.out.println("Nenhum dado encontrado para editar.");
				return;
			}

			Row row = sheet.getRow(rowNum);

			if (row == null) {
				System.out.println("Linha não encontrada.");
				return;
			}

			Scanner scanner = new Scanner(System.in);

			System.out.println("Digite a nova DATA:");
			row.getCell(0).setCellValue(scanner.nextLine());

			System.out.println("Digite a nova REFERENCIA:");
			row.getCell(1).setCellValue(scanner.nextLine());

			System.out.println("Digite a nova OP:");
			row.getCell(2).setCellValue(scanner.nextLine());

			System.out.println("Digite a nova QUANTIDADE:");
			row.getCell(3).setCellValue(scanner.nextLine());

			System.out.println("Digite a nova FRENT:");
			row.getCell(4).setCellValue(scanner.nextLine());

			System.out.println("Digite a nova TRAS:");
			row.getCell(5).setCellValue(scanner.nextLine());

			System.out.println("Digite a nova SIL/BOR:");
			row.getCell(6).setCellValue(scanner.nextLine());

			System.out.println("Digite a nova KAMB:");
			row.getCell(7).setCellValue(scanner.nextLine());
			
			System.out.println("Digite o novo STATUS");
			row.getCell(8).setCellValue(scanner.nextLine());

			try (FileOutputStream fileOut = new FileOutputStream("dados.xlsx")) {
				workbook.write(fileOut);
				System.out.println("Dados editados e exportados para o arquivo dados.xlsx");
			}
		} catch (IOException e) {
			System.out.println("Erro ao fechar o workbook: " + e.getMessage());
		}
	}
}