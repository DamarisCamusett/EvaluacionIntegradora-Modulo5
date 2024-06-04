package connectionDB;

//Clase para establecer la conexion con la base de datos 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static String url = "jdbc:mysql://localhost:3306/alkewallet_db"; //url de MySQL
    private static String usuario = "root"; //Nombre de usuario
    private static String password = "Dami29"; //Contraseña, si no tiene contraseña se deja solo las comillas pass = ""


	public static Connection establecerConexion() {
	      try {
	           Class.forName("com.mysql.cj.jdbc.Driver"); //Este es el drive más actualizado
	           return DriverManager.getConnection(url, usuario, password);
	       } catch (ClassNotFoundException | SQLException e) { //Se establecen exceptiones en caso de conexión
	           e.printStackTrace();
	            return null;
	       }
	}
}

