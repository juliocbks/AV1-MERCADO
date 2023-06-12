package projeto.entidades;

import java.util.ArrayList;

// Classe filha da classe Produto, com os atributos modelo, tamanho e conexões:
public class ProdutosEletronicos extends Produto {
    private String modelo;
    private String tamanhoE;
    private String conexoes;

    public ProdutosEletronicos() {

    }

    // Atribuindo atributos ao produto:
    public ProdutosEletronicos(String nome, String marca, Categorias categoria, double preco, int qnt, int id, String modelo, String tamanhoE, String conexoes) {
        super(nome, marca, categoria, preco, qnt, id);
        this.modelo = modelo;
        this.tamanhoE = tamanhoE;
        this.conexoes = conexoes;
    }

    // Getters:
    public String getModelo() {
        return modelo;
    }
    public String getTamanhoE() {
        return tamanhoE;
    }
    public String getConexoes() {
        return conexoes;
    }

    // Setters:
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setTamanho(String tamanhoE) {
        this.tamanhoE = tamanhoE;
    }
    public void setConexoes(String conexoes) {
        this.conexoes = conexoes;
    }

    // Método para cadastrar produto do tipo eletrônicos
    public void cadastrarProdutoEletronico(ArrayList<Produto> lista) {
        double altura = 0, largura = 0, profundidade = 0;
        ProdutosEletronicos produto = new ProdutosEletronicos();
        // Cadastro geral classe mãe:
        cadastro(produto, Categorias.ELETRONICOS);

        // Cadastrar modelo:
        do {
            System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira o modelo do produto"+ Cores.RESET + ": ");
            String modelo = sc.nextLine();
            produto.setModelo(modelo);
            break;
        } while (true);

        // Cadastrar tamanho:
        System.out.print("\n>>> Insira as medidas do produto <<<\n");

        do{
            System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira a altura em cm do produto"+ Cores.RESET + ": ");
            if(sc.hasNextDouble()){
                altura = sc.nextDouble();
                sc.nextLine();
                break;
            } else {
                System.out.println(Cores.VERMELHO+ "\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***"+ Cores.RESET);
                sc.next();
            }
        } while(true);

        do{
            System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira a largura em cm do produto"+ Cores.RESET + ": ");
            if(sc.hasNextDouble()){
                largura = sc.nextDouble();
                sc.nextLine();
                break;
            } else {
                System.out.println(Cores.VERMELHO+ "\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***"+ Cores.RESET);
                sc.next();
            }
        } while(true);

        do{
            System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira a profundidade em cm do produto"+ Cores.RESET + ": ");
            if(sc.hasNextDouble()){
                profundidade = sc.nextDouble();
                sc.nextLine();
                break;
            } else {
                System.out.println(Cores.VERMELHO+ "\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***"+ Cores.RESET);
                sc.next();
            }
        } while(true);
            
        produto.setTamanho( "A: " + altura + "cm | L: " +largura +"cm | P: " + profundidade +"cm");

        // Cadastrar conexões:
            System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira as conexões do produto"+ Cores.RESET + ": ");
            String conexoes = sc.nextLine();
            produto.setConexoes(conexoes);

         System.out.println("\n>>> " + Cores.VERDE + "Produto cadastrado com sucesso!"+ Cores.RESET + " <<<");

        // Adicionar produto à lista:
        lista.add(produto);
    }

    // Método para editar o modelo no cadastro do eletrônico
    public void editarModelo(ArrayList<Produto> lista, byte id) {
        System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira o novo modelo" + Cores.RESET + ": ");
        String newModelo = sc.nextLine();
        for (Produto produto : lista) {
            if (produto.getID() == id) {
                ProdutosEletronicos produtoE = (ProdutosEletronicos) produto;
                produtoE.setModelo(newModelo);
            }
        }
        System.out.println(Cores.VERDE + "*** O modelo do produto foi atualizado com sucesso! ***" + Cores.RESET);
        visualizarProduto(lista, id);
    }

    // Método para editar o tamanho no cadastro do eletrônico
    public void editarTamanhoE(ArrayList<Produto> lista, byte id) {
        double altura = 0, largura = 0, profundidade = 0;
        for (Produto produto : lista) {
            if (produto.getID() == id) {
                ProdutosEletronicos produtoE = (ProdutosEletronicos) produto;
                System.out.print("\n>>> Insira as novas medidas do produto <<<\n");

                do{
                    System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira a altura em cm do produto"+ Cores.RESET + ": ");
                    if(sc.hasNextDouble()){
                        altura = sc.nextDouble();
                        sc.nextLine();
                        break;
                    } else {
                        System.out.println(Cores.VERMELHO+ "\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***"+ Cores.RESET);
                        sc.next();
                    }
                } while(true);

                do{
                    System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira a largura em cm do produto"+ Cores.RESET + ": ");
                    if(sc.hasNextDouble()){
                        largura = sc.nextDouble();
                        sc.nextLine();
                        break;
                    } else {
                        System.out.println(Cores.VERMELHO+ "\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***"+ Cores.RESET);
                        sc.next();
                    }
                } while(true);

                do{
                    System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira a profundidade em cm do produto"+ Cores.RESET + ": ");
                    if(sc.hasNextDouble()){
                        profundidade = sc.nextDouble();
                        sc.nextLine();
                        break;
                    } else {
                        System.out.println(Cores.VERMELHO+ "\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***"+ Cores.RESET);
                        sc.next();
                    }
                } while(true);
                    
                produtoE.setTamanho("A: " + altura + "cm | L: " + largura +"cm | P: " + profundidade +"cm");
                visualizarProduto(lista, id);
            }
        }
    }

    // Método para editar os tipos de conexões no cadastro do eletrônico
    public void editarConexoes(ArrayList<Produto> lista, byte id) {
        String newConexoes;
        System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira as novas conexões" + Cores.RESET + ": ");
        newConexoes = sc.nextLine();
        for (Produto produto : lista) {
            if (produto.getID() == id) {
                ProdutosEletronicos produtoE = (ProdutosEletronicos) produto;
                produtoE.setConexoes(newConexoes);
                System.out.println(Cores.VERDE + "*** As conexões do produto foram atualizadas com sucesso! ***" + Cores.RESET);
                visualizarProduto(lista, id);
            }
        }
    }

    // Método para acessar as propriedades de edição do cadastro do eletrônico
    public void editarProdutoEletronico(ArrayList<Produto> lista, byte id) {
        // boolean para indicar se existe ou não um produto no ID selecionado, com o padrão false:
        boolean existe = false;
        for (Produto produto : lista) {
            // Se o id do produto for o id indicado pelo usuário, indicará os atributos do produto e definirá o boolean para true:
            if (produto.getID() == id) {
                visualizarProduto(lista, id);
                existe = true;
            }
        }
        // Caso o produto exista, irá perguntar qual atributo o usuário deseja editar e, dependendo da resposta, executará um dos switch case; caso não exista, enviará a mensagem:
        byte escolha = 0;
        if (existe) {
            do {
                System.out.println("\n1- Nome | 2- Marca | 3- Preço | 4- Quantidade | 5- Modelo | 6-Tamanho | 7-Conexões | 0- VOLTAR AO MENU! ");
                System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO+ "Insira a opção a editar no produto" + Cores.RESET + ": ");
                if (sc.hasNextByte()) {
                    escolha = sc.nextByte();
                    sc.nextLine();
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
                            // Voltar ao menu principal:
                            System.out.println(Cores.VERMELHO + "\n*** Voltando ao menu principal! ***" + Cores.RESET);
                            return;
                        default:
                            System.out.println(Cores.VERMELHO + "\n*** Insira um valor dentro dos parâmetros! ***" + Cores.RESET);
                    }
                } else {
                    System.out.println(Cores.VERMELHO+ "\n*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***"+ Cores.RESET);
                    sc.next();
                }
            } while (true);
        } else {
            // Caso digite um id incorreto de produto:
            System.out.println(Cores.VERMELHO + "\n*** Não há nenhum produto com esse ID! ***" + Cores.RESET);
        }
    }
}
