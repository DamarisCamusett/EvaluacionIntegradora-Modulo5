package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectionDB.ConnectionDB;
import models.Cliente;


public class DaoCliente {
	private Connection connection = ConnectionDB.establecerConexion();

	public void DaoCuenta(Connection connection) {
		this.connection = connection;
	};
	
	public List<Cliente> obtenerTodos(){
    	String consultaSQL = "SELECT cliente_id, nombre, apellido, rutCliente FROM cliente ";
    	List<Cliente> lista = new ArrayList<Cliente>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(consultaSQL);

            while (resultSet.next()) {

                Cliente cliente = new Cliente();
                		
                int clienteID = resultSet.getInt("cliente_id");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String rutCliente = resultSet.getString("rutCliente");
                
                System.out.println("ID cliente: " + clienteID + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Rut: " + rutCliente);
                
                cliente.setCliente_id(clienteID);
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setRutCliente(rutCliente);
                
                 lista.add(cliente);
                
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }
    	return lista;
    }
}
