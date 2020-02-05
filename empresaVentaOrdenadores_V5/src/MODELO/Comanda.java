package MODELO;
import java.util.ArrayList;
/**
 * Clase comanda, donde tenemos los constructores y metodos para trabajar con todos los atributos de una comanda.
 * @author Sol Marin
 * @version 2
 *
 */

public class Comanda {
	//Atributos
		private int idComanda;
		private String idCliente;
		private double precioTotal;
		private char statusComanda;
		private String fechaE;
		private String fechaF;
		private ArrayList<LC> productosSeleccionados = new ArrayList<LC>();

		
	//Constructor xml
		public Comanda(int idComanda,String idCliente, char statusComanda,String fechaE, double preuTotal, ArrayList<LC>productosSeleccionados) {
			super();
			this.idComanda = idComanda;
			this.idCliente = idCliente;
			this.statusComanda = statusComanda;
			this.fechaE = fechaE;
			this.precioTotal = this.getPrecioTotal();
			this.productosSeleccionados = productosSeleccionados;
			
		}
		

	//constructor sql
		public Comanda(int idComanda, String idCliente, String fechaE,char statusComanda, double preuTotal, String fechaF) {
			super();
			this.idComanda = idComanda;
			this.idCliente = idCliente;
			this.statusComanda = statusComanda;
			this.fechaE = fechaE;
			this.precioTotal = preuTotal;
			this.fechaF = fechaF;
		}
		
	//Metodos
		public int getIdComanda() {
			return idComanda;
		}

		public void setIdComanda(int idComanda) {
			this.idComanda = idComanda;
		}

		public String getIdCliente() {
			return idCliente;
		}

		public void setIdCliente(String idCliente) {
			this.idCliente = idCliente;
		}


		public char getStatusComanda() {
			return statusComanda;
		}

		public void setStatusComanda(char statusComanda) {
			this.statusComanda = statusComanda;
		}

		public String getFechaE() {
			return fechaE;
		}

		public void setFechaE(String fechaE) {
			this.fechaE = fechaE;
		}

		public String getFechaF() {
			return fechaF;
		}

		public void setFechaF(String fechaF) {
			this.fechaF = fechaF;
		}
		
		public double getPrecioTotal () {
			for(LC lc : productosSeleccionados) precioTotal += lc.getPrecioTLC();			
			return precioTotal;
		}
		
		public ArrayList<LC> getProductosSeleccionados() {
			return productosSeleccionados;
		}
		
		public void setProductosSeleccionados(ArrayList<LC> productosSeleccionados) {
			this.productosSeleccionados = productosSeleccionados;
		}
		
		
		@Override
		public String toString() {
			return String.format(
					"	\n	Comanda [idComanda=%s, idCliente=%s, precioTotal=%s€, statusComanda=%s, fechaE=%s, \n	productosSeleccionados=\n%s]",
					idComanda, idCliente, this.getPrecioTotal(), statusComanda, fechaE, productosSeleccionados);
		}
		
		

}
