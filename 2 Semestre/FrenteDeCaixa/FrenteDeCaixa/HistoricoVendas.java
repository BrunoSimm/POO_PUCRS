import java.util.ArrayList;

public class HistoricoVendas {
    private ArrayList <Venda> vendas = new ArrayList <Venda>();

    public HistoricoVendas() {
        this.vendas = new ArrayList<Venda>();
    }
    
    public int getNroVendas() {
        return vendas.size();
    }
    public boolean cadastrarVenda(Venda venda){
        if (venda.getQtdItens() > 0){
            vendas.add(venda);
            return true;
        }
        return false;
    }
    public Venda getVenda(int numero){
        for (Venda item: vendas){
            if (item.getNumero() == numero){
                return item;
            }
        }
        return null;
    }

    public ArrayList<Venda> getVendas(){
        return vendas;
    }

    public void getUltimasVendas(int quantidade){
        if (quantidade <= vendas.size()){
            System.out.println("\n********HISTÓRICO********");
            for (int i = (vendas.size() - (quantidade)); i < vendas.size(); i++){
                vendas.get(i).imprimeRecibo();
            }
        } else System.out.println("\nErro! Quantidade requisitada superior ao numero de registros de vendas.");
    }
}
