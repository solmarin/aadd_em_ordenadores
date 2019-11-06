package MODELO;
import java.util.ArrayList;
/**
 * Clase para tratar todos los atributos y metodos de un articulo.
 * @author Sol Marin
 * @version 1
 */
public class Articulo {
	//Atributos
		private String nombre;
		private int idArticulo;
		private ArrayList<Integer> idComponentes = new ArrayList<Integer>();
		private int unidades;
		private double precio;
		
	//Constructor
		public Articulo(int idArticulo, int unidades) {
			super();
			this.idArticulo = idArticulo;
			this.unidades = unidades;
		}
	//Metodes	
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getIdArticulo() {
			return idArticulo;
		}

		public void setIdArticulo(int idArticulo) {
			this.idArticulo = idArticulo;
		}

		/** public ArrayList<Integer> getIdComponentes() {
			return idComponentes;
		}

		public void setIdComponentes(ArrayList<Integer> idComponentes) {
			this.idComponentes = idComponentes;
		}
		**/
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
