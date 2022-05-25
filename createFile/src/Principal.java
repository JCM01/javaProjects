import java.io.File;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File fichero = new File("C:\\jose\\cine.txt");
		
		System.out.println("Tres\nTristes\nTigres");
		
		if (fichero.exists()) {
			System.out.println("Existe el fichero");
			System.out.println("Nº de bytes que ocupa: " + fichero.length());
			System.out.println("Nombre de archivo: " + fichero.getName());
			System.out.println("Ruta: " + fichero.getPath());
			System.out.println("¿Es un fichero oculto? " + fichero.isHidden());
			System.out.println("¿Está permitida la escritura? " + fichero.canWrite());
			System.out.println("¿Está permitida la lectura? " + fichero.canRead());

		
		}
		else {
			System.out.println("No existe el fichero");
		}
		
		File fich = new File("C:/jose/pelis2.txt");
		/*boolean ok = fich.createNewFile();
		if (ok)
			System.out.println("El fichero se ha creado con éxito");
		else
			System.out.println("El fichero no ha podido crearse");*/
		
		boolean ok = fich.delete();
		if (ok)
			System.out.println("El fichero se ha borrado con éxito");
		else
			System.out.println("El fichero no ha podido borrarse");
		
		
		
	}

}
