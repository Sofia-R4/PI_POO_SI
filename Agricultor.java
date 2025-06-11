package projetoJunto;
import java.util.ArrayList;

	public class Agricultor extends Utilizador {
		private String biografia;
		private String localizacao;
		private String certificado;
		private ArrayList<ProdutoAgricultor>produtos;
		private ArrayList<Compra>historicoVenda;
		
		public Agricultor(String nome, String email, String password, String biografia, String localizacao,
				String certificado) {
			super(nome, email, password);
			this.biografia = biografia;
			this.localizacao = localizacao;
			this.certificado = certificado;
			produtos = new ArrayList<ProdutoAgricultor>();
			historicoVenda = new ArrayList<Compra>();
		}

		public void registarProduto(ProdutoAgricultor produto) {
			produtos.add(produto);
			}
		
		public void ocultarProduto(ProdutoAgricultor produto) {
			produtos.remove(produto);
			}
		
		public ArrayList<ProdutoAgricultor> gets() {
			return produtos;
			}
		
		public void setLocalizacao(String localizacao) {
			this.localizacao = localizacao;
			}
		
		public void setBiografia(String biografia) {
			this.biografia = biografia;
			}
		
		public void setCertificado(String certificado) {
			this.certificado = certificado;
			}
		
		public String getBiografia() {
			return biografia;
			}
		
		public String getLocalizacao() {
			return localizacao;
			}
		
		public String isCertificado() {
			return certificado;
			}

		public void adicionarHistorico(Compra compra) {
			historicoVenda.add(compra);
		}
		
		public ArrayList<Compra> getHistoricoCompra() {
			return historicoVenda;
		}
		public ProdutoAgricultor pesquisarProdutoAgricultor(String nomeProduto) {
			for (ProdutoAgricultor produto : produtos) {
				if (produto.getIdProduto().equals(nomeProduto)) {
					return produto;
				}
			}
			return null;
		}

		@Override
		public String toString() {
			return "Agricultor [biografia=" + biografia + ", localizacao=" + localizacao + ", certificado="
					+ certificado + ", produtos=" + produtos + ", historicoVenda=" + historicoVenda + "]";
		}
		
	}