package models;

public class Cliente {
	
	//Declaración de variables
	private int cliente_id;
	private String nombre;
	private String apellido;
	private String rutcliente;
	
	//Constructor vacío
	public Cliente() {
		super();
	}
	
	//Constructor con parametros
	public Cliente(int cliente_id, String nombre, String apellido, String rutcliente) {
		super();
		this.cliente_id = cliente_id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rutcliente = rutcliente;
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

	public String getRutcliente() {
        return rutcliente;
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

	public void setRutcliente(String rutcliente) {
		this.rutcliente = rutcliente;
	}

	
	
}

/* Datos utilizados en la base de datos:
 * Tabla: Cliente
- cliente_id int
- nombre varchar 
- apellido varchar(
- rutcliente varchar
 */