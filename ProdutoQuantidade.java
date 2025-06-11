package projetoJunto;
/**
 * @author andre
 * 21/05/2025
 */
 class ProdutoQuantidade extends ProdutoAgricultor {
	 private int quantidade;

	public ProdutoQuantidade(Produto idProduto, Utilizador idAgricultor, int stock, double preco, int quantidade) {
		super(idProduto, idAgricultor, stock, preco);
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