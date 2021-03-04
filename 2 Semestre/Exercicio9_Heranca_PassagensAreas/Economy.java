public class Economy extends Passagem {
    public Economy(String cpf, String nome, String assento, double custoPassagem) {
        super(cpf, nome, assento, custoPassagem);
    }
    @Override
    public double custoBagagem(int qtd, int[] pesos) {
        double custoBagagem = 0;
        if (qtd != pesos.length) {
            //erro
        }else {
            for(int item:pesos){
                custoBagagem = custoBagagem + (item * 0.5);
            }
        }
        custoTotal = custoTotal + (custoBagagem + (qtd * 10));//Adicional de R$10,00 por bagagem.
        return custoBagagem;
    }
}
