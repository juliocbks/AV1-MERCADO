package projeto.aplicacao;

import java.util.Scanner;
import java.util.ArrayList;

import projeto.entidades.Produto;
import projeto.entidades.Categorias;

public class Principal {
    public static void main(String[] args) {
        // Variáveis:
        byte opcao = 127, id = 0;

        // Inicialização do objeto da classe Produto:
        Produto produto = new Produto();

        // Inicialização da ArrayList e dos objetos random e scanner:
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
        Scanner sc = new Scanner(System.in);

        // Inicialização do enum de categorias:
        Categorias bebidas = Categorias.BEBIDAS;
        Categorias mercearia = Categorias.MERCEARIA;
        Categorias limpeza = Categorias.LIMPEZA;
        Categorias frios = Categorias.FRIOS;
        Categorias padaria = Categorias.PADARIA;
        Categorias hortifruti = Categorias.HORTIFRUTI;
        Categorias petshop = Categorias.PETSHOP;
        Categorias cereais = Categorias.CEREAIS;
        Categorias outros = Categorias.OUTROS;
        Categorias carnes = Categorias.CARNES;
        Categorias higiene = Categorias.HIGIENE;

        // Inicialização dos objetos pré-definidos:

        Produto p1 = new Produto("Feijão Carioca", "Camil", mercearia, 9.90, 542, produto.randomNum());
        listaProdutos.add(p1);

        Produto p2 = new Produto("Detergente Neutro", "Ypê", limpeza, 1.99, 97, produto.randomNum());
        listaProdutos.add(p2);

        Produto p3 = new Produto("Presunto", "Sadia", frios, 29.99, 100, produto.randomNum());
        listaProdutos.add(p3);

        Produto p4 = new Produto("Picanha", "Friboi", carnes, 72.90, 80, produto.randomNum());
        listaProdutos.add(p4);

        Produto p5 = new Produto("Absorvente", "Always", higiene, 2.57, 323, produto.randomNum());
        listaProdutos.add(p5);

        Produto p6 = new Produto("Cebola", "SEM MARCA", hortifruti, 3.89, 542, produto.randomNum());
        listaProdutos.add(p6);

        Produto p7 = new Produto("Óleo", "Liza", mercearia, 5.99, 132, produto.randomNum());
        listaProdutos.add(p7);

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
                    produto.cadastrarProduto(listaProdutos);
                    break;
                case 5:
                    produto.listarProdutos(listaProdutos);
                    System.out.print("\n-> Digite o ID do produto que você deseja editar: ");
                    id = sc.nextByte();
                    produto.editarProduto(listaProdutos, id);
                    break;
                case 6:
                    produto.listarProdutos(listaProdutos);
                    System.out.print("\n-> Digite o ID do produto que você deseja remover: ");
                    id = sc.nextByte();
                    produto.removerProduto(listaProdutos, id);
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
