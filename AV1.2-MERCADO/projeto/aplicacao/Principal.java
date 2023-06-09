package projeto.aplicacao;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
 
import projeto.entidades.Produto;
import projeto.entidades.ProdutosAlimenticios;
import projeto.entidades.ProdutosEletronicos;
import projeto.entidades.ProdutosVestuario;
import projeto.entidades.Categorias;
import projeto.entidades.InicializadorProdutos;


public class Principal {
    public static void main(String[] args) {
        // Variáveis:
        byte opcao = 127, id = 0;

        // Inicialização do objeto da classe Produto:
        Produto produto = new Produto();

        // Inicialização da ArrayList e dos objetos random e scanner:
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
        Scanner sc = new Scanner(System.in);

        // Inicialização dos objetos pré-definidos e categorias:
        InicializadorProdutos.inicializarProdutos(listaProdutos);

        // Loop para o menu:
        while (opcao != 0) {
            // Menu:
            do {
                System.out.print("\n|-------------<<<|MENU|>>>-------------|\n");
                System.out.print("| Opção 1 - Listar produtos            |\n");
                System.out.print("| Opção 2 - Listar por categoria       |\n");
                System.out.print("| Opção 3 - Detalhar produto           |\n");
                System.out.print("| Opção 4 - Cadastrar produto          |\n");
                System.out.print("| Opção 5 - Editar produto             |\n");
                System.out.print("| Opção 6 - Remover produto            |\n");
                System.out.print("| Opção 0 - Encerrar programa     <<<--|\n");
                System.out.print("|---------------------->>>\n");
                System.out.print("|-------->>> Digite uma opção: ");
                if (sc.hasNextByte()) {
                    opcao = sc.nextByte();
                    // sc.nextLine();
                    break;
                } else {
                    System.out.println("\n*** Informe uma opção válida! ***");
                    sc.next();
                }
                sc.next();
            } while (true);

            // Switch case para funcionalidade do menu:
            switch (opcao) {
                case 1:
                    produto.listarProdutos(listaProdutos);
                    break;
                case 2:
                    produto.filtrarCategoria(listaProdutos);
                    break;
                case 3:
                produto.listarProdutos(listaProdutos);
                System.out.print("\n-> Digite o ID do produto que você deseja visualizar: ");
                do{
                    if(sc.hasNextByte()) {
                        id = sc.nextByte();
                        produto.visualizarProduto(listaProdutos, id);
                        break;
                    } else {
                        System.out.println("\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***");
                        System.out.print("\n-> Digite o ID do produto que você deseja visualizar: ");
                        sc.next();
                    }                
                } while(true);
                break;
                case 4:
                    System.out.println("\n-----<<<|TIPOS DE PRODUTO|>>>----- \n 1 >> Produto alimentício\n 2 >> Produto eletrônico \n 3 >> Produto de vestuário");
                    do{
                        System.out.print("\nInsira o tipo de produto a cadastrar: ");
                        if(sc.hasNextByte()) {
                            byte tipo = sc.nextByte();
                            switch(tipo) {
                                case 1:
                                produto.cadastrarProdutoAlimenticio(listaProdutos);
                                break;
                                case 2:
                                produto.cadastrarProdutoEletronico(listaProdutos);
                                break;
                                case 3:
                                produto.cadastrarProdutoVestuario(listaProdutos);
                                break;
                                default:
                                System.out.println("*** Por favor, insira um valor dentro dos parâmetros! ***");
                            }
                            break;
                        } else {
                            System.out.println("\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***\n");
                            sc.next();
                        }
                    } while(true);
                    break;
                case 5:
                produto.listarProdutos(listaProdutos);
                System.out.print("\n-> Digite o ID do produto que você deseja editar: ");
                if (sc.hasNextByte()) {
                    byte idProduto = sc.nextByte();
                    boolean produtoEncontrado = false;
                    for (Produto p : listaProdutos) {
                        if (p.getID() == idProduto) {
                            produtoEncontrado = true;
                            if (p instanceof ProdutosAlimenticios) {
                                ((ProdutosAlimenticios) p).editarProdutoAlimenticio(listaProdutos, idProduto);
                            } else if (p instanceof ProdutosEletronicos) {
                                ((ProdutosEletronicos) p).editarProdutoEletronico(listaProdutos, idProduto);
                            } else if (p instanceof ProdutosVestuario) {
                                ((ProdutosVestuario) p).editarProdutoVestuario(listaProdutos, idProduto);
                            } else {
                                System.out.println("\n*** Categoria do produto desconhecida! ***");
                            }
                            break;
                        }
                    }
                    if (!produtoEncontrado) {
                        System.out.println("\n*** Produto não encontrado! ***");
                    }
                } else {
                    System.out.println("\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***");
                    sc.next();
                }
                break;
                case 6:
                    do{
                        produto.listarProdutos(listaProdutos);
                        System.out.print("\n-> Digite o ID do produto que você deseja remover: ");
                        if(sc.hasNextByte()) {
                        id = sc.nextByte();
                        produto.removerProduto(listaProdutos, id);
                        break;
                        } else {
                            System.out.println("\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***");
                            sc.next();
                        }
                    } while(true);
                    break;
                case 0:
                    System.out.println("\n*** Programa encerrado! ***");
                    sc.close();
                    break;
                default:
                    System.out.println("\n*** Insira uma opção válida! ***");
                    break;
            }
        }
    }
}