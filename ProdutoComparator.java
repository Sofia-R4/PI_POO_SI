package projetoJunto;

import java.util.Comparator;

public class ProdutoComparator implements Comparator<Produto> {
	
	public int compare(Produto p1, Produto p2) {
		return p1.getNomeP().compareTo(p2.getNomeP());
	}
}