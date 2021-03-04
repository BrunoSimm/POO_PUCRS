public class Premier extends Executive {

    public Premier(String cpf, String nome, String assento, double custoPassagem) {
        super(cpf, nome, assento, custoPassagem);
        milhas = custoPassagem * 0.20;
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
        custoTotal = custoTotal + (custoBagagem * 0.5);
        return custoBagagem;
    }

    @Override
    public void defineAssento(String identificadorAssento){
       setAssento(identificadorAssento);
    }
    
}
