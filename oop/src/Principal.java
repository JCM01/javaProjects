import concesionario.autos.Coche;
import concesionario.autos.Motor;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Motor m = new Motor();
		m.setPotencia(150);
		m.setCombustible("Gasolina");
		System.out.println(m);
		
		Coche miCoche1 = new Coche("5577ABC", "Ford", "Fiesta", "Delantera", m);
		Coche miCoche2 = new Coche("5537ABC", "Renault", "Scenic", "Trasera", m);
		Coche miCoche3 = new Coche("4577ABC", "Opel", "Corsa", "Delantera", m);
		
		miCoche1.setMarca("Seat");
		Coche.INFORMACION = "Hola Hola";
		System.out.println(Coche.INFORMACION);
		
		System.out.println(miCoche1);
		System.out.println(miCoche2);
		System.out.println(miCoche3);
		
		System.out.println(Coche.INFORMACION);
		
		
		System.out.println("Cilindrada: "+ miCoche1.getMotor().getCilindrada());
		
		miCoche1.getMotor().setCombustible("Diesel");

		System.out.println(m);
	}

}
