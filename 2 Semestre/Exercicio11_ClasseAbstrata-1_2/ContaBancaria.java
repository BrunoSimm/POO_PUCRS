public abstract class ContaBancaria {
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

    public abstract boolean deposito(double valor);

    public abstract boolean retirada(double valor);
    
    
}