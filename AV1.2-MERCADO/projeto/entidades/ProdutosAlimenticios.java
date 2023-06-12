package projeto.entidades;

import java.text.ParseException; // Utilizado para formatação de data e evasão dos erros(exceptions);
import java.text.SimpleDateFormat; // Utilizado para formatar a entrada da data;
import java.util.ArrayList;
import java.util.Date; //import utilitário Data

// Classe filha da classe Produto, com os atributos peso e dataValidade:
public class ProdutosAlimenticios extends Produto {
    private String peso;
    private String dataValidade;

    public ProdutosAlimenticios() {

    }

    // Atribuindo atributos ao produto:
    public ProdutosAlimenticios(String nome, String marca, Categorias categoria, double preco, int qnt, int id,
            String peso,
            String dataValidade) {
        super(nome, marca, categoria, preco, qnt, id);
        this.peso = peso;
        this.dataValidade = dataValidade;
    }

    // Getters:
    public String getPeso() {
        return peso;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    // Setters:
    public void setPeso(String peso) {
        this.peso = peso;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    // Método para cadastrar produto do tipo alimentício
    public void cadastrarProdutoAlimenticio(ArrayList<Produto> lista) {
        ProdutosAlimenticios produto = new ProdutosAlimenticios();
        // Cadastro geral classe mãe:
        cadastro(produto, Categorias.ALIMENTOS);

        // Cadastrar peso:
        do {
            System.out.println("\n1- Grama(g) | 2- Mililitro(ml) | 3- Quilograma(kg) | 4- Litro(l) | 5- Tonelada(t)\n");
            System.out.print(">>> "+Cores.AMARELO+Cores.AMARELO_SUBLINHADO+"Escolha a unidade de medida desejada"+Cores.RESET+": ");
            if(sc.hasNextByte()) {
                byte UM = sc.nextByte();
                do {
                    System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira o volume de acordo com a medida selecionada" + Cores.RESET + ": ");
                    if (sc.hasNextDouble()) {
                        double pesoDouble = sc.nextDouble();
                        sc.nextLine();
                        switch(UM) {
                            case 1:
                            produto.setPeso(pesoDouble+"g");
                            break;
                            case 2:
                            produto.setPeso(pesoDouble+"ml");
                            break;
                            case 3:
                            produto.setPeso(pesoDouble+"kg");
                            break;
                            case 4:
                            produto.setPeso(pesoDouble+"l");
                            break;
                            case 5:
                            produto.setPeso(pesoDouble+"t");
                            break;
                        }
                        break;
                    } else {
                        System.out.println(Cores.VERMELHO+ "*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***"+ Cores.RESET);
                        sc.next();
                    }
                } while (true);
                break;
            } else {
                System.out.println(Cores.VERMELHO+ "*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***" + Cores.RESET);
                sc.nextLine();
            }
        } while (true);

        // Cadastrar data de validade:

        Date data = null;
        while (data == null) {
            String inputData = "00/00/0000";
            byte cont = 0;
            do {
                System.out.println("\n>>> " + Cores.AMARELO + "Informe a data de validade" + Cores.RESET + " <<<");
                System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Digite uma data (formato: dd/MM/yyyy)"+Cores.RESET+": ");
                inputData = sc.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    data = dateFormat.parse(inputData);
                    produto.setDataValidade(dateFormat.format(data));
                } catch (ParseException e) {
                    System.out.println("\n>>> " + Cores.VERMELHO + "*** Formato de data inválido! ***" + Cores.RESET + " <<<");
                    if (cont == 3) {
                        System.out.println("\n>>> " + Cores.VERMELHO + "Atenção ao formato da data!" + Cores.RESET + " <<<");
                        cont = 0;
                    }
                    cont++;
                }
            } while (inputData.length() != 10);
        }
        System.out.println("\n>>> " + Cores.VERDE + "Produto cadastrado com sucesso!"+ Cores.RESET + " <<<");

        // Adicionar produto à lista:
        lista.add(produto);
    }

    // Método para editar o peso no cadastro do produto alimentício
    public void editarPeso(ArrayList<Produto> lista, byte id) {
        do{
            System.out.println("\n1- Gramas(g) | 2- Mililitro(ml) | 3- Quilogramas(kg) | 4- Litro(l) | 5- Toneladas(t)\n");
            System.out.print(">>> "+Cores.AMARELO+Cores.AMARELO_SUBLINHADO+"Insira a unidade de medida utilizada"+Cores.RESET+": ");
            if(sc.hasNextByte()) {
                byte UM = sc.nextByte();
                sc.nextLine();
                if(UM>0 && UM<6){
                    do {
                        System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira o novo peso" + Cores.RESET + ": ");
                        if (sc.hasNextDouble()) {
                            double newPesoDouble = sc.nextDouble();
                            for (Produto produto : lista) {
                                if (produto.getID() == id) {
                                    ProdutosAlimenticios produtoA = (ProdutosAlimenticios) produto;
                                    String newPesoString = newPesoDouble+"";
                                    switch(UM) {
                                        case 1:
                                        produtoA.setPeso(newPesoString+"g");
                                        break;
                                        case 2:
                                        produtoA.setPeso(newPesoString+"ml");
                                        break;
                                        case 3:
                                        produtoA.setPeso(newPesoString+"kg");
                                        break;
                                        case 4:
                                        produtoA.setPeso(newPesoString+"l");
                                        break;
                                        case 5:
                                        produtoA.setPeso(newPesoString+"t");
                                        break;
                                        default:
                                        System.out.println(Cores.VERMELHO+"*** Insira um valor dentro dos parâmetros! ***"+Cores.RESET);
                                    }
                                    System.out.println(Cores.VERDE + "*** O peso do produto foi atualizado com sucesso! ***" + Cores.RESET);
                                    visualizarProduto(lista, id);
                                    break;
                                }
                            }
                        break;
                        } else {
                            System.out.println(Cores.VERMELHO+ "*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***"+ Cores.RESET);
                            sc.nextLine();
                        }
                    } while (true);
                    break;
                } else {
                    System.out.println(Cores.VERMELHO+"*** Insira um valor dentro dos parâmetros! ***"+Cores.RESET);
                }
            } else {
                System.out.println(Cores.VERMELHO+ "*** Valor informado é inválido, por favor, digite novamente um valor numérico válido! ***"+ Cores.RESET);
                sc.nextLine();
            }
        } while (true);
    }

    // Método para editar a data de validade no cadastro do produto alimentício
    public void editarDataValidade(ArrayList<Produto> lista, byte id) {
        Date data = null;
        while (data == null) {
            String inputData = "00/00/0000";
            byte cont = 0;
            do {
                System.out.println("\n>>> " + Cores.AMARELO + "Informe a data de validade" + Cores.RESET + " <<<");
                System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Digite uma data (formato: dd/MM/yyyy)" + ": "+ Cores.RESET);
                inputData = sc.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    data = dateFormat.parse(inputData);
                    for (Produto produto : lista) {
                        if (produto.getID() == id) {
                            ProdutosAlimenticios produtoA = (ProdutosAlimenticios) produto;
                            produtoA.setDataValidade(dateFormat.format(data));

                        }
                    }

                } catch (ParseException e) {
                    System.out.println("\n>>> " + Cores.VERMELHO + "Formato de data inválido!" + Cores.RESET + " <<<");
                    if (cont == 3) {
                        System.out.println("\n>>> " + Cores.VERMELHO + "Atenção ao formato da data!"+ Cores.RESET + " <<<");
                        cont = 0;
                    }
                    cont++;
                }
            } while (inputData.length() != 10);
        }
        System.out.println(Cores.VERDE + "*** A data de validade do produto foi atualizado com sucesso! ***" + Cores.RESET);
        visualizarProduto(lista, id);
    }

    // Método para acessar as propriedades de edição do cadastro do produto alimentício
    public void editarProdutoAlimenticio(ArrayList<Produto> lista, byte id) {
        // boolean para indicar se existe ou não um produto no ID selecionado, com o padrão false:
        boolean existe = false;
        for (Produto produto : lista) {
            // Se o id do produto for o id indicado pelo usuário, indicará os atributos do produto e definirá o boolean para true:
            if (produto.getID() == id) {
                visualizarProduto(lista, id);
                existe = true;
            } else { }
        }

        // Caso o produto exista, irá perguntar qual atributo o usuário deseja editar e, dependendo da resposta, executará um dos switch case; caso não exista, enviará a mensagem:
        byte escolha;
        if (existe) {
            do {
                System.out.println("\n1- Nome | 2- Marca | 3- Preço | 4- Quantidade | 5- Peso | 6- Data de validade | 0- VOLTAR AO MENU! ");
                System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO+ "Insira a opção a editar no produto" + Cores.RESET + ": ");
                if (sc.hasNextByte()) {
                    escolha = sc.nextByte();
                    sc.nextLine();
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
                        // Voltar ao menu principal:
                        case 0:
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
