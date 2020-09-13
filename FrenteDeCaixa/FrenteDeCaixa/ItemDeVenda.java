public class ItemDeVenda {
    private Produto produto;
    private int quantidade;
    private double precoDeVenda;

    public ItemDeVenda(Produto produto, int quantidade, double precoDeVenda) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoDeVenda = precoDeVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoDeVenda() {
        return this.precoDeVenda;
    }

    @Override
    public String toString() {
        return "ItemDeVenda [precoDeVenda=" + precoDeVenda + ", produto=" + produto.getDescricao() + ", quantidade=" + quantidade
                + "]";
    }
    
}
