public class ContaRemunerada extends ContaBancaria {
    private final double percentRemuneracao = 0.02;

    public ContaRemunerada(int nroConta, String nomeCorrentista, double saldo) {
        super(nroConta, nomeCorrentista, saldo);
    }

    public double getPercentRemuneracao() {
        return percentRemuneracao * 100;
    }

    @Override
    public boolean deposito(double valor) {
        if (valor > 0) {
            this.saldo = (this.saldo + valor) + (percentRemuneracao * valor);//Remuneração de depósito
            return true;
        } else {
            System.out.println("Valor depositado deve ser maior que 0.");
            return false;
        }
    }
    @Override
    public boolean retirada(double valor){
        if (valor > this.saldo){
            System.out.println("Valor requisitado maior que o saldo disponível.");
            return false;
        } else {
            this.saldo = this.saldo - valor;
            return true;
        }
    }

}
