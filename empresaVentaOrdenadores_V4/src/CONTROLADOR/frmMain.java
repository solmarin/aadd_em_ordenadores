package CONTROLADOR;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import VISTA.frmClientes;
import javax.swing.JMenu;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Clase para la creación de la pantalla inicio del programa y la llamada de las otras ventanas (ejemplo: formulario clientes)
 * @author Sol Marin
 * @version 2
 */
public class frmMain {
	//Declaración de variables
		private JFrame frmSolcomputerSl;
		private  int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width/2;
		private int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height/2;
		JMenuBar menuBar;
		JMenu mnOpcions;
		JButton btnNewButton;

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
	 * Constructor: Create the application.
	 */
		public frmMain() {
			initialize();
		}

	/**
	 * Initialize the contents of the frame.
	 */
		private void initialize() {
			//frame 
				frmSolcomputerSl = new JFrame();
				frmSolcomputerSl.setType(Type.UTILITY);
				frmSolcomputerSl.setFont(new Font("aakar", Font.BOLD, 12));
				frmSolcomputerSl.getContentPane().setFont(new Font("Impact", Font.BOLD, 12));
				frmSolcomputerSl.setTitle("SolComputer SL");
				frmSolcomputerSl.setBounds(500, 200, ancho, alto);
				frmSolcomputerSl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//menu opciones
				menuBar = new JMenuBar();
				menuBar.setBounds(0, 0, 960, 32);
				menuBar.setBackground(new Color(173, 216, 230));
				frmSolcomputerSl.getContentPane().add(menuBar, BorderLayout.NORTH);
			
				mnOpcions = new JMenu("MENU");
				menuBar.add(mnOpcions);
				
			//Evento: abrir ventana formulario clientes
				btnNewButton = new JButton("Gestió Clients");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						frmClientes frmClientes = new frmClientes();
						frmClientes.frmC.setVisible(true);
					}
				});
				mnOpcions.add(btnNewButton);
			
	}

}
