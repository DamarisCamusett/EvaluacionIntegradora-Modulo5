package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectionDB.ConnectionDB;
import models.Cuenta;

public class DaoCuenta {
	private Connection connection = ConnectionDB.establecerConexion();

	public DaoCuenta(Connection connection) {
		this.connection = connection;
	};
	
	//Para obtener datos de todas las cuentas
	public List<Cuenta> obtenerTodaCuenta() {
		String consultaSQL = "SELECT id, numeroCta, rut_cliente, apodo, banco, saldo FROM cuenta";
		List<Cuenta> lista = new ArrayList<Cuenta>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(consultaSQL);

			while (resultSet.next()) {

				Cuenta cuenta = new Cuenta();

				int id = resultSet.getInt("id");
                int numeroCta = resultSet.getInt("numeroCta");
                String rut_cliente = resultSet.getString("rut_cliente");
                String apodo = resultSet.getString("apodo");
                String banco = resultSet.getString("banco");
                double saldo = resultSet.getDouble("saldo");

				System.out.println("ID: " + id + ", Saldo: " + saldo + ", Banco: " + banco + ", Numero de cuenta: " + numeroCta + ", Rut: " + rut_cliente);

				cuenta.setId(id);
                cuenta.setNumeroCta(numeroCta);
                cuenta.setRut_cliente(rut_cliente);
                cuenta.setApodo(apodo);
                cuenta.setBanco(banco);
                cuenta.setSaldo(saldo);

				lista.add(cuenta);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			System.err.println("Error al ejecutar la consulta: " + e.getMessage());
		}
		return lista;
	}
	
	//Para obtener datos por id
		public double consultarCuentaId(int id ) {
			String consulta = "SELECT id, saldo, banco, numeroCta, rut_cliente FROM cuenta WHERE id = ?";
			try {
				PreparedStatement ps = connection.prepareStatement(consulta);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					return rs.getDouble("saldo");
				}
			} catch (SQLException e) {
				System.err.println("Error al consultar : " + e.getMessage());
			}
			return 0.0;
		}
	
	/*Para buscar por rut
	public Double consultarRut(String rutCliente) {
		String consulta = "SELECT rutCliente FROM cuenta WHERE id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setString(1, rutCliente);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getDouble("saldo");
			}
		} catch (SQLException e) {
			System.err.println("Error al realizar la busqueda: " + e.getMessage());
		}
		return 0.0;
	}*/
	
	//Para poder cambiar el saldo de una cuenta
	public void actualizarSaldoCuenta(int id, double saldo) {
		String consulta = "UPDATE cuenta SET saldo = ? WHERE id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(consulta);
			ps.setDouble(1, saldo);
			ps.setInt(2, id);
			ps.executeUpdate();
			System.out.println("Saldo actualizado correctamente.");
		} catch (SQLException e) {
			System.err.println("Error al actualizar el Saldo: " + e.getMessage());
		}
	}
	
	/*Para poder crear una nueva cuenta (int id, int numeroCta, String rutCliente, String apodo, String banco, double saldo)
	public void insertarNuevaCuenta(Cuenta cuenta) {

		String consultaCuenta = "INSERT INTO cuenta (id, numeroCta, rut_cliente, apodo, banco, saldo) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(consultaCuenta);
			
			ps.setInt(1, cuenta.getId());
			ps.setInt(2, cuenta.getNumeroCta());
			ps.setString(3, cuenta.getRut_cliente());
			ps.setString(4, cuenta.getApodo());
			ps.setString(5, cuenta.getBanco());
			ps.setDouble(6, cuenta.getSaldo());

			ps.executeUpdate();

			System.out.println("Cuenta creada correctamente.");
		} catch (SQLException e) {
			System.err.println("Error al crear la nueva cuenta: " + e.getMessage());
		}
	}*/
	
	/*Para poder actualizar datos de la cuenta
	public void actualizarCuenta(Cuenta cuenta) {
	}
	
	//Para poder eliminar la cuenta por id
	public void eliminarCuenta(int id) {
	}

	public boolean retirarSaldo(int id, double montoRetiro) {
		return false;
	}

	/*public Object consultarRut_cliente(String rut_cliente) {
		// TODO Auto-generated method stub
		return null;
	}*/

}