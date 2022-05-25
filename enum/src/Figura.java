
import java.io.Serializable;
import java.util.ArrayList;

public class Figura implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8551351040079768436L;
	private Color colorTrazo;
	private Color colorFondo;
	private ArrayList<Integer> lados;
	private String tipo;
	
	public Figura(Color colorTrazo, Color colorFondo, int lado1, int lado2, int lado3) {
		this.colorTrazo = colorTrazo;
		this.colorFondo = colorFondo;
		this.lados = new ArrayList<Integer>();
		this.lados.add(lado1);
		this.lados.add(lado2);
		this.lados.add(lado3);
		this.tipo = "Triángulo";
	}
	public Figura(Color colorTrazo, Color colorFondo, 
			int lado1, int lado2, int lado3, int lado4) {
		this.colorTrazo = colorTrazo;
		this.colorFondo = colorFondo;
		this.lados = new ArrayList<Integer>();
		this.lados.add(lado1);
		this.lados.add(lado2);
		this.lados.add(lado3);
		this.lados.add(lado4);
		this.tipo = "Cuadrilátero";
	}	
	public Figura(Color colorTrazo, Color colorFondo, 
			int lado1, int lado2, int lado3, int lado4, int lado5) {
		this.colorTrazo = colorTrazo;
		this.colorFondo = colorFondo;
		this.lados = new ArrayList<Integer>();
		this.lados.add(lado1);
		this.lados.add(lado2);
		this.lados.add(lado3);
		this.lados.add(lado4);
		this.lados.add(lado5);
		this.tipo = "Pentágono";
	}
	public Figura(Color colorTrazo, Color colorFondo, 
			int lado1, int lado2, int lado3, int lado4, int lado5, int lado6) {
		this.colorTrazo = colorTrazo;
		this.colorFondo = colorFondo;
		this.lados = new ArrayList<Integer>();
		this.lados.add(lado1);
		this.lados.add(lado2);
		this.lados.add(lado3);
		this.lados.add(lado4);
		this.lados.add(lado5);
		this.lados.add(lado6);
		this.tipo = "Hexágono";
	}
	public Color getColorTrazo() {
		return colorTrazo;
	}
	public Color getColorFondo() {
		return colorFondo;
	}
	public ArrayList<Integer> getLados() {
		return lados;
	}
	public String getTipo() {
		return tipo;
	}
	
	@Override
	public String toString() {
		return tipo + " Lados=" + lados + " en " + colorTrazo + " sobre " + this.colorFondo;
	}
}
