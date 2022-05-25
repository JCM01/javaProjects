
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
	
public class Principal {

	public static void main(String[] args) {
		
		// Paso 1: Cargar el driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver para MySQL");
			return;
		}
		System.out.println("Se ha cargado el Driver de MySQL");
		
		// Paso 2: Establecer conexión con la base de datos
		String cadenaConexion = "jdbc:mysql://localhost:3306/CIRCO";
		String user = "root";
		String pass = "curso";
		Connection con;
		try {
			con = DriverManager.getConnection(cadenaConexion, user, pass);
		} catch (SQLException e) {
			System.out.println("No se ha podido establecer la conexión con la BD");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha establecido la conexión con la Base de datos");
		
		// Paso 3: Interactuar con la BD 
		try {
			Statement sentencia = con.createStatement();
			
			String sql = "INSERT INTO ACTORES VALUES ('55555577A', 'LUCAS SERRANO', 'C/ CHAMBERI, 4', '6546496874', 'MADRID');";
			//String sql = "UPDATE PRODUCTO SET PRECIO=PRECIO+1;";
			sentencia.executeUpdate(sql);		
			System.out.println("Se han añadido a la tienda");
			
		
		} catch (SQLException e) {
			System.out.println("Error al añadir a la tienda");
			System.out.println(e.getMessage());
		}		
		
		// Paso 4: Cerrar la conexión
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("No se ha podido cerrar la conexión con la BD");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha cerrado la base de datos");

	}
}
