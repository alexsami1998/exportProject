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

public class ManagerDeleteAloc {

	public static void deleteEntryByEntrega(String op) {
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
						// Se a OP encontrada corresponder à OP fornecida, exclua a linha
						sheet.removeRow(currentRow);
						System.out.println("Entrada com OP " + op + " excluída com sucesso.");
						FileOutputStream fos = new FileOutputStream(new File("dados.xlsx"));
						workbook.write(fos);
						fos.close();
						workbook.close();
						fis.close();
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
		System.out.print("Digite a OP que deseja excluir: ");
		String opToDelete = scanner.nextLine();

		deleteEntryByEntrega(opToDelete);
	}
}
