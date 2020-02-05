package DATOS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import MODELO.Comanda;
import MODELO.LC;

public class SQLComandas {

	Connection c = null;
	Statement sentencia = null;
	ArrayList<Comanda> aComandas = new ArrayList <Comanda>(); 
	SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");

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
		//update lc: añadir precio lc 
		SQLArticulos sqlA = new SQLArticulos();
		ArrayList<LC> lineasComandas = co.getProductosSeleccionados();
		for(LC lc : lineasComandas) {
			int id = lc.getIdArticulo();
			if((Integer)id != null) {
				lc.setPrecioTLC(sqlA.consultarPrecio(id));
			}
		}
		
		
		//insertar lcs y comandas
		String sqlInsert;
		SQLLCs sqllcs = new SQLLCs();
		try {

			conectar();
			for(int i=0; i<lineasComandas.size(); ++i) {
				 sqllcs.insertaLC(lineasComandas.get(i));
			  }
			
			sqlInsert = "INSERT INTO comandas(idComanda, idCliente, statusComanda, precioTotal, fechaE) VALUES ('"+co.getIdComanda()+"','"+co.getIdCliente()+"','"+co.getStatusComanda()+"','"+co.getPrecioTotal()+"','"+co.getFechaE()+"');";

			sentencia = c.createStatement();
			sentencia.executeUpdate(sqlInsert);
			sentencia.close();
			c.close();
			System.out.println("Datos insertados");

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "ERROR AL INSERTAR DATOS EN LA TABLA: "+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
		}

	}

public void deleteComanda(int id) throws SQLException {
	
	String sqlDelet = "DELETE FROM comandas WHERE idComanda = '"+id+"';";

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


public void updateStatus(int idC, char status) {
	String sqlUp = "UPDATE comandas SET statusComanda='"+status+"' WHERE idComanda = '"+idC+"';";
	
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

public void updateFechaS(int idC) {
	
	String sqlUp = "UPDATE comandas SET fechaF='"+date.format(new Date())+"' WHERE idComanda = '"+idC+"';";
	
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


public ArrayList<Comanda> consultaComandas(char tipo) throws SQLException {

	conectar();
	sentencia = c.createStatement();
	 String consultaSql = "SELECT * FROM comandas ORDER BY fechaE ASC;";
	 
	if (tipo == 'B') consultaSql = "SELECT * FROM comandas WHERE statusComanda='B' ORDER BY fechaE ASC;";
	else if(tipo == 'C') consultaSql = "SELECT * FROM comandas WHERE statusComanda='C' ORDER BY fechaE ASC;";

	try {

		ResultSet rs = sentencia.executeQuery(consultaSql);

		while (rs.next()) {
			int idComanda = rs.getInt("idComanda");
			String idCliente = rs.getString("idCliente");
			String fechaE = rs.getString("fechaE");
			char statusComanda = rs.getString("statusComanda").charAt(0);
			double precioTotal = rs.getDouble("precioTotal");
			String fechaF = rs.getString("fechaF");
			aComandas.add(new Comanda(idComanda, idCliente,fechaE,statusComanda,precioTotal,fechaF));

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
