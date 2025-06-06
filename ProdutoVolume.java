
package minhaParte;

/**
 * @author andre
 * 21/05/2025
 */
 class ProdutoVolume extends Produto {
	 private double volume;


	public ProdutoVolume(String nome, double preco, String categoria, String origem, String condicoesProduto,
			double volume) {
		super(nome, preco, categoria, origem, condicoesProduto);
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
	    return a + " volume " + volume ;
	}

}
