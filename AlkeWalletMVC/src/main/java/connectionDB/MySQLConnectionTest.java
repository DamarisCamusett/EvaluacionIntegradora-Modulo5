package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionTest {
    public static void main(String[] args) {
        // Datos de la base de datos (se establecen variables)
        String url = "jdbc:mysql://localhost:3306/alkewallet_db";
        String usuario = "root";
        String contrasena = "Dami29";

        try {
            // Cargando el driver
            Class.forName("com.mysql.cj.jdbc.Driver"); //Se llama al driver de mysql
            // Estableciendo la conexión
            Connection conexion = DriverManager.getConnection(url, usuario, contrasena); //se leen las variables
            System.out.println("Conectado a la base de datos MySQL.");
            
            // Cerrando la conexión
            conexion.close();
            System.out.println("Desconectado de la base de datos MySQL.");
        } catch (ClassNotFoundException e) { //Mensajes de errores de conexion
            System.out.println("Error al cargar el driver de MySQL: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}
