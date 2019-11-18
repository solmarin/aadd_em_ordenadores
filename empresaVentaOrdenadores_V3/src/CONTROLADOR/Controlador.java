package CONTROLADOR;
import java.sql.SQLException;
import java.util.ArrayList;

import DATOS.LectorXML;
import DATOS.SQLClientes;
import MODELO.Cliente;
import MODELO.LC;

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
		
		//insertamos un cliente
		SQLClientes sqlclientes = new SQLClientes();
		sqlclientes.insertaClientes(new Cliente("PruevaInfo3", "A-11111113","C. St. joan","St. vicenç de castellet", Integer.parseInt("08295")));
		//borramos un cliente
		sqlclientes.deleteClientes("A-11111113");
		//modificamos un cliente
		sqlclientes.updateClientes("A-11111112","PruevaM2");
		//mostramos los clientes
		System.out.println("CLIENTES");
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes = sqlclientes.consultaClientes("clientes");
		System.out.println(clientes.toString());
	
		
	}

}
