public class Passagem {
    private String cpf;
    private String nome;
    private String assento;
    private double custoPassagem;
    protected double custoTotal;

    public Passagem(String cpf, String nome, String assento, double custoPassagem) {
        this.cpf = cpf;
        this.nome = nome;
        this.assento = assento;
        this.custoPassagem = custoPassagem;
        this.custoTotal = custoPassagem;
    }

    public double custoBagagem(int qtd, int[] pesos){
        double custoBagagem = 0;
        if (qtd != pesos.length){
            //err
        } else{
            for(int item:pesos){
                custoBagagem = custoBagagem + (item * 0.5);
            }
        }
        custoTotal += custoBagagem;
        return custoBagagem;
    }

    public void defineAssento(String identificadorAssento){
        this.assento = identificadorAssento;
        this.custoTotal += 5.0;
    }

    public String toString() {
        return "Passagem [assento=" + assento + ", cpf=" + cpf + ", custoPassagem=" + custoPassagem + ", custoTotal="
                + custoTotal + ", nome=" + nome + "]";
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public double getCustoPassagem() {
        return custoPassagem;
    }

    public void setCustoPassagem(double custoPassagem) {
        this.custoPassagem = custoPassagem;
    }
}