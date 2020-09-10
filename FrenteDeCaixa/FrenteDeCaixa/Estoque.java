import java.util.ArrayList;

public class Estoque {
    private ArrayList<ItemDeEstoque> itens = new ArrayList<ItemDeEstoque>();

    public Estoque(){
        this.itens = new ArrayList<ItemDeEstoque>();
    }
    public void cadastraProduto(Produto produto,int quantidadeInicial){
        ItemDeEstoque item = new ItemDeEstoque(produto, quantidadeInicial);
        this.itens.add(item);
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
