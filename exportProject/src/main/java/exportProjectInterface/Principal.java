package exportProjectInterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {
	private static final long serialVersionUID = 1L;
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

		JList<Object> list = new JList<Object>();
		list.setBounds(74, 24, 0, 0);
		contentPane.add(list);

		JButton btnAdicionarDados = new JButton("ADICIONAR DADOS - ENTRADA");
		btnAdicionarDados.setForeground(Color.BLUE);
		btnAdicionarDados.setBounds(74, 113, 301, 74);
		btnAdicionarDados.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(btnAdicionarDados);

		btnAdicionarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.this.setVisible(false);
				
				SalvarEntrada salvarEntrada = new SalvarEntrada();
				salvarEntrada.setVisible(true);
			}
		});

		JMenuItem mntmNewMenuItem = new JMenuItem("GOP");
		mntmNewMenuItem.setBackground(Color.GRAY);
		mntmNewMenuItem.setBounds(423, 0, 68, 19);
		contentPane.add(mntmNewMenuItem);

		JButton btnAlocacao = new JButton("EXIBIR OPS - ALOCAÇÃO");
		btnAlocacao.setBounds(74, 284, 301, 50);
		contentPane.add(btnAlocacao);
		btnAlocacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.this.setVisible(false);
				
				EntradaAloc entradaAloc = new EntradaAloc();
				entradaAloc.setVisible(true);
			}
		});

		JButton btnEntrega = new JButton("EXIBIR OPS - ENTREGA");
		btnEntrega.setBounds(74, 359, 301, 52);
		contentPane.add(btnEntrega);

		btnEntrega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.this.setVisible(false);
				
				EntregaListar entregaListar = new EntregaListar();
				entregaListar.setVisible(true);
			}
		});

		JButton btnEntradaListar = new JButton("EXIBIR OPS - ENTRADA");
		btnEntradaListar.setBounds(74, 211, 301, 50);
		contentPane.add(btnEntradaListar);

		btnEntradaListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.this.setVisible(false);
				
				EntradaListar entradaListar = new EntradaListar();
				entradaListar.setVisible(true);
			}
		});

		JButton btnEntradaReg = new JButton("ENTRADA");
		btnEntradaReg.setBounds(618, 120, 266, 60);
		contentPane.add(btnEntradaReg);

		btnEntradaReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.this.setVisible(false);
				
				RegistroEntrada registroEntrada = new RegistroEntrada();
				registroEntrada.setVisible(true);
			}
		});

		JButton btnAlocacaoReg = new JButton("ALOCAÇÃO");
		btnAlocacaoReg.setBounds(618, 241, 266, 60);
		contentPane.add(btnAlocacaoReg);

		btnAlocacaoReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.this.setVisible(false);
				
				RegistroAlocacao registroAlocacao = new RegistroAlocacao();
				registroAlocacao.setVisible(true);
			}
		});

		JButton btnEntregaReg = new JButton("ENTREGA");
		btnEntregaReg.setBounds(618, 355, 266, 60);
		contentPane.add(btnEntregaReg);

		btnEntregaReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.this.setVisible(false);
				
				RegistroEntrega registroEntrega = new RegistroEntrega();
				registroEntrega.setVisible(true);
			}
		});

		JLabel lblVersion = new JLabel("VERSION - 0.1");
		lblVersion.setBounds(867, 586, 96, 16);
		contentPane.add(lblVersion);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.setForeground(Color.RED);
		btnSair.setBounds(310, 550, 301, 52);
		contentPane.add(btnSair);
		
		JPanel panel = new JPanel();
		panel.setBounds(146, 10, 142, 33);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("GERENCIAMENTO");
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(675, 10, 142, 33);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("HISTÓRICO");
		panel_1.add(lblNewLabel_1_1);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(455, 24, 7, 527);
		contentPane.add(verticalBox);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox.add(verticalBox_1);

		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}
}