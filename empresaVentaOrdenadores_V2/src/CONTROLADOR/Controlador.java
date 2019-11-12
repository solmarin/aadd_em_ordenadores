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
		
		SQLClientes sqlclientes = new SQLClientes();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes = sqlclientes.consultaClientes("clientes");
		for(int i=0; clientes.size()>i;++i) System.out.println(clientes.get(i).toString());
		
		
		//sqlclientes.insertaClientes( "PruevaInfo", "A-11111111","C. St. joan","St. vicenç de castellet", Integer.parseInt("08295"));
		
	
		
	}

}
