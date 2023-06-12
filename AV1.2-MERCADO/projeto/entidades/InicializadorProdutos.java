package projeto.entidades;

import java.util.ArrayList;

// Inicialização dos produtos pré-definidos:
public class InicializadorProdutos {
        public static void inicializarProdutos(ArrayList<Produto> listaProdutos) {
                ProdutosAlimenticios a1 = new ProdutosAlimenticios("Feijão Carioca", "Camil", Categorias.ALIMENTOS,9.90, 542,0, "1kg", "05/10/2025");
                listaProdutos.add(a1);

                ProdutosAlimenticios a2 = new ProdutosAlimenticios("Molho de Tomate", "Quero", Categorias.ALIMENTOS,1.79, 97,1, "300g", "10/10/2023");
                listaProdutos.add(a2);

                ProdutosAlimenticios a3 = new ProdutosAlimenticios("Salgadinho Cheetos Onda", "Elma Chips",Categorias.ALIMENTOS, 9.99, 97, 2, "140g", "07/08/2024");
                listaProdutos.add(a3);

                ProdutosEletronicos e1 = new ProdutosEletronicos("Smartphone", "Samsung", Categorias.ELETRONICOS,1999.99, 50,3, "Galaxy S21", "6.2 polegadas", "Wi-Fi, Bluetooth, NFC");
                listaProdutos.add(e1);

                ProdutosEletronicos e2 = new ProdutosEletronicos("Televisão", "LG", Categorias.ELETRONICOS, 3499.90, 30,4, "OLED55C1", "55 polegadas", "Wi-Fi, Bluetooth, HDMI");
                listaProdutos.add(e2);

                ProdutosVestuario v1 = new ProdutosVestuario("Camiseta", "Nike", Categorias.VESTUARIO, 99.90, 200,5, "M", "Branca", "Algodão");
                listaProdutos.add(v1);

                ProdutosVestuario v2 = new ProdutosVestuario("Calça Jeans", "Zara", Categorias.VESTUARIO, 200, 150,6, "40", "Azul", "Jeans");
                listaProdutos.add(v2);

                ProdutosVestuario v3 = new ProdutosVestuario("Óculos RB 3025 Aviador", "Ray Ban", Categorias.VESTUARIO,200,150, 7, "PADRÃO", "Verde G-15", "Alumínio");
                listaProdutos.add(v3);
        }
}
