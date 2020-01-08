package MODELO;
/**
 * Clase LC, donde tratamos todos los metodos necesarios de los atributos que contiene una linea de comanda.
 * @author Sol Marin
 * @version 2
 *
 */
public class LC {
	//Atributos
		private int idLC;
		private int idC;
		private int unidades;
		private int unidadesServidas;
		private int StatusLC;
		private double precioU;
		private double precioTLC;
	//Constructor
		public LC(int idLC, int unidades, int unidadesServidas,double precioU, int statusLC) {
			super();
			this.idLC = idLC;
			this.unidades = unidades;
			this.unidadesServidas = unidadesServidas;
			this.StatusLC = statusLC;
			this.precioU = precioU;
		}
		
	//Metodos
		public int getIdLC() {
			return idLC;
		}

		

		public void setIdLC(int idLC) {
			this.idLC = idLC;
		}

		public int getIdC() {
			return idC;
		}

		public void setIdC(int idC) {
			this.idC = idC;
		}


		public int getUnidades() {
			return unidades;
		}

		public void setUnidades(int unidades) {
			this.unidades = unidades;
		}

		public int isStatusLC() {
			return StatusLC;
		}

		public void setStatusLC(int statusLC) {
			StatusLC = statusLC;
		}

		public int getUnidadesServidas() {
			return unidadesServidas;
		}

		public void setUnidadesServidas(int unidadesServidas) {
			this.unidadesServidas = unidadesServidas;
		}
		
		public double getPrecioU() {
			return precioU;
		}

		public void setPrecioU(double precioU) {
			this.precioU = precioU;
		}
		
		public double getPrecioTLC() {
			this.setPrecioTLC();
			return precioTLC;
		}

		public void setPrecioTLC() {
			this.precioTLC = this.precioU*this.getUnidades();
		}
		

		@Override
		public String toString() {
			return String.format("		LC: idLC=%s,unidades=%s, unidadesServidas=%s, StatusLC=%s, precioU=%s€, precioTLC=%s\n",
					idLC, unidades, unidadesServidas, StatusLC, precioU, precioTLC);
		}


}
