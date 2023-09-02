package exportProjectInterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import exportProject.ManagerData;

public class Gui extends JFrame {

	private JPanel contentPane;
	private final JButton btnNewButton = new JButton("Exibir OPS - Entrada");

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JList list = new JList();
		contentPane.add(list);

		JButton btnNewButton_2 = new JButton("Adicionar dados");
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(btnNewButton_2);

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gui2 gui2 = new Gui2();
		        
		        gui2.setVisible(true);
			}
		});

		JMenuItem mntmNewMenuItem = new JMenuItem("Gerenciador de OPS");
		contentPane.add(mntmNewMenuItem);

		JButton btnNewButton_1 = new JButton("Editar dados");
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton);

		JButton btnNewButton_3 = new JButton("Deletar dados");
		contentPane.add(btnNewButton_3);
	}

}
