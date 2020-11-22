import java.time.LocalDateTime;

public class FretamentoOnibus_Vans extends Fretamento{

	public FretamentoOnibus_Vans(Veiculo veiculo, Funcionario condutor, LocalDateTime dataInicio,
			LocalDateTime dataTermino, double distancia, double valor) {
		super(veiculo, condutor, dataInicio, dataTermino, distancia, valor);
	}
    
}
