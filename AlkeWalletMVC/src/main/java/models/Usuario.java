package models;

import java.util.Date;

public class Usuario {
	
	//Declaración de variables
    private int user_id;
    private String nombre;
    private String apellido;
    private String user_rut;
    private Date fechaNacimiento;
    private String contrasena;
	
    //Constructor vacío
    public Usuario() {
		super();
	}
	
    //Constructor con parametros
	public Usuario(int user_id, String nombre, String apellido, String user_rut, Date fechaNacimiento, String contrasena) {
		super();
		this.user_id = user_id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.user_rut = user_rut;
		this.fechaNacimiento = fechaNacimiento;
		this.contrasena = contrasena;
	}

	//Getter y Setter
	public int getUser_id() {
		return user_id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getUser_rut() {
		return user_rut;
	}

	public Date getFechanacimiento() {
		return fechaNacimiento;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setUser_rut(String user_rut) {
		this.user_rut = user_rut;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechaNacimiento = fechanacimiento;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
}

/* Datos utilizados en la base de datos:
Tabla: Usuario
  
- user_id int AI PK 
- nombre varchar(45) 
- apellido varchar(45) 
- user_rut varchar(45) 
- fechanacimiento date 
- contrasena varchar(45
 */
