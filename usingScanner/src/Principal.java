import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class Principal {
	public static void main(String[] args)  {
		File fichero = new File("C:\\jose\\cine.txt");
		
		try {
			Scanner lector;
			lector = new Scanner(fichero);
			while (lector.hasNextLine()) {
				String linea = lector.nextLine();
				System.out.println(linea);
			}
			lector.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No se encuentra el fichero");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Hasta pronto");
		
		
	}
}


