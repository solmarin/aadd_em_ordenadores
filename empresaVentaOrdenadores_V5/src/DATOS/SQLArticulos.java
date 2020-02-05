package DATOS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import MODELO.Articulo;
public class SQLArticulos {

	Connection c = null;
	Statement sentencia = null;
	ArrayList<Articulo> aArticulos = new ArrayList <Articulo>(); 

	public void conectar() {

		try {

			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:servidor/montaje.db");
			System.out.println("Exito al conectar con base de datos");

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "ERROR AL CONECTAR A LA BASE DE DATOS: "+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);

		}

	}


	public void insertaArticulo(Articulo ar) throws SQLException {

		String sqlInsert = "INSERT INTO articulos(descripcion,precioVenta, unidadesStock) VALUES('"+ar.getDescripcion()+"','"+ar.getPrecio()+"','"+ar.getUnidades()+"');";

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
	
	public void deleteArticulos(String id) throws SQLException {
		
		String sqlDelet = "DELETE FROM articulos WHERE idArticulo = '"+id+"'";

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
	
	public void updateArticulos( int idArticulo, String descripcion, double precioVenta, int unidadesStock ) throws SQLException {
		
		String sqlUp = "UPDATE articulos SET descripcion = '"+descripcion+"', precioVenta ='"+precioVenta+"', unidadesStock='"+unidadesStock+"' WHERE idArticulo ='"+idArticulo+"';";

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

	public ArrayList<Articulo> consultaArticulos() throws SQLException {

		conectar();
		sentencia = c.createStatement();
		String consultaSql = "SELECT * FROM articulos;";

		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);

			while (rs.next()) {
				int idArticulo = rs.getInt("idArticulo");
				String descripcion = rs.getString("descripcion");
				double precioVenta = rs.getDouble("precioVenta");
				int unidadesStock = rs.getInt("unidadesStock");
				
				aArticulos.add(new Articulo(idArticulo,descripcion,precioVenta, unidadesStock));

			}
		
			rs.close();
			sentencia.close();
			c.close();
		 

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "ERROR AL RECUPERAR DATOS: "+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			
		}
		return aArticulos;

	}
	
	public double consultarPrecio(int id) throws SQLException {

		conectar();
		sentencia = c.createStatement();
		String consultaSql = "SELECT precioVenta FROM Articulos WHERE idArticulo='"+id+"';";
		double precio = 0.0;
		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);

			while (rs.next()) {
				 precio = rs.getFloat("precioVenta");
			}
		
			rs.close();
			sentencia.close();
			c.close();
		 

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "ERROR AL RECUPERAR DATOS: "+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			
		}
		return precio;
	}

	

}
