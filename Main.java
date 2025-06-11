package projetoJunto;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Mercado mercado = new Mercado();
        Agricultor andre = new Agricultor("André","andre@gmail.com","andre123","Gosto de sapos","Custoias","Certificado de bom agricultor");
        mercado.registarUtilizador(andre, "André");
        Produto produtoG = new Produto("Bananas","Amarelas e ricas em Vitamina A","Criado sem adubos");
        ProdutoAgricultor produtoA = new ProdutoAgricultor(produtoG,andre,2,5);
        andre.registarProduto(produtoA);
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
            } // fim opcao registo
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
            					System.out.println("Início da compra. Adicione produtos ao carrinho.");
								Cliente clienteAtual = (Cliente) mercado.pesquisarUtilizador(nome2);
								boolean continuarCompras = true;

								while (continuarCompras) {
									System.out.println("\n Menu Compras");
									System.out.println("1 - Adiconar ao carrinho");
									System.out.println("2 - Remover do carrinho");
									System.out.println("3 - Ver carrinho");
									System.out.println("4 - Finalizar compra");
									System.out.println("5 - Cancelar compra");
									System.out.println("0 - Voltar");
									System.out.print("Escolha uma opção: ");

									int opcaoCompra = ler.nextInt();
									ler.nextLine(); // Limpar buffer

									switch (opcaoCompra) {
									case 1:
										System.out.print("Introduza o nome do produto: ");
										String nomeProd = ler.nextLine();
										Produto produtoBase = mercado.pesquisarProduto(nomeProd);

										if (produtoBase != null) {
											System.out.println("Agricultores que vendem este produto:");
											for (Agricultor agricultor : produtoBase.getAgricultores()) {
												ProdutoAgricultor produtoAgricultor = agricultor
														.pesquisarProdutoAgricultor(nomeProd);
												if (produtoAgricultor != null && produtoAgricultor.getStock() > 0) {
													System.out.println("Agricultor : " + agricultor.getNomeU()
															+ " | Preço: " + produtoAgricultor.getPreco() + " | Stock: "
															+ produtoAgricultor.getStock());
												}
											}

											System.out.print("Introduza o nome do agricultor desejado: ");
											String nomeAgricultor = ler.nextLine();
											Agricultor agricultorSelecionado = produtoBase
													.pesquisarAgricultor(nomeAgricultor);

											if (agricultorSelecionado != null) {
												ProdutoAgricultor produtoFinal = agricultorSelecionado
														.pesquisarProdutoAgricultor(nomeProd);

												if (produtoFinal != null && produtoFinal.getStock() > 0) {
													System.out
															.print("Introduza a quantidade a adicionar ao carrinho: ");
													int quantidade = ler.nextInt();
													ler.nextLine(); // limpar o buffer
													
													if (quantidade > 0 && quantidade <= produtoFinal.getStock()) {
														boolean adicionado = mercado.adicionarAoCarrinho((Cliente)mercado.pesquisarUtilizador(nome2),
																produtoFinal, quantidade);

														if (adicionado) {
															System.out.println(
																	"Produto adicionado ao carrinho com sucesso!");
														} else {
															System.out
																	.println("Falha ao adicionar produto ao carrinho.");
														}
													} else {
														System.out.println("Quantidade inválida. Stock disponível: "
																+ produtoFinal.getStock());
													}
												} else {
													System.out.println(
															"Este agricultor não tem stock disponível para este produto.");
												}

											} else {
												System.out.println("Agricultor não existe");
											}
										} else {
											System.out.println("Produto não encontrado no mercado");
										}
										break;
									case 2:
										mercado.listarCarrinho(clienteAtual);
										if (!clienteAtual.getCarrinho().isEmpty()) {
											System.out.print("Introduza o indice do produto a remover: ");
											int index = ler.nextInt();

											if (mercado.removerDoCarrinho(clienteAtual, index)) {
												System.out.println("Produto removido do carrinho");
											} else {
												System.out.println("Índice inválido");
											}
										}
										break;

									case 3:
										mercado.listarCarrinho(clienteAtual);
										break;

									case 4:
										mercado.listarCarrinho(clienteAtual);
										if (!clienteAtual.getCarrinho().isEmpty()) {
											System.out.print("Deseja confirmar a compra?(Sim/Não) ");
											String confirmacao = ler.next();

											if (confirmacao.equalsIgnoreCase("Sim")) {
												if (mercado.finalizarCompra(clienteAtual)) {
													System.out.println("Compra finalizada");
												} else {
													System.out.println("Erro");
												}
												continuarCompras = false;
											}
										}
										break;

									case 5:
										System.out.print("Tem certeza que quer cancelar a compra?(Sim/Não) ");
										String confirmacao = ler.next();

										if (confirmacao.equalsIgnoreCase("Sim")) {
											mercado.cancelarCompra(clienteAtual);
											System.out.println("Compra cancelada com sucesso");
											continuarCompras = false;
										}
										break;

									case 0:
										continuarCompras = false;
										break;
									default:
										System.out.println("Opção inválida!");
									}// fim opcao compra
								} // while
            				}// fim switch 
            				System.out.println("Introduza uma opção");
                			System.out.println("1-Listar agricultores");
                			System.out.println("2-Comprar produtos");
                			System.out.println("0-Sair");
                			opcao6 = ler.nextInt();
            				} // fim while menu cliente - op 1 e 2
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
            					//String emailAgricultor = mercado.pesquisarUtilizador(nome2).getEmail();
                                System.out.print("Nome do produto: ");
                                String nomeProduto = ler.nextLine();
                                Produto p=mercado.pesquisarProduto(nomeProduto);
                                Produto produto = null;
                                if(p==null) {// adicionar produto à lista de produtos
                                	System.out.println("Introduza uma breve descrição: ");
                                	String descricao = ler.next();
                                	System.out.println("Introduza as condições a que foi criado o produto: ");
                                	String condicao = ler.next();
                                	produto = new Produto(nomeProduto,descricao,condicao);
                                	mercado.adicionarProduto(produto);
                                }
                                // adicionar produto ao agricultor
                                	System.out.print("Indique como pretende vender o de produto (peso/quantidade/volume): ");
                                    String tipo = ler.next();

                                    ProdutoAgricultor produtoP = null;
                                    if (tipo.equalsIgnoreCase("peso")) {
                                        System.out.print("Indique o  peso: ");
                                        double peso = ler.nextDouble();
                                        System.out.println("Indique o stock: ");
                                        int stock = ler.nextInt();
                                        System.out.println("Indique o preco ao kilo: ");
                                        double preco = ler.nextDouble();
                                        ler.nextLine();
                                        produtoP = new ProdutoPeso(produto,mercado.pesquisarUtilizador(nome2),stock,preco,peso);
                                    } else if (tipo.equalsIgnoreCase("quantidade")) {
                                        System.out.print("Indique a quantidade: ");
                                        int quantidade = ler.nextInt();
                                        ler.nextLine();
                                        System.out.println("Indique o stock: ");
                                        int stock = ler.nextInt();
                                        System.out.println("Indique o preco à unidade: ");
                                        double preco = ler.nextDouble();
                                        ler.nextLine();
                                        produtoP = new ProdutoQuantidade(produto,mercado.pesquisarUtilizador(nome2),stock,preco,quantidade);
                                    } else if (tipo.equalsIgnoreCase("volume")) {
                                        System.out.print("Indique o volume: ");
                                        double volume = ler.nextDouble();
                                        ler.nextLine();
                                        System.out.println("Indique o stock: ");
                                        int stock = ler.nextInt();
                                        System.out.println("Indique o preco por dm^3: ");
                                        double preco = ler.nextDouble();
                                        ler.nextLine();
                                        produtoP = new ProdutoVolume(produto,mercado.pesquisarUtilizador(nome2),stock,preco,volume);
                                    } else {
                                        System.out.println("O tipo de produto é invalido");
                                    }
                                    
                                	mercado.adicionarProdutoAgricultor((Agricultor)mercado.pesquisarUtilizador(nome2), produtoP);
                                	break;
            				case 2:
            					String emailAgri = mercado.pesquisarUtilizador(nome2).getEmail();
								System.out.print("Indique o produto que quer ocultar: ");
								String nomeProd = ler.nextLine();
								Produto prod = mercado.pesquisarProduto(nomeProd);
								if (prod != null) {
									for (Agricultor agricultor : prod.getAgricultores()) {
										ProdutoAgricultor produtoAgricultor = agricultor
												.pesquisarProdutoAgricultor(nomeProd);
										if(produtoAgricultor != null) {
											mercado.ocultarProduto(emailAgri,produtoAgricultor);
											}
									}
								} 
								else {
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
            					System.out.println("Introduza o nome do agricultor que pretende aprovar: ");
            					String nomeU = ler.next();
            					String password3 = mercado.pesquisarUtilizador(nomeU).getPassword();
            					mercado.verificarUtilizador(nomeU, password3);
            					System.out.println("Agricultor arovado com sucesso!");
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
            	}//fim login
         	
        	System.out.println("Escolha uma das seguintes opções: ");
            System.out.println("2-Login");
            System.out.println("0-Sair");
            opcao = ler.nextInt();     
        }// fim opcao else - vai fazer login
}
}