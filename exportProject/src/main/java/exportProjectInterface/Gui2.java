package exportProjectInterface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import exportProject.ManagerData;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Gui2 extends JFrame {
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
					Gui2 frame = new Gui2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Gui2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Salvar dados");
		btnNewButton.setBounds(147, 206, 117, 29);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener () {
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
			
			
			managerData.addEntry(data, ref, op, qntd, frent, tras, silbor, kamb, sts);
			Gui2.this.dispose();
			}
		});

		JLabel lblNewLabel = new JLabel("Data");
		lblNewLabel.setBounds(16, 6, 29, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("REF");
		lblNewLabel_1.setBounds(16, 34, 61, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("OP");
		lblNewLabel_2.setBounds(16, 67, 61, 16);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("QUANT");
		lblNewLabel_3.setBounds(16, 104, 61, 16);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("FRENT");
		lblNewLabel_4.setBounds(239, 6, 61, 16);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("SIL/BOR");
		lblNewLabel_5.setBounds(239, 67, 61, 16);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("KAMB");
		lblNewLabel_6.setBounds(239, 104, 61, 16);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("TRAS");
		lblNewLabel_7.setBounds(239, 34, 61, 16);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("STATUS");
		lblNewLabel_8.setBounds(239, 143, 61, 16);
		contentPane.add(lblNewLabel_8);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(74, 1, 130, 26);
		contentPane.add(textFieldData);
		textFieldData.setColumns(10);
		
		textFieldRef = new JTextField();
		textFieldRef.setBounds(74, 29, 130, 26);
		contentPane.add(textFieldRef);
		textFieldRef.setColumns(10);

		textFieldOp = new JTextField();
		textFieldOp.setBounds(74, 62, 130, 26);
		contentPane.add(textFieldOp);
		textFieldOp.setColumns(10);

		textFieldQntd = new JTextField();
		textFieldQntd.setBounds(74, 99, 130, 26);
		contentPane.add(textFieldQntd);
		textFieldQntd.setColumns(10);

		textFieldFrent = new JTextField();
		textFieldFrent.setBounds(299, 1, 130, 26);
		contentPane.add(textFieldFrent);
		textFieldFrent.setColumns(10);

		textFieldTras = new JTextField();
		textFieldTras.setBounds(299, 29, 130, 26);
		contentPane.add(textFieldTras);
		textFieldTras.setColumns(10);

		textFieldSilbor = new JTextField();
		textFieldSilbor.setBounds(299, 62, 130, 26);
		contentPane.add(textFieldSilbor);
		textFieldSilbor.setColumns(10);

		textFieldKamb = new JTextField();
		textFieldKamb.setBounds(299, 99, 130, 26);
		contentPane.add(textFieldKamb);
		textFieldKamb.setColumns(10);

		textFieldSts = new JTextField();
		textFieldSts.setBounds(299, 138, 130, 26);
		contentPane.add(textFieldSts);
		textFieldSts.setColumns(10);
	}
}