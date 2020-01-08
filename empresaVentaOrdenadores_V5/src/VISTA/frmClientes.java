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
import javax.swing.JOptionPane;
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

/**
 * Clase vista del formulario clientes (diseño y eventos). 
 * @author Sol Marin
 * @version 4
 *
 */

public class frmClientes {
	//Declaración de variables 
		 int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width/2;
	     int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height/2;
		 int seleccion;
	     
	     public JFrame frmC;
	     
		 JTextField txtGestiDeClients;
		 JTextField txtCif;
		 JTextField txtEmpresa;
		 JTextField txtDireccion;
		 JTextField txtPoblacion;
		 JTextField txtCP;
		 
		 JLabel lblEmpresa;
		 JLabel lblDireccin;
		 JLabel lblPoblacin;
		 JLabel lblCd;
		 JTable table;
		 JLabel lblCif;
		 
		 JScrollPane scroll ;
		 
		 Object[] titulos = {"CIF", "Nombre Empresa", "Direcci\u00F3n", "Poblaci\u00F3n", "CP"};
		 Object[] celdas;
		 
		 JButton button;
		 JButton button_1;
		 JButton button_2;
		 JButton button_3;
		 JButton button_4;
		 JButton button_5;
		 
		 SQLClientes sqlclientes;
		 
		 ArrayList<Cliente> clientes;
	
		 DefaultTableModel model;
		 
		 boolean editar = false;
		 boolean añadir = false;
		 
		 frmClientes window;
	
	 /**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new frmClientes();
					window.frmC.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	/**
	 * Constructor: Create the application.
	 */
	public frmClientes() {
		try {
			
			//crear la ventana
			this.pantalla();
			
		    //creamos el modelo de tabla y la tabla
		    this.eventos();
		    
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
	}

	/**
	 * Funcion donde se crea todo el diseño del formulario clientes.
	 * 
	 */
	@SuppressWarnings("serial")
	public void pantalla() {
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
			txtGestiDeClients.setBounds(0, 0, 960, 32);
			txtGestiDeClients.setBackground(new Color(173, 216, 230));
			txtGestiDeClients.setFont(new Font("Arial Black", Font.ITALIC, 12));
			txtGestiDeClients.setText(" GESTIÓN DE CLIENTES");
			txtGestiDeClients.setColumns(10);
			txtGestiDeClients.setEditable(false);
			frmC.getContentPane().add(txtGestiDeClients);
		
		//txts
			txtCif = new JTextField();
			txtCif.setToolTipText("");
			txtCif.setFont(new Font("Dialog", Font.BOLD, 12));
			txtCif.setBounds(18, 63, 172, 22);
			txtCif.setColumns(10);
			frmC.getContentPane().add(txtCif);
			
			txtEmpresa = new JTextField();
			txtEmpresa.setFont(new Font("Dialog", Font.BOLD, 12));
			txtEmpresa.setColumns(10);
			txtEmpresa.setBounds(274, 63, 534, 22);
			frmC.getContentPane().add(txtEmpresa);
		
			txtDireccion = new JTextField();
			txtDireccion.setFont(new Font("Dialog", Font.BOLD, 12));
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(18, 132, 328, 22);
			frmC.getContentPane().add(txtDireccion);
			
			txtPoblacion = new JTextField();
			txtPoblacion.setFont(new Font("Dialog", Font.BOLD, 12));
			txtPoblacion.setColumns(10);
			txtPoblacion.setBounds(386, 132, 401, 22);
			frmC.getContentPane().add(txtPoblacion);
			
			txtCP = new JTextField();
			txtCP.setFont(new Font("Dialog", Font.BOLD, 12));
			txtCP.setColumns(10);
			txtCP.setBounds(809, 132, 90, 22);
			frmC.getContentPane().add(txtCP);
			
		//Etiquetas Jlabel
			lblCif = new JLabel("CIF");
			lblCif.setBounds(18, 36, 66, 15);
			frmC.getContentPane().add(lblCif);
			
			lblEmpresa = new JLabel("Empresa");
			lblEmpresa.setBounds(287, 36, 66, 15);
			frmC.getContentPane().add(lblEmpresa);
			
			lblDireccin = new JLabel("Dirección");
			lblDireccin.setBounds(28, 106, 66, 19);
			frmC.getContentPane().add(lblDireccin);
			
			lblPoblacin = new JLabel("Población");
			lblPoblacin.setBounds(386, 108, 66, 15);
			frmC.getContentPane().add(lblPoblacin);
			
			lblCd = new JLabel("CP");
			lblCd.setBounds(818, 108, 27, 15);
			frmC.getContentPane().add(lblCd);
		
		//bottones
			button = new JButton("Editar");
			button.setFont(new Font("Dialog", Font.BOLD, 18));
			button.setBounds(10, 410, 150, 60);
			frmC.getContentPane().add(button);
			
			button_1 = new JButton("Añadir");
			button_1.setFont(new Font("Dialog", Font.BOLD, 18));
			button_1.setBounds(170, 410,  150, 60);
			frmC.getContentPane().add(button_1);
			 
			button_2 = new JButton("Eliminar");
			button_2.setFont(new Font("Dialog", Font.BOLD, 18));
			button_2.setBounds(330, 410,  150, 60);
			frmC.getContentPane().add(button_2);
			
			button_3 = new JButton("Guardar");
			button_3.setFont(new Font("Dialog", Font.BOLD, 18));
			button_3.setBounds(625, 410,  150, 60);
			frmC.getContentPane().add(button_3);
			
			button_4 = new JButton("Cancelar");
			button_4.setFont(new Font("Dialog", Font.BOLD, 18));
			button_4.setBounds(785, 410,  150, 60);
			frmC.getContentPane().add(button_4);
			
			button_4.setFont(new Font("Dialog", Font.BOLD, 18));
			button_4.setBounds(785, 410,  150, 60);
			frmC.getContentPane().add(button_4);
			
			button_5 = new JButton("Ayuda");
			button_5.setFont(new Font("Ayuda", Font.BOLD, 8));
			button_5.setBounds(830, 60,  70, 30);
			frmC.getContentPane().add(button_5);
	
		//inicializamos la pantalla sin poder editar los campos
			noEditable();
		
		//creacion del modelo y la tabla
			scroll = new JScrollPane();
			model = new DefaultTableModel(celdas,0){ 
				public boolean isCellEditable(int rowIndex,int coluumnIndex) { return false;}
				};
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
	    
	    //llenamos la tabla
		    select();
		    
	}

	/**
	 * Funcion que contiene los eventos que pueden suceder en el frmClientes
	 * @throws SQLException
	 */
	private void eventos() throws SQLException {
		//editar un cliente
			button.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(button.isEnabled()) {
						txtEmpresa.setEnabled(true);
						txtDireccion.setEnabled(true);
						txtPoblacion.setEnabled(true);
						txtCP.setEnabled(true);
						editar=true;
						saveAndDelT();
						//callar otros botones
						button_1.setEnabled(false);
						button_2.setEnabled(false);
					}
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
					txtCif.setText("");
					txtEmpresa.setText("");
					txtDireccion.setText("");
					txtPoblacion.setText("");
					txtCP.setText("");	
					añadir = true;
					
					//poder guardar y eliminar
						saveAndDelT();
					
					//callar otros botones
						button.setEnabled(false);
						button_2.setEnabled(false);
				
				}
			});
		
		//borrar un cliente
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					 int dialogResult = JOptionPane.showConfirmDialog (null, "Seguro que quieres eliminar el cliente?","BORRAR CLIENTE",JOptionPane.YES_NO_OPTION);
					 if(dialogResult == JOptionPane.YES_OPTION){
						   delete();
						}
					 noEditable();
				}
				
			});
		
	
		//control del save
			button_3.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent j) {
					if(!controlD()) {
						if(editar) edit();
						if(añadir) add();
						select(); 
						noEditable();
					}else JOptionPane.showConfirmDialog(null, "Error al guardar: tens camp/camps incorrectes.", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
					
					if(!añadir && !editar) {
						JOptionPane.showConfirmDialog(null, "Error al guardar: no hay ninguna acción selecionada.", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
						noEditable();
					}
					
					
				}
			});
		
		//cancelar un evento
			button_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//refresh de la pantalla para cancelar todos los cambios
						frmClientes frmClientes = new frmClientes();
						frmClientes.frmC.setVisible(true);
						frmC.setVisible(false);
						JOptionPane.showConfirmDialog(null, "Cambios no guardados.", "Cancelar", JOptionPane.DEFAULT_OPTION);
					//inicializamos que no se pueda editar nada
						noEditable();
				}
			});
			
		//mostrar ayuda
			button_5.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					JOptionPane.showConfirmDialog(null, " Añadir: clica editar y rellena los campos. Selecciona Guardar o cancelar al finalizar. \n Editar: clica editar y rellena los campos (el cif no se puede modifica). Selecciona Guardar o cancelar al finalizar. \n Eliminar: seleciona en la tabla un cliente, clica eliminar y confirma si estas seguro de eliminar. \n Cancelar: para cancelar toda opción que no se desea guardar. \n Guardar: al añadir y editar seleciona guardar para guardar los cambios. \n Contacto: solmarin1999@gmail.com","MANUAL DE USUARIO", JOptionPane.DEFAULT_OPTION);
				}
			});
	    
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
				editAndAdd();
				
				if(editar) button_2.setEnabled(false);
			}
		});
	}

	/**
	 * Función para seleccionar todos los clientes por consulta sql y añadirlos al modelo de la tabla.
	 * 
	 */
	public void select() {
		try {
		 model.setRowCount(0);
		 sqlclientes = new SQLClientes();
		 for(Cliente c: sqlclientes.consultaClientes("Clientes")) {
		    	if(c != null) {
			    	String cif = c.getCif();
			    	String nE = c.getNombreEmpresa();
			    	String d = c.getDireccion();
			    	String p = c.getPoblacion();
			    	String cp = c.getCp();
			    	if(cp.length()!=5) for(int i=cp.length(); i<5;++i) cp = "0" + cp;
			    	
					model.addRow(new Object[] {cif,nE,d,p,cp});
		    	}  	
		    }
		 } catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
		 }
		
	}
	
	/**
	 * Funcion para añadir un clente a la bbdd.
	 */
	public void add() {
			try {
				editar=false;
				sqlclientes = new SQLClientes();
				sqlclientes.insertaClientes(new Cliente(txtEmpresa.getText(), txtCif.getText(),txtDireccion.getText(),txtPoblacion.getText(), txtCP.getText()));
			} catch (NumberFormatException | SQLException e) {
				JOptionPane.showMessageDialog(null, "No se ha introducido ningun campo para añadir.", "WARNING", JOptionPane.WARNING_MESSAGE);
				
			}			
	}
	/**
	 * Funcion para editar un cliente de la bbdd apartir del cif.
	 */

	public void edit() {
			try {
				añadir=false;
				sqlclientes = new SQLClientes();
				sqlclientes.updateClientes(txtCif.getText(),txtEmpresa.getText(),txtDireccion.getText(),txtPoblacion.getText(),txtCP.getText());
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}	
		
	}
	/**
	 * Funcion para borrar un cliente de la bbdd apartir de su cif (el cliente tiene que estar seleccionado en la tabla).
	 */
	
	public void delete() {
		try {
			sqlclientes = new SQLClientes();
			sqlclientes.deleteClientes(String.valueOf(table.getValueAt(seleccion, 0)));
			model.setRowCount(0);
			select(); 
		}catch (NumberFormatException | SQLException f) {
			f.printStackTrace();
			
		}
	
	}
	/**
	 * Funcion para poner los caracteres de inicialización, es decir, poner botones y txt sin poder editar y el ejemplo dentro de los txt.
	 */
	public void noEditable() {
		txtCif.setEnabled(false);
		txtEmpresa.setEnabled(false);
		txtDireccion.setEnabled(false);
		txtPoblacion.setEnabled(false);
		txtCP.setEnabled(false);
		button.setEnabled(false);
		button_2.setEnabled(false);
		button_3.setEnabled(false);
		button_4.setEnabled(false);
		txtCif.setText("B-1234567");
		txtEmpresa.setText("empresa ejemplo");
		txtDireccion.setText("calle ejemplo, n 10");
		txtPoblacion.setText("barcelona");
		txtCP.setText("08295");	
	}

	/**
	 * Función para hacer que se pueda usar el boton guardar y eliminar.
	 */
	public void saveAndDelT() {
		button_3.setEnabled(true);
		button_4.setEnabled(true);
	}
	
	/**
	 * Boton para que se pueda editar y añadir.
	 */
	public void editAndAdd() {
		button.setEnabled(true);
		button_2.setEnabled(true);
	}

	/**
	 * Función para controlar que los datos que se introducen son correctos (control de datos).
	 * @return si devuelte true hay algun campo incorrecto, sino devuelte true.
	 */
	public boolean controlD() {		
		if(txtCif.getText().length()!=10) return true;
		if(txtEmpresa.getText().isEmpty()) return true;
		if(txtDireccion.getText().isEmpty()) return true;
		if(txtPoblacion.getText().isEmpty()) return true;
		if(txtCP.getText().length() != 5) return true;
		return false;
		
	}
	

}



