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
        for (Produto produto:lista) {
            System.out.print("\nID: "+produto.getID()+" ||Nome: "+produto.getNome()+"\n");
        }
    }

    // Lógica para visualizar um único produto com base no ID, loop for each
    public void visualizarProduto(ArrayList<Produto> lista, byte id) {
        // boolean para indicar se existe ou não um produto no ID selecionado, com o padrão false: 
        boolean existe = false;
        for (Produto produto:lista) {
            // Caso o id do produto seja o id inserido pelo usuário, irá listar o produto e definir que o produto existe:
            if (produto.getID() == id) {
            System.out.print("\n<<<|PRODUTO ID "+id+"|>>>"+"\nNome: "+produto.getNome()+"\nMarca: "+produto.getMarca()+"\nCategoria: "+ produto.getCategoria()+ "\nPreço: "+produto.getPreco()+ "\nQuantidade: "+produto.getQnt()+"\n");
            existe = true;
        }
    }
        // Caso não exista, irá exibir a mensagem:
        if (!existe) {
            System.out.println("***** Não há nenhum produto com esse ID! *****");
        }
    }

    // Lógica para cadastrar um novo produto:
    public void cadastrarProduto(ArrayList<Produto> lista) {
        Produto produto = new Produto();

        System.out.print("\nInsira o nome do produto: "); 
        String nome = sc.nextLine(); // Input/Entrada
        produto.setNome(nome); // Setar/Definir nome

        System.out.print("\nInsira a marca do produto: ");
        String marca = sc.nextLine();
        produto.setMarca(marca);
        
        // No caso da categoria, irá listar as categorias e, com um switch case do tipo integer, definir a categoria do produto, caso o número inserido não esteja no switch case, irá definir como OUTROS:
        System.out.println("\n-----<<<|CATEGORIAS|>>>----- \n1-BEBIDAS; \n2-CARNES; \n3-CEREAIS; \n4-FRIOS; \n5-HIGIENE; \n6-HORTIFRUTI; \n7-LIMPEZA; \n8-MERCEARIA; \n9-PADARIA; \n10-PETSHOP; \n11-OUTROS.");
        System.out.print("Insira a categoria do produto: ");
        int cat = sc.nextInt();
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
                produto.setCategoria(Categorias.OUTROS);
                System.out.println("Opção incorreta, produto inserido na categoria *OUTROS*!");
                break;
        }

        System.out.print("\nInsira o preço do produto: ");
        double preco = sc.nextDouble();
        produto.setPreco(preco);
        
        System.out.print("\nInsira a quantidade do produto: ");
        int qnt = sc.nextInt();
        produto.setQnt(qnt);
        
        // ID aleatório gerado automaticamente:
        produto.setID(randomNum());
        // Adicionar produto à lista:
        lista.add(produto);
        // Limpando buffer:
        sc.nextLine();
    }

    // Lógica para editar um produto(cada atributo dele):
    public void editarProduto(ArrayList<Produto> lista, byte id) {
        // boolean para indicar se existe ou não um produto no ID selecionado, com o padrão false: 
        boolean existe = false;
        for (Produto produto:lista) {
             // Se o id do produto for o id indicado pelo usuário, indicará os atributos do produto e definirá o boolean para true:
            if (produto.getID() == id) {
                System.out.print("\n<<<|PRODUTO ID "+id+"|>>>"+"\nNome: "+produto.getNome()+"\nMarca: "+produto.getMarca()+"\nCategoria: "+ produto.getCategoria()+ "\nPreço: "+produto.getPreco()+ "\nQuantidade: "+produto.getQnt()+"\n");
                existe = true;
            }    
        }
        // Caso o produto exista, irá perguntar qual atributo o usuário deseja editar e, dependendo da resposta, executará um dos switch case; caso não exista, enviará a mensagem:
        if (existe){
            System.out.println("\n1- Nome | 2- Marca | 3- Categoria | 4- Preço | 5- Quantidade");
            System.out.print("O que deseja editar no produto? ");
            int escolha = sc.nextInt();
            switch(escolha) {
                case 1:
                // Definir novo nome:
                System.out.print("Insira o novo nome: "); 
                sc.nextLine();
                String newNome = sc.nextLine();
                for (Produto produto:lista) {
                    if (produto.getID() == id) { 
                    produto.setNome(newNome); 
                    }
                }
                break;
                case 2:
                // Definir nova marca:
                System.out.print("Insira a nova marca: "); 
                sc.nextLine();
                String newMarca = sc.nextLine();
                for (Produto produto:lista) {
                    if (produto.getID() == id) { 
                    produto.setMarca(newMarca); 
                    }
                }
                break;
                case 3:
                    // Definir nova categoria:
                    for (Produto produto:lista) {
                        if (produto.getID() == id) { 
                            System.out.println("\n-----<<<|CATEGORIAS|>>>----- \n1-BEBIDAS; \n2-CARNES; \n3-CEREAIS; \n4-FRIOS; \n5-HIGIENE; \n6-HORTIFRUTI; \n7-LIMPEZA; \n8-MERCEARIA; \n9-PADARIA; \n10-PETSHOP; \n11-OUTROS.");
                            System.out.print("Insira a categoria do produto: "); byte newx3 = sc.nextByte();
                            switch(newx3) {
                                case 1:
                                produto.setCategoria(bebidas);
                                break;
                                case 2:
                                produto.setCategoria(carnes);
                                break;
                                case 3:
                                produto.setCategoria(cereais);
                                break;
                                case 4:
                                produto.setCategoria(frios);
                                break;
                                case 5:
                                produto.setCategoria(higiene);
                                break;
                                case 6:
                                produto.setCategoria(hortifruti);
                                break;
                                case 7:
                                produto.setCategoria(limpeza);
                                break;
                                case 8:
                                produto.setCategoria(mercearia);
                                break;
                                case 9:
                                produto.setCategoria(padaria);
                                break;
                                case 10:
                                produto.setCategoria(petshop);
                                break;
                                case 11:
                                produto.setCategoria(outros);
                                break;
                                default:
                                System.out.println("Opção não encontrada, categoria *OUTROS* aplicada!");
                                produto.setCategoria(outros);
                                break;
                            }
                        }
                    }
                break;
                case 4:
                // Definir novo preço:
                System.out.print("Insira o novo preço: ");
                double newPreco = sc.nextDouble();
                for (Produto produto:lista) {
                    if (produto.getID() == id) { 
                    produto.setPreco(newPreco); 
                    }
                }
                break;
                // Editar a quantidade - diminuir ou adicionar à quantidade atual de x produto:
                case 5:
                System.out.print("Digite 0 para diminuir e 1 para adicionar à quantidade: "); 
                byte newQnt = sc.nextByte();
                switch(newQnt) {
                    case 0:
                    System.out.print("Insira a quantidade a subtrair: ");
                    int qnts = sc.nextInt();
                    for (Produto produto:lista) {
                        // Subtrair da quantidade atual de produtos a quantidade inserida pelo usuário e exibir a nova quantidade total:
                        if (produto.getID() == id) { 
                        produto.setQnt(produto.getQnt()-qnts); 
                        System.out.println("Nova quantidade: "+produto.getQnt());
                        }
                    }
                    break;
                    case 1:
                    System.out.print("Insira a quantidade a adicionar: ");
                    int qnta = sc.nextInt();
                    for (Produto produto:lista) {
                        // Adicionar à quantidade atual de produtos a quantidade inserida pelo usuário e exibir a nova quantidade total:
                        if (produto.getID() == id) { 
                        produto.setQnt(produto.getQnt()+qnta);
                        System.out.println("Nova quantidade: "+produto.getQnt()); 
                        }
                    }
                    break;
                    default:
                    // Caso insira uma opção diferente:
                    System.out.println("Número incorreto!");
                    break;
                }
                break;
                default:
                // Caso insira uma opção fora das 5 opções de edição:
                System.out.println("Opção incorreta!");
            }
        } else {
            // Caso digite um id incorreto de produto:
            System.out.println("***** Não há nenhum produto com esse ID! *****");
        }
    }

    // Lógica para remover um produto com for each e remover o ID da lista de IDs, para que possa ser gerado novamente, foi necessária a criação de uma nova lista de objetos, para evitar que aconteça o erro de remoção dentro do loop:
    public void removerProduto(ArrayList<Produto> lista, byte id) {
        // boolean para indicar se existe ou não um produto no ID selecionado, com o padrão false:
        boolean existe = false;
        ArrayList<Produto> listaProdutos2 = new ArrayList<>(lista);
        for (Produto produto:listaProdutos2) {
            // Se o id do produto for o id indicado pelo usuário, definirá o boolean para true, removerá o produto da ArrayList e removerá o seu id da ArrayList de IDs:
            if (produto.getID() == id) {  
                existe = true;
                lista.remove(produto);
                IDs.remove(IDs.indexOf(produto.getID()));
            } 
        } 
        // Caso não exista, enviará uma mensagem indicando, caso contrário, enviará a mensagem que o produto foi removido:
        if (!existe) {
            System.out.println("***** Não há nenhum produto com esse ID! *****");
        } else {
            System.out.println("Produto removido!");
        }
        listaProdutos2.clear();
    } 

    // Lógica para listar apenas os produtos com x categoria, filtro:
    public void filtrarCategoria(ArrayList<Produto> lista) {
        // Enviar categorias:
        System.out.println("\n-----<<<|CATEGORIAS|>>>----- \n1-BEBIDAS; \n2-CARNES; \n3-CEREAIS; \n4-FRIOS; \n5-HIGIENE; \n6-HORTIFRUTI; \n7-LIMPEZA; \n8-MERCEARIA; \n9-PADARIA; \n10-PETSHOP; \n11-OUTROS.");
        System.out.print("Qual categoria de produtos desejas visualizar? ");
        byte catv = sc.nextByte(); 
        sc.nextLine();
        Categorias categoriafiltro = outros; 
        // Switch case para definir a categoria a ser filtrada,  a categoria padrão é OUTROS:
        switch(catv) {
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
            System.out.println("Opção não encontrada, listando produtos na categoria *OUTROS*!\n");
            break;
        }
        // boolean para indicar se existe ou não um produto no ID selecionado, com o padrão false:
        boolean possui = false;
        System.out.println("-----<<<|"+categoriafiltro+"|>>>-----");
        for (Produto produto:lista) {
            // Se a categoria do produto for a mesma selecionada, irá definir o boolean possui para true e enviá-la:
            if (produto.getCategoria() == categoriafiltro) {
                System.out.print("\nID: "+produto.getID()+" ||Nome: "+produto.getNome()+"\n");
                possui = true;
            } else {
                continue;
            }
        }
        // Caso não possua, irá enviar a mensagem, indicando que não há produtos em dada categoria:
        if (!possui) {
            System.out.println("\n***Não há produtos nesta categoria!***");
        }
    }
}