package VISTA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.CompoundBorder;

public class frmClientes {

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
	private void initialize() {
		frmSolcomputerSl = new JFrame();
		frmSolcomputerSl.setTitle("SolComputer SL");
		frmSolcomputerSl.getContentPane().setLayout(null);
		
		txtGestiDeClients = new JTextField();
		txtGestiDeClients.setBounds(0, 0, 450, 22);
		txtGestiDeClients.setBackground(new Color(173, 216, 230));
		txtGestiDeClients.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtGestiDeClients.setText("Gestió de Clients");
		frmSolcomputerSl.getContentPane().add(txtGestiDeClients);
		txtGestiDeClients.setColumns(10);
		
		txtCif = new JTextField();
		txtCif.setToolTipText("");
		txtCif.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCif.setBounds(10, 38, 90, 19);
		frmSolcomputerSl.getContentPane().add(txtCif);
		txtCif.setColumns(10);
		
		txtEmpresa = new JTextField();
		txtEmpresa.setFont(new Font("Dialog", Font.BOLD, 12));
		txtEmpresa.setColumns(10);
		txtEmpresa.setBounds(112, 38, 264, 19);
		frmSolcomputerSl.getContentPane().add(txtEmpresa);
		
		txtPoblacin = new JTextField();
		txtPoblacin.setFont(new Font("Dialog", Font.BOLD, 12));
		txtPoblacin.setColumns(10);
		txtPoblacin.setBounds(10, 89, 194, 19);
		frmSolcomputerSl.getContentPane().add(txtPoblacin);
		
		txtCd = new JTextField();
		txtCd.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCd.setColumns(10);
		txtCd.setBounds(216, 89, 142, 19);
		frmSolcomputerSl.getContentPane().add(txtCd);
		
		textFieldCP = new JTextField();
		textFieldCP.setFont(new Font("Dialog", Font.BOLD, 12));
		textFieldCP.setColumns(10);
		textFieldCP.setBounds(369, 89, 56, 19);
		frmSolcomputerSl.getContentPane().add(textFieldCP);
		
		JLabel lblCif = new JLabel("CIF");
		lblCif.setBounds(20, 23, 66, 15);
		frmSolcomputerSl.getContentPane().add(lblCif);
		
		lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setBounds(119, 23, 66, 15);
		frmSolcomputerSl.getContentPane().add(lblEmpresa);
		
		lblDireccin = new JLabel("Dirección");
		lblDireccin.setBounds(20, 69, 66, 19);
		frmSolcomputerSl.getContentPane().add(lblDireccin);
		
		lblPoblacin = new JLabel("Población");
		lblPoblacin.setBounds(231, 69, 66, 15);
		frmSolcomputerSl.getContentPane().add(lblPoblacin);
		
		lblCd = new JLabel("CP");
		lblCd.setBounds(376, 71, 27, 15);
		frmSolcomputerSl.getContentPane().add(lblCd);
		
		table = new JTable();
		table.setName("TABLA CLIENTES");
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"CIF", "Empresa", "Direcci\u00F3n", "Poblaci\u00F3n", "CP"
			}
		));
		table.setBounds(10, 140, 405, 44);
		frmSolcomputerSl.getContentPane().add(table);
	}
}
