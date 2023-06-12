package projeto.entidades;

import java.util.ArrayList;

// Classe filha da classe Produto, com os atributos tamanho, cor e material:
public class ProdutosVestuario extends Produto {
    private String tamanhoV;
    private String cor;
    private String material;

    public ProdutosVestuario() {

    }

    // Atribuindo atributos ao produto:
    public ProdutosVestuario(String nome, String marca, Categorias categoria, double preco, int qnt, int id, String tamanhoV, String cor, String material) {
        super(nome, marca, categoria, preco, qnt, id);
        this.tamanhoV = tamanhoV;
        this.cor = cor;
        this.material = material;
    }

    // Getters:
    public String getTamanhoV() {
        return tamanhoV;
    }
    public String getCor() {
        return cor;
    }
    public String getMaterial() {
        return material;
    }

    // Setters:
    public void setTamanho(String tamanhoV) {
        this.tamanhoV = tamanhoV;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public void setMaterial(String material) {
        this.material = material;
    }

    // Método para cadastrar produtos do tipo vestuário
    public void cadastrarProdutoVestuario(ArrayList<Produto> lista) {
        ProdutosVestuario produto = new ProdutosVestuario();
        // Cadastro geral classe mãe:
        cadastro(produto, Categorias.VESTUARIO);

        // Cadastrar tamanho:
        do {
            System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira o tamanho do produto"+ Cores.RESET + ": ");
            String tamanho = sc.nextLine();
            produto.setTamanho(tamanho);
            break;
        } while (true);

        // Cadastrar cor:
        do {
            System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira a cor do produto"+ Cores.RESET + ": ");
            String cor = sc.nextLine();
            produto.setCor(cor);
            break;
        } while (true);

        // Cadastrar material:
        do {
            System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira o material do produto"+ Cores.RESET + ": ");
            String material = sc.nextLine();
            produto.setMaterial(material);
            break;
        } while (true);

         System.out.println("\n>>> " + Cores.VERDE + "Produto cadastrado com sucesso!"+ Cores.RESET + " <<<");

        // Adicionar produto à lista:
        lista.add(produto);
    }

    // Método para editar tamanho do vestuário no cadastro
    public void editarTamanhoV(ArrayList<Produto> lista, byte id) {
        System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira o novo tamanho" + Cores.RESET + ": ");
        String newTamanhoV = sc.nextLine();
        for (Produto produto : lista) {
            if (produto.getID() == id) {
                ProdutosVestuario produtoV = (ProdutosVestuario) produto;
                produtoV.setTamanho(newTamanhoV);
                System.out.println(Cores.VERDE + "*** O tamanho do produto foi atualizado com sucesso! ***" + Cores.RESET);
                visualizarProduto(lista, id);
            }
        }
    }

    // Método para editar cor do vestuário no cadastro
    public void editarCor(ArrayList<Produto> lista, byte id) {
        System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira a nova cor" + Cores.RESET + ": ");
        String newCor = sc.nextLine();
        for (Produto produto : lista) {
            if (produto.getID() == id) {
                ProdutosVestuario produtoV = (ProdutosVestuario) produto;
                produtoV.setCor(newCor);
                System.out.println(Cores.VERDE + "*** A cor do produto foi atualizado com sucesso! ***" + Cores.RESET);
                visualizarProduto(lista, id);
            }
        }
    }

    // Método para editar o tipo de material do vestuário no cadastro
    public void editarMaterial(ArrayList<Produto> lista, byte id) {
        System.out.print("\n>>> " + Cores.AMARELO + Cores.AMARELO_SUBLINHADO + "Insira o novo material" + Cores.RESET + ": ");
        String newMaterial = sc.nextLine();
        for (Produto produto : lista) {
            if (produto.getID() == id) {
                ProdutosVestuario produtoV = (ProdutosVestuario) produto;
                produtoV.setMaterial(newMaterial);
                System.out.println(Cores.VERDE + "*** O material do produto foi atualizado com sucesso! ***" + Cores.RESET);
                visualizarProduto(lista, id);
            }
        }
    }

    // Método para acessar as propriedades de edição do cadastro do vestuário
    public void editarProdutoVestuario(ArrayList<Produto> lista, byte id) {
        // boolean para indicar se existe ou não um produto no ID selecionado, com o padrão false:
        boolean existe = false;
        for (Produto produto : lista) {
            // Se o id do produto for o id indicado pelo usuário, indicará os atributos do produto e definirá o boolean para true:
            if (produto.getID() == id) {
                visualizarProduto(lista, id);
                existe = true;
                break;
            }
        }
        // Caso o produto exista, irá perguntar qual atributo o usuário deseja editar e, dependendo da resposta, executará um dos switch case; caso não exista, enviará a mensagem:
        byte escolha = 0;
        if (existe) {
            do {
                System.out.println("\n1- Nome | 2- Marca | 3- Preço | 4- Quantidade | 5- Tamanho | 6-Cor | 7-Material | 0-VOLTAR AO MENU! ");
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
