package concesionario.autos;

public class Motor {
	//Propiedades del objeto
	 int potencia;
	private int cilindrada;
	private String combustible;
	
	//Contructor o constructores
	public Motor(int potencia, int cilindrada, String combustible) {
		super();
		this.potencia = potencia;
		this.cilindrada = cilindrada;
		this.combustible = combustible;
	}

	public Motor() {
		super();
		// TODO Auto-generated constructor stub
		this.potencia =110;
		this.cilindrada = 1600;
		this.combustible = "Diesel";
	}
	//Setters and Getters

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public String getCombustible() {
		return combustible;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}

	@Override
	public String toString() {
		return "Motor [potencia=" + potencia + ", cilindrada=" + cilindrada + ", combustible=" + combustible + "]";
	}
	
	 
	
	

}
