import java.io.File;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File carpeta = new File("C:\\Windows");
		
		if (carpeta.exists()) {
			System.out.println("Existe la carpeta");
			System.out.println("Archivos o carpetas: "+carpeta.list().length);
			String[] contenido = carpeta.list();
			for (String c : contenido) {
				File elem = new File(carpeta, c);
				boolean esCarp = elem.isDirectory();
				if (esCarp) {
				System.out.println(c+" carpeta con "+elem.list().length);
				}
				else {
					System.out.println(c+ "archivo con "+elem.length()+" bytes");
				}
				
			}
		}
		else {
			System.out.println("No existe la carpeta");
		}
		
		
	}

}
