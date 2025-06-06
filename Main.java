package projetoJunto;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Mercado mercado = new Mercado();
        Scanner ler = new Scanner(System.in);
        System.out.println("Escolha uma das seguintes opções: ");
        System.out.println("1-Registar Utilizador");
        System.out.println("2-Login");
        System.out.println("0-Sair");
        int opcao = ler.nextInt(); 
        while (opcao != 0) {
        	if (opcao == 1) {
            	System.out.println("Registo de utilizador");
            	System.out.println("Nome: ");
            	String nome = ler.next();
            	System.out.println("Email: ");
            	String email = ler.next();
            	System.out.println("Password: ");
            	String password = ler.next();
            	System.out.println("Introduza o seu tipo de utilizador: ");
            	System.out.println("1-Cliente");
            	System.out.println("2-Agricultor");
            	System.out.println("3-Admin");
            	int opcao2 = ler.nextInt();
            	switch (opcao2) {
            	case 1:
            		System.out.println("Introduza o cartão de crédito: ");
            		int cartao = ler.nextInt();
            		Utilizador user = new Cliente(nome,email,password,cartao);
            		mercado.registarUtilizador(user,nome);
            		System.out.println("O utilizador foi registado!");
            		break;
            	case 2:
            		System.out.println("Introduza a sua biografia: ");
            		String biografia = ler.next();
            		System.out.println("Introduza a sua localização: ");
            		String localizacao = ler.next();
            		System.out.println("Introduza os seus certificados: ");
            		String certificados = ler.next();
            		Utilizador user2 = new Agricultor(nome, email, password, biografia, localizacao,certificados);
            		mercado.registarUtilizador(user2, nome);
            		System.out.println("O utilizador foi registado!");
            		break;
            	case 3:
            		Utilizador user3 = new Utilizador(nome, email, password);
            		mercado.registarUtilizador(user3, nome);
            		System.out.println("O utilizador foi registado!");
            		break;
            	}
            }
            else{
            	if(opcao == 2) {
            		System.out.println("Login");
            		System.out.println("Introduza o seu nome: ");
            		String nome2 = ler.next();
            		System.out.println("Introduza a password: ");
            		String password2 = ler.next();
            		String tipoU = mercado.verificarUtilizador(nome2, password2);
            		switch (tipoU) {
            		case "Cliente":
            			System.out.println("Introduza uma opção");
            			System.out.println("1-Listar agricultores");
            			System.out.println("2-Comprar produtos");
            			System.out.println("0-Sair");
            			int opcao6 = ler.nextInt();
            			while(opcao6 != 0) {
            				switch (opcao6){
            				case 1:
            					mercado.listarTipoUtilizador("Agricultor");
            					break;
            				case 2:
            					break;
            				}
            				System.out.println("Introduza uma opção");
                			System.out.println("1-Listar agricultores");
                			System.out.println("2-Comprar produtos");
                			System.out.println("0-Sair");
                			opcao6 = ler.nextInt();
            			}
            			break;
            		case "Agricultor":
            			System.out.println("Introduza uma opção");
            			System.out.println("1-Registar produto");
            			System.out.println("2-Ocultar produto");
            			System.out.println("3-Listar produtos");
            			System.out.println("4-Consultar relatório de vendas");
            			System.out.println("0-Sair");
            			int opcao3 = ler.nextInt();
            			while(opcao3 != 0) {
            				switch (opcao3){
            				case 1 :
            					String emailAgricultor = mercado.pesquisarUtilizador(nome2).getEmail();
                                System.out.print("Nome do produto: ");
                                String nomeProduto = ler.nextLine();
                                System.out.print("Preço do produto: ");
                                double preco = ler.nextDouble();
                                ler.nextLine();
                                System.out.print("Categoria do produto: ");
                                String categoria = ler.nextLine();
                                System.out.print("Origem do produto: ");
                                String origem = ler.nextLine();
                                System.out.print("Condições do produto: ");
                                String condicoes = ler.nextLine();
                                System.out.print("Indique o tipo de produto (peso/quantidade/volume): ");
                                String tipo = ler.nextLine();

                                Produto produto;
                                if (tipo.equalsIgnoreCase("peso")) {
                                    System.out.print("Indique o  peso: ");
                                    double peso = ler.nextDouble();
                                    ler.nextLine();
                                    produto = new ProdutoPeso(nomeProduto, preco, categoria, origem, condicoes, peso);
                                } else if (tipo.equalsIgnoreCase("quantidade")) {
                                    System.out.print("Indique a quantidade: ");
                                    int quantidade = ler.nextInt();
                                    ler.nextLine();
                                    produto = new ProdutoQuantidade(nomeProduto, preco, categoria, origem, condicoes, quantidade);
                                } else if (tipo.equalsIgnoreCase("volume")) {
                                    System.out.print("Indique o volume: ");
                                    double volume = ler.nextDouble();
                                    ler.nextLine();
                                    produto = new ProdutoVolume(nomeProduto, preco, categoria, origem, condicoes, volume);
                                } else {
                                    System.out.println("O tipo de produto é invalido");
                                    break;
                                }

                                mercado.registarProduto(emailAgricultor, produto);
                                break;
            				case 2:
            					String emailAgri = mercado.pesquisarUtilizador(nome2).getEmail();
                                System.out.print("Indique o produto que quer ocultar: ");
                                String nomeProd = ler.nextLine();
                                Produto prod = mercado.pesquisarProduto(nomeProd);
                                if (prod != null) {
                                    mercado.ocultarProduto(emailAgri, prod);
                                } else {
                                    System.out.println("Produto não encontrado.");
                                }
                                break;
            				case 3:
            					mercado.listarProdutos();
                                break;
            				case 4:
            					break;
            				}
            				System.out.println("Introduza uma opção");
                			System.out.println("1-Registar produto");
                			System.out.println("2-Ocultar produto");
                			System.out.println("3-Listar produtos");
                			System.out.println("4-Consultar relatório de vendas");
                			System.out.println("0-Sair");
                			opcao3 = ler.nextInt();
            			}
            			
            		case "Utilizador":       //Admin
            			System.out.println("Introduza uma opção");
            			System.out.println("1-Listar utilizadores");
            			System.out.println("2-Aprovar agricultor");
            			System.out.println("0-Sair");
            			int opcao5 = ler.nextInt();
            			while(opcao5 != 0) {
            				switch (opcao5){
            				case 1:
            					mercado.listarUtilizadores();
            					break;
            				case 2:
            					break;
            				}
            				System.out.println("Introduza uma opção");
                			System.out.println("1-Listar utilizadores");
                			System.out.println("2-Aprovar agricultor");
                			System.out.println("0-Sair");
                			opcao5 = ler.nextInt();
            			}
            			break;
            		case "null":
            			System.out.println("O utilizador não existe ou os dados foram inseridos incorretamente!!!");
            		}
            	}
            	else {
            		System.out.println("Introduziu uma opção inválida!!!");
            		System.out.println("Tente novamente por favor");
            	}
            	
            }
        	System.out.println("Escolha uma das seguintes opções: ");
            System.out.println("1-Registar Utilizador");
            System.out.println("2-Login");
            System.out.println("0-Sair");
            opcao = ler.nextInt(); 
           
        }
        
    }
}