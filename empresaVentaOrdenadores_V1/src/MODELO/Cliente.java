package MODELO;
/**
 * Clase para tratar todos los atributos y metodos de un cliente.
 * @author Sol Marin
 * @version 1
 */
public class Cliente {
	//Atributos
		private int idCliente;
		private String nombreEmpresa;
		private String cif;
		private String direccion;
		private String poblacion;
		private int cp;
		
	//Constructor
		public Cliente(int idCliente, String nombreEmpresa, String cif, String direccion, String poblacion, int cp) {
			super();
			this.idCliente = idCliente;
			this.nombreEmpresa = nombreEmpresa;
			this.cif = cif;
			this.direccion = direccion;
			this.poblacion = poblacion;
			this.cp = cp;
		}
		
	//Metodos 
		public int getIdCliente() {
			return idCliente;
		}
		public void setIdCliente(int idCliente) {
			this.idCliente = idCliente;
		}
		public String getNombreEmpresa() {
			return nombreEmpresa;
		}
		public void setNombreEmpresa(String nombreEmpresa) {
			this.nombreEmpresa = nombreEmpresa;
		}
		public String getCif() {
			return cif;
		}
		public void setCif(String cif) {
			this.cif = cif;
		}
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		public String getPoblacion() {
			return poblacion;
		}
		public void setPoblacion(String poblacion) {
			this.poblacion = poblacion;
		}
		public int getCp() {
			return cp;
		}
		public void setCp(int cp) {
			this.cp = cp;
		}
		
		/** public void crearComanda(){
			...
		}
		public int selecProducte(){
		...
		}
		public int elimProducte(){
		...
		}
		public void consultarComanda(int idComanda){
		...
		}
		**/

}
