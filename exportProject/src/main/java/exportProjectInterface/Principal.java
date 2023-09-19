package exportProjectInterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
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

		JButton btnAdicionarDados = new JButton("Adicionar dados no arquivo de ENTRADA");
		btnAdicionarDados.setForeground(Color.BLUE);
		btnAdicionarDados.setBounds(310, 55, 301, 74);
		btnAdicionarDados.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(btnAdicionarDados);

		btnAdicionarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.this.setVisible(false);
				
				SalvarEntrada salvarEntrada = new SalvarEntrada();
				salvarEntrada.setVisible(true);
			}
		});

		JMenuItem mntmNewMenuItem = new JMenuItem("Gerenciador de OPS");
		mntmNewMenuItem.setBounds(370, 24, 183, 19);
		contentPane.add(mntmNewMenuItem);

		JButton btnAlocacao = new JButton("Exibir OPS - Alocação");
		btnAlocacao.setBounds(310, 227, 301, 50);
		contentPane.add(btnAlocacao);
		btnAlocacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.this.setVisible(false);
				
				EntradaAloc entradaAloc = new EntradaAloc();
				entradaAloc.setVisible(true);
			}
		});

		JButton btnEntrega = new JButton("Exibir OPS - Entrega");
		btnEntrega.setBounds(310, 302, 301, 52);
		contentPane.add(btnEntrega);

		btnEntrega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.this.setVisible(false);
				
				EntregaListar entregaListar = new EntregaListar();
				entregaListar.setVisible(true);
			}
		});

		JButton btnEntradaListar = new JButton("Exibir OPS - Entrada");
		btnEntradaListar.setBounds(310, 155, 301, 50);
		contentPane.add(btnEntradaListar);

		btnEntradaListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.this.setVisible(false);
				
				EntradaListar entradaListar = new EntradaListar();
				entradaListar.setVisible(true);
			}
		});

		JButton btnEntradaReg = new JButton("ENTRADA");
		btnEntradaReg.setBounds(386, 403, 142, 29);
		contentPane.add(btnEntradaReg);

		btnEntradaReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.this.setVisible(false);
				
				RegistroEntrada registroEntrada = new RegistroEntrada();
				registroEntrada.setVisible(true);
			}
		});

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(331, 359, 255, 12);
		contentPane.add(separator_1_2);

		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setBounds(331, 366, 255, 12);
		contentPane.add(separator_1_2_1);

		JButton btnAlocacaoReg = new JButton("ALOCAÇÃO");
		btnAlocacaoReg.setBounds(386, 444, 142, 29);
		contentPane.add(btnAlocacaoReg);

		btnAlocacaoReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.this.setVisible(false);
				
				RegistroAlocacao registroAlocacao = new RegistroAlocacao();
				registroAlocacao.setVisible(true);
			}
		});

		JButton btnEntregaReg = new JButton("ENTREGA");
		btnEntregaReg.setBounds(386, 485, 142, 29);
		contentPane.add(btnEntregaReg);

		btnEntregaReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.this.setVisible(false);
				
				RegistroEntrega registroEntrega = new RegistroEntrega();
				registroEntrega.setVisible(true);
			}
		});

		JLabel lblNewLabel = new JLabel("HISTÓRICO");
		lblNewLabel.setBounds(423, 376, 88, 16);
		contentPane.add(lblNewLabel);

		JLabel lblVersion = new JLabel("version - 1.0.1");
		lblVersion.setBounds(867, 586, 96, 16);
		contentPane.add(lblVersion);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setForeground(Color.RED);
		btnSair.setBounds(310, 550, 301, 52);
		contentPane.add(btnSair);

		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}
}