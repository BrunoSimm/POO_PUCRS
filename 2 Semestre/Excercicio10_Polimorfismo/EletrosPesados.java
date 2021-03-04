public class EletrosPesados extends Produto {

    public EletrosPesados(int codigo, String descricao, double preco) {
        super(codigo, descricao, preco);
    }
    @Override
    public double getMargemLucro(){
        if(getPreco() > 999){
            return getPreco()*0.2;
        } else {
            return getPreco() * 0.4;
        }
    }
}
