package DATOS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import MODELO.Cliente;
import MODELO.Comanda;
import MODELO.LC;

public class SQLComandas {

	Connection c = null;
	Statement sentencia = null;
	ArrayList<Comanda> aComandas = new ArrayList <Comanda>(); 

	public void conectar() {

		try {

			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:servidor/montaje.db");
			System.out.println("Exito al conectar con base de datos");

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "ERROR AL CONECTAR A LA BASE DE DATOS: "+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);

		}

	}
	
public void insertaComandas(Comanda co) throws SQLException {
	
		
		String sqlInsert = "INSERT INTO comandas(idCliente, statusComanda, precioTotal, fechaE) VALUES ('"+co.getIdCliente()+"','"+co.getStatusComanda()+"','"+co.getPrecioTotal()+"','"+co.getFechaE()+"');";

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

public void deleteComanda(String id) throws SQLException {
	
	String sqlDelet = "DELETE FROM comandas WHERE idC = '"+id+"'";

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

public void updateComanda(int idC, int idCliente, String fechaE, int statusComanda, double preuTotal ) throws SQLException {
	
	String sqlUp = "UPDATE comandas SET idCliente ='"+idCliente+"', fechaE = '"+fechaE+"', statusComanda ='"+statusComanda+"', preuTotal='"+preuTotal+"' WHERE idC = '"+idC+"'";

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

public ArrayList<Comanda> consultaComandas() throws SQLException {

	conectar();
	sentencia = c.createStatement();
	String consultaSql = "SELECT * FROM comandas;";

	try {

		ResultSet rs = sentencia.executeQuery(consultaSql);

		while (rs.next()) {
			int idComanda = rs.getInt("idComanda");
			String idCliente = rs.getString("idCliente");
			String fechaE = rs.getString("fechaE");
			char statusComanda = rs.getString("statusComanda").charAt(0);
			int precioTotal = rs.getInt("precioTotal");
			
			aComandas.add(new Comanda(idComanda, idCliente,fechaE,statusComanda,precioTotal));

		}
	
		rs.close();
		sentencia.close();
		c.close();
	 

	} catch (Exception e) {
		JOptionPane.showConfirmDialog(null, "ERROR AL RECUPERAR DATOS: "+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
		
	}
	return aComandas;
	
	}
}
