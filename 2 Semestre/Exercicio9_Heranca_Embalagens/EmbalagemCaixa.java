public class EmbalagemCaixa extends Embalagem {

    public EmbalagemCaixa(double custoUnitario, String codigoReferecia) {
        super(custoUnitario, codigoReferecia);
    }
    public double getVolume(double lado1,double lado2,double altura){
        this.volume = (lado1 * lado2) * altura;
        return this.volume;
    }
    
}
