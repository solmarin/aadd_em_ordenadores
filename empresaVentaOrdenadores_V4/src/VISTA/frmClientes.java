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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmClientes {
	 int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width/2;
     int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height/2;
     public JFrame frmC;
	 JTextField txtGestiDeClients;
	 JTextField txtCif;
	 JTextField txtEmpresa;
	 JTextField txtDireccion;
	 JTextField txtPoblacion;
	 JLabel lblEmpresa;
	 JLabel lblDireccin;
	 JLabel lblPoblacin;
	 JLabel lblCd;
	 JTextField txtCP;
	 JTable table;
	 JScrollPane scroll ;
	 Object[] titulos = {"CIF", "Nombre Empresa", "Direcci\u00F3n", "Poblaci\u00F3n", "CP"};
	 JButton button_1;
	 JButton button_2;
	 JButton button_3;
	 SQLClientes sqlclientes;
	 ArrayList<Cliente> clientes;
	 Object[] celdas;
	 DefaultTableModel model;
	 int seleccion;
	 boolean editar = false;
	 boolean seguroDel = false;
	
	 // Launch the application.
	 
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmClientes window = new frmClientes();
					window.frmC.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	 // Create the application.
	 
	public frmClientes() {
		initialize();
	}

	
	 //Initialize the contents of the frame.
	 
	@SuppressWarnings("serial")
	private void initialize() {
		
		try {
			//crear la ventana
			this.pantallaBotones();
		    //creamos el modelo de tabla y la tabla
		    this.crearModeloYTabla();
			//llenamos el modelo de tabla
		    
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
	    
	}
	
	public void pantallaBotones() {
			//pantalla
			frmC = new JFrame();
			frmC.setType(Type.UTILITY);
			frmC.setFont(new Font("aakar", Font.BOLD, 12));
			frmC.getContentPane().setFont(new Font("Impact", Font.BOLD, 12));
			frmC.setTitle("SolComputer SL");
			frmC.setBounds(500, 200, ancho, alto);
			frmC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmC.getContentPane().setLayout(null);
			
			//titulo
			txtGestiDeClients = new JTextField();
			txtGestiDeClients.setBounds(0, 0, 960, 22);
			txtGestiDeClients.setBackground(new Color(173, 216, 230));
			txtGestiDeClients.setFont(new Font("Arial Black", Font.PLAIN, 12));
			txtGestiDeClients.setText("Gestión de Clientes");
			frmC.getContentPane().add(txtGestiDeClients);
			txtGestiDeClients.setColumns(10);
			txtGestiDeClients.setEditable(false);
			
			//escribir cif
			txtCif = new JTextField();
			txtCif.setToolTipText("");
			txtCif.setFont(new Font("Dialog", Font.BOLD, 12));
			txtCif.setBounds(18, 63, 172, 22);
			frmC.getContentPane().add(txtCif);
			txtCif.setColumns(10);
			
			//escribir Empresa
			txtEmpresa = new JTextField();
			txtEmpresa.setFont(new Font("Dialog", Font.BOLD, 12));
			txtEmpresa.setColumns(10);
			txtEmpresa.setBounds(274, 63, 534, 22);
			frmC.getContentPane().add(txtEmpresa);
			
			//escribir Direccion
			txtDireccion = new JTextField();
			txtDireccion.setFont(new Font("Dialog", Font.BOLD, 12));
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(18, 132, 328, 22);
			frmC.getContentPane().add(txtDireccion);
			
			//escribir Poblacion
			txtPoblacion = new JTextField();
			txtPoblacion.setFont(new Font("Dialog", Font.BOLD, 12));
			txtPoblacion.setColumns(10);
			txtPoblacion.setBounds(386, 132, 401, 22);
			frmC.getContentPane().add(txtPoblacion);
			
			//escribir CP
			txtCP = new JTextField();
			txtCP.setFont(new Font("Dialog", Font.BOLD, 12));
			txtCP.setColumns(10);
			txtCP.setBounds(809, 132, 90, 22);
			frmC.getContentPane().add(txtCP);
			
			noEditable();
			
			//Etiqueta
			JLabel lblCif = new JLabel("CIF");
			lblCif.setBounds(18, 36, 66, 15);
			frmC.getContentPane().add(lblCif);
			
			//Etiqueta
			lblEmpresa = new JLabel("Empresa");
			lblEmpresa.setBounds(287, 36, 66, 15);
			frmC.getContentPane().add(lblEmpresa);
			
			//Etiqueta
			lblDireccin = new JLabel("Dirección");
			lblDireccin.setBounds(28, 106, 66, 19);
			frmC.getContentPane().add(lblDireccin);
			
			//Etiqueta
			lblPoblacin = new JLabel("Población");
			lblPoblacin.setBounds(386, 108, 66, 15);
			frmC.getContentPane().add(lblPoblacin);
			
			//Etiqueta
			lblCd = new JLabel("CP");
			lblCd.setBounds(818, 108, 27, 15);
			frmC.getContentPane().add(lblCd);
			
			//bottones
			JButton button = new JButton("Editar");
			button.setFont(new Font("Dialog", Font.BOLD, 8));
			button.setBounds(34, 452, 99, 35);
			frmC.getContentPane().add(button);
			
			button_1 = new JButton("Añadir");
			button_1.setFont(new Font("Dialog", Font.BOLD, 8));
			button_1.setBounds(145, 452, 90, 35);
			frmC.getContentPane().add(button_1);
			
			
			button_2 = new JButton("Eliminar");
			button_2.setFont(new Font("Dialog", Font.BOLD, 8));
			button_2.setBounds(247, 452, 99, 35);
			frmC.getContentPane().add(button_2);
			
			button_3 = new JButton("Guardar");
			button_3.setFont(new Font("Dialog", Font.BOLD, 8));
			button_3.setBounds(694, 452, 90, 35);
			frmC.getContentPane().add(button_3);
			
			//editar un cliente
			button.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					txtEmpresa.setEnabled(true);
					txtDireccion.setEnabled(true);
					txtPoblacion.setEnabled(true);
					txtCP.setEnabled(true);
					editar=true;
				}
			});
			
			//añadir un cliente
			button_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					txtCif.setEnabled(true);
					txtEmpresa.setEnabled(true);
					txtDireccion.setEnabled(true);
					txtPoblacion.setEnabled(true);
					txtCP.setEnabled(true);
				
				}
			});
			//borrar un cliente
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frmSaveDelete frmSaveDelete = new frmSaveDelete(frmClientes); /*********** pasar el frmclientes y cojer los parametros de aqui*****/
					frmSaveDelete.frmSD.setVisible(true);
					if(seguroDel) delete();
					else System.out.println("no funciona el delete");
				}
			});
			
		
			//control del save
			button_3.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent j) {
					if(editar) edit();
					else add();
					noEditable();
				}
			});
			
	}
	
	@SuppressWarnings("serial")
	private void crearModeloYTabla() throws SQLException {
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
		frmC.getContentPane().add(scroll);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    table.getTableHeader().setReorderingAllowed(false);
	    
	    select();
	    
	  //mostrar en los campos txt los datos de la fila seleccionada
	    table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seleccion = table.rowAtPoint(e.getPoint());
				txtCif.setText(String.valueOf(table.getValueAt(seleccion, 0)));
				txtEmpresa.setText(String.valueOf(table.getValueAt(seleccion, 1)));
				txtDireccion.setText(String.valueOf(table.getValueAt(seleccion, 2)));
				txtPoblacion.setText(String.valueOf(table.getValueAt(seleccion, 3)));
				txtCP.setText(String.valueOf(table.getValueAt(seleccion, 4)));	
			}
		});
	}

	public void select() {
		try {
		 sqlclientes = new SQLClientes();
		 for(Cliente c: sqlclientes.consultaClientes("Clientes")) {
		    	if(c != null) {
		    	String cif = c.getCif();
		    	String nE = c.getNombreEmpresa();
		    	String d = c.getDireccion();
		    	String p = c.getPoblacion();
		    	int cp = c.getCp();
				model.addRow(new Object[] {cif,nE,d,p,cp});
		    	}  	
		    }
		 } catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }
		 	
	}
	
	public void add() {
		try {
			sqlclientes = new SQLClientes();
			sqlclientes.insertaClientes(new Cliente(txtEmpresa.getText(), txtCif.getText(),txtDireccion.getText(),txtPoblacion.getText(), Integer.parseInt(txtCP.getText())));
			model.setRowCount(0);
			select(); 
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	

	public void edit() {
		try {
			sqlclientes = new SQLClientes();
			sqlclientes.updateClientes(txtCif.getText(),txtEmpresa.getText(),txtDireccion.getText(),txtPoblacion.getText(),Integer.parseInt(txtCP.getText()));
			model.setRowCount(0);
			select(); 
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void noEditable() {
		txtCif.setEnabled(false);
		txtEmpresa.setEnabled(false);
		txtDireccion.setEnabled(false);
		txtPoblacion.setEnabled(false);
		txtCP.setEnabled(false);
	}


}



