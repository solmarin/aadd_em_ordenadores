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

public class frmClientes {
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
	 
	 JScrollPane scroll ;
	 
	 Object[] titulos = {"CIF", "Nombre Empresa", "Direcci\u00F3n", "Poblaci\u00F3n", "CP"};
	 Object[] celdas;
	 
	 JButton button;
	 JButton button_1;
	 JButton button_2;
	 JButton button_3;
	 JButton button_4;
	 
	 SQLClientes sqlclientes;
	 
	 ArrayList<Cliente> clientes;

	 DefaultTableModel model;
	 

	 boolean editar = false;
	 boolean añadir = false;
	 
	 frmClientes window;
	
	
	// Launch the application.
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
	
	
	 // Create the application.
	 
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
		txtGestiDeClients.setBounds(0, 0, 960, 22);
		txtGestiDeClients.setBackground(new Color(173, 216, 230));
		txtGestiDeClients.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtGestiDeClients.setText("Gestión de Clientes");
		txtGestiDeClients.setColumns(10);
		txtGestiDeClients.setEditable(false);
		frmC.getContentPane().add(txtGestiDeClients);
		
		//escribir cif
		txtCif = new JTextField();
		txtCif.setToolTipText("");
		txtCif.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCif.setBounds(18, 63, 172, 22);
		txtCif.setColumns(10);
		frmC.getContentPane().add(txtCif);
		
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
		button = new JButton("Editar");
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
		
		button_4 = new JButton("Cancelar");
		button_4.setFont(new Font("Dialog", Font.BOLD, 8));
		button_4.setBounds(794, 452, 90, 35);
		frmC.getContentPane().add(button_4);
		
		noEditable();
		
		//creacion del modelo y la tabla
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
	    //llenamos la tabla
	    select();
		    
	}

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
				añadir = true;
				
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
				frmClientes frmClientes = new frmClientes();
				frmClientes.frmC.setVisible(true);
				frmC.setVisible(false);
				JOptionPane.showConfirmDialog(null, "Cambios no guardados.", "Cancelar", JOptionPane.DEFAULT_OPTION);
				noEditable();
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
	
	public void add() {
			try {
				editar=false;
				sqlclientes = new SQLClientes();
				sqlclientes.insertaClientes(new Cliente(txtEmpresa.getText(), txtCif.getText(),txtDireccion.getText(),txtPoblacion.getText(), txtCP.getText()));
			} catch (NumberFormatException | SQLException e) {
				JOptionPane.showMessageDialog(null, "No se ha introducido ningun campo para añadir.", "WARNING", JOptionPane.WARNING_MESSAGE);
				
			}			
	}
	

	public void edit() {
			try {
				añadir=false;
				sqlclientes = new SQLClientes();
				sqlclientes.updateClientes(txtCif.getText(),txtEmpresa.getText(),txtDireccion.getText(),txtPoblacion.getText(),txtCP.getText());
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}	
		
	}
	
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
		txtCif.setText("");
		txtEmpresa.setText("");
		txtDireccion.setText("");
		txtPoblacion.setText("");
		txtCP.setText("");	
	}


	public void saveAndDelT() {
		button_3.setEnabled(true);
		button_4.setEnabled(true);
	}
	
	public void editAndAdd() {
		button.setEnabled(true);
		button_2.setEnabled(true);
	}

	//control de datos a entrar/editar
	public boolean controlD() {		
		if(txtCif.getText().length()<9 || txtCif.getText().length()>10) return true;
		if(txtEmpresa.getText().isEmpty()) return true;
		if(txtDireccion.getText().isEmpty()) return true;
		if(txtPoblacion.getText().isEmpty()) return true;
		if(txtCP.getText().length() != 5) return true;
		return false;
		
	}
	

}



