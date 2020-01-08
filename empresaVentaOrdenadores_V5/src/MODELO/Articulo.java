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
		public Articulo(int idArticulo, int unidades) {
			super();
			this.idArticulo = idArticulo;
			this.unidades = unidades;
		}
	//Metodes	
		public String getNombre() {
			return descripcion;
		}

		public void setNombre(String descripcion) {
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
		

}
