import java.time.LocalDate;

public class FretamentoVeiculoCarga extends Fretamento {
    private boolean cargaPerigosa;

    public FretamentoVeiculoCarga(int id,VeiculoCargas veiculo, FuncionarioMotorista condutor, LocalDate dataInicio, LocalDate dataTermino, double distancia, boolean is_cargaPerigosa) {
        super(id,veiculo,condutor, dataInicio, dataTermino, distancia);
        this.cargaPerigosa = is_cargaPerigosa;
        this.calculaValor(veiculo,this);
        System.out.println("Fretamento de Carga cadastrado com sucesso!\n");
    }

	public boolean getCargaPerigosa() {
		return this.cargaPerigosa;
	}

	public void setCargaPerigosa(boolean cargaPerigosa) {
		this.cargaPerigosa = cargaPerigosa;
	}

    @Override
    void calculaValor(Veiculo veiculo,Fretamento frete) {
        double total = 0;
        VeiculoCargas v = (VeiculoCargas)this.getVeiculo();

        if(this.cargaPerigosa == true){
            total = total + (v.getNrEixos() * 1.50 * this.getDistancia());
            this.setValor(total);
        } else {
            total = total + (v.getNrEixos() * 1.20 * this.getDistancia());
            this.setValor(total);
        }
    }
    
}
