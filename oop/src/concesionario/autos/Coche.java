package concesionario.autos;

public class Coche {
	//Propiedades del objeto
	private String matricula;
	private String marca;
	private String modelo;
	private String traccion;
	private Motor motor;
	
	
	//Variables de la clase (no pertenecen al objeto)
	public static String INFORMACION = "Disponemos de coche de todas las marcas";
	public static int contador = 0;
	
	public Coche(String matricula, String marca, String modelo, String traccion, Motor motor) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.traccion = traccion;
		this.motor = motor;
		contador++;
	}

	public Coche() {
		super();
		// TODO Auto-generated constructor stub
		this.matricula = "Sin matricular";
		this.marca = "Suzuki";
		this.modelo = "Ignis";
		this.traccion = "Delantera";
		this.motor = new Motor();
		
		
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTraccion() {
		return traccion;
	}

	public void setTraccion(String traccion) {
		this.traccion = traccion;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", traccion=" + traccion
				+ ", motor=" + motor + "]";
	}


	
	
	
	
	
	
	
	
}
