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
        Produto p1 = new Produto();
        p1.setNome("Feijão Carioca");
        p1.setMarca("Camil");
        p1.setCategoria(mercearia);
        p1.setPreco(9.90);
        p1.setQnt(542);
        p1.setID(produto.randomNum());
        listaProdutos.add(p1);

        Produto p2 = new Produto();
        p2.setNome("Detergente Neutro");
        p2.setMarca("Ypê");
        p2.setCategoria(limpeza);
        p2.setPreco(1.99);
        p2.setQnt(97);
        p2.setID(produto.randomNum());
        listaProdutos.add(p2);

        Produto p3 = new Produto();
        p3.setNome("Presunto");
        p3.setMarca("Sadia");
        p3.setCategoria(frios);
        p3.setPreco(29.99);
        p3.setQnt(100);
        p3.setID(produto.randomNum());
        listaProdutos.add(p3);

        Produto p4 = new Produto();
        p4.setNome("Picanha");
        p4.setMarca("Friboi");
        p4.setCategoria(carnes);
        p4.setPreco(72.90);
        p4.setQnt(80);
        p4.setID(produto.randomNum());
        listaProdutos.add(p4);

        Produto p5 = new Produto();
        p5.setNome("Absorvente");
        p5.setMarca("Always");
        p5.setCategoria(higiene);
        p5.setPreco(2.57);
        p5.setQnt(323);
        p5.setID(produto.randomNum());
        listaProdutos.add(p5);

        Produto p6 = new Produto();
        p6.setNome("Cebola");
        p6.setMarca("SEM MARCA");
        p6.setCategoria(hortifruti);
        p6.setPreco(3.89);
        p6.setQnt(542);
        p6.setID(produto.randomNum());
        listaProdutos.add(p6);

        Produto p7 = new Produto();
        p7.setNome("Óleo");
        p7.setMarca("Liza");
        p7.setCategoria(mercearia);
        p7.setPreco(5.99);
        p7.setQnt(132);
        p7.setID(produto.randomNum());
        listaProdutos.add(p7);

        // Loop para o menu:
        while (opcao != 0) {
            // Menu: 
		    System.out.print("\n|-------------<<<|MENU|>>>-------------|\n");
		    System.out.print("| Opção 1 - Listar produtos            |\n");
		    System.out.print("| Opção 2 - Listar por categoria       |\n");
		    System.out.print("| Opção 3 - Detalhar produto           |\n");
		    System.out.print("| Opção 4 - Cadastrar produto          |\n");
            System.out.print("| Opção 5 - Editar produto             |\n");
            System.out.print("| Opção 6 - Remover produto            |\n");
            System.out.print("| Opção 0 - Encerrar programa     <<<--|\n");
		    System.out.print("|---------------------->>>\n");
		    System.out.print("|-------->>>Digite uma opção: ");
            opcao = sc.nextByte();
            sc.nextLine();
            
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
                    System.out.print("\nDigite o ID do produto que você deseja visualizar: ");
                    id = sc.nextByte();
                    produto.visualizarProduto(listaProdutos, id);
                    break;
                case 4:
                    produto.cadastrarProduto(listaProdutos);
                    break;
                case 5:
                    produto.listarProdutos(listaProdutos);
                    System.out.print("\nDigite o ID do produto que você deseja editar: ");
                    id = sc.nextByte();
                    produto.editarProduto(listaProdutos, id);
                    break;
                case 6:
                    produto.listarProdutos(listaProdutos);
                    System.out.print("\nDigite o ID do produto que você deseja remover: ");
                    id = sc.nextByte();
                    produto.removerProduto(listaProdutos, id);
                    break;
                case 0:
                    System.out.println("\nPrograma encerrado!");
                    sc.close();
                    break;
                default:
                    System.out.println("\nInsira uma opção correta.");
                    break;
            }
        }
    }
}