package minhaParte;
/**
 * @author andre
 * 21/05/2025
 */
 class ProdutoQuantidade extends Produto {
	 private int quantidade;

	public ProdutoQuantidade(String nome, double preco, String categoria, String origem, String condicoesProduto,
			int quantidade) {
		super(nome, preco, categoria, origem, condicoesProduto);
		this.quantidade = quantidade;
	}

	/**
	 * Refere a quantidade de produtos 
	 */
	public int getQuantidade() {
		return quantidade;
	}


	/**
	 * Altera a quantidade de produtos
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String toString() {
		String a = super.toString();
	    return a + " quantidade " + quantidade ;
	}
	

}
