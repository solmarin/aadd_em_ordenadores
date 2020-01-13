package VISTA;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DATOS.LectorXML;
import DATOS.SQLComandas;
import MODELO.Comanda;

public class frmComandas {
	int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width/2;
    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height/2;
	int seleccion;
    public JFrame frmCo;
	frmComandas window;
	JTextField txtGC;
	Object[] titulos = {"idComanda", "idCliente", "Status", "Precio Total", "Fecha entrada", "Fecha Salida"};
	Object[] celdas;
	JButton buttonXML;
	JScrollPane scroll;
	DefaultTableModel model; 
	JTable table;
	SQLComandas sqlcomandas;

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
			
		//tabla 
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
		    
		  //bottones
			buttonXML = new JButton("Insertar XML");
			buttonXML.setFont(new Font("Dialog", Font.BOLD, 18));
			buttonXML.setBounds(10, 440, 200, 50);
			frmCo.getContentPane().add(buttonXML);
			
			actualizarComandas();
		    
	}
	
	public void eventos() {
			
		buttonXML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					 LectorXML lectorXML = new LectorXML();
					 sqlcomandas = new SQLComandas();
					 for(int i = 0; i< lectorXML.getCS().size(); ++i) {
						 sqlcomandas.insertaComandas(lectorXML.getCS().get(i));
						 	
					    }
					 actualizarComandas();
					 } catch (NumberFormatException | SQLException e) {
							e.printStackTrace();
					 }
				
				
			}
			
		});
		
	}
	
	public void actualizarComandas() {
		try {
			 model.setRowCount(0);
			 sqlcomandas = new SQLComandas();
			 for(Comanda c: sqlcomandas.consultaComandas()) {
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
	
	
}

