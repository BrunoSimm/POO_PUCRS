import java.time.LocalDateTime;

public class FretamentoUtilitario_Caminhao extends Fretamento {
    private boolean cargaPerigosa;

    public FretamentoUtilitario_Caminhao(Veiculo veiculo, Funcionario condutor, LocalDateTime dataInicio,
            LocalDateTime dataTermino, double distancia, double valor, boolean cargaPerigosa) {
        super(veiculo, condutor, dataInicio, dataTermino, distancia, valor);
        this.cargaPerigosa = cargaPerigosa;
    }
    
}
