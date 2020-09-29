public class Executive extends Passagem {
    protected double milhas;

    public Executive(String cpf, String nome, String assento, double custoPassagem) {
        super(cpf, nome, assento, custoPassagem);
        milhas = custoPassagem * 0.10;
    }

    @Override
    public double custoBagagem(int qtd, int[] pesos) {
        double custoBagagem = 0;
        if (qtd != pesos.length) {
            //erro
        }else {
            if(qtd >= 2){
                for (int i = 2; i < pesos.length; i++) {
                    custoBagagem += (pesos[i] * 0.5);
                }
            } else{
                custoBagagem = 0;
            }
        }
        custoTotal = custoTotal + custoBagagem;
        return custoBagagem;
    }

    public double getMilhas() {
        return milhas;
    }
}
