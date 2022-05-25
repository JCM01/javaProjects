import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) {
		FileWriter file; //iniciador
		 
		//Abrimos fichero para escritura
		try {
			file = new FileWriter("C:\\cine\\peliculas.txt", true);
		}catch (Exception e) {
			System.out.println("No se ha podido abrir el fichero");
			System.out.println(e.getMessage());
			return;
		}
		
		BufferedWriter buffer = new BufferedWriter(file); //filtro
		try {
			buffer.write("¡Bienvenido, Mister Marshall!");
			buffer.newLine();
			buffer.write("Con la muerte en los talones");
			buffer.newLine();
			buffer.write("Muerte de un ciclista");
			buffer.newLine();
		} catch (IOException e) {
			System.out.println("Error al escribir en el fichero");
			System.out.println(e.getMessage());
		}
		
		// Cerrar el buffer y el fichero
		try {
			buffer.close();
			file.close();
		} catch (IOException e) {
			System.out.println("Error al cerrar el fichero");
			System.out.println(e.getMessage());
		}


	}

}
