import java.util.ArrayList;

public class Venda {
    private int numero;
    private ArrayList<ItemDeVenda> itens = new ArrayList<ItemDeVenda>();
    private final double IMPOSTO = 0.25;
    

    public Venda(HistoricoVendas historico) {
        this.itens = new ArrayList<ItemDeVenda>();
        this.numero = historico.getNroVendas() + 1;
    }

    public int getNumero() {
        return this.numero;
    }

    public void getItens() {
        System.out.println("-------VENDA-------");
        System.out.println("Itens - Quantidade");
        for(ItemDeVenda item: itens){
                System.out.println(item.getProduto().getDescricao()+ " : "+ item.getQuantidade());
        }
        System.out.println("-------------------");

    }
    
//Precisa fazer validações
    public boolean insereItem(Produto produto, int quantidade, Estoque estoque) {
        if (estoque.getQuantidade(produto.getCodigo()) >= quantidade){
            this.itens.add(new ItemDeVenda(produto, quantidade, produto.getPreco()));
            System.out.println(quantidade +" "+ produto.getDescricao() + "'s adicionados a Venda");
            return true;
        } else {
            System.err.println("Erro! Quantidade requerida de " +produto.getDescricao() +" MAIOR que disponível em estoque("+estoque.getQuantidade(produto.getCodigo())+").");
            return false;
        }
    }

    public double getIMPOSTO() {
        return IMPOSTO;
    }

    public void imprimeRecibo(){

    }
    public boolean concluir(){
        return true;
    }
    public int getQtdItens(){
        return 1;
    }
    public double getSubTotal(){
        return 0;
    }
    public double getDesconto(){
        return 0;
    }
    public double getTotal(){
        return 1;
    }
    public boolean removeItem(ItemDeVenda produto){
        return true;
    }

    @Override
    public String toString() {
        return "Venda [IMPOSTO=" + IMPOSTO + ", itens=" + itens + ", numero=" + numero + "]";
    }
    
}
