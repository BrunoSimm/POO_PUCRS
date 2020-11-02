public class EmbalagemConica extends Embalagem{
    public EmbalagemConica(double custoUnitario, String codigoReferecia) {
        super(custoUnitario, codigoReferecia);
    }
    public double getVolume(double lado1,double lado2,double altura,double raio){
        this.volume = (Math.PI * (Math.pow(raio,2) * altura)) / 3;
        return this.volume;
    }

    public static int qtdade1(){
        return 1;

    }

    public int qtdade2(){

        return 2;

    }
}
