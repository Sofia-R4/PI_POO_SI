package projetoJunto;

public class Utilizador {
	//variáveis de instância
	private String nomeU;
	private String email;
	private String password;
	
	// Método construtor - inicializar variavvéis de instância
	/**
	 * @param nomeU
	 * @param email
	 * @param password
	 */
	public Utilizador(String nomeU, String email, String password) {
		this.nomeU = nomeU;
		this.email = email;
		this.password = password;
	}

	/**
	 * @return the nomeU
	 */
	public String getNomeU() {
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

	@Override
	public String toString() {
		return "Utilizador [nomeU=" + nomeU + ", email=" + email + ", password=" + password + "]";
	}
	
}