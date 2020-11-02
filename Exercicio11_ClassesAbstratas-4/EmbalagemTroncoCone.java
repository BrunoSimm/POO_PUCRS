public class EmbalagemTroncoCone extends EmbalagemConica{
    public EmbalagemTroncoCone(double custoUnitario, String codigoReferecia) {
        super(custoUnitario, codigoReferecia);
    }
    public double getVolume(double altura,double raio_da_base, double raio_do_topo){
        this.volume = ((Math.PI * altura * (Math.pow(raio_da_base, 2) + raio_da_base * (raio_do_topo + Math.pow(raio_do_topo, 2))))) / 3;
        return this.volume;
    }

    @Override
    public String toString() {
        return super.toString()+ "Embalagem "+ this.getClass().getName()+" [codigoReferecia=" + this.getCodigoReferecia() + ", custoUnitario=" + this.getCustoUnitario()+", volume="
                + volume + "]." + "\nAtenção, esta embalagem leva mais tempo para ser produzido.";
    }

}
