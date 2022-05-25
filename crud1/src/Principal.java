import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {
	private static Scanner lector = new Scanner(System.in);
	private static GestionBD gestion = new GestionBD();
	
	public static void main(String[] args) {
		String opcion = "";
		
		do {
			System.out.println("    Gestión de supermercado");
			System.out.println("--------------------------------");
			System.out.println(" 1. Productos de una categoría");
			System.out.println(" 2. Buscar producto por nombre");
			System.out.println(" 3. Aumenta el precio de un producto");
			System.out.println(" 4. Clientes de un país");
			System.out.println(" 5. Elimina un pedido");
			System.out.println(" 6. Salir del programa");
			System.out.println("--------------------------------");
			System.out.println("¿Qué operación quieres realizar?");
			opcion = lector.nextLine();
			
			switch(opcion) {
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
				System.out.println("Gracias por utilizar nuestra aplicación");
				break;
			default:
				System.out.println("Opción incorrecta, teclea un número del 1 al 6");
			}
		} while (!opcion.equals("6"));
		
		lector.close();
	}
	
	private static void opcion1() {	
		// Productos de una categoría
		
		System.out.println("Introduce id de la categoría (1 a 8)");
		String idCategoria = lector.nextLine();
		ResultSet rs = gestion.productosCategoria(idCategoria);
		
		int c = 0;
		int a = 0;
		
		if (rs==null) return;
		try {
			while (rs.next()) {
				System.out.print(rs.getString("Nombre"));
				System.out.print(" - "); 
				System.out.print(rs.getString("Medida"));
				System.out.print(" - "); 
				System.out.print(rs.getString("Precio"));
				System.out.print(" - "); 
				System.out.print(rs.getString("Stock"));	
				System.out.println(); 
				int pre = rs.getInt("precio");
				a = a + pre;
				c++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Numero total de productos: "+ c);
		System.out.println("Media aritmetica: "+ a/c);

	}
	private static void opcion2() {
		// Productos por nombre
		System.out.println("Escribe nombre del producto: ");
		String nombre = lector.nextLine();
		ResultSet rs = gestion.productosNombre(nombre);
		
		if (rs==null) return;
		try {
			while (rs.next()) {
					System.out.print(rs.getString("nombre"));
					System.out.print(" - "); 
					System.out.print(rs.getString("medida"));
					System.out.print(" - "); 
					System.out.print(rs.getString("precio"));
					System.out.print(" - "); 
					System.out.print(rs.getString("stock"));
					System.out.println(); // Retorno de carro					
				
			}
		} catch (SQLException e) {
			System.out.println("Error al obtener la relación de producto");
			System.out.println(e.getMessage());
		}
	}
	
	private static void opcion3() {
		// Aumentar el precio de un producto
	System.out.println("Escribe el id del producto para aumentar el precio");
	String id = lector.nextLine();
	gestion.aumentarPrecio(id);
		
	}	
	
	private static void opcion4() {		
		// Clientes de un país
		System.out.println("Escribe nombre del pais: ");
		String pais = lector.nextLine();
		ResultSet rsp = gestion.clientesPais(pais);
		
		if (rsp==null) return;
		try {
			while (rsp.next()) {
					System.out.print(rsp.getString("cia"));
					System.out.print(" - "); 
					System.out.print(rsp.getString("contacto"));
					System.out.print(" - "); 
					System.out.print(rsp.getString("cargo"));
					System.out.print(" - "); 
					System.out.print(rsp.getString("direccion"));
					System.out.println(); // Retorno de carro					
				
			}
		} catch (SQLException e) {
			System.out.println("Error al obtener la relación de producto");
			System.out.println(e.getMessage());
		}
	}
		
	private static void opcion5() {
		// Eliminar pedido
	}
}