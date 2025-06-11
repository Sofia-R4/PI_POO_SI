package projetoJunto;

/**
 * @author andre
 * 21/05/2025
 */
 class ProdutoVolume extends ProdutoAgricultor {
	 private double volume;

	public ProdutoVolume(Produto idProduto, Utilizador idAgricultor, int stock, double preco, double volume) {
		super(idProduto, idAgricultor, stock, preco);
		this.volume = volume;
	}

	/**
	 * Refere o volume dos produtos
	 */
	public double getVolume() {
		return volume;
	}

	/**
	 * Altera o volume dos produtos
	 */
	public void setVolume(double volume) {
		this.volume = volume;
	}
	 
	public String toString() {
		String a = super.toString();
	    return a + " volume " + volume;
	}

}