package MODELO;
/**
 * Clase para tratar todos los atributos y metodos de la relacion componente-articulo.
 * @author Sol Marin
 * @version 1
 */

public class AC {
	//Atributos
		private String idArticulo;
		private String idComponente;
		
	//Constructor
		public AC(String idArticulo, String idComponente) {
			super();
			this.idArticulo = idArticulo;
			this.idComponente = idComponente;
		}
		
	//Metodos
		public String getIdArticulo() {
			return idArticulo;
		}

		public void setIdArticulo(String idArticulo) {
			this.idArticulo = idArticulo;
		}

		public String getIdComponente() {
			return idComponente;
		}

		public void setIdComponente(String idComponente) {
			this.idComponente = idComponente;
		}
	
		/**public void addArtComp(int idComponente,int idArticulo) {
		...
		}
		public void delArtComp(int idComponente,int idArticulo) {
		...
		}**/


}
