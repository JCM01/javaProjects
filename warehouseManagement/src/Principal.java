import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Principal {


	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
			
			String prod="";
			Scanner teclado = new Scanner(System.in);
			
			FileOutputStream fichero;
			DataOutputStream p;
			
			try {
				fichero = new FileOutputStream("almacen.dat", true);
				p = new DataOutputStream(fichero);
			} catch (IOException e) {
				System.out.println("No se ha podido abrir el fichero almacen.dat");
				System.out.println(e.getMessage());
				return;
			}
			
			// Escribir datos en el fichero almacen.dat
		
				do {
					System.out.println("-----------");
					System.out.println("1. Añadir nuevo producto.");
					System.out.println("2. Listado de productos.");
					System.out.println("3. Listado de productos agotados.");
					System.out.println("4. Terminar programa.");
					prod = teclado.nextLine();
					switch (prod) {
					case "1":
						System.out.println("Nuevo producto");
						Scanner anadir = new Scanner(System.in);
						String producto = anadir.nextLine();
						System.out.println("Añade un precio");
						float precio=anadir.nextFloat();
						System.out.println("Añade Stock");
						float stock=anadir.nextFloat();
						Producto p1 = new Producto(producto,precio,stock);
						p.writeUTF(p1.getNombre());
						p.writeFloat(p1.getPrecio());
						p.writeFloat(p1.getUnidadesEnExistencia());
						break;
					case "2":
						System.out.println("Listado");
						lectura();
						break;
					case "3":
						System.out.println("Listado sin stock");
						stock();
						break;
					case "4":
						System.out.println("Fin del programa");
						break;
					default:
						System.out.println("Opción incorrecta");
					}
					
				} while (!prod.equals("4"));
				teclado.close();
		

			try {
				p.close();
				fichero.close();
			} catch (IOException e) {
				System.out.println("Ha ocurrido un error al cerrar el fichero");
				System.out.println(e.getMessage());
			}		

		}
		
		public static void lectura() {
			FileInputStream fichero;
			DataInputStream lector;
			try {
				fichero = new FileInputStream("almacen.dat");
				lector = new DataInputStream(fichero);
			} catch (IOException e) {
				System.out.println("Ha ocurrido un error al abrir el fichero");
				System.out.println(e.getMessage());
				return;
			}

			boolean eof = false;
			while (!eof) {
				try {
					String pro = lector.readUTF();
					float pre = lector.readFloat();
					float uni = lector.readFloat();
					Producto p = new Producto(pro, pre, uni);
					System.out.println(p);
				} catch (EOFException e1) {
					eof = true;
				} catch (IOException e2) {
					System.out.println("Ha ocurrido un error al leer los registros");
					System.out.println(e2.getMessage());
					break; // sale del bucle while
				}
			}

			try {
				lector.close();
				fichero.close();
			} catch (IOException e) {
				System.out.println("Ha ocurrido un error al cerrar el fichero");
				System.out.println(e.getMessage());
			}
				
		}
		
		public static void stock() {
			FileInputStream fichero;
			DataInputStream lector;
			try {
				fichero = new FileInputStream("almacen.dat");
				lector = new DataInputStream(fichero);
			} catch (IOException e) {
				System.out.println("Ha ocurrido un error al abrir el fichero");
				System.out.println(e.getMessage());
				return;
			}

			boolean eof = false;
			while (!eof) {
				try {
					String pro = lector.readUTF();
					float pre = lector.readFloat();
					float uni = lector.readFloat();
					Producto p = new Producto(pro, pre, uni);
					if (uni == 0.0f) {
						System.out.println(p);
					}
				} catch (EOFException e1) {
					eof = true;
				} catch (IOException e2) {
					System.out.println("Ha ocurrido un error al leer los registros");
					System.out.println(e2.getMessage());
					break; // sale del bucle while
				}
			}

			try {
				lector.close();
				fichero.close();
			} catch (IOException e) {
				System.out.println("Ha ocurrido un error al cerrar el fichero");
				System.out.println(e.getMessage());
			}
		}
}