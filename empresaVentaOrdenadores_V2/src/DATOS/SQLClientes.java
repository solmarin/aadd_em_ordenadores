package DATOS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLClientes {

	Connection c = null;
	Statement sentencia = null;
	String nombreTabla;
	String nombreEmpresa, cif, direccion, poblacion;
	int cp;


	public void conectar() {

		try {

			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:servidor/montaje.db");
			System.out.println("Exito al conectar con base de datos");

		} catch (Exception e) {

			System.out.println("Error al conectar con base de datos");

		}

	}


	public void insertaClientes( String nombreEmpresa, String cif,String direccion, String poblacion, int cp) throws SQLException {
	
		this.nombreEmpresa = nombreEmpresa;
		this.cif = cif;
		this.direccion = direccion;
		this.poblacion=poblacion;
		this.cp = cp;
		
		String sqlInsert = "INSERT INTO clientes(nombreEmpresa, cif,direccion, poblacion, cp) VALUES('"+this.nombreEmpresa+"','"+this.cif+"','"+this.direccion+"','"+this.poblacion+"',"+this.cp+");";

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

	public void consultaClientes(String nombreTabla) throws SQLException {

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
				int cp = rs.getInt("cp");

				System.out.println(" CIF: "+ cif + " Nombre empresa : " + nombreEmpresa + " Direccion: "+direccion+" Poblacion: "+poblacion+" CP: "+cp);

			}

			rs.close();
			sentencia.close();
			c.close();

		} catch (Exception e) {
			System.out.println("ERROR AL RECUPERAR DATOS: "+e.getLocalizedMessage());

		}
	}

}
