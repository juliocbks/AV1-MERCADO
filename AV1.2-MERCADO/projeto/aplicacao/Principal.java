package projeto.aplicacao;

import java.util.Scanner;
import java.util.ArrayList;
 
import projeto.entidades.Produto;
import projeto.entidades.ProdutosAlimenticios;
import projeto.entidades.ProdutosEletronicos;
import projeto.entidades.ProdutosVestuario;
import projeto.entidades.InicializadorProdutos;
import projeto.entidades.Cores;

public class Principal {
    public static void main(String[] args) {
        // Variáveis:
        byte opcao = 127, id = 0;

        // Inicialização do objeto da classe Produto:
        Produto produto = new Produto();

        // Inicialização da ArrayList e dos objetos random e scanner:
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
        Scanner sc = new Scanner(System.in);

        // Inicialização dos objetos pré-definidos:
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
                System.out.print("|-------->>> "+Cores.AMARELO+Cores.AMARELO_SUBLINHADO+"Digite uma opção"+Cores.RESET+": ");
                if (sc.hasNextByte()) {
                    opcao = sc.nextByte();
                    break;
                } else {
                    System.out.println(Cores.VERMELHO+"\n*** Informe uma opção válida! ***"+Cores.RESET);
                }
                sc.next();
            } while (true);

            // Switch case para funcionalidade do menu:
            switch (opcao) {
                // Listar todos os produtos, NOME | CATEGORIA | ID:
                case 1:
                    produto.listarProdutos(listaProdutos);
                    break;
                // Listar todos os produtos de x categoria:
                case 2:
                    produto.filtrarCategoria(listaProdutos);
                    break;
                // Listar todos os atributos de um produto em específico:
                case 3:
                produto.listarProdutos(listaProdutos);
                System.out.print("\n>>> "+Cores.AMARELO+Cores.AMARELO_SUBLINHADO+"Digite o ID do produto que você deseja visualizar"+Cores.RESET+": ");
                do{
                    if(sc.hasNextByte()) {
                        id = sc.nextByte();
                        produto.visualizarProduto(listaProdutos, id);
                        break;
                    } else {
                        System.out.println(Cores.VERMELHO+"\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***"+Cores.RESET);
                        System.out.print("\n>>> "+Cores.AMARELO+Cores.AMARELO_SUBLINHADO+"Digite o ID do produto que você deseja visualizar"+Cores.RESET+": ");
                        sc.next();
                    }                
                } while(true);
                break;
                // Cadastrar um novo produto em uma das 3 categorias:
                case 4:
                    System.out.println("\n-----<<<|TIPOS DE PRODUTO|>>>----- \n 1 >> Produto alimentício\n 2 >> Produto eletrônico \n 3 >> Produto de vestuário");
                    do{
                        System.out.print("\n>>> "+Cores.AMARELO+Cores.AMARELO_SUBLINHADO+"Insira o tipo de produto a cadastrar: "+Cores.RESET);
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
                                System.out.println(Cores.VERMELHO+"*** Por favor, insira um valor dentro dos parâmetros! ***"+Cores.RESET);
                            }
                            break;
                        } else {
                            System.out.println(Cores.VERMELHO+"\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***\n"+Cores.RESET);
                            sc.next();
                        }
                    } while(true);
                    break;
                // Editar um produto pelo seu ID:
                case 5:
                produto.listarProdutos(listaProdutos);
                System.out.print("\n>>> "+Cores.AMARELO+Cores.AMARELO_SUBLINHADO+"Digite o ID do produto que você deseja editar"+Cores.RESET+": ");
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
                                System.out.println(Cores.VERMELHO+"\n*** Categoria do produto desconhecida! ***"+Cores.RESET);
                            }
                            break;
                        }
                    }
                    if (!produtoEncontrado) {
                        System.out.println(Cores.VERMELHO+"\n*** Produto não encontrado! ***"+Cores.RESET);
                    }
                } else {
                    System.out.println(Cores.VERMELHO+"\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***"+Cores.RESET);
                    sc.next();
                }
                break;
                // Remover um produto pelo seu ID:
                case 6:
                    do{
                        produto.listarProdutos(listaProdutos);
                        System.out.print("\n>>> "+Cores.AMARELO+Cores.AMARELO_SUBLINHADO+"Digite o ID do produto que você deseja remover"+Cores.RESET+": ");
                        if(sc.hasNextByte()) {
                        id = sc.nextByte();
                        produto.removerProduto(listaProdutos, id);
                        break;
                        } else {
                            System.out.println(Cores.VERMELHO+"\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***"+Cores.RESET);
                            sc.next();
                        }
                    } while(true);
                    break;
                // Encerrar programa:
                case 0:
                    System.out.println(Cores.VERMELHO+"\n*** Programa encerrado! ***"+Cores.RESET);
                    sc.close();
                    break;
                default:
                    System.out.println(Cores.VERMELHO+"\n*** Insira uma opção válida! ***"+Cores.RESET);
                    break;
            }
        }
    }
}
