package projetoJunto;

import java.util.ArrayList;

public class Mercado {
    private ArrayList<Utilizador> utilizadores;
    private ArrayList<Produto> produtos;

    public Mercado() {
        this.utilizadores = new ArrayList<>();
        this.produtos = new ArrayList<>();
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

    // Registrar produto
    public void registarProduto(String emailAgricultor, Produto produto) {
        if (pesquisarUtilizador(emailAgricultor) instanceof Agricultor agricultor) {
            agricultor.registarProduto(produto);
            produtos.add(produto);
            System.out.println("Produto registrado com sucesso!");
        } else {
            System.out.println("O utilizador informado não é um agricultor.");
        }
    }
    
    // Ocultar produto
    public void ocultarProduto(String emailAgricultor, Produto produto) {
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
    
    public Produto pesquisarProduto(String nomeProduto) {
        for (Produto p : produtos) {
            if (p.getNomeP().equalsIgnoreCase(nomeProduto)) {
                return p;
            }
        }
        return null;
    }
    
    public String verificarUtilizador(String nome, String password) {
    	for (Utilizador u: utilizadores) {
    		if (u.getNomeU().equalsIgnoreCase(nome) && u.getPassword().equalsIgnoreCase(password)) {
    			return u.getClass().getSimpleName();
    		}
    	}
    	return null;
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
    
}