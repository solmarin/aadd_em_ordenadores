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
import javax.swing.JLabel;
import javax.swing.JTextField;

import DATOS.SQLClientes;

public class frmSaveDelete{
	
	public JFrame frmSD;
	int ancho = (java.awt.Toolkit.getDefaultToolkit().getScreenSize().width/2)/2;
    int alto = (java.awt.Toolkit.getDefaultToolkit().getScreenSize().height/2)/2;
    JTextField txtSaveDelete;
    JTextField txtElim;
    JLabel lblElim;
    String cif;

	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmSaveDelete window = new frmSaveDelete();
					window.frmSD.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	 
	public frmSaveDelete(String cif) {
		this.cif = cif;
		initialize();
	}

	 //Initialize the contents of the frame.
	 
	@SuppressWarnings("serial")
	private void initialize() {
	
		//pantalla
		frmSD = new JFrame();
		frmSD.setType(Type.UTILITY);
		frmSD.setFont(new Font("aakar", Font.BOLD, 12));
		frmSD.getContentPane().setFont(new Font("Impact", Font.BOLD, 12));
		frmSD.setTitle("SolComputer SL");
		frmSD.setBounds(720, 300, ancho, alto);
		frmSD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSD.getContentPane().setLayout(null);
		
		//titulo
		txtSaveDelete = new JTextField();
		txtSaveDelete.setBounds(0, 0, 960, 22);
		txtSaveDelete.setBackground(new Color(173, 216, 230));
		txtSaveDelete.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtSaveDelete.setText("Eliminar un cliente");
		frmSD.getContentPane().add(txtSaveDelete);
		txtSaveDelete.setColumns(10);
		txtSaveDelete.setEditable(false);
		
		//texto
		lblElim = new JLabel("Estas seguro que quieres eliminar el cliente?");
		lblElim.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblElim.setBounds(50, 40, 960, 22);
		frmSD.getContentPane().add(lblElim);
		
		//bottones
		JButton button = new JButton("Si");
		button.setFont(new Font("Dialog", Font.BOLD, 8));
		button.setBounds(50, 100, 150, 50);
		frmSD.getContentPane().add(button);
		
		JButton button_1 = new JButton("No");
		button_1.setFont(new Font("Dialog", Font.BOLD, 8));
		button_1.setBounds(250, 100, 150, 50);
		frmSD.getContentPane().add(button_1);
		
		//acciones con los botones
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmClientes c = new frmClientes();
				c.setSeguroDel(true);
				frmSD.setVisible(false);
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmClientes c = new frmClientes();
				c.setSeguroDel(false);
				frmSD.setVisible(false);
			}
		});
	}

}
