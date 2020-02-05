package VISTA;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DATOS.LectorXML;
import DATOS.SQLComandas;
import DATOS.SQLLCs;
import MODELO.Comanda;
import MODELO.LC;

public class frmComandas {
	int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width/2;
    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height/2;
	int seleccion;
	boolean editar=false;
	boolean save=false;
	boolean eliminar = false;
    public JFrame frmCo;
	frmComandas window;
	
	JTextField txtGC;
	JTextField txtUS;
	JTextField txtEdit;
	
	Object[] titulos = {"idComanda", "idCliente", "Status", "Precio Total", "Fecha entrada", "Fecha Salida"};
	Object[] titulos2 = {"idComanda", "idLC", "idArticulo","unidades", "unidades servidas", "status"};
	Object[] celdas;
	
	JButton buttonXML;
	JButton buttonEditar;
	JButton buttonDesUS;
	JButton buttonAugUS;
	JButton buttonSave;
	JButton buttonDel;
	JButton buttonStatusB;
	JButton buttonStatusT;
	JButton buttonStatusC;
	JButton buttonFS;
	
	JScrollPane scroll;
	DefaultTableModel model; 
	JTable table;
	SQLComandas sqlcomandas;
	
	JScrollPane scroll2;
	DefaultTableModel model2;
	JTable table2;
	SQLLCs sqllcs;
	
	int idC;
	int idLC;
	int status;

	/**
	* Launch the application.
	*/
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new frmComandas();
					window.frmCo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	/**
	* Constructor: Create the application.
	*/
	public frmComandas() {
		try {
			
			//crear la ventana
			this.pantalla();
			
		    //creamos el modelo de tabla y la tabla
		    this.eventos();
		    
		}finally {
			
		}
	}

	/**
	 * Funcion donde se crea todo el diseño del formulario comandas.
	 * 
	 */
	@SuppressWarnings("serial")
	public void pantalla() {
		//pantalla
			frmCo = new JFrame();
			frmCo.setType(Type.UTILITY);
			frmCo.setFont(new Font("aakar", Font.BOLD, 12));
			frmCo.getContentPane().setFont(new Font("Impact", Font.BOLD, 12));
			frmCo.setTitle("SolComputer SL");
			frmCo.setBounds(500, 200, ancho, alto);
			frmCo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmCo.getContentPane().setLayout(null);
		
		//titulo
			txtGC = new JTextField();
			txtGC.setBounds(0, 0, 960, 32);
			txtGC.setBackground(new Color(173, 216, 230));
			txtGC.setFont(new Font("Arial Black", Font.ITALIC, 12));
			txtGC.setText(" GESTIÓN DE COMANDAS");
			txtGC.setColumns(10);
			txtGC.setEditable(false);
			frmCo.getContentPane().add(txtGC);
			
		//tabla comandas
			scroll = new JScrollPane();
			model = new DefaultTableModel(celdas,0){ 
				public boolean isCellEditable(int rowIndex,int coluumnIndex) { return false;}
				};
			model.setColumnIdentifiers(titulos);
			table = new JTable();
			table.setModel(model);
		    table.setFont(new Font("Dialog", Font.PLAIN, 16));
			table.setBorder(new LineBorder(new Color(0, 0, 0)));
			table.setRowHeight(18);
			scroll.setViewportView(table);
			scroll.setBounds(10, 40, 925, 150);;
			table.setBackground(new Color(173, 216, 230));
			frmCo.getContentPane().add(scroll);
		    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		    table.getTableHeader().setReorderingAllowed(false);
		 
		 //tabla LCs
			scroll2 = new JScrollPane();
			model2 = new DefaultTableModel(celdas,0){ 
				public boolean isCellEditable(int rowIndex,int coluumnIndex) { return false;}
				};
			model2.setColumnIdentifiers(titulos2);
			table2 = new JTable();
			table2.setModel(model2);
		    table2.setFont(new Font("Dialog", Font.PLAIN, 16));
			table2.setBorder(new LineBorder(new Color(0, 0, 0)));
			table2.setRowHeight(18);
			scroll2.setViewportView(table2);
			scroll2.setBounds(10, 200, 925, 150);;
			table2.setBackground(new Color(173, 216, 230));
			frmCo.getContentPane().add(scroll2);
		    table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		    table2.getTableHeader().setReorderingAllowed(false);
		    
		  //bottones
			buttonXML = new JButton("INSERTAR XML");
			buttonXML.setFont(new Font("Dialog", Font.BOLD, 18));
			buttonXML.setBounds(10, 440, 200, 50);
			frmCo.getContentPane().add(buttonXML);
			
		    
			buttonEditar = new JButton("UNIDADES SERVIDAS");
			buttonEditar.setFont(new Font("Dialog", Font.PLAIN, 8));
			buttonEditar.setBounds(215, 440, 150, 50);
			buttonEditar.setEnabled(false);
			frmCo.getContentPane().add(buttonEditar);

		//boton guardar
			buttonSave = new JButton("GUARDAR");
			buttonSave.setFont(new Font("Dialog", Font.BOLD, 16));
			buttonSave.setBounds(800, 440, 140, 50);
			buttonSave.setEnabled(false);
			frmCo.getContentPane().add(buttonSave);
			
		//boton eliminar Comanda
			buttonDel = new JButton("ELIMINAR COMANDA");
			buttonDel.setFont(new Font("Dialog", Font.BOLD, 10));
			buttonDel.setBounds(647, 440, 150, 50);
			buttonDel.setEnabled(false);
			frmCo.getContentPane().add(buttonDel);
		
		//boton status todas
			buttonStatusT = new JButton("CMS. TODAS");
			buttonStatusT.setFont(new Font("Dialog", Font.ITALIC, 8));
			buttonStatusT.setBounds(10, 350, 110, 25);
			buttonStatusT.setEnabled(true);
			frmCo.getContentPane().add(buttonStatusT);
			
		//boton status B
			buttonStatusB = new JButton("CMS. ABIERTAS");
			buttonStatusB.setFont(new Font("Dialog", Font.ITALIC, 8));
			buttonStatusB.setBounds(120, 350, 110, 25);
			buttonStatusB.setEnabled(true);
			frmCo.getContentPane().add(buttonStatusB);
			
		//boton status C
			buttonStatusC = new JButton("CMS. CERRADAS");
			buttonStatusC.setFont(new Font("Dialog", Font.ITALIC, 8));
			buttonStatusC.setBounds(220, 350, 110, 25);
			buttonStatusC.setEnabled(true);
			frmCo.getContentPane().add(buttonStatusC);
		
		//boton grabar fecha salida
			buttonFS = new JButton("GRB. FECHA SALIDA");
			buttonFS.setFont(new Font("Dialog", Font.PLAIN, 8));
			buttonFS.setBounds(445, 440, 150, 50);
			buttonFS.setEnabled(false);
			frmCo.getContentPane().add(buttonFS);
			
			
		//cuadro txt para editar
			txtEdit = new JTextField();
			txtEdit.setFont(new Font("Dialog", Font.BOLD, 16));
			txtEdit.setColumns(10);
			txtEdit.setBounds(370, 440, 70, 50);
			frmCo.getContentPane().add(txtEdit);
			txtEdit.setEnabled(false);
			txtEdit.setText("");
			actualizarComandas('T');
			
		    
	}
	
	public void eventos() {
		
		buttonXML.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
					 LectorXML lectorXML = new LectorXML();
					 sqlcomandas = new SQLComandas();
					 for(int i = 0; i< lectorXML.getCS().size(); ++i) sqlcomandas.insertaComandas(lectorXML.getCS().get(i));
					 actualizarComandas('T');
					 buttonEditar.setEnabled(false);
					 editar=false;
					 
				 } catch (NumberFormatException | SQLException e) {
						e.printStackTrace();
				 }	
			}
		});
	
		buttonEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!save) {
					buttonSave.setEnabled(true);
					buttonEditar.setEnabled(false);
					buttonDel.setEnabled(false);
					txtEdit.setEnabled(true);
					buttonXML.setEnabled(false);
					editar=true;
					save=true;
					eliminar=false;
					
				}

			}
		});
		

		buttonStatusT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizarComandas('T');

			}
		});
		
		buttonStatusB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizarComandas('B');

			}
		});
		
		buttonStatusC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizarComandas('C');

			}
		});

		buttonFS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				upFechaS(Integer.parseInt(String.valueOf(table.getValueAt(seleccion, 0))));
			}
		});

		
	//mostrar en los campos txt las lc de la comanda selecionada
	    table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!save) {
					seleccion = table.rowAtPoint(e.getPoint());
					actualizarLCs(Integer.parseInt(String.valueOf(table.getValueAt(seleccion, 0)))); //mostramos lc con el id de la comanda
					buttonEditar.setEnabled(false);
					buttonDel.setEnabled(true);
					
					if(String.valueOf(table.getValueAt(seleccion, 2)).charAt(0)=='C' && String.valueOf(table.getValueAt(seleccion, 5))=="--" ) buttonFS.setEnabled(true);
					else buttonFS.setEnabled(false);
				}
				
			}
		});
	    
	  //seleccionar una lc
	    table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(editar) {
					buttonEditar.setEnabled(true);
					txtEdit.setEnabled(false);
					buttonSave.setEnabled(false);
					buttonXML.setEnabled(true);					
					editar=false;
					save=false;
				}else {
					buttonEditar.setEnabled(true);
					editar=false;
					seleccion = table2.rowAtPoint(e.getPoint());
					
				}
				
				buttonDel.setEnabled(false);
				eliminar = false;
				
		// 		valores de variables 
				idC = (Integer)table2.getValueAt(table2.rowAtPoint(e.getPoint()), 0);
				idLC = (Integer)table2.getValueAt(table2.rowAtPoint(e.getPoint()), 1);
				status = (Integer)table2.getValueAt(table2.rowAtPoint(e.getPoint()), 5);
				txtEdit.setText(String.valueOf(table2.getValueAt(table2.rowAtPoint(e.getPoint()), 4)));
			
			}
		});
	    
		//boton guardar y modificacion de lc status
		buttonSave.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				try {
	
					 
					if(editar) {
						sqllcs = new SQLLCs();
						editar=false;
						save=false;
						buttonEditar.setEnabled(false);
						buttonSave.setEnabled(false);
						txtEdit.setEnabled(false);
						buttonXML.setEnabled(true);
						editUS();
						
						//comparamos valores de las unidades servidas con las unidades que hay que servir y modificamos el campo status
						if((Integer.parseInt(String.valueOf(table2.getValueAt(seleccion, 3))) == Integer.parseInt(txtEdit.getText()))) editStatusLC(1);
						else if ((Integer.parseInt(String.valueOf(table2.getValueAt(seleccion, 3))) < Integer.parseInt(txtEdit.getText()))) editStatusLC(-1);
						else if ((Integer.parseInt(String.valueOf(table2.getValueAt(seleccion, 3))) > Integer.parseInt(txtEdit.getText()))) editStatusLC(0);
						
						//actualizar lineas de comanda
						actualizarLCs(Integer.parseInt(String.valueOf(table.getValueAt(seleccion, 0))));
						
						//actualizar status Comanda
						if(statusC(Integer.parseInt(String.valueOf(table.getValueAt(seleccion, 0))))) editStatusC('C');							
						else editStatusC('B');
						
						actualizarComandas('T');
								
					}else if(eliminar) {
						 int dialogResult = JOptionPane.showConfirmDialog (null, "Seguro que quieres eliminar la Comanda?","ELIMINAR COMANDA",JOptionPane.YES_NO_OPTION);
						 if(dialogResult == JOptionPane.YES_OPTION) {
							 eliminarComanda(Integer.parseInt(String.valueOf(table.getValueAt(seleccion, 0))));
							 
						 }	 
							
					}
					
					eliminar=false;
					buttonDel.setEnabled(false);
					buttonSave.setEnabled(false);
					
				}catch (NumberFormatException | SQLException j) {
					j.printStackTrace();
				}
			}
		});
		
		//boton eliminar comanda
			buttonDel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e){
						buttonDel.setEnabled(false);
						eliminar = true;
						buttonSave.setEnabled(true);
				}
			});
	
		
	}
	
	public void actualizarComandas(char tipo) {
		try {
			 model.setRowCount(0);
			 sqlcomandas = new SQLComandas();
			 for(Comanda c: sqlcomandas.consultaComandas(tipo)) {
			    	if(c != null) {
				    	int idComanda =  c.getIdComanda();
						String idCliente = c.getIdCliente();
						double precioTotal = c.getPrecioTotal();
						char statusComanda = c.getStatusComanda();
						String fechaE = c.getFechaE();
						String fechaF = c.getFechaF();
				    	
				    	if(fechaF == null || fechaF.isEmpty()) fechaF ="--";
				    	
						model.addRow(new Object[] {Integer.toString(idComanda),idCliente,Character.toString(statusComanda),Double.toString(precioTotal),fechaE,fechaF});
			    	}  	
			    }
			 } catch (NumberFormatException | SQLException e) {
					e.printStackTrace();
			 }
	}
	
	public void actualizarLCs(int id) {
		try {			
			model2.setRowCount(0);
			sqllcs = new SQLLCs();
			for(LC c: sqllcs.consultaLCS(id)) {
				if(c != null) {
					int idC = c.getIdC();
					int idLC = c.getIdLC();
					int idArticulo = c.getIdArticulo();
					int unidades = c.getUnidades();
					int unidadesServidas = c.getUnidadesServidas();
					int statusLC = c.getStatusLC();
					model2.addRow(new Object[] {idC, idLC, idArticulo, unidades, unidadesServidas, statusLC});
				}
				
			}
			
		}catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void editUS() {
		try {
			sqllcs = new SQLLCs();
			sqllcs.updateUS(idLC, idC, Integer.parseInt(txtEdit.getText()));
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}	
		
	}
	
	public void editStatusLC(int status) {
		try {
			sqllcs = new SQLLCs();
			sqllcs.updateStatus(idLC, idC, status);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}	
		
		
	}
	
	public void editStatusC(char status) {
		try {
			sqlcomandas = new SQLComandas();
			sqlcomandas.updateStatus(idC, status);
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	public boolean statusC(int id) throws SQLException {
		int size = 0;
		try {			
			model2.setRowCount(0);
			sqllcs = new SQLLCs();
			for(LC c: sqllcs.consultaLCS(id)) {
				if(c != null) size++;
			}
			
			
		}catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		if(size ==  sqllcs.contStatus(id)) return true;
		else return false;
		
		
	}
	
	public void eliminarComanda(int id) {
		try {		
			 eliminarLCs(id);
			 actualizarLCs(id);
			 sqlcomandas = new SQLComandas();
			 sqlcomandas.deleteComanda(id);
			 actualizarComandas('T');

		}catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void eliminarLCs(int id) {
		try {			
			 sqllcs = new SQLLCs();
			 sqllcs.deleteLCs(id);
			
		}catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void upFechaS(int id) {
		try {			
			 sqlcomandas = new SQLComandas();
			 sqlcomandas.updateFechaS(id);
			 actualizarComandas('T');
			
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}

