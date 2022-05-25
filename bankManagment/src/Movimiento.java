
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Movimiento implements Serializable {
	private static final long serialVersionUID = 3057545624874202352L;
	private String movimiento;
	private float importe; // Sobre 10000
	private LocalDateTime f;
	
	public Movimiento(String movimiento, float importe) {
		this.movimiento = movimiento;
		this.importe = importe;
		this.f = LocalDateTime.now();
	}
 
	public String getMovimiento() {
		return movimiento;
	}

	public void setConcepto(String movimiento) {
		this.movimiento = movimiento;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}
	
	public LocalDateTime getF() {
		return f;
	}

	public void setF(LocalDateTime f) {
		this.f = f;
	}
	
	@Override
	public String toString() {
		String formatDateTime=null;
		if (f !=null) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd/HH:mm:ss");

         formatDateTime = f.format(formatter);
		}
		return "Movimiento [Tipo de movimiento = "+movimiento+", Importe="+importe+" con la fecha y hora="+formatDateTime+"]";
	
	}

	
}	

