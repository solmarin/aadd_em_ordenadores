package DATOS;
import MODELO.*;
import java.io.File;
import java.text.SimpleDateFormat;

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
	SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");	//donde guardaremos la fechaE (fecha inicial) 

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
					    	      NodeList nl = nNodeC.getChildNodes(); //creamos el nodo para navegar por los "hijos"
					    	      lcs = new ArrayList<LC>(); //inicializamos un arrayList para las lineas de comanda
					    	      
					    	      for(int j=0; j<nl.getLength(); j++) { //recorremos la linea de comanda
					    	        Node nd = nl.item(j);	//nodo para navegar por los atributos y componentes de linea de comanda
							          if (nd.getNodeType() == Node.ELEMENT_NODE ) {
							            Element eElement = (Element) nd;	//creamos un elemento desde el nodo de linea de comanda
							           
							            lcs.add(new LC( //rellenamos el arraylist con una nueva linea de comanda
							            		Integer.parseInt(eElementC.getAttribute("idC")),
							            		lcs.size()+1,
							            		Integer.parseInt(eElement.getAttribute("articulo")),
							            		Integer.parseInt(eElement.getElementsByTagName("unidades").item(0).getTextContent()),
							     				Integer.parseInt(eElement.getElementsByTagName("unidadesServidas").item(0).getTextContent()),
							     				Integer.parseInt(eElement.getElementsByTagName("statusLC").item(0).getTextContent())
							     				));
							          }
						    	     
					    	      }
					    	     
					       cs.add(new Comanda( //rellenamos el arraylist de comanda con una nueva comanda
					    		   	  Integer.parseInt(eElementC.getAttribute("idC")),
				    	    		  eElementC.getAttribute("idCliente").toString(),
				    	    		  'B', //cambiamos el status al introducirlo en la bbdd
				    	    		  date.format(new Date()),
				    	    		  0,
				    	    		  this.getLCs()
					    		   ));
					       
				      } 
			     }       
			    } catch (Exception e) {
			       e.printStackTrace();
			    }
	 }

	public ArrayList<LC> getLCs() {
		return this.lcs;
	}
	
	public ArrayList<Comanda> getCS(){
		return this.cs;
	}
	

	
}


