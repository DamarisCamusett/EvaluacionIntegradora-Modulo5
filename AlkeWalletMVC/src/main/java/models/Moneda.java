package models;

public class Moneda {
	//Declaración de variables
    private int currency_id; 
    private String currency_name;
    private String currency_simbol;
	
    //Constructor vacío
    public Moneda() {
		super();
	}
    
    //Constructor con parametros
	public Moneda(int currency_id, String currency_name, String currency_simbol) {
		super();
		this.currency_id = currency_id;
		this.currency_name = currency_name;
		this.currency_simbol = currency_simbol;
	}
	
	//Getter y Setter
	public int getCurrency_id() {
		return currency_id;
	}

	public String getCurrency_name() {
		return currency_name;
	}

	public String getCurrency_simbol() {
		return currency_simbol;
	}

	public void setCurrency_id(int currency_id) {
		this.currency_id = currency_id;
	}

	public void setCurrency_name(String currency_name) {
		this.currency_name = currency_name;
	}

	public void setCurrency_simbol(String currency_simbol) {
		this.currency_simbol = currency_simbol;
	}
}

/* Datos utilizados en la base de datos:
 * Tabla: Moneda
- currency_id int
- currency_name varchar
- currency_simbol varchar
 */