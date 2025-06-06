
package minhaParte;

/**
 * @author andre
 * 21/05/2025
 */
 class ProdutoPeso extends Produto {
	 private double peso;

	public ProdutoPeso(String nome, double preco, String categoria, String origem, String condicoesProduto,
			double peso) {
		super(nome, preco, categoria, origem, condicoesProduto);
		this.peso = peso;
	}

	/**
	 * Referir o peso total de um certo produto
	 */
	public double getPesoTotal() {
		return peso;
	}

	/**
	 * Alterar o peso total de um certo produto
	 */
	public void setPesoTotal(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		String a = super.toString();
	    return a + " peso " + peso ;
	}
	
	
	 
}
