import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lectura {

	public static void main(String[] args) {
		// Abrir fichero para lectura
		FileReader file; // Iniciador
		try {
			file = new FileReader("C:\\jose\\cine.txt"); 
		} catch (IOException e) {
			System.out.println("No se puede abrir el fichero");
			System.out.println(e.getMessage());
			return;
		}

		// Abrir buffer y escribir tres líneas
		BufferedReader buffer = new BufferedReader(file); // Filtro
		String linea = "";
		try {
			linea = buffer.readLine();
			while (linea != null) {
				System.out.println(linea);
				linea = buffer.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error al leer el fichero");
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

