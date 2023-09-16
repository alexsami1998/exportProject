package exportProjectInterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Gui extends JFrame {

	private JPanel contentPane;
	private final JButton btnNewButton = new JButton("Exibir OPS - Entrada");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JList list = new JList();
		list.setBounds(74, 24, 0, 0);
		contentPane.add(list);

		JButton btnNewButton_2 = new JButton("Adicionar dados no arquivo de ENTRADA");
		btnNewButton_2.setBounds(74, 50, 301, 29);
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(btnNewButton_2);

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gui2 gui2 = new Gui2();
		        
		        gui2.setVisible(true);
			}
		});
		
		JButton btnNewButton = new JButton("Exibir OPS - Entrada - Manut.");
		btnNewButton.setBounds(74, 171, 301, 29);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntradaListar entradaListar = new EntradaListar();
		        
		        entradaListar.setVisible(true);
			}
		});



		JMenuItem mntmNewMenuItem = new JMenuItem("Gerenciador de OPS");
		mntmNewMenuItem.setBounds(130, 5, 183, 19);
		contentPane.add(mntmNewMenuItem);

		JButton btnNewButton_1 = new JButton("Exibir OPS - Alocação");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(74, 130, 301, 29);
		contentPane.add(btnNewButton_1);
		btnNewButton.setBounds(74, 89, 301, 29);
		contentPane.add(btnNewButton);

		JButton btnNewButton_3 = new JButton("Deletar dados");
		btnNewButton_3.setBounds(74, 215, 301, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Exibir OPS - Entrega");
		btnNewButton_4.setBounds(74, 171, 301, 29);
		contentPane.add(btnNewButton_4);
	}

}
