import java.time.LocalDateTime;

public class FretamentoUtilitario_Caminhao extends Fretamento {
    private boolean cargaPerigosa;

    public FretamentoUtilitario_Caminhao(int id,Veiculo veiculo, Funcionario condutor, LocalDateTime dataInicio,
            LocalDateTime dataTermino, double distancia, double valor, boolean cargaPerigosa) {
        super(id,veiculo, condutor, dataInicio, dataTermino, distancia, valor);
        this.cargaPerigosa = cargaPerigosa;
    }

	public boolean getCargaPerigosa() {
		return cargaPerigosa;
	}

	public void setCargaPerigosa(boolean cargaPerigosa) {
		this.cargaPerigosa = cargaPerigosa;
	}

    //TO DO
    
}
