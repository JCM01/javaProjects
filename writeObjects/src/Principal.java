import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Crear objeto Alumno
		Alumno alu1=new Alumno("Pedro",25);
		alu1.calificar("Matemáticas",50);
		alu1.calificar("Inglés",75);
		alu1.calificar("Informática",95);
		alu1.calificar("Lengua",60);
		
		FileOutputStream file;
		ObjectOutputStream buffer;
		
		//Abrir el fichero para escritura
		try {
			file = new FileOutputStream("C:\\jose\\alumno.dat");
			buffer = new ObjectOutputStream(file);
		} catch (IOException e) {
			System.out.println("Se ha producido un error al abrir el fichero");
			System.out.println(e.getMessage());
			return;
		}
		
		//Grabar el objeto alumno
		
		try {
			buffer.writeObject(alu1);
		} catch (IOException e) {
			System.out.println("Se ha producido error al grabar la informacion del alumno");
			System.out.println(e.getMessage());
		}
		
		
		//Cerrar el fichero
		
		try {
			buffer.close();
			file.close();
		} catch (IOException e) {
			System.out.println("Se ha producido un error al cerrar el fichero");
			System.out.println(e.getMessage());
		}
		System.out.println("Se han guardado los datos del alumno");
		

	}

}
