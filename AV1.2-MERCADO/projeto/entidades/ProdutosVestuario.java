package projeto.entidades;

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
}
