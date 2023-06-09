package projeto.entidades;

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
}
