import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {
 
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver para MySQL");
			return;
		}
		System.out.println("Se ha cargado el Driver de MySQL");
	

//Paso 2: Establecer conexión con la base de datos
		String cadenaConexion = "jdbc:mysql://localhost:3306/TIENDA";
		String user = "root";
		String pass = "curso"; 
		Connection con;


		try {
			con = DriverManager.getConnection(cadenaConexion, user, pass);
		} catch (SQLException e) {
			System.out.println("Error en la conexión con la BD");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha establecido la conexión con la Base de datos");
		// Paso 3: Interactuar con la BD (todavía pendiente)
	
		try {	
		Statement sentencia = con.createStatement();
		
		ResultSet rs = sentencia.executeQuery("SELECT * FROM CLIENTE");
		while (rs.next()) {
			System.out.print(rs.getString("NIF"));
			System.out.print(" - "); 
			System.out.print(rs.getString("NOMBRE"));
			System.out.print(" - "); 
			System.out.print(rs.getString("TLF"));
			System.out.println(); // Retorno de carro
		}
} catch (SQLException e) {
	System.out.println("Error al ejecutar la sentencia SQL");
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

	


