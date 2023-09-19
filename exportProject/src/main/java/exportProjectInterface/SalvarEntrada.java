package exportProjectInterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import exportProject.ManagerData;
import java.awt.Component;

public class SalvarEntrada extends JFrame {
	private static final long serialVersionUID = 1L;

	ManagerData adicionarDados = new ManagerData();

	private JPanel contentPane;
	private JTextField textFieldData;
	private JTextField textFieldRef;
	private JTextField textFieldOp;
	private JTextField textFieldQntd;
	private JTextField textFieldFrent;
	private JTextField textFieldTras;
	private JTextField textFieldSilbor;
	private JTextField textFieldKamb;
	private JTextField textFieldSts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalvarEntrada frame = new SalvarEntrada();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SalvarEntrada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("SALVAR DADOS");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(710, 113, 216, 54);

		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ManagerData managerData = new ManagerData();

				String data = textFieldData.getText();
				String ref = textFieldRef.getText();
				String op = textFieldOp.getText();
				String qntd = textFieldQntd.getText();
				String frent = textFieldFrent.getText();
				String tras = textFieldTras.getText();
				String silbor = textFieldSilbor.getText();
				String kamb = textFieldKamb.getText();
				String sts = textFieldSts.getText();

				managerData.addEntryProhibited(data, ref, op, qntd, frent, tras, silbor, kamb, sts);
				SalvarEntrada.this.setVisible(false);
				Principal principal = new Principal();
				principal.setVisible(true);
				JOptionPane.showMessageDialog(null, "OP REGISTRADA");
			}
		});

		JLabel lblNewLabel = new JLabel("Data");
		lblNewLabel.setBounds(19, 149, 29, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("REF");
		lblNewLabel_1.setBounds(19, 184, 61, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("OP");
		lblNewLabel_2.setBounds(19, 223, 61, 16);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("QUANT");
		lblNewLabel_3.setBounds(19, 269, 61, 16);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("FRENT");
		lblNewLabel_4.setBounds(19, 312, 61, 16);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("SIL/BOR");
		lblNewLabel_5.setBounds(19, 388, 61, 16);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("KAMB");
		lblNewLabel_6.setBounds(19, 426, 61, 16);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("TRAS");
		lblNewLabel_7.setBounds(19, 350, 61, 16);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("STATUS");
		lblNewLabel_8.setBounds(19, 464, 61, 16);
		contentPane.add(lblNewLabel_8);

		textFieldData = new JTextField();
		textFieldData.setBounds(339, 144, 306, 26);
		contentPane.add(textFieldData);
		textFieldData.setColumns(10);

		textFieldRef = new JTextField();
		textFieldRef.setBounds(339, 179, 306, 26);
		contentPane.add(textFieldRef);
		textFieldRef.setColumns(10);

		textFieldOp = new JTextField();
		textFieldOp.setBounds(339, 218, 306, 26);
		contentPane.add(textFieldOp);
		textFieldOp.setColumns(10);

		textFieldQntd = new JTextField();
		textFieldQntd.setBounds(339, 264, 306, 26);
		contentPane.add(textFieldQntd);
		textFieldQntd.setColumns(10);

		textFieldFrent = new JTextField();
		textFieldFrent.setBounds(339, 307, 306, 26);
		contentPane.add(textFieldFrent);
		textFieldFrent.setColumns(10);

		textFieldTras = new JTextField();
		textFieldTras.setBounds(339, 345, 306, 26);
		contentPane.add(textFieldTras);
		textFieldTras.setColumns(10);

		textFieldSilbor = new JTextField();
		textFieldSilbor.setBounds(339, 383, 306, 26);
		contentPane.add(textFieldSilbor);
		textFieldSilbor.setColumns(10);

		textFieldKamb = new JTextField();
		textFieldKamb.setBounds(339, 421, 306, 26);
		contentPane.add(textFieldKamb);
		textFieldKamb.setColumns(10);

		textFieldSts = new JTextField();
		textFieldSts.setBounds(339, 459, 306, 26);
		contentPane.add(textFieldSts);
		textFieldSts.setColumns(10);

		JButton btnNewButton_1 = new JButton("VOLTAR");
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setBounds(710, 205, 216, 54);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalvarEntrada.this.setVisible(false);
				Principal principal = new Principal();
				principal.setVisible(true);
			}
		});

		JSeparator separator = new JSeparator();
		separator.setBounds(72, 468, 255, 12);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(72, 430, 255, 12);
		contentPane.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(72, 392, 255, 12);
		contentPane.add(separator_2);

		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(72, 354, 255, 12);
		contentPane.add(separator_2_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(72, 316, 255, 12);
		contentPane.add(separator_1_1);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(72, 273, 255, 12);
		contentPane.add(separator_1_2);

		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setBounds(72, 227, 255, 12);
		contentPane.add(separator_1_3);

		JSeparator separator_1_4 = new JSeparator();
		separator_1_4.setBounds(72, 188, 255, 12);
		contentPane.add(separator_1_4);

		JSeparator separator_1_5 = new JSeparator();
		separator_1_5.setBounds(72, 153, 255, 12);
		contentPane.add(separator_1_5);

		JLabel lblNewLabel_9 = new JLabel("REGISTRAR DADOS EM - ENTRADA");
		lblNewLabel_9.setBounds(710, 6, 228, 54);
		contentPane.add(lblNewLabel_9);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(6, 6, 671, 618);
		contentPane.add(scrollPane);

	}
}