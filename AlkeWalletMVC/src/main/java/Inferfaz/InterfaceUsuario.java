package Inferfaz;

import java.util.List;

import models.Usuario;

public interface InterfaceUsuario {
	//Implementación de metodos desde interfaz
	public List<Usuario> obtenerTodosLosDatos();
	public Double consultarRut(String rut_user);
	public void insertarNuevoUsuario(Usuario usuario);
	public void actualizarUsuario(Usuario usuario);
	public void eliminarUsuario(int user_id);
}
