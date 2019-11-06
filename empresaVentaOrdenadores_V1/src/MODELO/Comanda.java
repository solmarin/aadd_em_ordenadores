package MODELO;
import java.util.ArrayList;
import java.util.Date;
/**
 * Clase comanda, donde tenemos los constructores y metodos para trabajar con todos los atributos de una comanda.
 * @author Sol Marin
 * @version 2
 *
 */

public class Comanda {
	//Atributos
		private int idComanda;
		private int idCliente;
		private int idProveidorTransport;
		private double precioTotal = 0;
		private char statusComanda;
		private Date fechaE;
		private Date fechaF;
		private ArrayList<LC> productosSeleccionados = new ArrayList<LC>();

		
	//Constructors
		public Comanda(int idComanda, int idCliente,ArrayList<LC> productosSeleccionados, Date fechaE,char statusComanda) {
			super();
			this.idComanda = idComanda;
			this.idCliente = idCliente;
			this.statusComanda = statusComanda;
			this.fechaE = fechaE;
			this.productosSeleccionados=productosSeleccionados;
		}
		
		public Comanda(int idCliente,ArrayList<LC> productosSeleccionados, Date fechaE,char statusComanda) {
			super();
			this.idCliente = idCliente;
			this.statusComanda = statusComanda;
			this.fechaE = fechaE;
			this.productosSeleccionados=productosSeleccionados;
		}
	//Metodos
		public int getIdComanda() {
			return idComanda;
		}

		public void setIdComanda(int idComanda) {
			this.idComanda = idComanda;
		}

		public int getIdCliente() {
			return idCliente;
		}

		public void setIdCliente(int idCliente) {
			this.idCliente = idCliente;
		}

		public int getIdProveidorTransport() {
			return idProveidorTransport;
		}

		public void setIdProveidorTransport(int idProveidorTransport) {
			this.idProveidorTransport = idProveidorTransport;
		}


		public char getStatusComanda() {
			return statusComanda;
		}

		public void setStatusComanda(char statusComanda) {
			this.statusComanda = statusComanda;
		}

		public Date getFechaE() {
			return fechaE;
		}

		public void setFechaE(Date fechaE) {
			this.fechaE = fechaE;
		}

		public Date getFechaF() {
			return fechaF;
		}

		public void setFechaF(Date fechaF) {
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
		
		public void omplirComandes(ArrayList<Comanda>cs) {
			for(int i=0; i < cs.size(); i++) {
				this.setIdCliente(cs.get(i).idCliente);
				this.setIdComanda(cs.get(i).idComanda);
				this.setFechaE(cs.get(i).fechaE);
				this.setStatusComanda(cs.get(i).statusComanda);
				this.setProductosSeleccionados(cs.get(i).productosSeleccionados);
			}
		}
		
		@Override
		public String toString() {
			return String.format(
					"	\n	Comanda [idComanda=%s, idCliente=%s, precioTotal=%s€, statusComanda=%s, fechaE=%s, \n	productosSeleccionados=\n%s]",
					idComanda, idCliente, this.getPrecioTotal(), statusComanda, fechaE, productosSeleccionados);
		}
		
		

}
