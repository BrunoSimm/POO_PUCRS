public class ContaComLimite extends ContaBancaria{
    private double limiteDeSaque;
    private double juros;
    private double taxaDeJuros;

    public ContaComLimite(int nroConta, String nomeCorrentista, double saldo, double limiteDeSaque, double taxaDeJuros) {
        super(nroConta, nomeCorrentista, saldo);
        this.limiteDeSaque = limiteDeSaque;
        this.taxaDeJuros = taxaDeJuros;
    }
    @Override
    public boolean retirada(double valor){
        if (valor > this.saldo){
            System.out.println("Valor requisitado maior que o saldo disponível.");
            return false;
        }else if(this.juros >= getSaldo()){
            System.out.println("Juros maior que saldo disponível, operação bloqueada.");
            return false; 
        }else {
            if (valor > limiteDeSaque){
                this.juros = this.juros + (valor * taxaDeJuros);
                this.saldo = this.saldo - valor;
                return true;
            } else {
                this.saldo = this.saldo - valor;
                return true;
            }
        }
    }

    public double getJuros(){
        return this.juros;
    }

    public boolean quitaJuros(){
        if (this.saldo >= this.juros){
            this.saldo = this.saldo - this.juros;
            this.juros = 0;
            return true;
        } else {
            System.out.println("Saldo em conta insuficiente para quitar juros.");
            return false;
        }
    }
}
