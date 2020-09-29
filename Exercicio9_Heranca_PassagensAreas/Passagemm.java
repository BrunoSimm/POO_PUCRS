public class Passagemm {
    private String cpf;
    private String nome;
    private String assento;
    private double custoPassagem;
    private double custoTotal;

    public Passagemm(String cpf, String nome, double custoPassagem) {
        this.cpf = cpf;
        this.nome = nome;
        this.custoPassagem = custoPassagem;
        this.custoTotal = custoPassagem;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getAssento() {
        return assento;
    }

    public void defineAssento(String assento) {
        this.assento = assento;
        this.custoTotal += 5.0;
    }

    public double getCustoPassagem() {
        return custoPassagem;
    }

    public double custoBagagem(int quantidade, int[] pesos) {
        double custoBagagem = 0;
        if (quantidade != pesos.length) {
            //erro
        }
        for (int i = 0; i < pesos.length; i++) {
            custoBagagem += pesos[i] * 0.5;
        }
        custoTotal += custoBagagem;
        return custoBagagem;
    }

    @Override
    public String toString() {
        return "Passagem [assento=" + assento + ", cpf=" + cpf + ", custoPassagem=" + custoPassagem + ", custoTotal="
                + custoTotal + ", nome=" + nome + "]";
    }

    
    
}
