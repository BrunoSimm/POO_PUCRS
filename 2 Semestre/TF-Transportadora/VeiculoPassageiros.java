public class VeiculoPassageiros extends Veiculo{
    private int lotacaoMaxima;

    public VeiculoPassageiros(String placa, String modelo, int anoFabricacao, double peso, int lotacaoMaxima) {
        super(placa, modelo, anoFabricacao, peso);
        this.lotacaoMaxima = lotacaoMaxima;
        System.out.println("Veiculo de Passageiros adicionado!\n");
    }

    public int getLotacaoMaxima() {
        return lotacaoMaxima;
    }
    
}
