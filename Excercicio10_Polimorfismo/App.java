import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Produto p1 = new Eletrodomesticos(1, "Geladeira", 1800, true);
        Produto p2 = new EletrosPesados(2, "Maquina de Lavar Roupa(?)", 2500);
        Produto p3 = new ProdutosTelefonia(3, "iPhone super valorizado", 3900, true);


        ArrayList<Produto> produtos = new ArrayList<Produto>();

        produtos.add(p1);
        produtos.add(p2);
        produtos.add(p3);


        for (Produto produto: produtos){
            System.out.println(produto);
        }
    }
}
