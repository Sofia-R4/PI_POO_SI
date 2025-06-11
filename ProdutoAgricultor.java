package projetoJunto;

public class ProdutoAgricultor {
    private Produto idProduto;
    private Utilizador idAgricultor;
    private int stock;
    private double preco;

	public ProdutoAgricultor(Produto idProduto, Utilizador idAgricultor, int stock, double preco) {
		this.idProduto = idProduto;
		this.idAgricultor = idAgricultor;
		this.stock = stock;
		this.preco = preco;
	}

	/**
	 * @return the idProduto
	 */
	public Produto getIdProduto() {
		return idProduto;
	}

	/**
	 * @return the idAgricultor
	 */
	public Utilizador getIdAgricultor() {
		return idAgricultor;
	}


	public int getStock() {
        return stock;
    }

    public void alterarStock(int quantidade) {
        if (stock - quantidade >= 0) {
            stock -= quantidade;
        } else {
            System.out.println("Stock insuficiente");
        }
    }

    public double getPreco() {
        return preco;
    }

	@Override
	public String toString() {
		return "ProdutoAgricultor [idProduto=" + idProduto + ", idAgricultor=" + idAgricultor + ", stock=" + stock
				+ ", preco=" + preco + "]";
	}

	public static double getProdutoAgricultor() {
		return 0;
	}


}