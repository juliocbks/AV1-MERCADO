package projeto.entidades;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.io.*;

public class Produto {

    // Atributos:
    private String nome, marca;
    Categorias categoria;
    private double preco;
    private int qnt, id;

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
    static ArrayList<Integer> IDs = new ArrayList<>(100);
    static Random rnd = new Random();
    Scanner sc = new Scanner(System.in);

    // Gerar IDs aleatórios para cada produto
    public static int randomNum() {
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
        // Ordenar a lista com Comparator e Stream.collectors:
        List<Produto> listaOrdenada = lista.stream().sorted(Comparator.comparingInt(Produto::getID)).collect(Collectors.toList());

        System.out.print("\n-----<<<|LISTA DE PRODUTOS[" + listaOrdenada.size() + "]|>>>----- \n");
        for (Produto produto : listaOrdenada) {
            System.out.print("\nID: " + produto.getID() + " || "  + produto.getCategoria() + " || Nome: " + produto.getNome() + "\n");
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
                // Listar todos os atributos padrões da classe Produto:
                System.out.print("\n<<<|PRODUTO ID " + id + "|>>>" + "\nNome: " + produto.getNome() + "\nMarca: "
                + produto.getMarca() + "\nCategoria: " + produto.getCategoria() + "\nPreço: "
                + produto.getPreco() + "\nQuantidade: " + produto.getQnt() + "\n");

                // Listar atributos de cada classe filha separada:
                if(produto.getCategoria()==Categorias.ALIMENTOS) {
                    ProdutosAlimenticios pAlimento = (ProdutosAlimenticios) produto;
                    System.out.print("Peso(kg/l): " + pAlimento.getPeso() + "\nData de validade: " + pAlimento.getDataValidade()+"\n");
                } else if(produto.getCategoria()==Categorias.ELETRONICOS) {
                    ProdutosEletronicos pEletronico = (ProdutosEletronicos) produto;
                    System.out.print("Modelo: " + pEletronico.getModelo() + "\nTamanho: " + pEletronico.getTamanhoE() + "\nConexões: " + pEletronico.getConexoes()+"\n");
                } else if(produto.getCategoria()==Categorias.VESTUARIO) {
                    ProdutosVestuario pVestuario = (ProdutosVestuario) produto;
                   System.out.print("Tamanho: " + pVestuario.getTamanhoV() + "\nMaterial: " + pVestuario.getMaterial() + "\nCor: " + pVestuario.getCor()+"\n");
                }
                existe = true;
            }
        }
        // Caso não exista, irá exibir a mensagem:
        if (!existe) {
            System.out.println("\n*** Não há nenhum produto com esse ID! ***");
        }
    }

    // Lógica para cadastrar um novo produto:
    public void cadastro(Produto produto, Categorias categoria) {
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

        produto.setCategoria(categoria);

        // ID aleatório gerado automaticamente:
        produto.setID(randomNum());
        // Limpando buffer:
        sc.nextLine();
    }

    public void cadastrarProdutoAlimenticio(ArrayList<Produto> lista) {
        ProdutosAlimenticios produto = new ProdutosAlimenticios();
        // Cadastro geral classe mãe:
        cadastro(produto, Categorias.ALIMENTOS);
        // Cadastrar peso:
        do {
            System.out.print("\n-> Insira o peso do produto: ");
            if (sc.hasNextDouble()) {
                double peso = sc.nextDouble();
                produto.setPeso(peso);
                break;
            } else {
                System.out.println("*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***");
                sc.next();
            }
        } while (true);

        // Cadastrar data de validade:
        System.out.print("\n-> Insira a data de validade do produto(dd/MM/yyyy): ");
        String dataValidade = sc.nextLine();
        produto.setDataValidade(dataValidade);
        // Limpando buffer:
        sc.nextLine();
        // Adicionar produto à lista:
        lista.add(produto);
    }

    public void cadastrarProdutoEletronico(ArrayList<Produto> lista) {
        ProdutosEletronicos produto = new ProdutosEletronicos();
        // Cadastro geral classe mãe:
        cadastro(produto, Categorias.ELETRONICOS);
        // Cadastrar modelo:
        do {
            System.out.print("\n-> Insira o modelo do produto: ");
            String modelo = sc.nextLine();
            produto.setModelo(modelo);
            break;
        } while (true);

        // Cadastrar tamanho:
        do {
            System.out.print("\n-> Insira o tamanho do produto: ");
            if(sc.hasNextDouble()) {
                String tamanho = sc.nextLine();
                produto.setTamanho(tamanho);
                break;
            }
            else {
                System.out.println("*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***");
                sc.next();
            }
        } while (true);

        // Cadastrar conexões:
        do {
            System.out.print("\n-> Insira as conexões do produto: ");
            String conexoes = sc.nextLine();
            produto.setConexoes(conexoes);
            break;
        } while (true);
        // Adicionar produto à lista:
        lista.add(produto);
    }

    public void cadastrarProdutoVestuario(ArrayList<Produto> lista) {
        ProdutosVestuario produto = new ProdutosVestuario();
        // Cadastro geral classe mãe:
        cadastro(produto, Categorias.VESTUARIO);

        // Cadastrar tamanho:
        do {
            System.out.print("\n-> Insira o tamanho do produto: ");
            String tamanho = sc.nextLine();
            produto.setTamanho(tamanho);
            break;
        } while (true);

        // Cadastrar cor:
        do {
            System.out.print("\n-> Insira a cor do produto: ");
            String cor = sc.nextLine();
            produto.setCor(cor);
            break;
        } while (true);

        // Cadastrar material:
        do {
            System.out.print("\n-> Insira o material do produto: ");
            String material = sc.nextLine();
            produto.setMaterial(material);
            break;
        } while (true);

        // Adicionar produto à lista:
        lista.add(produto);
    }
    
    public void editarNome(ArrayList<Produto> lista, byte id) {
        System.out.print("-> Insira o novo nome: ");
        sc.nextLine();
        String newNome = sc.nextLine();
        for (Produto produto : lista) {
            if (produto.getID() == id) {
                produto.setNome(newNome);
                System.out.println("*** Nome atualizado com sucesso! ***");
                visualizarProduto(lista, id);
            }
        }
    }

    public void editarMarca(ArrayList<Produto> lista, byte id) {
        System.out.print("-> Insira a nova marca: ");
        sc.nextLine();
        String newMarca = sc.nextLine();
        for (Produto produto : lista) {
            if (produto.getID() == id) {
                produto.setMarca(newMarca);
                System.out.println("*** Marca atualizada com sucesso! ***");
                visualizarProduto(lista, id);
            }
        }
    }

    public void editarPreco(ArrayList<Produto> lista, byte id) {
        do {
            System.out.print("-> Insira o novo preço: ");
            if (sc.hasNextDouble()) {
                double newPreco = sc.nextDouble();
                for (Produto produto : lista) {
                    if (produto.getID() == id) {
                        produto.setPreco(newPreco);
                        System.out.println("*** O preço do produto foi atualizado com sucesso! ***");
                        visualizarProduto(lista, id);
                    }
                }
            break;
            } else {
                System.out.println("*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***");
                sc.nextLine();
            }

        } while (true);
    }

    public void editarQuantidade(ArrayList<Produto> lista, byte id) {
        do{
            System.out.print("-> Digite o valor a adicionar, para diminuir, insira um valor negativo: ");
            if(sc.hasNextInt()) {
                int newQnt = sc.nextInt();
                for (Produto produto : lista) {
                    // Adicionar à quantidade atual de produtos a quantidade inserida pelo usuário:
                    if (produto.getID() == id) {
                        produto.setQnt(produto.getQnt() + newQnt);
                        System.out.println("*** A quantidade do produto foi atualizado com sucesso! ***");
                        visualizarProduto(lista, id);
                        break;
                    }
                }
                break;
            } else {
                System.out.println("\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***\n");
                sc.next();
            }
        } while(true);
    }

    public void editarPeso(ArrayList<Produto> lista, byte id) {
            do {
                System.out.print("-> Insira o novo peso: ");
                if (sc.hasNextDouble()) {
                    double newPeso = sc.nextDouble();
                    for (Produto produto : lista) {
                        if (produto.getID() == id) {
                            ProdutosAlimenticios produtoA = (ProdutosAlimenticios) produto;
                            produtoA.setPeso(newPeso);
                            System.out.println("*** O peso do produto foi atualizado com sucesso! ***");
                            visualizarProduto(lista, id);
                        }
                    }
                break;
                } else {
                    System.out.println("*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***");
                    sc.nextLine();
                }

            } while (true);
    }

    public void editarDataValidade(ArrayList<Produto> lista, byte id) {
        System.out.print("-> Insira a nova data de validade: ");
        String newDataValidade = sc.nextLine();
        for (Produto produto : lista) {
            if (produto.getID() == id) {
                ProdutosAlimenticios produtoA = (ProdutosAlimenticios) produto;
                produtoA.setDataValidade(newDataValidade);
                System.out.println("*** A data de validade do produto foi atualizado com sucesso! ***");
                visualizarProduto(lista, id);
            }
        }
    }

    public void editarModelo(ArrayList<Produto> lista, byte id) {
        System.out.print("-> Insira o novo modelo: ");
        String newModelo = sc.nextLine();
        for (Produto produto : lista) {
            if (produto.getID() == id) {
                ProdutosEletronicos produtoE = (ProdutosEletronicos) produto;
                produtoE.setModelo(newModelo);
            }
        }
        System.out.println("*** O modelo do produto foi atualizado com sucesso! ***");
        visualizarProduto(lista, id);
    }

    public void editarTamanhoE(ArrayList<Produto> lista, byte id) {
        System.out.print("-> Insira o novo tamanho: ");
        String newTamanhoE = sc.nextLine();
        for (Produto produto : lista) {
            if (produto.getID() == id) {
                ProdutosEletronicos produtoE = (ProdutosEletronicos) produto;
                produtoE.setTamanho(newTamanhoE);
                System.out.println("*** O tamanho do produto foi atualizado com sucesso! ***");
                visualizarProduto(lista, id);
            }
        }
    }

    public void editarConexoes(ArrayList<Produto> lista, byte id) {
        String newConexoes;
        System.out.print("-> Insira as novas conexões: ");
        newConexoes = sc.nextLine();
        for (Produto produto : lista) {
            if (produto.getID() == id) {
                ProdutosEletronicos produtoE = (ProdutosEletronicos) produto;
                produtoE.setConexoes(newConexoes);
                System.out.println("*** As conexões do produto foram atualizadas com sucesso! ***");
                visualizarProduto(lista, id);
            }
        }
    }

    public void editarTamanhoV(ArrayList<Produto> lista, byte id) {
        System.out.print("-> Insira o novo tamanho: ");
        String newTamanhoV = sc.nextLine();
        for (Produto produto : lista) {
            if (produto.getID() == id) {
                ProdutosVestuario produtoV = (ProdutosVestuario) produto;
                produtoV.setTamanho(newTamanhoV);
                System.out.println("*** O tamanho do produto foi atualizado com sucesso! ***");
                visualizarProduto(lista, id);
            }
        }
    }

    public void editarCor(ArrayList<Produto> lista, byte id) {
        System.out.print("-> Insira a nova cor: ");
        String newCor = sc.nextLine();
        for (Produto produto : lista) {
            if (produto.getID() == id) {
                ProdutosVestuario produtoV = (ProdutosVestuario) produto;
                produtoV.setCor(newCor);
                System.out.println("*** A cor do produto foi atualizado com sucesso! ***");
                visualizarProduto(lista, id);
            }
        }
    }

    public void editarMaterial(ArrayList<Produto> lista, byte id) {
        System.out.print("-> Insira o novo material: ");
        String newMaterial = sc.nextLine();
        for (Produto produto : lista) {
            if (produto.getID() == id) {
                ProdutosVestuario produtoV = (ProdutosVestuario) produto;
                produtoV.setMaterial(newMaterial);
                System.out.println("*** O material do produto foi atualizado com sucesso! ***");
                visualizarProduto(lista, id);
            }
        }
    }

    // Lógica para editar um produto alimenticio(cada atributo dele):
    public void editarProdutoAlimenticio(ArrayList<Produto> lista, byte id) {
        // boolean para indicar se existe ou não um produto no ID selecionado, com o
        // padrão false:
        boolean existe = true;
        for (Produto produto : lista) {
            // Se o id do produto for o id indicado pelo usuário, indicará os atributos do
            // produto e definirá o boolean para true:
            if (produto.getID() == id) {
                visualizarProduto(lista, id);
            } else {

            }
        }

        // Caso o produto exista, irá perguntar qual atributo o usuário deseja editar e,
        // dependendo da resposta, executará um dos switch case; caso não exista,
        // enviará a mensagem:
        byte escolha;
        if (existe) {
            do{
                System.out.println("\n1- Nome | 2- Marca | 3- Preço | 4- Quantidade | 5- Peso | 6- Data de validade | 0- VOLTAR AO MENU! ");
                System.out.print("-> Insira a opção a editar no produto: ");
                if (sc.hasNextByte()) {
                    escolha = sc.nextByte();
                    switch (escolha) {
                        // Definir novo nome:
                        case 1:
                            editarNome(lista, id);
                            break;
                        // Definir nova marca:
                        case 2:
                            editarMarca(lista, id);
                            break;
                        // Definir novo preço:
                        case 3:
                            editarPreco(lista, id);
                            break;
                        // Editar a quantidade - diminuir ou adicionar à quantidade atual de x produto:
                        case 4:
                            editarQuantidade(lista, id);
                            break;
                        // Definir novo peso:
                        case 5:
                            editarPeso(lista, id);
                            break;
                        // Definir nova data de validade:
                        case 6:
                            editarDataValidade(lista, id);
                            break;
                        case 0:
                            System.out.println("\n*** Voltando ao menu principal! ***");
                            sc.nextLine();
                            return;
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

    // Lógica para editar um produto eletrônico(cada atributo dele):
    public void editarProdutoEletronico(ArrayList<Produto> lista, byte id) {
        // boolean para indicar se existe ou não um produto no ID selecionado, com o
        // padrão false:
        boolean existe = false;
        for (Produto produto : lista) {
            // Se o id do produto for o id indicado pelo usuário, indicará os atributos do
            // produto e definirá o boolean para true:
            if (produto.getID() == id) {
                visualizarProduto(lista, id);
                existe = true;
            }
        }
        // Caso o produto exista, irá perguntar qual atributo o usuário deseja editar e,
        // dependendo da resposta, executará um dos switch case; caso não exista,
        // enviará a mensagem:
        byte escolha = 0;
        if (existe) {
            do{
                System.out.println("\n1- Nome | 2- Marca | 3- Preço | 4- Quantidade | 5- Modelo | 6-Tamanho | 7-Conexões | 0- VOLTAR AO MENU! ");
                System.out.print("-> Insira a opção a editar no produto: ");
                if (sc.hasNextByte()) {
                    escolha = sc.nextByte();
                    switch (escolha) {
                        case 1:
                            editarNome(lista, id);
                            break;
                        case 2:
                            editarMarca(lista, id);
                            break;
                        case 3:
                            editarPreco(lista, id);
                            break;
                        case 4:
                            editarQuantidade(lista, id);
                            break;
                        // Editar modelo:
                        case 5:
                            editarModelo(lista, id);
                            break;
                        // Editar tamanho do eletrônico:
                        case 6:
                            editarTamanhoE(lista, id);
                            break;
                        // Editar conexões:
                        case 7:
                            editarConexoes(lista, id);
                            break;
                        case 0:
                            System.out.println("\n*** Voltando ao menu principal! ***");
                            sc.nextLine();
                            return;
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

    // Lógica para editar um produto de vestuário(cada atributo dele):
    public void editarProdutoVestuario(ArrayList<Produto> lista, byte id) {
        // boolean para indicar se existe ou não um produto no ID selecionado, com o
        // padrão false:
        boolean existe = false;
        for (Produto produto : lista) {
            // Se o id do produto for o id indicado pelo usuário, indicará os atributos do
            // produto e definirá o boolean para true:
            if (produto.getID() == id) {
                visualizarProduto(lista, id);
                existe = true;
            }
        }
        // Caso o produto exista, irá perguntar qual atributo o usuário deseja editar e,
        // dependendo da resposta, executará um dos switch case; caso não exista,
        // enviará a mensagem:
        byte escolha = 0;
        if (existe) {
            do{
                System.out.println("\n1- Nome | 2- Marca | 3- Preço | 4- Quantidade | 5- Tamanho | 6-Cor | 7-Material | 0-VOLTAR AO MENU! ");
                System.out.print("-> Insira a opção a editar no produto: ");
                if (sc.hasNextByte()) {
                    escolha = sc.nextByte();
                    switch (escolha) {
                        case 1:
                            editarNome(lista, id);
                            break;
                        case 2:
                            editarMarca(lista, id);
                            break;
                        case 3:
                            editarPreco(lista, id);
                            break;
                        case 4:
                            editarQuantidade(lista, id);
                            break;
                        // Editar tamanho da roupa:
                        case 5:
                            editarTamanhoV(lista, id);
                            break;
                        // Editar cor:
                        case 6:
                            editarCor(lista, id);
                            break;
                        // Editar material:
                        case 7:
                            editarMaterial(lista, id);
                            break;
                        case 0:
                            System.out.println("\n*** Voltando ao menu principal! ***");
                            sc.nextLine();
                            return;
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
        ArrayList<Produto> listaProdutosTemp = new ArrayList<>(lista);
        for (Produto produto : listaProdutosTemp) {
            // Se o id do produto for o id indicado pelo usuário, definirá o boolean para
            // true, removerá o produto da ArrayList e removerá o seu id da ArrayList de
            // IDs:
            if (produto.getID() == id) {
                existe = true;
                System.out.print("Deseja mesmo remover o produto ID "+id+" - "+produto.getNome()+"? (s/n): ");
                String confirmacao = sc.nextLine();
                switch(confirmacao) {
                    case "s":
                    lista.remove(produto);
                    IDs.remove(IDs.indexOf(produto.getID()));
                    System.out.println("*** Produto removido! ***");
                    break;
                    case "n":
                    System.out.println("*** Produto não removido! ***");
                    return;
                    default:
                    System.out.println("\n*** Insira um valor correto (s/n) ***");
                }
            }
        }
        // Caso não exista, enviará uma mensagem indicando, caso contrário, enviará a
        // mensagem que o produto foi removido:
        if (!existe) {
            System.out.println("\n*** Não há nenhum produto com esse ID! ***");
        }
        listaProdutosTemp.clear();
    }

    // Lógica para listar apenas os produtos com x categoria, filtro:
    public void filtrarCategoria(ArrayList<Produto> lista) {
        // Quantidade de produtos por categoria:
        int qntA = 0; int qntE = 0; int qntV = 0;
        for(Produto produto:lista) {
            if(produto.getCategoria()==Categorias.ALIMENTOS) {
                qntA++;
            } else if(produto.getCategoria()==Categorias.ELETRONICOS) {
                qntE++;
            } else if(produto.getCategoria()==Categorias.VESTUARIO) {
                qntV++;
            }
        }
        // Enviar categorias:
        byte catFiltro = 0;
        do {
            System.out.println("\n-----<<<|CATEGORIAS|>>>----- \n1-ALIMENTOS ["+qntA+"] \n2-ELETRÔNICOS ["+qntE+"] \n3-VESTUÁRIO ["+qntV+"]\n");
            System.out.print("-> Insira a categoria a visualizar: ");
            if(sc.hasNextByte()) {
                catFiltro = sc.nextByte();
                if (catFiltro>3 || catFiltro<1) {
                    System.out.println("\n*** Insira um valor válido! ***");
                }
                sc.nextLine();
            } else {
                System.out.println("\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***");
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
        // boolean para indicar se existe ou não um produto no ID selecionado, com o
        // padrão false:
        boolean possui = false;
        // Ordenar a lista com Comparator e stream.collectors:
        List<Produto> listaOrdenadaFiltro = lista.stream().sorted(Comparator.comparingInt(Produto::getID)).collect(Collectors.toList());
        System.out.print("\n-----<<<|"+categoriafiltro+"|>>>----- \n");
        for (Produto produtoOrd : listaOrdenadaFiltro) {
            if(produtoOrd.getCategoria()==categoriafiltro) {
                    // Se a categoria do produto for a mesma selecionada, irá definir o boolean
                   // possui para true e enviá-la:
                   if (produtoOrd.getCategoria() == categoriafiltro) {
                       System.out.print("\nID: " + produtoOrd.getID() + " ||Nome: " + produtoOrd.getNome() + "\n");
                       possui = true;
                   } else {
                       continue;
                   }
            }
        }
        // Caso não possua, irá enviar a mensagem, indicando que não há produtos em dada
        // categoria:
        if (!possui) {
            System.out.println("\n*** Não há produtos nesta categoria! ***");
        }
    }
}