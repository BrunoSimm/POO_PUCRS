import java.time.LocalDate;

public class FretamentoVeiculoCarga extends Fretamento {
    private boolean cargaPerigosa = false;

    public FretamentoVeiculoCarga(int id,VeiculoCargas veiculo, Funcionario condutor, LocalDate dataInicio,
            LocalDate dataTermino, double distancia, boolean cargaPerigosa) {
        super(id,veiculo, condutor, dataInicio, dataTermino, distancia);
        this.cargaPerigosa = cargaPerigosa;
        this.setCargaPerigosa(cargaPerigosa);
    }

	public boolean getCargaPerigosa() {
		return this.cargaPerigosa;
	}

	public void setCargaPerigosa(boolean cargaPerigosa) {
		this.cargaPerigosa = cargaPerigosa;
	}

    @Override
    public double setValor() {
        double total = 0;
        VeiculoCargas v = (VeiculoCargas)this.getVeiculo();
        System.out.println("Periogoso?"+this.getCargaPerigosa());
        if(this.getCargaPerigosa() == true){
            System.out.println("PERIOGOSO");
            total = total + (v.getNrEixos() * 1.50 * this.getDistancia());
            return total;
        } else {
            System.out.println("NORMAL");
            total = total + (v.getNrEixos() * 1.20 * this.getDistancia());
            return total;
        }
    }
    
}
