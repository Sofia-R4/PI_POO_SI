package projetoJunto;

public class ProdutoComprado {
    private ProdutoAgricultor prodComprado;
    private int quantidade;
    
	public ProdutoComprado(ProdutoAgricultor prodComprado, int quantidade) {
		super();
		this.prodComprado = prodComprado;
		this.quantidade = quantidade;
	}

	/**
	 * @return the prodComprado
	 */
	public ProdutoAgricultor getProdComprado() {
		return prodComprado;
	}


	/**
	 * @return the quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}
	public int getQuantidadeComprada() {
		return 0;
	}

	@Override
	public String toString() {
		return "ProdutoComprado [prodComprado=" + prodComprado + ", quantidade=" + quantidade + "]";
	}
}