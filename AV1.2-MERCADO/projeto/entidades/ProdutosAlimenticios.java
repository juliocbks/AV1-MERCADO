package projeto.entidades;

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
}
