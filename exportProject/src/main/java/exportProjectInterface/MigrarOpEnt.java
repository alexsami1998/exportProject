package exportProjectInterface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exportProject.SearchOpByData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class MigrarOpEnt extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MigrarOpEnt frame = new MigrarOpEnt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MigrarOpEnt() {
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
		
		btnNewButton = new JButton("Prosseguir");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(510, 207, 117, 77);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				
				String opDesejada = textField.getText();
				
				 SearchOpByData.searchAndDisplayDataByOP(opDesejada);
	            
	            
	          
	            
	            MigrarOpEnt.this.setVisible(false);
	            
	            Principal principal = new Principal();
	            principal.setVisible(true);
			}
		});
		
		btnNewButton_1 = new JButton("VOLTAR");
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setBounds(286, 207, 117, 77);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				MigrarOpEnt.this.setVisible(false);
				EntradaListar entradaListar = new EntradaListar();
				entradaListar.setVisible(true);
			}
		});
	}
}
