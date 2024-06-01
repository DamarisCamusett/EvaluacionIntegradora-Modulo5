package models;

public class Cuenta {
	
	//Declaración de variables
	private int id;
	private int numeroCta;
	private String rutCliente;
	private String apodo;
	private String banco;
	private double saldo;
	
	//Constructor vacío
	public Cuenta() {
		super();
	}
	
	//Constructor con parametros
	public Cuenta(int id, int numeroCta, String rutCliente, String apodo, String banco, double saldo) {
		super();
		this.id = id;
		this.numeroCta = numeroCta;
		this.rutCliente = rutCliente;
		this.apodo = apodo;
		this.banco = banco;
		this.saldo = saldo;
	}
	
	//Getter y Setter
	public int getId() {
		return id;
	}

	public int getNumeroCta() {
		return numeroCta;
	}

	public String getRutCliente() {
		return rutCliente;
	}

	public String getApodo() {
		return apodo;
	}

	public String getBanco() {
		return banco;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNumeroCta(int numeroCta) {
		this.numeroCta = numeroCta;
	}

	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}

/* Datos utilizados en la base de datos:
 * Tabla: Banco
- id int AI PK 
- numeroCta int 
- rut_cliente varchar(45) 
- apodo varchar(45) 
- banco varchar(45) 
- saldo double
*/
