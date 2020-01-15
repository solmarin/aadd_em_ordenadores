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
		private int idArticulo;
		private int unidades;
		private int unidadesServidas;
		private int statusLC;
		private double precioU;
		private double precioTLC;
		
	//Constructor
		public LC(int idLC, int idC, int idArticulo, int unidades, int unidadesServidas, int statusLC) {
			super();
			this.idC = idC;
			this.idLC = idLC;
			this.unidades = unidades;
			this.unidadesServidas = unidadesServidas;
			this.statusLC = statusLC;
			this.precioU = precioU;
			this.idArticulo = idArticulo;
			this.getPrecioTLC();
		}
		
	//constructor xml
		public LC(int idC, int idArticulo, int unidades, int unidadesServidas, int statusLC) {
			this.idC = idC;
			this.idArticulo = idArticulo;
			this.unidades = unidades;
			this.unidadesServidas = unidadesServidas;
			this.statusLC = statusLC;
			this.getPrecioTLC();
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
			return statusLC;
		}

		public void setStatusLC(int statusLC) {
			statusLC = statusLC;
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
		

		public int getIdArticulo() {
			return idArticulo;
		}

		public void setIdArticulo(int idArticulo) {
			this.idArticulo = idArticulo;
		}

		public int getStatusLC() {
			return statusLC;
		}

		public void setPrecioTLC(double precioTLC) {
			this.precioTLC = precioTLC;
		}

		@Override
		public String toString() {
			return String.format("		LC: idC=%s, idArticulo=%s, unidades=%s, unidadesServidas=%s, statusLC=%s\n",
					idC, idArticulo, unidades, unidadesServidas, statusLC);
		}


}
