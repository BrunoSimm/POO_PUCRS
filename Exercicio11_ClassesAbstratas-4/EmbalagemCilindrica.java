public class EmbalagemCilindrica extends Embalagem {

    public EmbalagemCilindrica(double custoUnitario, String codigoReferecia) {
        super(custoUnitario, codigoReferecia);
    }
    public double getVolume(double lado1,double lado2,double altura,double raio){
        this.volume = (Math.PI * (Math.pow(raio,2))) * altura;
        return this.volume;
    }
}
