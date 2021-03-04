import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Produto p1 = new Eletrodomesticos(1, "Torradeira", 279.99, true);
        Produto p2 = new Eletrodomesticos(2, "Microndas", 399, false);
        Produto p3 = new EletrosPesados(3, "Maquina de Lavar Roupa(?)", 2500);
        Produto p4 = new ProdutosTelefonia(4, "iPhone super valorizado", 3900, true);
        Produto p5 = new ProdutosTelefonia(5, "Quantum Sky", 11000, false);


        ArrayList<Produto> produtos = new ArrayList<Produto>();
        produtos.add(p1);
        produtos.add(p2);
        produtos.add(p3);
        produtos.add(p4);
        produtos.add(p5);

        for (Produto produto: produtos){
            System.out.println(produto);
        }
    }
}
