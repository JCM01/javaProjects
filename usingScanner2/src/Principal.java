import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Principal {

	public static void main(String[] args) {
File fichero = new File("productos.txt");
 			Scanner lector;
 		
 			
		try {
			lector = new Scanner(fichero);
			if(fichero.exists()) {
				System.out.println("¡El fichero de productos si existe!");
				System.out.println("Este el número de bytes de almacenamiento: "+ fichero.length());
				System.out.println("\n");
			}
			while (lector.hasNextLine()) {
				String linea = lector.nextLine();
				fragmentarLinea(linea);
				
				
			}
			
			lector.close();
			
		} catch (FileNotFoundException e) {
			
			System.out.println("No se ha podido leer el archivo");
		}

	}

	public static void fragmentarLinea(String linea) {
		Scanner lector2 = new Scanner(linea);
		lector2.useDelimiter(";");
		
		String categoria = lector2.next();
		
		String producto = lector2.next();
		
		String precio = lector2.next();
		
		String stock = lector2.next();
		
		System.out.println(producto + " ("+ categoria +") " + "-- " + "Precio" +": "+ precio + "€ " + "-- " + "Stock" + ": " + stock );
		
		System.out.println();
		lector2.close();
	}
	

}
