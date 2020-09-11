import java.util.ArrayList;

public class Estoque {
    private ArrayList<ItemDeEstoque> itens = new ArrayList<ItemDeEstoque>();

    public Estoque(){
        this.itens = new ArrayList<ItemDeEstoque>();
    }
    public void cadastraProduto(Produto produto,int quantidadeInicial){
        // caso seja passado um código de produto errado ao getProdutos() do catalogo ou quantidade inicial inválida.
        if (produto != null && quantidadeInicial >= 0){
            ItemDeEstoque item = new ItemDeEstoque(produto, quantidadeInicial);
            this.itens.add(item);
            System.out.println(quantidadeInicial +" "+ produto.getDescricao() + "'s adicionados ao estoque");
        }
    }

    public Produto getProduto(int codigo){
        for(ItemDeEstoque item: itens){
            if(item.getProduto().getCodigo() == codigo){
                return item.getProduto();
            }
        }
        return null;
    }

    public int getQuantidade(int codigo){
        for(ItemDeEstoque item: itens){
            if(item.getProduto().getCodigo() == codigo){
                return item.getQuantidade();
            }
        }
        return -1;
    }

    public boolean baixaEstoque(int codigo,int quantidade){
        for(ItemDeEstoque item: itens){
            if(item.getProduto().getCodigo() == codigo){
                item.baixaEstoque(quantidade);
                return true;
            }
        }
        return false;
    }

    public boolean reposicaoEstoque(int codigo,int quantidade){
        for(ItemDeEstoque item: itens){
            if(item.getProduto().getCodigo() == codigo){
                item.reposicaoEstoque(quantidade);
                return true;
            }
        }
        return false;
    }
}
