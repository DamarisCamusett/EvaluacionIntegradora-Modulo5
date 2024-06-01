package models;

public class Cliente {
	
	//Declaración de variables
	private int cliente_id;
	private String nombre;
	private String apellido;
	private String rutCliente;
	
	//Constructor vacío
	public Cliente() {
		super();
	}
	
	//Constructor con parametros
	public Cliente(int cliente_id, String nombre, String apellido, String rutCliente) {
		super();
		this.cliente_id = cliente_id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rutCliente = rutCliente;
	}
	//Getter y Setter

	public int getCliente_id() {
		return cliente_id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getRutCliente() {
		return rutCliente;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}
}

/* Datos utilizados en la base de datos:
 * Tabla: Cliente
- cliente_id int
- nombre varchar 
- apellido varchar(
- rutcliente varchar
 */