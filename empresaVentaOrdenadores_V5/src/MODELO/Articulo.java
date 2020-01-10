package MODELO;
// import java.util.ArrayList;
/**
 * Clase para tratar todos los atributos y metodos de un articulo.
 * @author Sol Marin
 * @version 1
 */
public class Articulo {
	//Atributos
		private String descripcion;
		private int idArticulo;
		private int unidades;
		private double precio;
		// private ArrayList<Integer> idComponentes = new ArrayList<Integer>();
		
	//Constructor
		public Articulo( String descripcion, double precio, int unidades) {
			super();
			this.unidades = unidades;
			this.descripcion = descripcion;
			this.precio = precio;
		}
		public Articulo(int idArticulo, String descripcion, double precio, int unidades) {
			super();
			this.idArticulo = idArticulo;
			this.unidades = unidades;
			this.descripcion = descripcion;
			this.precio = precio;
		}
	//Metodes	
		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public int getIdArticulo() {
			return idArticulo;
		}

		public void setIdArticulo(int idArticulo) {
			this.idArticulo = idArticulo;
		}

		public int getUnidades() {
			return unidades;
		}

		public void setUnidades(int unidades) {
			this.unidades = unidades;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}
		
		@Override
		public String toString() {
			return String.format("Articulo [idArticulo=%s, descripcion=%s,unidades=%s, precio=%s]", idArticulo, descripcion,
		unidades, precio);
		}
		

}
