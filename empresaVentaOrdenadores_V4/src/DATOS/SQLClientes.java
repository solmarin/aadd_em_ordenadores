package DATOS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MODELO.Cliente;

public class SQLClientes {

	Connection c = null;
	Statement sentencia = null;
	ArrayList<Cliente> aClientes = new ArrayList <Cliente>(); 


	public void conectar() {

		try {

			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:servidor/montaje.db");
			System.out.println("Exito al conectar con base de datos");

		} catch (Exception e) {

			System.out.println("Error al conectar con base de datos");

		}

	}


	public void insertaClientes(Cliente cli) throws SQLException {
	
		
		String sqlInsert = "INSERT INTO clientes(nombreEmpresa, cif,direccion, poblacion, cp) VALUES('"+cli.getNombreEmpresa()+"','"+cli.getCif()+"','"+cli.getDireccion()+"','"+cli.getPoblacion()+"',"+cli.getCp()+");";

		try {

			conectar();
			sentencia = c.createStatement();
			sentencia.executeUpdate(sqlInsert);
			sentencia.close();
			c.close();
			System.out.println("Datos insertados");

		} catch (Exception e) {
			System.out.println("ERROR AL INSERTAR DATOS EN LA TABLA: "+e.getLocalizedMessage()+" "+e.getMessage());
		}

	}
	
	public void deleteClientes(String cif) throws SQLException {
		
		String sqlDelet = "DELETE FROM clientes WHERE cif = '"+cif+"'";

		try {

			conectar();
			sentencia = c.createStatement();
			sentencia.executeUpdate(sqlDelet);
			sentencia.close();
			c.close();
			System.out.println("Datos eliminados");

		} catch (Exception e) {
			System.out.println("ERROR AL BORRAR DATOS EN LA TABLA: "+e.getLocalizedMessage()+" "+e.getMessage());
		}

	}
	
	public void updateClientes(String cif,String nombreEmpresa,String direccion, String poblacion, String cp ) throws SQLException {
		
		String sqlUp = "UPDATE clientes SET nombreEmpresa ='"+nombreEmpresa+"', direccion = '"+direccion+"', poblacion ='"+poblacion+"', cp='"+cp+"' WHERE cif = '"+cif+"'";

		try {

			conectar();
			sentencia = c.createStatement();
			sentencia.executeUpdate(sqlUp);
			sentencia.close();
			c.close();
			System.out.println("Datos actualizados");

		} catch (Exception e) {
			System.out.println("ERROR AL ACTUALIZAR DATOS EN LA TABLA: "+e.getLocalizedMessage()+" "+e.getMessage());
		}

	}

	public ArrayList<Cliente> consultaClientes(String nombreTabla) throws SQLException {

		conectar();
		sentencia = c.createStatement();
		String consultaSql = "SELECT * FROM " + nombreTabla + ";";

		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);

			while (rs.next()) {
				String cif = rs.getString("cif");
				String nombreEmpresa = rs.getString("nombreEmpresa");
				String direccion = rs.getString("direccion");
				String poblacion = rs.getString("poblacion");
				String cp = rs.getString("cp");
				
				aClientes.add(new Cliente(nombreEmpresa,cif,direccion, poblacion, cp));

			}
		
			rs.close();
			sentencia.close();
			c.close();
		 

		} catch (Exception e) {
			System.out.println("ERROR AL RECUPERAR DATOS: "+e.getLocalizedMessage());
			
		}
		return aClientes;

	}

	

}
