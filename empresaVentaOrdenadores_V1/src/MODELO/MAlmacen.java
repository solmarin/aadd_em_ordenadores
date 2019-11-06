package MODELO;
/**
 * Clase para tratar todos los atributos y metodos de los movimientos de almacen.
 * @author Sol Marin
 * @version 1
 */
public class MAlmacen {
	//Atributos
		private int idMAlmacen;
		private int idAlmacen;
		private char tipoMAlmacen;
		private int idArticuloMAlmacen;
		private int unidades;
		private int[] ubicacion = new int[3];
		
	//Constructor
		public MAlmacen(int idMAlmacen, int idAlmacen, char tipoMAlmacen, int idArticuloMAlmacen, int unidades,
				int[] ubicacion) {
			
			this.idMAlmacen = idMAlmacen;
			this.idAlmacen = idAlmacen;
			this.tipoMAlmacen = tipoMAlmacen;
			this.idArticuloMAlmacen = idArticuloMAlmacen;
			this.unidades = unidades;
			for(int i=0; i<ubicacion.length; ++i) this.ubicacion[i] = ubicacion[i];
		}
		
	//Metodos
		public int getIdMAlmacen() {
			return idMAlmacen;
		}

		public void setIdMAlmacen(int idMAlmacen) {
			this.idMAlmacen = idMAlmacen;
		}

		public int getIdAlmacen() {
			return idAlmacen;
		}

		public void setIdAlmacen(int idAlmacen) {
			this.idAlmacen = idAlmacen;
		}

		public char getTipoMAlmacen() {
			return tipoMAlmacen;
		}

		public void setTipoMAlmacen(char tipoMAlmacen) {
			this.tipoMAlmacen = tipoMAlmacen;
		}

		public int getIdArticuloMAlmacen() {
			return idArticuloMAlmacen;
		}

		public void setIdArticuloMAlmacen(int idArticuloMAlmacen) {
			this.idArticuloMAlmacen = idArticuloMAlmacen;
		}

		public int getUnidades() {
			return unidades;
		}

		public void setUnidades(int unidades) {
			this.unidades = unidades;
		}

		public void getUbicacion() {
			for(int i=0; i<this.ubicacion.length; ++i)System.out.println(this.ubicacion[i]);
		}

		public void setUbicacion(int[] ubicacion) {
			for(int i=0; i<ubicacion.length; ++i) this.ubicacion[i] = ubicacion[i];
		}
	
		

}
