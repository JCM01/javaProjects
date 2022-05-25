import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	
	private static ArrayList<Figura> figuras;
	private static Scanner lector;
	
	public static void main(String[] args) {
		figuras = new ArrayList<Figura>();
		lector = new Scanner(System.in);
		String opc;
				
		do {
			System.out.println("Construyendo figuras geométricas");
			System.out.println("1. Crear un triángulo");
			System.out.println("2. Crear un cuadrilátero");
			System.out.println("3. Crear un pentágono");
			System.out.println("4. Crear un hexágono");
			System.out.println("5. Mostrar todos los polígonos");
			System.out.println("6. Persistir figuras en disco");
			System.out.println("7. Recuperar figuras desde disco");
			System.out.println("8. Exportar figuras a un fichero de texto");
			System.out.println("9. Terminar programa");
			System.out.println("¿Qué opción eliges?");
			opc = lector.nextLine();
			
			switch(opc) {
			case "1":
				crearFigura(3);
				break;
			case "2":
				crearFigura(4);
				break;
			case "3":
				crearFigura(5);
				break;
			case "4":
				crearFigura(6);
				break;
			case "5":
				verFiguras();
				break;
			case "6":
				guardarFiguras();
				break;
			case "7":
				figuras=recuperarFiguras();
				break;
			case "8":
				exportarFiguras();
				break;
			case "9":
				System.out.println("Hasta pronto");
				System.out.println("Gracias por utilizar nuestro programa");
				break;
			default:
				System.out.println("Opción incorrecta");
				System.out.println("Debe escribir un número entre 1 y 9");
			}
		} while (!opc.toLowerCase().equals("9"));
		
	}
	
	public static void crearFigura(int lados) {
		switch (lados) {
		case 3:
			
			System.out.println("Ingresa el primer lado");
			int l1a = lector.nextInt();
			System.out.println("Ingresa el segundo lado");
			int l2a = lector.nextInt();
			System.out.println("Ingresa el tercer lado");
			int l3a = lector.nextInt();
			
			
			Figura f1 = new Figura(Color.ROJO, Color.NEGRO, l1a, l2a, l3a);
			
			System.out.println(f1);
			figuras.add(f1);
			break;
		case 4:
			
			System.out.println("Ingresa el primer lado");
			int l1b = lector.nextInt();
			System.out.println("Ingresa el segundo lado");
			int l2b = lector.nextInt();
			System.out.println("Ingresa el tercer lado");
			int l3b = lector.nextInt();
			System.out.println("Ingresa el cuarto lado");
			int l4b = lector.nextInt();
			
			Figura f2 = new Figura(Color.AZUL, Color.ROSA, l1b, l2b, l3b, l4b);
			
			System.out.println(f2);
			figuras.add(f2);
			break;
		case 5:
			
			System.out.println("Ingresa el primer lado");
			int l1c = lector.nextInt();
			System.out.println("Ingresa el segundo lado");
			int l2c = lector.nextInt();
			System.out.println("Ingresa el tercer lado");
			int l3c = lector.nextInt();
			System.out.println("Ingresa el cuarto lado");
			int l4c = lector.nextInt();
			System.out.println("Ingresa el quinto lado");
			int l5c = lector.nextInt();
			
			Figura f3 = new Figura(Color.VERDE, Color.AMARILLO, l1c, l2c, l3c, l4c, l5c);
			
			System.out.println(f3);
			figuras.add(f3);
			break;
			case 6:

			System.out.println("Ingresa el primer lado");
			int l1d = lector.nextInt();
			System.out.println("Ingresa el segundo lado");
			int l2d = lector.nextInt();
			System.out.println("Ingresa el tercer lado");
			int l3d = lector.nextInt();
			System.out.println("Ingresa el cuarto lado");
			int l4d = lector.nextInt();
			System.out.println("Ingresa el quinto lado");
			int l5d = lector.nextInt();
			System.out.println("Ingresa el sexto lado");
			int l6d = lector.nextInt();
			
			Figura f4 = new Figura(Color.AMARILLO, Color.NEGRO, l1d, l2d, l3d, l4d, l5d, l6d);
			
			System.out.println(f4);
			figuras.add(f4);
			break;	
		}
				
		
	}

	public static void verFiguras() {
			
		for (Figura figura : figuras) {
			Integer total = 0;
			System.out.println(figura.toString());
			for (Integer i : figura.getLados()) {
				total += i;
			}
			System.out.println("El perimetro de la figura " + total);
		}
	}
	
	public static void guardarFiguras() {
		
		FileOutputStream file; 
		ObjectOutputStream buffer; 
		
		// Abrimos el fichero para escritura.
		try {
			file = new FileOutputStream("c:\\jose\\poligonos.dat");
			buffer = new ObjectOutputStream(file);
		} catch (IOException e) {
			System.out.println("Se ha producido un error al abrir el fichero");
			System.out.println(e.getMessage());
			return;
		}

		// Grabar el objeto figuras.
		try {
			buffer.writeObject(figuras);
		} catch (IOException e1) {
			System.out.println("Se ha producido un error al grabar las figuras");
			System.out.println(e1.getMessage());
		}
		// Cerrar el fichero.
		try {
			buffer.close();
			file.close();
		} catch (IOException e) {
			System.out.println("Se ha producido un error al cerrar el fichero");
			System.out.println(e.getMessage());
		}

		System.out.println("Se ha guardado el fichero");
	}
	


	
	public static ArrayList<Figura> recuperarFiguras() {
		FileInputStream file;
		ObjectInputStream buffer;
		ArrayList<Figura>fig;
		
		try {
			file = new FileInputStream("C:\\jose\\poligonos.dat");
			buffer = new ObjectInputStream(file);
		} catch (IOException e) {
			System.out.println("No se ha podido abrir el fichero");
			System.out.println(e.getMessage());
			return null;
		}

		// Lee el objeto guardado en el archivo poligonos.dat
		try {
			fig= (ArrayList<Figura>) buffer.readObject();

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al escribir en el fichero");
			System.out.println(e.getMessage());
			fig= null;
		}

		// Cerrar el fichero
		try {
			buffer.close();
			file.close();
		} catch (IOException e) {
			System.out.println("Error al cerrar el fichero");
			System.out.println(e.getMessage());
		}
		return fig;
	}
	
	
	public static void exportarFiguras() {
		
		
		
		
		
	}
}
