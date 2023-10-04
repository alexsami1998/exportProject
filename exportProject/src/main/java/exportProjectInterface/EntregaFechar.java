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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import exportProject.SearchOpByData;

public class EntregaFechar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntregaFechar frame = new EntregaFechar();
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
	public EntregaFechar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("INFORME A OP PARA MIGRAR");
		lblNewLabel.setBounds(365, 41, 209, 16);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(392, 125, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnProsseguir = new JButton("PROSSEGUIR");
		btnProsseguir.setForeground(Color.RED);
		btnProsseguir.setBounds(510, 207, 117, 77);
		contentPane.add(btnProsseguir);

		btnProsseguir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String opDesejada = textField.getText();

				SearchOpByData.searchAndDisplayDataByRegisterEntrega(opDesejada);

				EntregaFechar.this.setVisible(false);

				Principal principal = new Principal();
				principal.setVisible(true);
				JOptionPane.showMessageDialog(null, "MIGRAÇÃO COMPLETA");
			}
		});

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setForeground(Color.BLUE);
		btnVoltar.setBounds(286, 207, 117, 77);
		contentPane.add(btnVoltar);

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntregaFechar.this.setVisible(false);

				EntregaListar entregaListar = new EntregaListar();
				entregaListar.setVisible(true);
			}
		});
	}
}