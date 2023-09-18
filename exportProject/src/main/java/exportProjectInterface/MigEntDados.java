package exportProjectInterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import exportProject.ManagerDataAloc;

public class MigEntDados extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private JTextField textFieldOfi;
	private JTextField textFieldDtinicio;
	private JTextField textFieldDtfinal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MigEntDados frame = new MigEntDados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MigEntDados() {
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
		JButton btnNewButton = new JButton("MIGRAR");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(747, 570, 216, 54);

		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ManagerDataAloc managerDataAloc = new ManagerDataAloc();
			
				
				MigEntDados.this.setVisible(false);
				Principal principal = new Principal();
				principal.setVisible(true);
			}
		});

		JLabel lblNewLabel = new JLabel("Oficina");
		lblNewLabel.setBounds(6, 410, 61, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Data início");
		lblNewLabel_1.setBounds(6, 457, 77, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Data final");
		lblNewLabel_2.setBounds(6, 507, 61, 16);
		contentPane.add(lblNewLabel_2);

		textFieldOfi = new JTextField();
		textFieldOfi.setBounds(79, 405, 306, 26);
		contentPane.add(textFieldOfi);
		textFieldOfi.setColumns(10);

		textFieldDtinicio = new JTextField();
		textFieldDtinicio.setBounds(79, 452, 306, 26);
		contentPane.add(textFieldDtinicio);
		textFieldDtinicio.setColumns(10);

		textFieldDtfinal = new JTextField();
		textFieldDtfinal.setBounds(79, 502, 306, 26);
		contentPane.add(textFieldDtfinal);
		textFieldDtfinal.setColumns(10);

		JButton btnNewButton_1 = new JButton("VOLTAR");
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setBounds(6, 570, 216, 54);
		contentPane.add(btnNewButton_1);

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// SalvarEntrada.this.setVisible(false);
				Principal principal = new Principal();
				principal.setVisible(true);
			}
		});

		JLabel lblNewLabel_9 = new JLabel("DADOS A MIGRAR");
		lblNewLabel_9.setBounds(6, 6, 228, 16);
		contentPane.add(lblNewLabel_9);

		JScrollPane scrollPane2 = new JScrollPane((Component) null);
		scrollPane2.setBounds(6, 23, 963, 283);
		contentPane.add(scrollPane2);

		JLabel lblNewLabel_9_1 = new JLabel("DADOS RESTANTES");
		lblNewLabel_9_1.setBounds(6, 377, 228, 16);
		contentPane.add(lblNewLabel_9_1);

		JSeparator separator_1_5 = new JSeparator();
		separator_1_5.setBounds(6, 340, 957, 12);
		contentPane.add(separator_1_5);

		JSeparator separator_1_5_1 = new JSeparator();
		separator_1_5_1.setBounds(6, 353, 957, 12);
		contentPane.add(separator_1_5_1);

	}

	private void preencherModeloTabela(DefaultTableModel tableModel) {

	}
}