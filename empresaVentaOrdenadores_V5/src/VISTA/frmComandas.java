package VISTA;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DATOS.SQLClientes;
import MODELO.Cliente;

public class frmComandas {
	int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width/2;
    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height/2;
	int seleccion;
    public JFrame frmCo;
	frmComandas window;
	JTextField txtGC;

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
		    
	}
	public void eventos() {
		
	}
}
