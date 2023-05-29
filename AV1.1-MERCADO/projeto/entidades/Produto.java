package projeto.entidades;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Produto {

    // Atributos:
    private String nome, marca;
    Categorias categoria;
    private double preco;
    private int qnt, id;

    // Inicialização ENUM CATEGORIAS
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

    public Produto() {
    };

    public Produto(String nome, String marca, Categorias categoria, double preco, int qnt, int id) {
        this.nome = nome;
        this.marca = marca;
        this.categoria = categoria;
        this.preco = preco;
        this.qnt = qnt;
        this.id = id;
    }

    // Criando Setters:

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public void setID(int id) {
        this.id = id;
    }

    // Criando Getters:

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    public int getQnt() {
        return qnt;
    }

    public int getID() {
        return id;
    }

    // Inicializando ArrayList de IDs e objetos
    ArrayList<Integer> IDs = new ArrayList<>(100);
    Random rnd = new Random();
    Scanner sc = new Scanner(System.in);

    // Gerar IDs aleatórios para cada produto
    public int randomNum() {
        int random = rnd.nextInt(100);
        if (IDs.contains(random)) {
            random = rnd.nextInt(100);
        }
        // Adicionando ID à ArrayList IDs e retorná-lo:
        IDs.add(random);
        return random;
    }

    // Lógica para listar todos os produtos com for each:
    public void listarProdutos(ArrayList<Produto> lista) {
        System.out.print("\n-----<<<|LISTA DE PRODUTOS|>>>----- \n");
        for (Produto produto : lista) {
            System.out.print("\nID: " + produto.getID() + " ||Nome: " + produto.getNome() + "\n");
        }
    }

    // Lógica para visualizar um único produto com base no ID, loop for each
    public void visualizarProduto(ArrayList<Produto> lista, byte id) {
        // boolean para indicar se existe ou não um produto no ID selecionado, com o
        // padrão false:
        boolean existe = false;
        for (Produto produto : lista) {
            // Caso o id do produto seja o id inserido pelo usuário, irá listar o produto e
            // definir que o produto existe:
            if (produto.getID() == id) {
                System.out.print("\n<<<|PRODUTO ID " + id + "|>>>" + "\nNome: " + produto.getNome() + "\nMarca: "
                        + produto.getMarca() + "\nCategoria: " + produto.getCategoria() + "\nPreço: "
                        + produto.getPreco() + "\nQuantidade: " + produto.getQnt() + "\n");
                existe = true;
            }
        }
        // Caso não exista, irá exibir a mensagem:
        if (!existe) {
            System.out.println("\n*** Não há nenhum produto com esse ID! ***");
        }
    }

    // Lógica para cadastrar um novo produto:
    public void cadastrarProduto(ArrayList<Produto> lista) {
        Produto produto = new Produto();

        System.out.print("\n-> Insira o nome do produto: ");
        String nome = sc.nextLine(); // Input/Entrada
        produto.setNome(nome); // Setar/Definir nome

        System.out.print("\n-> Insira a marca do produto: ");
        String marca = sc.nextLine();
        produto.setMarca(marca);

        // No caso da categoria, irá listar as categorias e, com um switch case do tipo
        // integer, definir a categoria do produto, caso o input não seja um número, irá
        // pedir novamente para digitar um valor numérico:
        byte cat = 0;

        do {
            System.out.println("\n-----<<<|CATEGORIAS|>>>----- \n1-BEBIDAS; \n2-CARNES; \n3-CEREAIS; \n4-FRIOS; \n5-HIGIENE; \n6-HORTIFRUTI; \n7-LIMPEZA; \n8-MERCEARIA; \n9-PADARIA; \n10-PETSHOP; \n11-OUTROS.");
            System.out.print("-> Insira a categoria do produto: ");
            if(sc.hasNextByte()) {
                cat = sc.nextByte();
                if(cat>11||cat<1) {
                    System.out.println("*** Insira um valor válido! ***");
                }
            } else {
                System.out.println("*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***");
                sc.nextLine();
            }   
        } while (cat < 1 || cat > 11);

        switch (cat) {
            case 1:
                produto.setCategoria(Categorias.BEBIDAS);
                break;
            case 2:
                produto.setCategoria(Categorias.CARNES);
                break;
            case 3:
                produto.setCategoria(Categorias.CEREAIS);
                break;
            case 4:
                produto.setCategoria(Categorias.FRIOS);
                break;
            case 5:
                produto.setCategoria(Categorias.HIGIENE);
                break;
            case 6:
                produto.setCategoria(Categorias.HORTIFRUTI);
                break;
            case 7:
                produto.setCategoria(Categorias.LIMPEZA);
                break;
            case 8:
                produto.setCategoria(Categorias.MERCEARIA);
                break;
            case 9:
                produto.setCategoria(Categorias.PADARIA);
                break;
            case 10:
                produto.setCategoria(Categorias.PETSHOP);
                break;
            case 11:
                produto.setCategoria(Categorias.OUTROS);
                break;
            default:
        }

        do {
            System.out.print("\n-> Insira o preço do produto: ");
            if (sc.hasNextDouble()) {
                double preco = sc.nextDouble();
                produto.setPreco(preco);
                break;
            } else {
                System.out.println("*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***");
                sc.next();
            }

        } while (true);

        do {
            System.out.print("\n-> Insira a quantidade do produto: ");
            if (sc.hasNextInt()) {
                int qnt = sc.nextInt();
                produto.setQnt(qnt);
                break;
            } else {
                System.out.println("*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***");
                sc.next();
            }
        } while (true);

        // ID aleatório gerado automaticamente:
        produto.setID(randomNum());
        // Adicionar produto à lista:
        lista.add(produto);
        // Limpando buffer:
        sc.nextLine();
    }

    // Lógica para editar um produto(cada atributo dele):
    public void editarProduto(ArrayList<Produto> lista, byte id) {
        // boolean para indicar se existe ou não um produto no ID selecionado, com o
        // padrão false:
        boolean existe = false;
        for (Produto produto : lista) {
            // Se o id do produto for o id indicado pelo usuário, indicará os atributos do
            // produto e definirá o boolean para true:
            if (produto.getID() == id) {
                System.out.print("\n<<<|PRODUTO ID " + id + "|>>>" + "\nNome: " + produto.getNome() + "\nMarca: "
                        + produto.getMarca() + "\nCategoria: " + produto.getCategoria() + "\nPreço: "
                        + produto.getPreco() + "\nQuantidade: " + produto.getQnt() + "\n");
                existe = true;
            }
        }
        // Caso o produto exista, irá perguntar qual atributo o usuário deseja editar e,
        // dependendo da resposta, executará um dos switch case; caso não exista,
        // enviará a mensagem:
        int escolha = 0;
        if (existe) {
            do{
                System.out.println("\n1- Nome | 2- Marca | 3- Categoria | 4- Preço | 5- Quantidade | 0- VOLTAR AO MENU");
                System.out.print("-> Insira a opção a editar no produto: ");
                if (sc.hasNextInt()) {
                    escolha = sc.nextInt();
                    switch (escolha) {

                        // Definir novo nome:
                        case 1:
                            System.out.print("-> Insira o novo nome: ");
                            sc.nextLine();
                            String newNome = sc.nextLine();
                            for (Produto produto : lista) {
                                if (produto.getID() == id) {
                                    produto.setNome(newNome);
                                    System.out.println("*** Nome atualizado com sucesso! ***");
                                    System.out.print("\n<<<|PRODUTO ID " + id + "|>>>" + "\nNome: " + produto.getNome() + "\nMarca: "
                                    + produto.getMarca() + "\nCategoria: " + produto.getCategoria() + "\nPreço: "
                                    + produto.getPreco() + "\nQuantidade: " + produto.getQnt() + "\n");
                                }
                            }
                            break;

                            // Definir nova marca:
                        case 2:
                            System.out.print("-> Insira a nova marca: ");
                            sc.nextLine();
                            String newMarca = sc.nextLine();
                            for (Produto produto : lista) {
                                if (produto.getID() == id) {
                                    produto.setMarca(newMarca);
                                    System.out.println("*** Marca atualizada com sucesso! ***");
                                    System.out.print("\n<<<|PRODUTO ID " + id + "|>>>" + "\nNome: " + produto.getNome() + "\nMarca: "
                                    + produto.getMarca() + "\nCategoria: " + produto.getCategoria() + "\nPreço: "
                                    + produto.getPreco() + "\nQuantidade: " + produto.getQnt() + "\n");
                                }
                            }
                            break;

                            // Definir nova categoria:
                        case 3:
                            for (Produto produto : lista) {
                                byte newCat = 0;
                                if (produto.getID() == id) {
                                    do {
                                        System.out.println("\n-----<<<|CATEGORIAS|>>>----- \n1-BEBIDAS; \n2-CARNES; \n3-CEREAIS; \n4-FRIOS; \n5-HIGIENE; \n6-HORTIFRUTI; \n7-LIMPEZA; \n8-MERCEARIA; \n9-PADARIA; \n10-PETSHOP; \n11-OUTROS.");
                                        do {
                                            System.out.print("-> Insira a categoria do produto: ");
                                            if(sc.hasNextByte()) {
                                                newCat = sc.nextByte();
                                                if (newCat<1|| newCat>11) {
                                                    System.out.println("\n*** Insira um valor válido! ***");
                                                }
                                                switch (newCat) {
                                                    case 1:
                                                        produto.setCategoria(bebidas);
                                                        System.out.println("*** Categoria atualizada com sucesso! ***");
                                                        break;
                                                    case 2:
                                                        produto.setCategoria(carnes);
                                                        System.out.println("*** Categoria atualizada com sucesso! ***");
                                                        break;
                                                    case 3:
                                                        produto.setCategoria(cereais);
                                                        System.out.println("*** Categoria atualizada com sucesso! ***");
                                                        break;
                                                    case 4:
                                                        produto.setCategoria(frios);
                                                        System.out.println("*** Categoria atualizada com sucesso! ***");
                                                        break;
                                                    case 5:
                                                        produto.setCategoria(higiene);
                                                        System.out.println("*** Categoria atualizada com sucesso! ***");
                                                        break;
                                                    case 6:
                                                        produto.setCategoria(hortifruti);
                                                        System.out.println("*** Categoria atualizada com sucesso! ***");
                                                        break;
                                                    case 7:
                                                        produto.setCategoria(limpeza);
                                                        System.out.println("*** Categoria atualizada com sucesso! ***");
                                                        break;
                                                    case 8:
                                                        produto.setCategoria(mercearia);
                                                        System.out.println("*** Categoria atualizada com sucesso! ***");
                                                        break;
                                                    case 9:
                                                        produto.setCategoria(padaria);
                                                        System.out.println("*** Categoria atualizada com sucesso! ***");
                                                        break;
                                                    case 10:
                                                        produto.setCategoria(petshop);
                                                        System.out.println("*** Categoria atualizada com sucesso! ***");
                                                        break;
                                                    case 11:
                                                        produto.setCategoria(outros);
                                                        System.out.println("*** Categoria atualizada com sucesso! ***");
                                                        break;
                                                } 
                                                System.out.print("\n<<<|PRODUTO ID " + id + "|>>>" + "\nNome: " + produto.getNome() + "\nMarca: "
                                                + produto.getMarca() + "\nCategoria: " + produto.getCategoria() + "\nPreço: "
                                                + produto.getPreco() + "\nQuantidade: " + produto.getQnt() + "\n");
                                            } else {
                                                System.out.println("\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***");
                                                sc.next();
                                            }
                                        break;
                                        } while(true);
                                    } while (newCat < 1 || newCat > 11);
                                }
                            }
                            break;

                        // Definir novo preço:
                        case 4:
        
                            double newPreco;
                            do {
                                System.out.print("-> Insira o novo preço: ");
                                if (sc.hasNextDouble()) {
                                    newPreco = sc.nextDouble();
                                    for (Produto produto : lista) {
                                        if (produto.getID() == id) {
                                            produto.setPreco(newPreco);
                                            System.out.println("*** O preço do produto foi atualizado com sucesso! ***");
                                            System.out.print("\n<<<|PRODUTO ID " + id + "|>>>" + "\nNome: " + produto.getNome() + "\nMarca: "
                                            + produto.getMarca() + "\nCategoria: " + produto.getCategoria() + "\nPreço: "
                                            + produto.getPreco() + "\nQuantidade: " + produto.getQnt() + "\n");
                                        }
                                    }
                                break;
                                } else {
                                    System.out.println("*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***");
                                    sc.nextLine();
                                }
        
                            } while (true);
                            break;
                        // Editar a quantidade - diminuir ou adicionar à quantidade atual de x produto:
                        case 5:
                            do{
                                System.out.print("-> Digite o valor a adicionar, para diminuir, insira um valor negativo: ");
                                if(sc.hasNextInt()) {
                                    int newQnt = sc.nextInt();
                                    for (Produto produto : lista) {
                                        // Adicionar à quantidade atual de produtos a quantidade inserida pelo usuário:
                                        if (produto.getID() == id) {
                                            produto.setQnt(produto.getQnt() + newQnt);
                                            System.out.println("*** A quantidade do produto foi atualizado com sucesso! ***");
                                            System.out.print("\n<<<|PRODUTO ID " + id + "|>>>" + "\nNome: " + produto.getNome() + "\nMarca: "
                                            + produto.getMarca() + "\nCategoria: " + produto.getCategoria() + "\nPreço: "
                                            + produto.getPreco() + "\nQuantidade: " + produto.getQnt() + "\n");
                                            break;
                                        }
                                    }
                                    break;
                                } else {
                                    System.out.println("\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***\n");
                                    sc.next();
                                }
                            } while(true);
                            break;
                        case 0:
                            System.out.println("\n*** Voltando ao menu principal! ***");
                            sc.nextLine();
                            return;
                        default:
                            // Caso insira uma opção fora das 5 opções de edição:
                            System.out.println("\n*** Digite uma opção válida! ***");
                            sc.nextLine();
                    }
                } else {
                    System.out.println("\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***");
                    sc.next();
                }
            } while (true);
        } else {
            // Caso digite um id incorreto de produto:
            System.out.println("\n*** Não há nenhum produto com esse ID! ***");
        }
    }

    // Lógica para remover um produto com for each e remover o ID da lista de IDs,
    // para que possa ser gerado novamente, foi necessária a criação de uma nova
    // lista de objetos, para evitar que aconteça o erro de remoção dentro do loop:
    public void removerProduto(ArrayList<Produto> lista, byte id) {
        // boolean para indicar se existe ou não um produto no ID selecionado, com o
        // padrão false:
        boolean existe = false;
        ArrayList<Produto> listaProdutos2 = new ArrayList<>(lista);
        for (Produto produto : listaProdutos2) {
            // Se o id do produto for o id indicado pelo usuário, definirá o boolean para
            // true, removerá o produto da ArrayList e removerá o seu id da ArrayList de
            // IDs:
            if (produto.getID() == id) {
                existe = true;
                lista.remove(produto);
                IDs.remove(IDs.indexOf(produto.getID()));
            }
        }
        // Caso não exista, enviará uma mensagem indicando, caso contrário, enviará a
        // mensagem que o produto foi removido:
        if (!existe) {
            System.out.println("\n*** Não há nenhum produto com esse ID! ***");
        } else {
            System.out.println("*** Produto removido! ***");
        }
        listaProdutos2.clear();
    }

    // Lógica para listar apenas os produtos com x categoria, filtro:
    public void filtrarCategoria(ArrayList<Produto> lista) {
        // Enviar categorias:
        byte catv = 0;
        do {
            System.out.println(
                    "\n-----<<<|CATEGORIAS|>>>----- \n1-BEBIDAS; \n2-CARNES; \n3-CEREAIS; \n4-FRIOS; \n5-HIGIENE; " +
                            " \n6-HORTIFRUTI; \n7-LIMPEZA; \n8-MERCEARIA; \n9-PADARIA; \n10-PETSHOP; \n11-OUTROS.");
            System.out.print("-> Insira a categoria a visualizar: ");
            if(sc.hasNextByte()) {
                catv = sc.nextByte();
                if (catv>11 || catv<1) {
                    System.out.println("\n*** Insira um valor válido! ***");
                }
                sc.nextLine();
            } else {
                System.out.println("\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***");
                sc.nextLine();
            }
        } while (catv < 1 || catv > 11);
        Categorias categoriafiltro = outros;
        // Switch case para definir a categoria a ser filtrada, a categoria padrão é
        // OUTROS:
        switch (catv) {
            case 1:
                categoriafiltro = bebidas;
                break;
            case 2:
                categoriafiltro = carnes;
                break;
            case 3:
                categoriafiltro = cereais;
                break;
            case 4:
                categoriafiltro = frios;
                break;
            case 5:
                categoriafiltro = higiene;
                break;
            case 6:
                categoriafiltro = hortifruti;
                break;
            case 7:
                categoriafiltro = limpeza;
                break;
            case 8:
                categoriafiltro = mercearia;
                break;
            case 9:
                categoriafiltro = padaria;
                break;
            case 10:
                categoriafiltro = petshop;
                break;
            case 11:
                categoriafiltro = outros;
                break;
            default:
        }
        // boolean para indicar se existe ou não um produto no ID selecionado, com o
        // padrão false:
        boolean possui = false;
        System.out.println("\n-----<<<|" + categoriafiltro + "|>>>-----");
        for (Produto produto : lista) {
            // Se a categoria do produto for a mesma selecionada, irá definir o boolean
            // possui para true e enviá-la:
            if (produto.getCategoria() == categoriafiltro) {
                System.out.print("\nID: " + produto.getID() + " ||Nome: " + produto.getNome() + "\n");
                possui = true;
            } else {
                continue;
            }
        }
        // Caso não possua, irá enviar a mensagem, indicando que não há produtos em dada
        // categoria:
        if (!possui) {
            System.out.println("\n*** Não há produtos nesta categoria! ***");
        }
    }
}
