/**
 * 
 */
package projetoInterdisciplinar;

/**
 * 
 */
public abstract class Utilizador {
	//variáveis de instância
	private String nomeU;
	private String email;
	private String password;
	private String tipoUtilizador;
	
	// Método construtor - inicializar variavvéis de instância
	/**
	 * @param nome
	 * @param email
	 * @param password
	 */
	public Utilizador(String nomeU, String email, String password, String tipoUtilizador) {
		this.nomeU = nomeU;
		this.email = email;
		this.password = password;
		this.tipoUtilizador = tipoUtilizador;
	}

	/**
	 * @return the nomeU
	 */
	public String getNome() {
		return nomeU;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the tipoUtilizador
	 */
	public String isTipoUtilizador() {
		return tipoUtilizador;
	}


}
