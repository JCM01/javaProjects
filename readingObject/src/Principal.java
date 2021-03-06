import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Principal {
	public static void main(String args[]) throws ClassNotFoundException {
		
		// Abrirfichero para lectura
		FileInputStream file;
		ObjectInputStream buffer;
		try {
			file = new FileInputStream("C:\\jose\\alumno.dat");
			buffer = new ObjectInputStream(file);
		} catch (IOException e) {
			System.out.println("No se ha podido abrir el fichero");
			System.out.println(e.getMessage());
			return;
		}	
		
		// Lee el objeto guardado en el archivo alumno.dat
		try {
			Alumno alu1 = (Alumno) buffer.readObject();
			System.out.println("Nombre del alumno: " + alu1.getNombre());
			System.out.println("Edad: " + alu1.getEdad());
			for (Calificacion c : alu1.getCalificaciones()) {
				System.out.println(c);
			}
		} catch (IOException e) {
			System.out.println("Error al escribir en el fichero");
			System.out.println(e.getMessage());
		}
		
		// Cerrar el fichero
		try {
			buffer.close();
			file.close();
		} catch (IOException e) {
			System.out.println("Error al cerrar el fichero");
			System.out.println(e.getMessage());
		}
		
	}
}
