package projeto.entidades;

import java.util.ArrayList;

// Inicialização dos produtos pré-definidos:
public class InicializadorProdutos {
    public static void inicializarProdutos(ArrayList<Produto> listaProdutos) {
    ProdutosAlimenticios a1 = new ProdutosAlimenticios("Feijão Carioca", "Camil", Categorias.ALIMENTOS, 9.90, 542, Produto.randomNum(), 1, "12 meses");
    listaProdutos.add(a1);

    ProdutosAlimenticios a2 = new ProdutosAlimenticios("Molho de Tomate", "Quero", Categorias.ALIMENTOS, 1.79, 97, Produto.randomNum(), 0.3, "9 meses");
    listaProdutos.add(a2);

     ProdutosAlimenticios a3 = new ProdutosAlimenticios("Salgadinho Cheetos Onda", "Elma Chips", Categorias.ALIMENTOS, 9.99, 97, Produto.randomNum(), 0.14, "10 meses");
    listaProdutos.add(a3);

    ProdutosEletronicos e1 = new ProdutosEletronicos("Smartphone", "Samsung", Categorias.ELETRONICOS, 1999.99, 50, Produto.randomNum(), "Galaxy S21", "6.2 polegadas", "Wi-Fi, Bluetooth, NFC");
    listaProdutos.add(e1);

    ProdutosEletronicos e2 = new ProdutosEletronicos("Televisão", "LG", Categorias.ELETRONICOS, 3499.90, 30, Produto.randomNum(), "OLED55C1", "55 polegadas", "Wi-Fi, Bluetooth, HDMI");
    listaProdutos.add(e2);

    ProdutosVestuario v1 = new ProdutosVestuario("Camiseta", "Nike", Categorias.VESTUARIO, 99.90, 200, Produto.randomNum(), "M", "Branca", "Algodão");
    listaProdutos.add(v1);

    ProdutosVestuario v2 = new ProdutosVestuario("Calça Jeans", "Zara", Categorias.VESTUARIO, 200, 150, Produto.randomNum(), "40", "Azul", "Jeans");
    listaProdutos.add(v2);

    ProdutosVestuario v3 = new ProdutosVestuario("Óculos RB 3025 Aviador", "Ray Ban", Categorias.VESTUARIO, 200, 150, Produto.randomNum(), "PADRÃO", "Verde G-15", "Alumínio");
    listaProdutos.add(v3);
    } 
}
