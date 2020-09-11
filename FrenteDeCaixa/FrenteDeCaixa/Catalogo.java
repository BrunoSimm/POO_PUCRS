import java.util.ArrayList;

public class Catalogo {
    ArrayList<Produto> produtos;

    public Catalogo() {
        produtos = new ArrayList<Produto>();
    }

    public Produto getProduto(int codigo) {
        for (Produto item: produtos){
            if (item.getCodigo() == codigo){
                return item;
            }
        }
        return null;
    }

    public void getProdutos() {
        System.out.println("---------CATALOGO--------");
        System.out.println("Codigo | Produto | Preço");
        for (Produto item: produtos){
            System.out.println(item.getCodigo()+ "       "
            + item.getDescricao().subSequence(0, 9)+ "    "+item.getPreco());
        }
        System.out.println("-------------------------");
    }

    public void cadastroProduto (Produto produto){
        boolean produtoUnico = true;
        //Evitar adicionar dois produtos com o mesmo código.
        for (Produto item: produtos){
            if (item.getCodigo() == produto.getCodigo()){
                System.out.println("Já existe um produto neste catálogo com o código " + produto.getCodigo()+" !");
                produtoUnico = false;
                break;
            }
        }
        if (produtoUnico == true){
            produtos.add(produto);
        }
    }

    
    
}
