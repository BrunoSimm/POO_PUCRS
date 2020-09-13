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
        System.out.println("----------VENDA"+this.numero+"----------");
        System.out.println("Itens - Quantidade - Preço");
        for(ItemDeVenda item: itens){
                System.out.println(item.getProduto().getDescricao()+ "\t "+ item.getQuantidade()+" \t\t\t"+item.getPrecoDeVenda());
        }
        System.out.println("--------------------------");

    }
    
    public boolean insereItem(Produto produto, int quantidade, Estoque estoque) {
        if (estoque.getQuantidade(produto.getCodigo()) >= quantidade){
            this.itens.add(new ItemDeVenda(produto, quantidade, produto.getPreco()));
            System.out.println(quantidade +" "+ produto.getDescricao() + "'s adicionados a Venda '"+this.numero+"'.");
            return true;
        } else {
            System.out.println("Erro! Quantidade requerida de " +produto.getDescricao() +" MAIOR que disponível em estoque("+estoque.getQuantidade(produto.getCodigo())+").");
            return false;
        }
    }

    public double getIMPOSTO() {
        return IMPOSTO;
    }

    public void imprimeRecibo(){
        System.out.println("**********RECIBO**********");
        this.getItens();
        System.out.printf("SUBTOTAL: R$ %.2f\n", this.getSubTotal());
        System.out.println("IMPOSTOS: "+ this.getIMPOSTO()*100 +"%");
        System.out.printf("TOTAL: R$ %.2f\n",this.getTotal());
        System.out.println("**************************\n");
    }
    public boolean concluirVenda(HistoricoVendas historico, Estoque estoque, Venda venda){
        System.out.println("\nEfetuando venda:");
        for (ItemDeVenda item: itens){
            estoque.baixaEstoque(item.getProduto().getCodigo(), item.getQuantidade());
        }
        historico.cadastrarVenda(venda);//Passa a própria venda para o histórico.
        System.out.println("Venda '"+this.numero+"' concluida com sucesso!");
        System.out.printf("Total da venda (com impostos): R$ %.2f\n",this.getTotal());
        return true;
    }
    public int getQtdItens(){
        return this.itens.size();
    }
    public double getSubTotal(){
        double subtotal = 0;
        for(ItemDeVenda item: itens){
            subtotal = subtotal + (item.getPrecoDeVenda() * item.getQuantidade());
        }
        return subtotal;
    }
    public double getDesconto(){
        return 0;
    }
    public double getTotal(){
        double total = 0;
        for(ItemDeVenda item: itens){
            total = total + (item.getPrecoDeVenda() * item.getQuantidade());
        }
        return total*(1 + this.IMPOSTO);
    }
    public boolean removeItem(Produto produto){
        for(ItemDeVenda item: itens){
            if (item.getProduto().getCodigo() == produto.getCodigo()){
                itens.remove(item);
                System.out.println(item.getQuantidade()+" "+item.getProduto().getDescricao()+"'s removido da venda.");
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Venda [IMPOSTO=" + IMPOSTO + ", itens=" + itens + ", numero=" + numero + "]";
    }
    
}
