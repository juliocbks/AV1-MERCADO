package projeto.entidades;

public class ProdutosAlimenticios extends Produto {
    private double peso;
    private String dataValidade;

    public ProdutosAlimenticios() {

    }

    public ProdutosAlimenticios(String nome, String marca, Categorias categoria, double preco, int qnt, int id, double peso, String dataValidade) {
        super(nome, marca, categoria, preco, qnt, id);
        this.peso = peso;
        this.dataValidade = dataValidade;
    }

    public double getPeso() {
        return peso;
    }
    public String getDataValidade() {
        return dataValidade;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }
}