package DATOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import MODELO.Cliente;
import MODELO.LC;

public class SQLLCs {
	Connection c = null;
	Statement sentencia = null;
	ArrayList<LC> aLCs = new ArrayList <LC>(); 


	public void conectar() {

		try {

			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:servidor/montaje.db");
			System.out.println("Exito al conectar con base de datos");

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "ERROR AL CONECTAR A LA BASE DE DATOS: "+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);

		}

	}


	public void insertaLC(LC lc) throws SQLException {
	
		
		String sqlInsert = "INSERT INTO LCS(idC, idArticulo, unidades, unidadesServidas, statusLC) VALUES('"+lc.getIdC()+"','"+lc.getIdArticulo()+"','"+lc.getUnidades()+"','"+lc.getUnidadesServidas()+"','"+lc.getStatusLC()+"');";

		try {

			conectar();
			sentencia = c.createStatement();
			sentencia.executeUpdate(sqlInsert);
			sentencia.close();
			c.close();
			System.out.println("Datos insertados");

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "ERROR AL INSERTAR DATOS EN LA TABLA: "+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public void deleteLCs(String id) throws SQLException {
		
		String sqlDelet = "DELETE FROM LCS WHERE idLC = '"+id+"'";

		try {

			conectar();
			sentencia = c.createStatement();
			sentencia.executeUpdate(sqlDelet);
			sentencia.close();
			c.close();
			System.out.println("Datos eliminados");

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "ERROR AL BORRAR DATOS EN LA TABLA: "+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
		
		}

	}
	
	public void updateLCS(int idLC, int idC, int idArticulo, int unidades, int unidadesServidas, int statusLC) throws SQLException {
		
		String sqlUp = "UPDATE LCS SET idC = '"+idC+"', idAriculo ='"+idArticulo+"', unidades='"+unidades+"',unidadesServidas='"+unidadesServidas+"',statusLC='"+statusLC+"' WHERE idLC = '"+idLC+"'";

		try {

			conectar();
			sentencia = c.createStatement();
			sentencia.executeUpdate(sqlUp);
			sentencia.close();
			c.close();
			System.out.println("Datos actualizados");

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "ERROR AL ACTUALIZAR DATOS EN LA TABLA: "+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			
		}

	}

	public ArrayList<LC> consultaLCS() throws SQLException {

		conectar();
		sentencia = c.createStatement();
		String consultaSql = "SELECT * FROM LCS;";

		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);

			while (rs.next()) {
				
				int idLC = rs.getInt("idLC");
				int idC = rs.getInt("idC");
				int idArticulo = rs.getInt("idArticulo");
				int unidades = rs.getInt("unidades");
				int unidadesServidas = rs.getInt("unidadesServidas");
				int statusLC = rs.getInt("statusLC");
				aLCs.add(new LC(idLC, idC, idArticulo, unidades, unidadesServidas, statusLC));

			}
		
			rs.close();
			sentencia.close();
			c.close();
		 

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "ERROR AL RECUPERAR DATOS: "+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			
		}
		return aLCs;

	}

}
