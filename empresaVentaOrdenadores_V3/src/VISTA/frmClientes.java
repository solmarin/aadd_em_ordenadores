package VISTA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmClientes {
	private  int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width/2;
    private int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height/2;
	private JFrame frmSolcomputerSl;
	private JTextField txtGestiDeClients;
	private JTextField txtCif;
	private JTextField txtEmpresa;
	private JTextField txtPoblacin;
	private JTextField txtCd;
	private JLabel lblEmpresa;
	private JLabel lblDireccin;
	private JLabel lblPoblacin;
	private JLabel lblCd;
	private JTextField textFieldCP;
	private JTable table;
	private JScrollPane scroll ;
	private Object[] titulos = {"CIF", "Nombre Empresa", "Direcci\u00F3n", "Poblaci\u00F3n", "CP"};
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	
	/**
	 * Launch the application.
	 */
	public void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmClientes window = new frmClientes();
					window.frmSolcomputerSl.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public frmClientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {

		frmSolcomputerSl = new JFrame();
		frmSolcomputerSl.setType(Type.UTILITY);
		frmSolcomputerSl.setFont(new Font("aakar", Font.BOLD, 12));
		frmSolcomputerSl.getContentPane().setFont(new Font("Impact", Font.BOLD, 12));
		frmSolcomputerSl.setTitle("SolComputer SL");
		frmSolcomputerSl.setBounds(500, 200, ancho, alto);
		frmSolcomputerSl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSolcomputerSl.getContentPane().setLayout(null);
		
		txtGestiDeClients = new JTextField();
		txtGestiDeClients.setBounds(0, 0, 960, 22);
		txtGestiDeClients.setBackground(new Color(173, 216, 230));
		txtGestiDeClients.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtGestiDeClients.setText("Gestió de Clients");
		frmSolcomputerSl.getContentPane().add(txtGestiDeClients);
		txtGestiDeClients.setColumns(10);
		
		
		txtCif = new JTextField();
		txtCif.setToolTipText("");
		txtCif.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCif.setBounds(18, 63, 172, 22);
		frmSolcomputerSl.getContentPane().add(txtCif);
		txtCif.setColumns(10);
		
		txtEmpresa = new JTextField();
		txtEmpresa.setFont(new Font("Dialog", Font.BOLD, 12));
		txtEmpresa.setColumns(10);
		txtEmpresa.setBounds(274, 63, 534, 22);
		frmSolcomputerSl.getContentPane().add(txtEmpresa);
		
		txtPoblacin = new JTextField();
		txtPoblacin.setFont(new Font("Dialog", Font.BOLD, 12));
		txtPoblacin.setColumns(10);
		txtPoblacin.setBounds(18, 132, 328, 22);
		frmSolcomputerSl.getContentPane().add(txtPoblacin);
		
		txtCd = new JTextField();
		txtCd.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCd.setColumns(10);
		txtCd.setBounds(386, 132, 401, 22);
		frmSolcomputerSl.getContentPane().add(txtCd);
		
		textFieldCP = new JTextField();
		textFieldCP.setFont(new Font("Dialog", Font.BOLD, 12));
		textFieldCP.setColumns(10);
		textFieldCP.setBounds(809, 132, 90, 22);
		frmSolcomputerSl.getContentPane().add(textFieldCP);
		
		JLabel lblCif = new JLabel("CIF");
		lblCif.setBounds(18, 36, 66, 15);
		frmSolcomputerSl.getContentPane().add(lblCif);
		
		lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setBounds(287, 36, 66, 15);
		frmSolcomputerSl.getContentPane().add(lblEmpresa);
		
		lblDireccin = new JLabel("Dirección");
		lblDireccin.setBounds(28, 106, 66, 19);
		frmSolcomputerSl.getContentPane().add(lblDireccin);
		
		lblPoblacin = new JLabel("Población");
		lblPoblacin.setBounds(386, 108, 66, 15);
		frmSolcomputerSl.getContentPane().add(lblPoblacin);
		
		lblCd = new JLabel("CP");
		lblCd.setBounds(818, 108, 27, 15);
		frmSolcomputerSl.getContentPane().add(lblCd);
		
		Object[][] celdas=new Object[9][5];
		scroll = new JScrollPane();
		table=new JTable(celdas, titulos);
		table.setModel(new DefaultTableModel(celdas,titulos){ public boolean isCellEditable(int rowIndex,int coluumnIndex) { return false;}});
		table.setFont(new Font("Dialog", Font.PLAIN, 22));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setRowHeight(22);
		scroll.setViewportView(table);
		scroll.setBounds(10, 182, 925, 200);;
		table.setBackground(new Color(173, 216, 230));
		frmSolcomputerSl.getContentPane().add(scroll);
	
		
		JButton button = new JButton("Editar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 8));
		button.setBounds(34, 452, 99, 35);
		frmSolcomputerSl.getContentPane().add(button);
		
		button_1 = new JButton("Añadir");
		button_1.setFont(new Font("Dialog", Font.BOLD, 8));
		button_1.setBounds(145, 452, 90, 35);
		frmSolcomputerSl.getContentPane().add(button_1);
		
		button_2 = new JButton("Eliminar");
		button_2.setFont(new Font("Dialog", Font.BOLD, 8));
		button_2.setBounds(247, 452, 99, 35);
		frmSolcomputerSl.getContentPane().add(button_2);
		
		button_3 = new JButton("Guardar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_3.setFont(new Font("Dialog", Font.BOLD, 8));
		button_3.setBounds(694, 452, 90, 35);
		frmSolcomputerSl.getContentPane().add(button_3);

	}
}



