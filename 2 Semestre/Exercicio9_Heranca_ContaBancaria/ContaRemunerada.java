public class ContaRemunerada extends ContaBancaria {
    private double percentRemuneracao;

    public ContaRemunerada(int nroConta, String nomeCorrentista, double saldo, double percentRemuneracao) {
        super(nroConta, nomeCorrentista, saldo);
        this.percentRemuneracao = percentRemuneracao;
    }

    public double getPercentRemuneracao() {
        return percentRemuneracao;
    }

    public void setPercentRemuneracao(double percentRemuneracao) {
        this.percentRemuneracao = percentRemuneracao;
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

}
