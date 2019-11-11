package CONTROLADOR;
import java.sql.SQLException;

import DATOS.LectorXML;
import DATOS.SQLClientes;

/**
 * Programa principal del programa, actualmente se encarga de mostrar por pantalla todos los objetos rellenados apartir de un xml. 
 * @author Sol Marin
 * @version 2
 *
 */
public class Controlador {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		/**LectorXML lectorXML = new LectorXML();
		System.out.println("----------------------------");
	    System.out.println("MOSTRAMOS LOS OBJETOS");
	    System.out.println("----------------------------");
		System.out.println(lectorXML.csToString());
		**/
		
		SQLClientes sqlclientes = new SQLClientes();
		
		sqlclientes.consultaClientes("clientes");
		
	
		
	}

}
