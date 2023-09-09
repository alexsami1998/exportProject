package exportProject;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ManagerList {

	public static void ManagerList() {
        try (FileInputStream fis = new FileInputStream("dados.xlsx");
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet("Entrada");

            if (sheet != null) {
                for (Row row : sheet) {
                    for (org.apache.poi.ss.usermodel.Cell cell : row) {
                        System.out.print(cell.toString() + "\t");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("A planilha 'Dados' não existe no arquivo.");
            }

        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ManagerList();
    }
    
    public static void ManagerListAloc() {
        try (FileInputStream fis = new FileInputStream("dados.xlsx");
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet("Alocacao");

            if (sheet != null) {
                for (Row row : sheet) {
                    for (org.apache.poi.ss.usermodel.Cell cell : row) {
                        System.out.print(cell.toString() + "\t");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("A planilha 'Dados' não existe no arquivo.");
            }

        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        }
    }
    
    public static void Main() {
    	ManagerListAloc();
    }
}