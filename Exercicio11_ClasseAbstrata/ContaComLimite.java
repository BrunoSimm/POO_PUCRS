public class ContaComLimite extends ContaBancaria{
    private double limite;
    private double juros;
    private final double TAXA_JUROS = 0.05;

    public ContaComLimite(int nroConta, String nomeCorrentista, double saldo, double limite) {
        super(nroConta, nomeCorrentista, saldo);
        this.limite = limite;
    }

    @Override
    public boolean deposito(double valor) {
        if (valor > 0) {
            this.saldo = this.saldo + valor;
            return true;
        } else {
            System.out.println("Valor depositado deve ser maior que 0.");
            return false;
        }
    }

    @Override
    public boolean retirada(double valor){
        if (valor > (this.saldo + this.limite)){//Saldo insuficiente e valor requisitado maior que o limite
            System.out.println("Valor requisitado maior que o saldo e limite disponível.");
            return false;
        }else {//Saldo insuficiente mas valor requisitado dentro do limite
            if ((valor > this.saldo) && (valor <= this.saldo + (this.limite - this.juros))){
                this.juros = this.juros + (valor * TAXA_JUROS);
                this.limite = this.limite - valor;
                this.saldo = this.saldo - valor;
                return true;
            } else if ((valor > this.saldo) && (valor >= this.saldo + (this.limite - this.juros))) { //Valor maior que limite disponível.
                System.out.println("Valor requisitado maior que o saldo e limite disponível.");
                return false;
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
