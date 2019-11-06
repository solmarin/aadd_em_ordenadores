package MODELO;
/**
 * Clase para tratar todos los atributos y metodos de los componentes.
 * @author Sol Marin
 * @version 1
 */
public class Componente {
	//Atributos
		private String nombre;
		private String descripcion;
		private int idComponente;
		private int idProveidor;
		private double precio;
		
	//Constructor
		public Componente(String nombre, String descripcion, int idComponente, int idProveidor, double precio) {
			super();
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.idComponente = idComponente;
			this.idProveidor = idProveidor;
			this.precio = precio;
		}
		
	//Metodos
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public int getIdComponente() {
			return idComponente;
		}

		public void setIdComponente(int idComponente) {
			this.idComponente = idComponente;
		}

		public int getIdProveidor() {
			return idProveidor;
		}

		public void setIdProveidor(int idProveidor) {
			this.idProveidor = idProveidor;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}
	
		/**public void pedirComponentes() {
		...
		}
		 **/

}
