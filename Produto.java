package projetoJunto;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author andre
 *  21/05/2025
 */
public class Produto {
	private String nomeP;
	private String descricao;
	private String condicao;
	private ArrayList<Agricultor>agricultores;
	/**
	 * @param descricao
	 * @param condicao
	 * @param produtosAgricultor
	 */
	public Produto(String nomeP, String descricao, String condicao) {
		this.nomeP = nomeP;
		this.descricao = descricao;
		this.condicao = condicao;
		agricultores = new ArrayList<Agricultor>();
	}
	
	/**
	 * @return the nomeP
	 */
	public String getNomeP() {
		return nomeP;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return the condicao
	 */
	public String getCondicao() {
		return condicao;
	}
	/**
	 * @param condicao the condicao to set
	 */
	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}
	@Override
	public String toString() {
		return "Produto [nomeP=" + nomeP + ", descricao=" + descricao + ", condicao=" + condicao + ", agricultores="
				+ agricultores + "]";
	}

	public static List<ProdutoComprado> getProdutoAgricultor() {
		return null;
	}
	public ArrayList<Agricultor> getAgricultores() {
		return agricultores;
	}
	public Agricultor pesquisarAgricultor(String nome) {
	    for (Agricultor agricultor : agricultores) {
	        if (agricultor.getNomeU().equalsIgnoreCase(nome)) {
	            return agricultor;
	        }
	    }
	    return null; // Não encontrado
	}
	
	
}