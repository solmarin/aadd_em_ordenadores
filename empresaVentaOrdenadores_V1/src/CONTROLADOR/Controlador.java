package CONTROLADOR;
import DATOS.LectorXML;

/**
 * Programa principal del programa, actualmente se encarga de mostrar por pantalla todos los objetos rellenados apartir de un xml. 
 * @author Sol Marin
 * @version 2
 *
 */
public class Controlador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LectorXML lectorXML = new LectorXML();
		
		
		System.out.println("----------------------------");
	    System.out.println("MOSTRAMOS LOS OBJETOS");
	    System.out.println("----------------------------");
		System.out.println(lectorXML.csToString());
		
	}

}
