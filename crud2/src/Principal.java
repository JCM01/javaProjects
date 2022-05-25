


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
	
public class Principal {
		private static Scanner lector;
		private static Connection con;
		private static ResultSet rs;
		private static Statement sentencia= null;
		
	public static void main(String[] args) throws SQLException  {
		lector = new Scanner(System.in);
		// Paso 1: Cargar el driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver para MySQL");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha cargado el Driver de MySQL");
		
		// Paso 2: Establecer conexión con la base de datos
		String cadenaConexion = "jdbc:mysql://localhost:3306/CIRCO";
		String user = "root";
		String pass = "curso";
		
		try {
			con = DriverManager.getConnection(cadenaConexion, user, pass);
			sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException e) {
			System.out.println("No se ha podido establecer la conexión con la BD");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha establecido la conexión con la Base de datos");
		String opc = "";
		rs = sentencia.executeQuery("SELECT * FROM circo.actores");
		do {
			System.out.println("1. Añadir sentencia");
			System.out.println("2. Ver listado");
			System.out.println("3. Búsqueda de un actor");
			System.out.println("4. Modificación");
			System.out.println("5. Borra un actor.");
			System.out.println("6. Fin del programa.");
			System.out.println("¿Que opción eliges del 1 al 6?");
			opc = lector.nextLine();
			switch (opc) {
			case "1":
				opcion1();
				break;
			case "2":
				opcion2();
				break;
			case "3":
				opcion3();
				break;
			case "4":
				opcion4();
				break;
			case "5":
				opcion5();
				break;
			case "6":
				System.out.println("Fin del programa");
				try {
					rs.close();
					con.close();
				} catch (SQLException e) {
					System.out.println("No se ha podido cerrar la conexión con la BD");
					System.out.println(e.getMessage());
					return;
				}
				System.out.println("Se ha cerrado la base de datos");

				break;
			default:
				System.out.println("Opción incorrecta");
			}
		}while (!opc.equals("6"));
	}
		
	

private static void opcion1() {
		
		System.out.println("Indique su NIF: ");
		String nif = lector.nextLine();
		System.out.println("Indique su nombre: ");
		String nombre = lector.nextLine();
		System.out.println("Indique su domicilio: ");
		String domicilio = lector.nextLine();
		System.out.println("Indique su telefono: ");
		String telefono = lector.nextLine();
		System.out.println("Indique su ciudad: ");
		String ciudad = lector.nextLine();
		lector.nextLine();


		try {
			
			rs.moveToInsertRow();
			rs.updateString("NIF", nif);
			rs.updateString("NOMBRE", nombre);
			rs.updateString("DOMICILIO", domicilio);
			rs.updateString("TLF", telefono);
			rs.updateString("CIUDAD", ciudad);
			rs.insertRow();

		} catch (SQLException e) {
			System.out.println("Error al añadir los datos de los actores del circo");
			System.out.println(e.getMessage());
		}
		System.out.println("Se están añadiendo los datos en la base de datos");
	}


private static void opcion2() {
					
	try {
		
		boolean registro = rs.last();
		while(registro) {
		System.out.print(rs.getString("NIF"));
		System.out.print(" - ");
		System.out.print(rs.getString("NOMBRE"));
		System.out.print(" - ");
		System.out.print(rs.getString("DOMICILIO"));
		System.out.print(" - ");
		System.out.print(rs.getString("TLF"));
		System.out.print(" - ");
		System.out.print(rs.getString("CIUDAD"));
		System.out.println();//retorno de carro
		registro = rs.previous();
		}
	} catch (SQLException e) {
		System.out.println("Error al ver el listado del circo");
		System.out.println(e.getMessage());
	}
}			
	private static void opcion3() {
		System.out.println("¿Que NIF quieres buscar?");
		String nif = lector.nextLine();
		try {
			
			boolean registro = rs.last();
			while(registro) {
				if(nif.equals(rs.getString("NIF"))) {
				System.out.print(rs.getString("NIF"));
				System.out.print(" - ");
				System.out.print(rs.getString("NOMBRE"));
				System.out.print(" - ");
				System.out.print(rs.getString("DOMICILIO"));
				System.out.print(" - ");
				System.out.print(rs.getString("TLF"));
				System.out.print(" - ");
				System.out.print(rs.getString("CIUDAD"));
				System.out.println();//retorno de carro
				} 
				registro = rs.previous();
				
			}
		}catch (SQLException e) {
			System.out.println("Error al buscar en el listado del circo de los actores");
			System.out.println(e.getMessage());
		}
		
		
	}
private static void opcion4() {
	
	try {
		rs.beforeFirst();
		System.out.println("Dime el NIF que quieres modificar");
		String opc = lector.nextLine();
		while (rs.next()) {
			if (opc.equals(rs.getString("NIF"))) {

				do {

					System.out.println("1. Modificar NIF");
					System.out.println("2. Modificar Nombre");
					System.out.println("3. Modificar Domicilio");
					System.out.println("4. Modificar Telefono");
					System.out.println("5. Modificar Ciudad");
					System.out.println("6. Terminar de modificar");
					System.out.println("¿Qué quieres modificar?(1-6)");
					opc = lector.nextLine();
					switch (opc) {

					case "1":
						System.out.println("Modificar el NIF");
						String opc1 = lector.nextLine();
						rs.updateString("NIF", opc1);
						break;
					case "2":
						System.out.println("Modificar el Nombre");
						String opc2 = lector.nextLine();
						rs.updateString("NOMBRE", opc2);
						break;
					case "3":
						System.out.println("Modificar el Domicilio");
						String opc3 = lector.nextLine();
						rs.updateString("DOMICILIO", opc3);
						break;
					case "4":
						System.out.println("Modificar el Telefono");
						String opc4 = lector.nextLine();
						rs.updateString("TLF", opc4);
						break;
					case "5":
						System.out.println("Modificar la Ciudad");
						String opc5 = lector.nextLine();
						rs.updateString("CIUDAD", opc5);
						break;
					case "6":
						rs.updateRow();
						break;
					default:
						System.out.println("Opción incorrecta");
					}

				} while (!opc.equals("6"));
			}
		}
	} catch (SQLException e) {
		System.out.println("Error al actualizar los datos de los actores del circo");
		System.out.println(e.getMessage());
	
	
	}
}

private static void opcion5() {
	try {
		rs.beforeFirst();
		System.out.println("Introduce el NIF que quieras borrar: ");
		String opc = lector.nextLine();
		boolean buscador = false;
		while (rs.next()) {
			if (opc.equals(rs.getString("NIF"))) {
				rs.deleteRow();
				buscador = true;
			}
		}

		if (buscador == false)
			System.out.println("El NIF que buscas no existe");
	} catch (SQLException e) {
		System.out.println("Error al eliminar el actor");
		System.out.println(e.getMessage());

	}

}



}







 
	 
 
		