package projetoJunto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mercado {
    private ArrayList<Utilizador> utilizadores;
    private ArrayList<Produto> produtos;

    public Mercado() {
        utilizadores = new ArrayList<Utilizador>();
        produtos = new ArrayList<Produto>();
    }

    // Pesquisar utilizador 
    public Utilizador pesquisarUtilizador(String nome) {
        for (Utilizador utilizador : utilizadores) {
            if (utilizador.getNomeU().equalsIgnoreCase(nome)) {
                return utilizador;
            }
        }
        return null; 
    }
    //pesquisar por agricultor para ter devolução de agricultor do tipo Agricultor e não utilizador
    public Utilizador pesquisarAgricultor(String nome) {
        for (Utilizador utilizador : utilizadores) {
            if (utilizador.getNomeU().equalsIgnoreCase(nome)) {
            	if (utilizador.getClass().getSimpleName().equalsIgnoreCase("Agricultor")) {
            		return utilizador;
            	}
            }
        }
        return null; 
    }

    // Registrar um novo utilizador
    public void registarUtilizador(Utilizador user, String nome) {
        if (pesquisarUtilizador(nome) != null) {
            System.out.println("Já existe um utilizador com este nome.");
            return;
        }
        else {
        	utilizadores.add(user);
        }
    }
    
    // Ocultar produto
    public void ocultarProduto(String emailAgricultor, ProdutoAgricultor produto) {
        Utilizador u = pesquisarUtilizador(emailAgricultor);

        if (u instanceof Agricultor) {
            Agricultor agricultor = (Agricultor) u;
            agricultor.ocultarProduto(produto);
            produtos.remove(produto);
            System.out.println("Produto ocultado com sucesso!");
        } else {
            System.out.println("O utilizador informado não é um agricultor.");
        }
    }

 // Listar produtos 
    public void listarProdutos() {
    	ProdutoComparator comparator = new ProdutoComparator();
    	produtos.sort(comparator);
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto registado no mercado.");
        } else {
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
    }

    // Listar utilizadores registados
    public void listarUtilizadores() {
        if (utilizadores.isEmpty()) {
            System.out.println("Nenhum utilizador registado no mercado.");
        } else {
            System.out.println("Lista de clientes");
            listarTipoUtilizador("Cliente");
            System.out.println("Lista de agricultor");
            listarTipoUtilizador("Agricultor");
          }
    }
    
    // listar por tipo de utilizador
    public void listarTipoUtilizador(String tipoUtilizador) {
    	UtilizadorComparator comparator = new UtilizadorComparator();
    	utilizadores.sort(comparator);
    	if (utilizadores.isEmpty()) {
            System.out.println("Nenhum utilizador registado no mercado.");
        } 
    	else {
    		for (Utilizador u: utilizadores) {
    			if(u.getClass().getSimpleName().equalsIgnoreCase(tipoUtilizador)) {
    				System.out.println(u);
    			}
    		}
    	}
    }
    
    // verificar utilizador
    public String verificarUtilizador(String nome, String password) {
    	for (Utilizador u: utilizadores) {
    		if (u.getNomeU().equalsIgnoreCase(nome) && u.getPassword().equalsIgnoreCase(password)) {
    			return u.getClass().getSimpleName();
    		}
    	}
    	return null;
    }
    public void adicionarProdutoAgricultor(Agricultor id, ProdutoAgricultor novoProduto) {
    	id.registarProduto(novoProduto);
    }
    public void adicionarProduto(Produto produtoNovo) {
    	produtos.add(produtoNovo);
    }
	/**
	 * @return the utilizadores
	 */
	public ArrayList<Utilizador> getUtilizadores() {
		return utilizadores;
	}

	/**
	 * @return the produtos
	 */
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public boolean adicionarAoCarrinho(Cliente cliente, ProdutoAgricultor produtoAgricultor, int quantidade) {
        if (produtoAgricultor.getStock() >= quantidade) {
            ProdutoComprado pc = new ProdutoComprado(produtoAgricultor,quantidade);
            if (cliente.getCarrinho().isEmpty()) {
                Compra novaCompra = new Compra(LocalDate.now(), 
                    (Agricultor)produtoAgricultor.getIdAgricultor(), 
                    0);
                novaCompra.getProdutosComprados().add(pc);
                cliente.getCarrinho().add(novaCompra);
            } else {
                Compra ultimaCompra = cliente.getCarrinho().get(cliente.getCarrinho().size()-1);
                ultimaCompra.getProdutosComprados().add(pc);
            }
            return true;
        }
        return false;
    }
    public boolean removerDoCarrinho(Cliente cliente, int index) {
        if (index >= 0 && index < cliente.getCarrinho().size()) {
            cliente.getCarrinho().remove(index);
            return true;
        }
        return false;
    }
    public boolean finalizarCompra(Cliente cliente) {
        if (cliente.getCarrinho().isEmpty()) {
            return false;
        }
        for (Compra compra : cliente.getCarrinho()) {
            for (ProdutoComprado pc : compra.getProdutosComprados()) {
            	pc.getProdComprado().alterarStock(pc.getQuantidade());
            }
        }
        return true;
    }
    public void cancelarCompra(Cliente cliente) {
        cliente.getCarrinho().clear();
    }
    public void listarCarrinho(Cliente cliente) {
        if (cliente.getCarrinho().isEmpty()) {
            System.out.println("O seu carrinho está vazio");
            return;
        }

        System.out.println("  Carrinho  ");
        for (int i = 0; i < cliente.getCarrinho().size(); i++) {
            Compra compra = cliente.getCarrinho().get(i);
            System.out.println(i + " - " + compra.toString());
        }
    }
    public Produto pesquisarProduto(String nomeProduto) {
    	for (Produto produto : produtos) {
    		if (produto.getNomeP().equalsIgnoreCase(nomeProduto)) {
    			return produto;
    		}
    	}
    	return null;
    }
    public void criarRelatorioVendas(Agricultor agricultor, double[] totais, Compra[] historicoVenda) {
    	System.out.println("RELATÓRIO DE VENDAS:");
    	System.out.println("Agricultor: " + agricultor.getNomeU());
    	
    	for (Compra compra : historicoVenda) {
    		for (ProdutoComprado produtoComprado : compra.getProdutosComprados()) {
    			Produto nomeP = produtoComprado.getProdComprado().getIdProduto();
    			int quantidade = produtoComprado.getQuantidadeComprada();
    			
    			if (produtos != null && ((List<ProdutoComprado>) Produto.getProdutoAgricultor()).contains(agricultor)) {
    				double peso = ProdutoPeso.getPeso();
    				double preco = ProdutoAgricultor.getProdutoAgricultor();
    				double total = peso * preco;
    				
    				double ganhoTotal = 0;
    				for (double soma : totais) {
    					ganhoTotal += total;
    				}
    				
    				System.out.println("Produto: " + nomeP + "\n" + "Peso: " + peso + "\n" + "Preço: " + preco + "\n" + "Total: " + total + "\n" + "\n" + "TOTAL GANHO: " + ganhoTotal);
    			}
    		}
    	}
    }
    
    // filtrar produtos
    public ArrayList<ProdutoAgricultor> filtrarProdutos(String categoria, double precoMaximo, int stockMinimo) {
	    ArrayList<ProdutoAgricultor> filtrados = new ArrayList<ProdutoAgricultor>();
	    /** 
	     * Filtrar por categoria (se fornecida)
	     */
	    if (categoria != null) {
	        if (!categoria.isEmpty()) {
	            ArrayList<ProdutoAgricultor> temp = new ArrayList<>();
	            for (ProdutoAgricultor pa : filtrados) {
	                if (pa.getIdProduto().getCondicao().equalsIgnoreCase(categoria)) {
	                    temp.add(pa);
	                }
	            }
	            filtrados = temp;
	        }
	    }
	    /**
	     * Filtrar por preço máximo
	     */
	    ArrayList<ProdutoAgricultor> tempPreco = new ArrayList<>();
	    for (ProdutoAgricultor pa : filtrados) {
	        if (pa.getPreco() <= precoMaximo) {
	            tempPreco.add(pa);
	        }
	    }
	    filtrados = tempPreco;
       /**
	    *Filtrar por stock mínimo
	    */
	    ArrayList<ProdutoAgricultor> tempStock = new ArrayList<>();
	    for (ProdutoAgricultor pa : filtrados) {
	        if (pa.getStock() >= stockMinimo) {
	            tempStock.add(pa);
	        }
	    }
	    filtrados = tempStock;

	    return filtrados;
	}

	@Override
	public String toString() {
		return "Mercado [utilizadores=" + utilizadores + ", produtos=" + produtos + "]";
	}
    
}
