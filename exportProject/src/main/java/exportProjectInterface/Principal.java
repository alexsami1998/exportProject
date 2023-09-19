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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Canvas;

public class Principal extends JFrame {
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal frame = new Principal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 658);

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
		btnNewButton_2.setBounds(310, 129, 301, 59);
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(btnNewButton_2);

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalvarEntrada salvarEntrada = new SalvarEntrada();

		        salvarEntrada.setVisible(true);
		        Principal.this.setVisible(false);
			}
		});


		JMenuItem mntmNewMenuItem = new JMenuItem("Gerenciador de OPS");
		mntmNewMenuItem.setBounds(371, 79, 183, 19);
		contentPane.add(mntmNewMenuItem);

		JButton btnNewButton_1 = new JButton("Exibir OPS - Alocação");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntradaAloc entradaAloc = new EntradaAloc();
				
				entradaAloc.setVisible(true);
				Principal.this.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(310, 286, 301, 50);
		contentPane.add(btnNewButton_1);
		
		JButton btnEntrega = new JButton("Exibir OPS - Entrega");
		btnEntrega.setBounds(310, 367, 301, 52);
		contentPane.add(btnEntrega);
		
		btnEntrega.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				EntregaListar entregaListar = new EntregaListar();
				entregaListar.setVisible(true);
				
				Principal.this.setVisible(false);
			}
		});
		
		
		
		JButton btnNewButton_1_1 = new JButton("Exibir OPS - Entrada");
		btnNewButton_1_1.setBounds(310, 211, 301, 50);
		contentPane.add(btnNewButton_1_1);
		
		btnNewButton_1_1.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				EntradaListar entradaListar = new EntradaListar();
				
				entradaListar.setVisible(true);
				Principal.this.setVisible(false);
			}
		});
		
		JButton btnNewButton_4_1 = new JButton("Sair");
		btnNewButton_4_1.setForeground(Color.RED);
		btnNewButton_4_1.setBounds(310, 550, 301, 52);
		contentPane.add(btnNewButton_4_1);
		
		btnNewButton_4_1.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
			}
}