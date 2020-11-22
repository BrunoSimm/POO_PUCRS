public class VeiculoPasseio extends Veiculo {
    private double quilometragem;
    private double posicaoTanque;

    public VeiculoPasseio(String placa, String modelo, int anoFabricacao, double peso, double quilometragem,
            double posicaoTanque) {
        super(placa, modelo, anoFabricacao, peso);
        this.quilometragem = quilometragem;
        this.posicaoTanque = posicaoTanque;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public double getPosicaoTanque() {
        return posicaoTanque;
    }

    public void setPosicaoTanque(double posicaoTanque) {
        this.posicaoTanque = posicaoTanque;
    }

    
}
