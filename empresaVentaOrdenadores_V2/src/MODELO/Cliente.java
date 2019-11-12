package MODELO;
/**
 * Clase para tratar todos los atributos y metodos de un cliente.
 * @author Sol Marin
 * @version 1
 */
public class Cliente {
	//Atributos
		private String nombreEmpresa;
		private String cif;
		private String direccion;
		private String poblacion;
		private int cp;
		
	//Constructor
		public Cliente( String nombreEmpresa, String cif, String direccion, String poblacion, int cp) {
			super();
			this.nombreEmpresa = nombreEmpresa;
			this.cif = cif;
			this.direccion = direccion;
			this.poblacion = poblacion;
			this.cp = cp;
		}
		
	//Metodos 
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

		@Override
		public String toString() {
			return String.format("Cliente [nombreEmpresa=%s, cif=%s, direccion=%s, poblacion=%s, cp=%s]", nombreEmpresa,
					cif, direccion, poblacion, cp);
		}
		
		

}
