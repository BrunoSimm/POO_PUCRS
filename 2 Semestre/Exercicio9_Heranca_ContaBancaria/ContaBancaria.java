public class ContaBancaria {
    private int nroConta;
    private String nomeCorrentista;
    protected double saldo;

    public ContaBancaria(int nroConta, String nomeCorrentista, double saldo) {
        this.nroConta = nroConta;
        this.nomeCorrentista = nomeCorrentista;
        this.saldo = saldo;
    }

    public int getNroConta() {
        return nroConta;
    }

    public String getnomeCorrentista() {
        return nomeCorrentista;
    } 

    public double getSaldo() {
        return saldo;
    }

    public boolean deposito(double valor){
        if (valor > 0){
            this.saldo = this.saldo + valor;
            return true;
        } else {
            System.out.println("Valor depositado deve ser maior que 0.");
            return false;
        }
    }

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