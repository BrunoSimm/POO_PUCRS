public class Eletrodomesticos extends Produto {
    private boolean aceita220;

    public Eletrodomesticos(int codigo, String descricao, double preco, boolean aceita220) {
        super(codigo, descricao, preco);
        this.aceita220 = aceita220;
    }

    public boolean getVoltagem220(){
        return aceita220;
    }
    public void setVoltagem220(boolean novaVoltagem){
        this.aceita220 = novaVoltagem;
    }

    @Override
    public String toString() {
        return "["+this.getClass().getName()+" Codigo: " + this.getCodigo() + ", Descricao: " + this.getDescricao() +", Voltagem: "+ (this.getVoltagem220() == true ? "220v":"110v")+", Preço de Venda: R$ " + this.calculaPrecoConsumidor() + "]";
    }


}
