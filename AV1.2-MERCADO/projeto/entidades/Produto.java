package projeto.entidades;

import java.util.Scanner; // Utilizado para realizar a entrada de dados do usuário;
import java.util.ArrayList; // Utilizado para armazenar dados;
import java.util.List; // Utilizado para armazenar dados;
import java.util.Random; // Utilizado para gerar números aleatórios em um range;
import java.util.Comparator; // Utilizado para ordenação;
import java.util.stream.Collectors; // Utilizado para ordenação;


// Classe pai Produto:
public class Produto {
    // Atributos:
    private String nome, marca;
    Categorias categoria;
    private double preco;
    private int qnt, id;

    public Produto() {

    };

    // Atribuindo os atibutos da classe pai:
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

    // Inicializando ArrayList de IDs e objetos - Random e Scanner:
    public static ArrayList<Integer> IDs = new ArrayList<>(100);
    static Random rnd = new Random();
    Scanner sc = new Scanner(System.in);

    // Método para gerar IDs aleatórios para cada produto(range de 0 a 100):
    public static int randomNum() {
        int random = rnd.nextInt(100);
        if (IDs.contains(random)) {
            random = rnd.nextInt(100);
        }
        // Adicionando ID à ArrayList IDs e retorná-lo:
        IDs.add(random);
        return random;
    }

    // Método para listar todos os produtos com for each:
    public void listarProdutos(ArrayList<Produto> lista) {
        // Ordenar a lista com Comparator e Stream.collectors:
        List<Produto> listaOrdenada = lista.stream().sorted(Comparator.comparingInt(Produto::getID)).collect(Collectors.toList());
        // Listar produtos com for each:
        System.out.print("\n-----<<<|LISTA DE PRODUTOS[" + listaOrdenada.size() + "]|>>>----- \n");
        for (Produto produto : listaOrdenada) {
            System.out.print("\nID: " + produto.getID() + " || " + produto.getCategoria() + " || Nome: "+ produto.getNome() + "\n");
        }
    }

    // Método para visualizar um único produto com base no ID, loop for each
    public void visualizarProduto(ArrayList<Produto> lista, byte id) {
        // boolean para indicar se existe ou não um produto no ID selecionado, com o padrão false:
        boolean existe = false;
        for (Produto produto : lista) {
            // Caso o id do produto seja o id inserido pelo usuário, irá listar o produto e definir que o produto existe:
            if (produto.getID() == id) {
                // Listar todos os atributos padrões da classe Produto:
                System.out.print("\n<<<|PRODUTO ID " + id + "|>>>" + "\nNome: " + produto.getNome() + "\nMarca: "+ produto.getMarca() + "\nCategoria: " + produto.getCategoria() + "\nPreço: "+ produto.getPreco() + "\nQuantidade: " + produto.getQnt() + "\n");

                // Listar atributos de cada classe filha separados:
                if (produto.getCategoria() == Categorias.ALIMENTOS) {
                    ProdutosAlimenticios pAlimento = (ProdutosAlimenticios) produto;
                    System.out.print("Volume(por unidade): " + pAlimento.getPeso() + "\nData de validade: "+ pAlimento.getDataValidade() + "\n");
                } else if (produto.getCategoria() == Categorias.ELETRONICOS) {
                    ProdutosEletronicos pEletronico = (ProdutosEletronicos) produto;
                    System.out.print("Modelo: " + pEletronico.getModelo() + "\nTamanho: " + pEletronico.getTamanhoE()+ "\nConexões: " + pEletronico.getConexoes() + "\n");
                } else if (produto.getCategoria() == Categorias.VESTUARIO) {
                    ProdutosVestuario pVestuario = (ProdutosVestuario) produto;
                    System.out.print("Tamanho: " + pVestuario.getTamanhoV() + "\nMaterial: " + pVestuario.getMaterial()+ "\nCor: " + pVestuario.getCor() + "\n");
                }
                existe = true;
            }
        }
        // Caso não exista, irá exibir a mensagem:
        if (!existe) {
            System.out.println(Cores.VERMELHO + "\n*** Não há nenhum produto com esse ID! ***" + Cores.RESET);
        }
    }

    // Método para cadastrar um novo produto:
    public void cadastro(Produto produto, Categorias categoria) {
        // Cadastrar nome:
        System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira o nome do produto" + Cores.RESET + ": ");
        String nome = sc.nextLine(); // Input/Entrada.
        produto.setNome(nome); // Setar/Definir valor ao atributo.

        // Cadastrar marca:
        System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira a marca do produto" + Cores.RESET + ": ");
        String marca = sc.nextLine();
        produto.setMarca(marca);

        // Cadastrar preço:
        do {
            System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira o preço do produto"+ Cores.RESET + ": ");
            if (sc.hasNextDouble()) {
                double preco = sc.nextDouble();
                produto.setPreco(preco);
                break;
            } else {
                System.out.println(Cores.VERMELHO+ "*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***"+ Cores.RESET);
                sc.next();
            }
        } while (true);

        // Cadastrar quantidade:
        do {
            System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira a quantidade do produto"+ Cores.RESET + ": ");
            if (sc.hasNextInt()) {
                int qnt = sc.nextInt();
                produto.setQnt(qnt);
                break;
            } else {
                System.out.println(Cores.VERMELHO+ "*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***"+ Cores.RESET);
                sc.next();
            }
        } while (true);

        // Setar categoria:
        produto.setCategoria(categoria);
        // ID aleatório gerado automaticamente:
        produto.setID(randomNum());
        // Limpar buffer:
        sc.nextLine();
    }

    // Método para editar o nome do produto:
    public void editarNome(ArrayList<Produto> lista, byte id) {
        System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira o novo nome" + Cores.RESET + ": ");
        String newNome = sc.nextLine();
        for (Produto produto : lista) {
            if (produto.getID() == id) {
                produto.setNome(newNome);
                System.out.println(Cores.VERDE + "*** Nome atualizado com sucesso! ***" + Cores.RESET);
                visualizarProduto(lista, id);
            }
        }
    }

    // Método para editar a marca do produto:
    public void editarMarca(ArrayList<Produto> lista, byte id) {
        System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira a nova marca" + Cores.RESET + ": ");
        String newMarca = sc.nextLine();
        for (Produto produto : lista) {
            if (produto.getID() == id) {
                produto.setMarca(newMarca);
                System.out.println(Cores.VERDE + "*** Marca atualizada com sucesso! ***" + Cores.RESET);
                visualizarProduto(lista, id);
            }
        }
    }

    // Método para editar o preço do produto:
    public void editarPreco(ArrayList<Produto> lista, byte id) {
        do {
            System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira o novo preço" + Cores.RESET + ": ");
            if (sc.hasNextDouble()) {
                double newPreco = sc.nextDouble();
                for (Produto produto : lista) {
                    if (produto.getID() == id) {
                        produto.setPreco(newPreco);
                        System.out.println(Cores.VERDE + "*** O preço do produto foi atualizado com sucesso! ***" + Cores.RESET);
                        visualizarProduto(lista, id);
                    }
                }
                break;
            } else {
                System.out.println(Cores.VERMELHO + "\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***"+ Cores.RESET);
                sc.nextLine();
            }
        } while (true);
    }

    // Método para editar a quantidade do produto:
    public void editarQuantidade(ArrayList<Produto> lista, byte id) {
        do {
            System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Digite o valor a adicionar, para diminuir, insira um valor negativo" + Cores.RESET + ": ");
            if (sc.hasNextInt()) {
                int newQnt = sc.nextInt();
                for (Produto produto : lista) {
                    // Adicionar à quantidade atual de produtos a quantidade inserida pelo usuário:
                    if (produto.getID() == id) {
                        produto.setQnt(produto.getQnt() + newQnt);
                        System.out.println(Cores.VERDE + "*** A quantidade do produto foi atualizado com sucesso! ***"+ Cores.RESET);
                        visualizarProduto(lista, id);
                        break;
                    }
                }
                break;
            } else {
                System.out.println(Cores.VERMELHO+ "\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***\n"+ Cores.RESET);
                sc.next();
            }
        } while (true);
    }

    // Método para remover um produto com for each e remover o ID da lista de IDs, para que possa ser gerado novamente, foi necessária a criação de uma nova lista de objetos, para evitar que aconteça o erro de remoção dentro do loop:
    public void removerProduto(ArrayList<Produto> lista, byte id) {
        // boolean para indicar se existe ou não um produto no ID selecionado, com o padrão false:
        boolean existe = false;
        ArrayList<Produto> listaProdutosTemp = new ArrayList<>(lista);
        for (Produto produto : listaProdutosTemp) {
            // Se o id do produto for o id indicado pelo usuário, definirá o boolean para true, removerá o produto da ArrayList e removerá o seu id da ArrayList de IDs:
            if (produto.getID() == id) {
                existe = true;
                System.out.print(Cores.VERMELHO + "Deseja mesmo remover o produto ID " + id + " - " + produto.getNome()+ "? (s/n)" + Cores.RESET + ": ");
                String confirmacao = sc.nextLine();
                switch (confirmacao) {
                    case "s":
                        lista.remove(produto);
                        IDs.remove(IDs.indexOf(produto.getID()));
                        System.out.println(Cores.VERDE + "*** Produto removido! ***" + Cores.RESET);
                        break;
                    case "n":
                        System.out.println(Cores.VERMELHO + "*** Produto não removido! ***" + Cores.RESET);
                        return;
                    default:
                        System.out.println(Cores.VERMELHO + "\n*** Insira um valor correto (s/n) ***" + Cores.RESET);
                }
            }
        }
        // Caso não exista, enviará uma mensagem indicando, caso contrário, enviará a mensagem que o produto foi removido:
        if (!existe) {
            System.out.println(Cores.VERMELHO + "\n*** Não há nenhum produto com esse ID! ***" + Cores.RESET);
        }
        listaProdutosTemp.clear();
    }

    // Método para listar apenas os produtos com x categoria, filtro:
    public void filtrarCategoria(ArrayList<Produto> lista) {
        // Quantidade de produtos por categoria:
        int qntA = 0;
        int qntE = 0;
        int qntV = 0;
        for (Produto produto : lista) {
            if (produto.getCategoria() == Categorias.ALIMENTOS) {
                qntA++;
            } else if (produto.getCategoria() == Categorias.ELETRONICOS) {
                qntE++;
            } else if (produto.getCategoria() == Categorias.VESTUARIO) {
                qntV++;
            }
        }
        // Enviar categorias:
        byte catFiltro = 0;
        do {
            System.out.println("\n-----<<<|CATEGORIAS|>>>----- \n1-ALIMENTOS [" + qntA + "] \n2-ELETRÔNICOS [" + qntE+ "] \n3-VESTUÁRIO [" + qntV + "]\n");
            System.out.print(">>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira a categoria a visualizar" + Cores.RESET + ": ");
            if (sc.hasNextByte()) {
                catFiltro = sc.nextByte();
                if (catFiltro > 3 || catFiltro < 1) {
                    System.out.println(Cores.VERMELHO + "\n*** Insira um valor válido! ***" + Cores.RESET);
                }
                sc.nextLine();
            } else {
                System.out.println(Cores.VERMELHO+ "\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***"+ Cores.RESET);
                sc.nextLine();
            }
        } while (catFiltro < 1 || catFiltro > 3);
        Categorias categoriafiltro = Categorias.ALIMENTOS;
        // Switch case para definir a categoria a ser filtrada:
        switch (catFiltro) {
            case 1:
                categoriafiltro = Categorias.ALIMENTOS;
                break;
            case 2:
                categoriafiltro = Categorias.ELETRONICOS;
                break;
            case 3:
                categoriafiltro = Categorias.VESTUARIO;
                break;
        }
        // boolean para indicar se existe ou não um produto no ID selecionado, com o padrão false:
        boolean possui = false;
        // Ordenar a lista com Comparator e stream.collectors:
        List<Produto> listaOrdenadaFiltro = lista.stream().sorted(Comparator.comparingInt(Produto::getID)).collect(Collectors.toList());
        System.out.print("\n-----<<<|" + categoriafiltro + "|>>>----- \n");
        for (Produto produtoOrd : listaOrdenadaFiltro) {
            if (produtoOrd.getCategoria() == categoriafiltro) {
                // Se a categoria do produto for a mesma selecionada, irá definir o boolean possui para true e enviá-la:
                if (produtoOrd.getCategoria() == categoriafiltro) {
                    System.out.print("\nID: " + produtoOrd.getID() + " ||Nome: " + produtoOrd.getNome() + "\n");
                    possui = true;
                } else {
                    continue;
                }
            }
        }
        // Caso não possua, irá enviar a mensagem, indicando que não há produtos em dada categoria:
        if (!possui) {
            System.out.println(Cores.VERMELHO + "\n*** Não há produtos nesta categoria! ***" + Cores.RESET);
        }
    }
}
