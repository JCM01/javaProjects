import java.io.Serializable;
import java.util.ArrayList;


public class Cuenta implements Serializable {

	private static final long serialVersionUID = 4854486451470258537L;

	private int nc;
	Cliente cliente;
	private ArrayList<Movimiento> movimientos;
	
	public Cuenta(int nc, String nombre, int edad) {
		this.nc = nc;
		this.cliente = new Cliente(nombre, edad);
		this.movimientos = new ArrayList<Movimiento>();
	}
	
	public void movimiento(String movimiento, float cantidad) {
		this.movimientos.add(new Movimiento(movimiento, cantidad));
	}

	public int getNc() {
		return nc;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Movimiento> getMovimientos() {
		return movimientos;
	}
	
	public void borrar(int br){
		movimientos.remove(br);
	}
	

}

