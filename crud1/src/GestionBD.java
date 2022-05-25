
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionBD {
	private Connection con;
	private Statement st;
	
	public GestionBD() {
		super();
		String cadenaConexion = "jdbc:mysql://localhost:3306/SUPERMERCADO";
		String user = "root";
		String pass = "curso";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(cadenaConexion, user, pass); 
			st=con.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver para MySQL");
		} catch (SQLException e) {
			System.out.println("No se ha podido conectar con la base de datos");
			System.out.println(e.getMessage());
			con = null;
		}
	}

	public void desconectar() {
		try {
			if (!(con==null)) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet productosCategoria(String idCategoria) {
		ResultSet rs;
		try {
			rs = st.executeQuery("SELECT * FROM PRODUCTO WHERE idCategoria = " + idCategoria);
		} catch (SQLException e) {
			System.out.println("No se ha podido ejecutar la sentencia SQL");
			rs = null;
		}
		return rs;
	}
	
	public ResultSet productosNombre(String nombre) {
		// Permite una búsqueda por contenido del nombre utilizando 
		// el operador LIKE.
		
		ResultSet rsNombre;
		
		try {
			rsNombre = st.executeQuery("SELECT * FROM PRODUCTO WHERE nombre LIKE '%"+nombre+"%'");
		} catch (SQLException e) {
			System.out.println("No se ha podido ejecutar la sentencia SQL");
			rsNombre = null;
		}
		
		return rsNombre;
	}
	public ResultSet clientesPais(String pais) {
		ResultSet rsPais;
		
		try {
			rsPais = st.executeQuery("SELECT * FROM ClIENTE WHERE pais LIKE '%"+pais+"%'");
		} catch (SQLException e) {
			System.out.println("No se ha podido ejecutar la sentencia SQL");
			rsPais = null;
		}
		
		return rsPais;
	}

	public boolean aumentarPrecio(String idProducto) {
		// Retorna true si la operación se ha realizado.
		Statement sentencia;
		try {
			sentencia = con.createStatement();
			String sql = "UPDATE PRODUCTO SET PRECIO = PRECIO*1.03 WHERE idProducto= "+ idProducto;
			sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Error al actualizar el precio");
			System.out.println(e.getMessage());
		}
		return true;
		
	}
	public boolean borrarPedido(String idPedido) {
		// Retorna true si la operación se ha realizado.
		// Tendrás que eliminar primero los detalles del pedido
		// y después el pedido.
		// Engloba ambas operaciones en la misma transacción.
		return false;
	}
}
