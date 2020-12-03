public class VeiculoCargas extends Veiculo{
    private double capacidadeCarga;
    private int nrEixos;
    private boolean unidadeAcoplada;

    public VeiculoCargas(String placa, String modelo, int anoFabricacao, double peso, double capacidadeCarga,
            int nrEixos, boolean unidadeAcoplada) {
        super(placa, modelo, anoFabricacao, peso);
        this.capacidadeCarga = capacidadeCarga;
        this.nrEixos = nrEixos;
        this.unidadeAcoplada = unidadeAcoplada;
        
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getNrEixos() {
        return nrEixos;
    }

    public void setNrEixos(int nrEixos) {
        this.nrEixos = nrEixos;
    }

    public boolean isUnidadeAcoplada() {
        return unidadeAcoplada;
    }

    public void setUnidadeAcoplada(boolean unidadeAcoplada) {
        this.unidadeAcoplada = unidadeAcoplada;
    }
    
}
