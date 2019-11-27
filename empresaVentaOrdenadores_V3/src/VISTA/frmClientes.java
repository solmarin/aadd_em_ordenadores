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
import DATOS.SQLClientes;
import MODELO.Cliente;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
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
	private SQLClientes sqlclientes;
	private ArrayList<Cliente> clientes;
	private Object[] celdas;
	private DefaultTableModel model;
	private int rowIndex;
	private int colIndex;
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
		//crear la ventana
		this.pantallaBotones();
		
		try {
			//Conectamos con la bbdd y hacemos el select
			sqlclientes = new SQLClientes();
			clientes = sqlclientes.consultaClientes("Clientes");
	
		    //creamos el modelo de tabla y la tabla
		    this.crearModeloYTabla();
		    
			//llenamos el modelo de tabla
			this.select();
		    
		}catch(SQLException e) {
			e.printStackTrace();
			
		}

	    rowIndex = table.getSelectedRow();
	    colIndex = table.getSelectedColumn();
		    
	}
	
	public void pantallaBotones() {
				//pantalla
				frmSolcomputerSl = new JFrame();
				frmSolcomputerSl.setType(Type.UTILITY);
				frmSolcomputerSl.setFont(new Font("aakar", Font.BOLD, 12));
				frmSolcomputerSl.getContentPane().setFont(new Font("Impact", Font.BOLD, 12));
				frmSolcomputerSl.setTitle("SolComputer SL");
				frmSolcomputerSl.setBounds(500, 200, ancho, alto);
				frmSolcomputerSl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frmSolcomputerSl.getContentPane().setLayout(null);
				//titulo
				txtGestiDeClients = new JTextField();
				txtGestiDeClients.setBounds(0, 0, 960, 22);
				txtGestiDeClients.setBackground(new Color(173, 216, 230));
				txtGestiDeClients.setFont(new Font("Arial Black", Font.PLAIN, 12));
				txtGestiDeClients.setText("Gestió de Clients");
				frmSolcomputerSl.getContentPane().add(txtGestiDeClients);
				txtGestiDeClients.setColumns(10);
				
				//escribir cif
				txtCif = new JTextField();
				txtCif.setToolTipText("");
				txtCif.setFont(new Font("Dialog", Font.BOLD, 12));
				txtCif.setBounds(18, 63, 172, 22);
				frmSolcomputerSl.getContentPane().add(txtCif);
				txtCif.setColumns(10);
				
				//escribir Empresa
				txtEmpresa = new JTextField();
				txtEmpresa.setFont(new Font("Dialog", Font.BOLD, 12));
				txtEmpresa.setColumns(10);
				txtEmpresa.setBounds(274, 63, 534, 22);
				frmSolcomputerSl.getContentPane().add(txtEmpresa);
				
				//escribir Poblacion
				txtPoblacin = new JTextField();
				txtPoblacin.setFont(new Font("Dialog", Font.BOLD, 12));
				txtPoblacin.setColumns(10);
				txtPoblacin.setBounds(18, 132, 328, 22);
				frmSolcomputerSl.getContentPane().add(txtPoblacin);
				
				//escribir
				txtCd = new JTextField();
				txtCd.setFont(new Font("Dialog", Font.BOLD, 12));
				txtCd.setColumns(10);
				txtCd.setBounds(386, 132, 401, 22);
				frmSolcomputerSl.getContentPane().add(txtCd);
				
				//escribir direccion
				textFieldCP = new JTextField();
				textFieldCP.setFont(new Font("Dialog", Font.BOLD, 12));
				textFieldCP.setColumns(10);
				textFieldCP.setBounds(809, 132, 90, 22);
				frmSolcomputerSl.getContentPane().add(textFieldCP);
				
				//Etiqueta
				JLabel lblCif = new JLabel("CIF");
				lblCif.setBounds(18, 36, 66, 15);
				frmSolcomputerSl.getContentPane().add(lblCif);
				
				//Etiqueta
				lblEmpresa = new JLabel("Empresa");
				lblEmpresa.setBounds(287, 36, 66, 15);
				frmSolcomputerSl.getContentPane().add(lblEmpresa);
				
				//Etiqueta
				lblDireccin = new JLabel("Dirección");
				lblDireccin.setBounds(28, 106, 66, 19);
				frmSolcomputerSl.getContentPane().add(lblDireccin);
				
				//Etiqueta
				lblPoblacin = new JLabel("Población");
				lblPoblacin.setBounds(386, 108, 66, 15);
				frmSolcomputerSl.getContentPane().add(lblPoblacin);
				
				//Etiqueta
				lblCd = new JLabel("CP");
				lblCd.setBounds(818, 108, 27, 15);
				frmSolcomputerSl.getContentPane().add(lblCd);
				
				//bottones
				JButton button = new JButton("Editar");
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
				button_3.setFont(new Font("Dialog", Font.BOLD, 8));
				button_3.setBounds(694, 452, 90, 35);
				frmSolcomputerSl.getContentPane().add(button_3);
	}
	
	@SuppressWarnings("serial")
	private void crearModeloYTabla() {
		celdas=new Object[clientes.size()];
		scroll = new JScrollPane();
		model = new DefaultTableModel(celdas,0){ public boolean isCellEditable(int rowIndex,int coluumnIndex) { return false;}};
		model.setColumnIdentifiers(titulos);
		table=new JTable();
		table.setModel(model);
	    table.setFont(new Font("Dialog", Font.PLAIN, 16));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setRowHeight(18);
		scroll.setViewportView(table);
		scroll.setBounds(10, 182, 925, 200);;
		table.setBackground(new Color(173, 216, 230));
		frmSolcomputerSl.getContentPane().add(scroll);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    table.getTableHeader().setReorderingAllowed(false);
	}

	public void select() {
		 for(Cliente c: clientes) {
		    	if(c != null) {
		    	String cif = c.getCif();
		    	String nE = c.getNombreEmpresa();
		    	String d = c.getDireccion();
		    	String p = c.getPoblacion();
		    	int cp = c.getCp();
				model.addRow(new Object[] {cif,nE,d,p,cp});
		    	}
		 }
	}
}



