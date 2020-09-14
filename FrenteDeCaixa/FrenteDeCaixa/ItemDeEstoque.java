public class ItemDeEstoque {
    private Produto produto;
    private int quantidade;

    public ItemDeEstoque(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }
    
    public Produto getProduto() {
        return this.produto;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public boolean baixaEstoque(int quantidade){
        if (quantidade <= 0) {
            return false;
        } else if (this.quantidade < quantidade){
            return false;
        } else {
            this.quantidade = this.quantidade - quantidade;
            return true;
        }
    }

    public boolean reposicaoEstoque(int quantidade){
        if (quantidade <= 0) {
            return false;
        }else {
            this.quantidade = this.quantidade + quantidade;
            return true;
        }
    }

}
