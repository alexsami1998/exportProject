package exportProjectInterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EntradaAloc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntradaAloc frame = new EntradaAloc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EntradaAloc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		final DefaultTableModel tableModel = new DefaultTableModel();

		preencherModeloTabela(tableModel);

		table = new JTable(tableModel);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(6, 6, 835, 618);
		contentPane.add(scrollPane);

		JButton btnMigrarEntrega = new JButton("MIGRAR OP");
		btnMigrarEntrega.setForeground(Color.RED);
		btnMigrarEntrega.setBounds(846, 6, 117, 77);
		contentPane.add(btnMigrarEntrega);

		btnMigrarEntrega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntradaAloc.this.setVisible(false);
				
				MigrarOpEntrega migrarOpEntrega = new MigrarOpEntrega();
				migrarOpEntrega.setVisible(true);
			}
		});

		JButton btnEditarDados = new JButton("EDITAR DADOS");
		btnEditarDados.setForeground(Color.ORANGE);
		btnEditarDados.setBounds(846, 95, 117, 77);
		contentPane.add(btnEditarDados);

		btnEditarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				int selectedColumn = table.getSelectedColumn();

				if (selectedRow != -1 && selectedColumn != -1) {
					String oldValue = (String) tableModel.getValueAt(selectedRow, selectedColumn);
					String newValue = JOptionPane.showInputDialog("Editar valor:", oldValue);

					if (newValue != null) {
						tableModel.setValueAt(newValue, selectedRow, selectedColumn);

						atualizarCelulaNoExcel(selectedRow, selectedColumn, newValue);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma célula para editar.");
				}
			}
		});

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setForeground(Color.BLUE);
		btnVoltar.setBounds(846, 184, 117, 77);
		contentPane.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntradaAloc.this.setVisible(false);
				
				Principal principal = new Principal();
				principal.setVisible(true);
			}
		});
		
		JButton btnExcluirDados = new JButton("EXCLUIR");
        btnExcluirDados.setForeground(new Color(139, 0, 0));
        btnExcluirDados.setBounds(846, 547, 117, 77);
        contentPane.add(btnExcluirDados);

        btnExcluirDados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();

                if (selectedRow != -1) {
                    Object opValue = table.getValueAt(selectedRow, getColumnIndexByName("OP"));

                    if (opValue != null) {
                        String opToBeDeleted = opValue.toString();
                        excluirLinhaPorOP(opToBeDeleted);
                    } else {
                        JOptionPane.showMessageDialog(null, "A célula 'OP' está vazia.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir.");
                }
            }
        });
	}
	
	private void excluirLinhaPorOP(String opToBeDeleted) {
        try (FileInputStream fis = new FileInputStream("dados.xlsx"); Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet("Alocacao");

            if (sheet != null) {
                for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                    Row row = sheet.getRow(rowIndex);
                    if (row != null) {
                        Cell opCell = row.getCell(getColumnIndexByName("OP"));
                        if (opCell != null) {
                            String opCellValue = opCell.toString();
                            if (opToBeDeleted.equals(opCellValue)) {
                                sheet.removeRow(row);
                                
                                EntradaAloc.this.setVisible(false);
                                
                                Principal principal = new Principal();
                                principal.setVisible(true);
                                JOptionPane.showMessageDialog(null, "OP EXCLUÍDA");
                                break;
                            }
                        }
                    }
                }
                try (FileOutputStream fos = new FileOutputStream("dados.xlsx")) {
                    workbook.write(fos);
                }
            } else {
                System.out.println("A planilha 'Entrada' não existe no arquivo.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao abrir/gravar o arquivo Excel: " + e.getMessage());
        }
    }
	
	private int getColumnIndexByName(String columnName) {
        for (int i = 0; i < table.getColumnCount(); i++) {
            if (columnName.equals(table.getColumnName(i))) {
                return i;
            }
        }
        return -1;
    }

// Método para atualizar a célula no arquivo Excel
	private void atualizarCelulaNoExcel(int rowIndex, int columnIndex, String newValue) {
		try (FileInputStream fis = new FileInputStream("dados.xlsx"); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheet("Alocacao");

			if (sheet != null) {
				Row row = sheet.getRow(rowIndex + 1); // +1 para ignorar a linha de cabeçalho
				if (row != null) {
					Cell cell = row.getCell(columnIndex);
					if (cell != null) {
						cell.setCellValue(newValue);

						// Salve as alterações de volta no arquivo Excel
						try (FileOutputStream fos = new FileOutputStream("dados.xlsx")) {
							workbook.write(fos);
						}
					}
				}
			} else {
				System.out.println("A planilha 'Alocacao' não existe no arquivo.");
			}
		} catch (IOException e) {
			System.out.println("Erro ao abrir/gravar o arquivo Excel: " + e.getMessage());
		}
	}

	private void preencherModeloTabela(DefaultTableModel tableModel) {
		try (FileInputStream fis = new FileInputStream("dados.xlsx"); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheet("Alocacao");

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
