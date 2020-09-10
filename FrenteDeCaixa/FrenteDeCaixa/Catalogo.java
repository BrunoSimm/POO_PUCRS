import java.util.ArrayList;

public class Catalogo {
    ArrayList<Produto> produtos;

    public Catalogo() {
        produtos = new ArrayList<Produto>();
    }

    public Produto getProdutos(int codigo) {
        return produtos;
    }

    public void cadastroProduto (Produto produto){
        produtos.add(produto);
    }

    
    
}
