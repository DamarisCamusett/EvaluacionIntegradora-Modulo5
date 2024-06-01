package Inferfaz;

import java.util.List;

import models.Cuenta;
import models.Usuario;

public interface InterfaceCuenta {
	public List<Cuenta> obtenerTodaCuenta();
	public Double consultarRut(String rutCliente); 
	public void insertarNuevaCuenta(Cuenta cuenta); 
	public void actualizarCuenta(Cuenta cuenta); 
	public Double consultarCuentaId(int id);
	public void actualizarSaldoCuenta(String rutCliente, Double saldo); 
	public void eliminarCuenta(int id);
	public void retirarSaldo(int idCuenta, Double montoRetiro);
}
