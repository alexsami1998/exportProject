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
import java.awt.Color;
import javax.swing.JLabel;

public class EntradaListar extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private JButton btnNewButton;
    private JButton btnMigrarAlocao;
    private JButton btnEditarDados;

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

        DefaultTableModel tableModel = new DefaultTableModel();

        preencherModeloTabela(tableModel);

        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(6, 6, 835, 618);
        contentPane.add(scrollPane);
        
        btnNewButton = new JButton("VOLTAR");
        btnNewButton.setForeground(Color.BLUE);
        btnNewButton.setBounds(846, 250, 117, 77);
        contentPane.add(btnNewButton);
        
        btnNewButton.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent e) {
				EntradaListar.this.setVisible(false);
				Principal principal = new Principal();
				principal.setVisible(true);
        	}
        });
        
        btnMigrarAlocao = new JButton("MIGRAR OP");
        btnMigrarAlocao.setForeground(Color.RED);
        btnMigrarAlocao.setBounds(846, 26, 117, 77);
        contentPane.add(btnMigrarAlocao);
        
        btnMigrarAlocao.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent e) {
        		MigrarOpEnt migrarOpEnt = new MigrarOpEnt();
        		migrarOpEnt.setVisible(true);
        		
        		EntradaListar.this.setVisible(false);
        	}
        });
        
        btnEditarDados = new JButton("EDITAR DADOS");
        btnEditarDados.setForeground(Color.ORANGE);
        btnEditarDados.setBounds(846, 138, 117, 77);
        contentPane.add(btnEditarDados);
    }

    private void preencherModeloTabela(DefaultTableModel tableModel) {
        try (FileInputStream fis = new FileInputStream("dados.xlsx");
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet("Entrada");

            if (sheet != null) {
                Row headerRow = sheet.getRow(0);
                for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                    Cell cell = headerRow.getCell(i);
                    if (cell != null) {
                        tableModel.addColumn(cell.getStringCellValue());
                    } else {
                        tableModel.addColumn("");
                    }
                }

                for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                    Row row = sheet.getRow(rowIndex);
                    if (row != null) {
                        Object[] rowData = new Object[row.getLastCellNum()];
                        for (int columnIndex = 0; columnIndex < row.getLastCellNum(); columnIndex++) {
                            Cell cell = row.getCell(columnIndex);
                            if (cell != null) {
                                rowData[columnIndex] = cell.toString();
                            } else {
                                rowData[columnIndex] = "";
                            }
                        }
                        tableModel.addRow(rowData);
                    }
                }
            } else {
                System.out.println("A planilha 'Entrada' não existe no arquivo.");
            }

        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        }
    }

}