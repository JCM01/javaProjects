
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Principal {
	
	private static Scanner lector;

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		//comprobar si existe el fichero cliente.dat
		// si existe lo recuperamos
		// si no existe creamos un nuevo objeto Cliente
		// El nombre y edad del cliente entran por teclado
		Cuenta cuenta = recuperarCuenta();
		
		
		String opc="";
		lector = new Scanner(System.in);
		


		if(cuenta==null) {
			System.out.println("Escribe nombre del nuevo cliente ");
			String nombre = lector.nextLine();
			System.out.println("Edad: ");
			int edad = lector.nextInt();
			System.out.println("Numero de cliente: ");
			int nc = lector.nextInt();
			
			lector.nextLine();
			cuenta = new Cuenta(edad, nombre, nc);
		}
		
	
		do {
			System.out.println("1. Ingresar movimiento");
			System.out.println("2. Modificar movimiento");
			System.out.println("3. Borrar movimiento");
			System.out.println("4. Ver movimientos");
			System.out.println("5. Ver ingreso");
			System.out.println("6. Ver retiro");
			System.out.println("7. Fin programa.");
			System.out.println("Que opcion eliges del 1 al 7");
			opc = lector.nextLine();
			switch (opc) {
			case "1":
				opcion1(cuenta);
				break;
			case "2":
				opcion2(cuenta);
				break;
			case "3":
				opcion3(cuenta);
				break;
			case "4":
				opcion4(cuenta);
				break;
			case "5":
				opcion5(cuenta);
				break;
			case "6":
				opcion6(cuenta);
				break;
			case "7":
				System.out.println("Fin del programa");
				opcion7(cuenta);
				break;
			default:
				System.out.println("Opción incorrecta");
			}
		}while (!opc.equals("7"));
		
		lector.close();
		grabarCuenta(cuenta);
		//guardar el objeto Cliente
}

	private static void opcion1(Cuenta a){
		System.out.println("¿Deseas ingresar o retirar?");
		String concepto = lector.nextLine();
		System.out.println("¿Cuanto deseas?");
		float dinero = lector.nextInt();
		lector.nextLine(); //limpiar buffer
		a.movimiento(concepto, dinero);
	}
	
	private static void opcion2(Cuenta a){
		int indice = 0;
		for (int i = 0; i < a.getMovimientos().size(); i++) {
			System.out.println(indice+ " --- " +a.getMovimientos().get(i).toString());
			indice++;
		}
		
		
		Scanner br = new Scanner(System.in);
		System.out.println("Índice a modificar: ");
		
		int num = br.nextInt();
		
		a.borrar(num);
		
		System.out.println("Es ingreso o retirada: ");
		String concepto = lector.nextLine();
		System.out.println("Cantidad: ");
		int dinero = lector.nextInt();
		lector.nextLine();
		a.movimiento(concepto, dinero);
		
	}
	
	private static void opcion3(Cuenta a){
		int ind = 0;
		for (int i = 0; i < a.getMovimientos().size(); i++) {
			System.out.println(ind+ " --- " +a.getMovimientos().get(i).toString());
			ind++;
		}
		
		
		Scanner br = new Scanner(System.in);
		System.out.println("Índice a borrar: ");
		
		int num = br.nextInt();
		
		a.borrar(num);
		
		
	}
	private static void opcion4(Cuenta a){
		System.out.println("Nombre: "+a.getCliente().getNombre()+" --- Edad: "+a.getCliente().getEdad());
		int ind = 0;
		for (int i = 0; i < a.getMovimientos().size(); i++) {
			System.out.println(ind+ " --- " +a.getMovimientos().get(i).toString());
			ind++;
		}
	}
		
	private static void opcion5(Cuenta a){
		int indice = 0;
		for (int i = 0; i < a.getMovimientos().size(); i++) {
			Movimiento c = a.getMovimientos().get(i);
			if (c.getMovimiento().toLowerCase().equals("ingresar")) {
				System.out.println(indice+ " --- " +c.toString());
				indice++;
		
			}
		}
		
	}
	
	private static void opcion6(Cuenta a){
		int indice = 0;
		for (int i = 0; i < a.getMovimientos().size(); i++) {
			Movimiento c = a.getMovimientos().get(i);
			if (c.getMovimiento().toLowerCase().equals("retirar")) {
				System.out.println(indice+ " --- " +c.toString());
				indice++;
			}
		}
		
	}
	
	private static void opcion7(Cuenta a) { 
		float total=0;
		
		for (int i = 0; i <a.getMovimientos().size(); i++) { 
			Movimiento dinero = a.getMovimientos().get(i);
			
			if (dinero.getMovimiento().toLowerCase().equals("ingresar")) {
				total+=dinero.getImporte(); 
				
			} else if (dinero.getMovimiento().toLowerCase().equals("retirar")){
				total-=dinero.getImporte(); 
				
			} else {
				System.out.println("Movimiento no válido");
	  
	  		}  
		}//cierra for
		System.out.println(total);
	}//cierra opcion7 
	
	
	private static Cuenta recuperarCuenta() throws ClassNotFoundException {
		File fich = new File ("C:\\jose\\cuenta.dat");
		Cuenta cuenta1=null;
		if (fich.exists()) {
			// Abrirfichero para lectura
			FileInputStream file;
			ObjectInputStream buffer;
			try {
				file = new FileInputStream
					("C:\\jose\\cuenta.dat");
				buffer = new ObjectInputStream(file);
			} catch (IOException e) {
				System.out.println("No se ha podido abrir el fichero");
				System.out.println(e.getMessage());
				return null;
			}	
			
			// Lee el objeto guardado en el archivo cliente.dat
			try {
				cuenta1 = (Cuenta) buffer.readObject();
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
		return null;
		
		
	}
	public static Cuenta grabarCuenta(Cuenta cuenta) {
		FileOutputStream file; // Iniciadores 

		ObjectOutputStream buffer; // Filtros

		// Abrir el fichero para escritura.

		try {

			file = new FileOutputStream

				("C:\\jose\\cuenta.dat");

			buffer = new ObjectOutputStream(file);

		} catch (IOException e) {

			System.out.println("Se ha producido un error al abrir el fichero");

			System.out.println(e.getMessage());

			return null;
		}

		// Grabar el objeto cuenta.

		try {

			buffer.writeObject(cuenta);

		} catch (IOException e1) {

			System.out.println("Se ha producido un error al grabar la información del cliente");

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

		System.out.println("Se han guardado los datos del cliente");
		return cuenta;
	
	}
		
}		
	
