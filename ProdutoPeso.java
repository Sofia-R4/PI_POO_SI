package projetoJunto;
/**
 * @author andre
 * 21/05/2025
 */
 class ProdutoPeso extends ProdutoAgricultor {
	 private double peso;

	public ProdutoPeso(Produto idProduto, Utilizador idAgricultor, int stock, double preco, double peso) {
		super(idProduto, idAgricultor, stock, preco);
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
	    return a + " peso " + peso;
	}

	public static double getPeso() {
		return 0;
	}
	
}