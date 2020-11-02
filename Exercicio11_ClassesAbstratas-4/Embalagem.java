public class Embalagem {
    private double custoUnitario;
    private String codigoReferecia;
    protected double volume;

    public Embalagem(double custoUnitario, String codigoReferecia) {
        this.custoUnitario = custoUnitario;
        this.codigoReferecia = codigoReferecia;
    }

    public String getCodigoReferecia(){
        return this.codigoReferecia;
    }
    public double getCustoUnitario(){
        return this.custoUnitario;
    }

    @Override
    public String toString() {
        return "XXXEmbalagem "+ this.getClass().getName()+" [codigoReferecia=" + codigoReferecia + ", custoUnitario=" + custoUnitario + ", volume="
                + volume + "]";
    }
    public static int qtdade1(){
        return 1;

    }

    public int qtdade2(){

        return 2;

    }

}