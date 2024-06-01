package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Inferfaz.InterfaceLogin;


public class DaoLogin implements InterfaceLogin {

	private Connection conexion;

	public DaoLogin(Connection conexion) {
		this.conexion = conexion;
	}

	@Override //Para poder validar el ingreso
	public boolean validarLogin(String user_rut, String contrasena) {
        String consulta = "SELECT user_rut, contrasena FROM usuario WHERE user_rut = ? and contrasena = ?";
        try {
        	PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setString(1, user_rut);
            ps.setString(2, contrasena);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar: " + e.getMessage());
        }
        
        return false;
	}
}
