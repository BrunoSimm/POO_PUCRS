import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class FretamentoVeiculoPassageiros extends Fretamento{

	public FretamentoVeiculoPassageiros(int id, VeiculoPassageiros veiculo, FuncionarioMotorista condutor, LocalDate dataInicio, LocalDate dataTermino, double distancia) {
		super(id,veiculo, condutor, dataInicio, dataTermino, distancia);
	}

	@Override
	double setValor() {
		double total = 0;
		VeiculoPassageiros v = (VeiculoPassageiros)this.getVeiculo();

		if (v.getLotacaoMaxima() == 15){
			total = total + (410 * (ChronoUnit.DAYS.between(this.getDataInicio(),this.getDataTermino()))) + (this.getDistancia() * 2.20);
			return total;
		} else if (v.getLotacaoMaxima() == 26){
			total = total + (490 * (ChronoUnit.DAYS.between(this.getDataInicio(),this.getDataTermino()))) + (this.getDistancia() * 2.80);
			return total;
		} else {
			total = total + (560 * (ChronoUnit.DAYS.between(this.getDataInicio(),this.getDataTermino()))) + (this.getDistancia() * 3);
			return total;
		}
	}
}
