package CONTROLADOR;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JMenuItem;

import VISTA.frmClientes;

import javax.swing.JMenu;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmMain {

	private JFrame frmSolcomputerSl;
	private  int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width/2;
    private int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height/2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMain window = new frmMain();
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
	public frmMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSolcomputerSl = new JFrame();
		frmSolcomputerSl.setType(Type.UTILITY);
		frmSolcomputerSl.setFont(new Font("aakar", Font.BOLD, 12));
		frmSolcomputerSl.getContentPane().setFont(new Font("Impact", Font.BOLD, 12));
		frmSolcomputerSl.setTitle("SolComputer SL");
		frmSolcomputerSl.setBounds(500, 200, ancho, alto);
		frmSolcomputerSl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(173, 216, 230));
		frmSolcomputerSl.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnOpcions = new JMenu("MENU");
		menuBar.add(mnOpcions);
		
		JButton btnNewButton = new JButton("Gestió Clients");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmClientes frmClientes = new frmClientes();
				frmClientes.newScreen();
			}
		});
		mnOpcions.add(btnNewButton);
		
	}

}
