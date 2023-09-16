package exportProjectInterface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.JButton;

public class EntradaListar extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private JButton btnNewButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EntradaListar frame = new EntradaListar();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public EntradaListar() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 969, 658);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Crie um modelo de tabela
        DefaultTableModel tableModel = new DefaultTableModel();

        // Preencha o modelo de tabela com os dados do Excel
        preencherModeloTabela(tableModel);

        // Crie a JTable com o modelo de tabela
        table = new JTable(tableModel);

        // Adicione a JTable a um JScrollPane para permitir a rolagem
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(6, 6, 835, 618);
        contentPane.add(scrollPane);
        
        btnNewButton = new JButton("voltar");
        btnNewButton.setBounds(846, 129, 117, 77);
        contentPane.add(btnNewButton);
        
        btnNewButton.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent e) {
				EntradaListar.this.setVisible(false);
				Principal principal = new Principal();
				principal.setVisible(true);
        	}
        });
    }

    // Método para preencher o modelo de tabela com os dados do Excel
    private void preencherModeloTabela(DefaultTableModel tableModel) {
        try (FileInputStream fis = new FileInputStream("dados.xlsx");
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet("Entrada");

            if (sheet != null) {
                // Adicione as colunas à tabela
                Row headerRow = sheet.getRow(0);
                for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                    Cell cell = headerRow.getCell(i);
                    tableModel.addColumn(cell.getStringCellValue());
                }

                // Adicione as linhas de dados à tabela
                for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                    Row row = sheet.getRow(rowIndex);
                    Object[] rowData = new Object[row.getLastCellNum()];
                    for (int columnIndex = 0; columnIndex < row.getLastCellNum(); columnIndex++) {
                        Cell cell = row.getCell(columnIndex);
                        rowData[columnIndex] = cell.toString();
                    }
                    tableModel.addRow(rowData);
                }
            } else {
                System.out.println("A planilha 'Entrada' não existe no arquivo.");
            }

        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        }
    }
}