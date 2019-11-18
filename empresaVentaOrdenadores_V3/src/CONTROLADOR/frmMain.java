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

public class frmMain {

	private JFrame frmSolcomputerSl;

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
		frmSolcomputerSl.setBounds(100, 100, 450, 300);
		frmSolcomputerSl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(100, 149, 237));
		frmSolcomputerSl.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnOpcions = new JMenu("MENU");
		menuBar.add(mnOpcions);
		
		JMenuItem mntmGestiDeClients = new JMenuItem("Gestió de clients");
		mntmGestiDeClients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmClientes frmClientes = new frmClientes();
				frmClientes.newScreen();
				
			}
		});
		mnOpcions.add(mntmGestiDeClients);
	}

}
