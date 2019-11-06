package DATOS;
import MODELO.*;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que lee arxivos xml y crea los arrays pertinentes para crear las clases necesarias (lineas de comanda y comanda).  
 * @author Sol Marin
 * @version v2
 */
public class LectorXML {
	//Declarem variables
	ArrayList<Comanda> cs = new ArrayList<Comanda>(); //donde guardamos las comandas
    ArrayList<LC> lcs; //donde guardamos las lineas de comandas
	Date date;	//donde guardaremos la fechaE (fecha inicial) 

	public LectorXML(){

			try {
			    //Leer  archivo xml
			       File inputFile = new File("datosComanda.xml");
			       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			       Document doc = dBuilder.parse(inputFile);
			       doc.getDocumentElement().normalize();
			       
			       NodeList nComanda = doc.getElementsByTagName("comanda"); //nodo para encontrar las etiquetas de comanda
			      //for para recorrer cada comanda entera
			       for(int tam = 0; tam < nComanda.getLength(); ++tam) {
			    	   Node nNodeC = nComanda.item(tam); //nodo para iterar entre todas las comandas
			    	   Element eElementC = (Element) nNodeC; //elemento para trabajar con los atributos y propiedades de las comandas
			    	   
			    	   if(eElementC.getAttribute("statusComanda").charAt(0)=='A' && nNodeC.hasChildNodes()) { //si el estatus es A y tiene "hijos", miramos los hijos que tiene
					    	   	  date = new Date(); 
					    	      NodeList nl = nNodeC.getChildNodes(); //creanis el nodo para navegar por los "hijos"
					    	      lcs = new ArrayList<LC>(); //inicializamos un arrayList para las lineas de comanda
					    	      
					    	      for(int j=0; j<nl.getLength(); j++) { //recorremos la linea de comanda
					    	        Node nd = nl.item(j);	//nodo para navegar por los atributos y componentes de linea de comanda
							          if (nd.getNodeType() == Node.ELEMENT_NODE ) {
							            Element eElement = (Element) nd;	//creamos un elemento desde el nodo de linea de comanda
							           
							     		lcs.add(new LC(	//rellenamos el arraylist con una nueva linea de comanda
							     				Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()),
							     				Integer.parseInt(eElement.getElementsByTagName("unidades").item(0).getTextContent()),
							     				Integer.parseInt(eElement.getElementsByTagName("unidadesServidas").item(0).getTextContent()),
							     				Double.parseDouble(eElement.getElementsByTagName("precioUnitario").item(0).getTextContent()),
							     				Boolean.parseBoolean(doc.getDocumentElement().getAttribute("statusLC"))));
							          }
						    	     
					    	      }
					    	     
					       cs.add(new Comanda( //rellenamos el arraylist de comanda con una nueva comanda
				    	    		  Integer.parseInt(eElementC.getAttribute("idCliente")),
				    	    		  this.getLcs(),
				    	    		  date,
				    	    		  eElementC.getAttribute("statusComanda").charAt(0)));
				      } 
			     }       
			    } catch (Exception e) {
			       e.printStackTrace();
			    }
	 }

	public ArrayList<LC> getLcs() {
		return this.lcs;
	}
	
	public String csToString() {
		return String.format("LectorXML [cs = %s]", cs);
	}

	
}


