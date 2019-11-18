package MODELO;
/**
 * Clase para tratar todos los atributos y metodos de un proveidor.
 * @author Sol Marin
 * @version 1
 */
public class Proveidor {
	//Atributos
	   private int idProveidor;
	   private String nombre;
	   private String tipoServei;
	   private double precio;
	   
	//Constructor
		public Proveidor(int idProveidor, String nombre, String tipoServei, double precio) {
			super();
			this.idProveidor = idProveidor;
			this.nombre = nombre;
			this.tipoServei = tipoServei;
			this.precio = precio;
		}
		
	//Metodos
		public int getIdProveidor() {
			return idProveidor;
		}
		public void setIdProveidor(int idProveidor) {
			this.idProveidor = idProveidor;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getTipoServei() {
			return tipoServei;
		}
		public void setTipoServei(String tipoServei) {
			this.tipoServei = tipoServei;
		}
		public double getPrecio() {
			return precio;
		}
		public void setPrecio(double precio) {
			this.precio = precio;
		}
		
	   


}
