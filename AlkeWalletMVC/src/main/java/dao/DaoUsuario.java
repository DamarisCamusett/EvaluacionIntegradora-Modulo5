package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connectionDB.ConnectionDB;
import models.Usuario;

public class DaoUsuario {
	private Connection connection = ConnectionDB.establecerConexion();

	public DaoUsuario(Connection connection) {
		this.connection = connection;
	};
	
    //Para obtener todos los datos de los usuarios 
    public List<Usuario> obtenerTodosLosDatos(){
    	String consultaSQL = "SELECT user_id, nombre, apellido, user_rut, fechaNacimiento, contrasena FROM usuario";
    	List<Usuario> lista = new ArrayList<Usuario>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(consultaSQL);

            while (resultSet.next()) {

                Usuario usuario = new Usuario();
                		
            	int id = resultSet.getInt("user_id");
                String nombreUser = resultSet.getString("nombre");
                String apellidoUser = resultSet.getString("apellido");
                String rutUser = resultSet.getString("user_rut");
                Date fNacimiento = resultSet.getDate("fechaNacimiento");
                String contrasenaUser = resultSet.getString("contrasena");

                System.out.println("ID: " + id + ", Nombre: " + nombreUser + ", Apellido: " + apellidoUser + ", Rut: " + rutUser);
                
                usuario.setUser_id(id);
                usuario.setNombre(nombreUser);
                usuario.setApellido(apellidoUser);
                usuario.setContrasena(contrasenaUser);
                usuario.setUser_rut(rutUser);
                
                lista.add(usuario);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }
    	return lista;
    }
    
    public Double consultarRut(String rut_user) {
    	String consultaSQL = "SELECT user_rut FROM usuario";
		return null;
	}
    
    //Para poder crear un nuevo usuario
    public void insertarNuevoUsuario(Usuario usuario) {
		String consulta_cliente = "INSERT INTO usuario (nombre, apellido, contrasena, user_rut) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(consulta_cliente);

			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getApellido());
			ps.setString(3, usuario.getContrasena());
			ps.setString(4, usuario.getUser_rut());

			ps.executeUpdate();

			System.out.println("Nuevo usuario creado correctamente.");
		} catch (SQLException e) {
			System.err.println("Error al crear el usuario: " + e.getMessage());
		}

	}
    
    //Para cambiar datos de un usuario
    public void actualizarUsuario() {
    }
    
    //Para poer eliminar un usuario
	public void eliminarUsuario(int user_id){
	}
}

