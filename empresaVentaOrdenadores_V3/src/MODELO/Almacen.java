package MODELO;
/**
 * Clase para tratar todos los atributos y metodos de un almacen.
 * @author Sol Marin
 * @version 1
 */
public class Almacen {
	//atributos
		private int idAlmacen;
		private String nombreAlmacen;
		
	//Constructor
		public Almacen(int idAlmacen, String nombreAlmacen) {
			this.idAlmacen = idAlmacen;
			this.nombreAlmacen = nombreAlmacen;
		}
		
	//Metodos
		public int getIdAlmacen() {
			return idAlmacen;
		}

		public void setIdAlmacen(int idAlmacen) {
			this.idAlmacen = idAlmacen;
		}

		public String getNombreAlmacen() {
			return nombreAlmacen;
		}

		public void setNombreAlmacen(String nombreAlmacen) {
			this.nombreAlmacen = nombreAlmacen;
		}
		


}
