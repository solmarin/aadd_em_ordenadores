package MODELO;
import java.util.Date;
/**
 * Clase para tratar todos los atributos y metodos de un orden de fabricacion.
 * @author Sol Marin
 * @version 1
 */
public class OF {
	//Atributos
		private int idOF;
		private int idLC;
		private char statusOF;
		private Date fechaE;
		private Date fechaF;
		
	//Constructor
		public OF(int idOF, int idLC, char statusOF, Date fechaE, Date fechaF) {
			super();
			this.idOF = idOF;
			this.idLC = idLC;
			this.statusOF = statusOF;
			this.fechaE = fechaE;
			this.fechaF = fechaF;
		}
		
	//Metodos
		public int getIdOF() {
			return idOF;
		}

		public void setIdOF(int idOF) {
			this.idOF = idOF;
		}

		public int getIdLC() {
			return idLC;
		}

		public void setIdLC(int idLC) {
			this.idLC = idLC;
		}

		public char getStatusOF() {
			return statusOF;
		}

		public void setStatusOF(char statusOF) {
			this.statusOF = statusOF;
		}

		public Date getFechaE() {
			return fechaE;
		}

		public void setFechaE(Date fechaE) {
			this.fechaE = fechaE;
		}

		public Date getFechaF() {
			return fechaF;
		}

		public void setFechaF(Date fechaF) {
			this.fechaF = fechaF;
		}
		
		/**public void prepararComponents() {
		...
		}**/


}
