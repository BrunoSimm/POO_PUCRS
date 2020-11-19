import java.util.Calendar;

public class FuncionarioMotorista extends Funcionario {
    private String numeroCNH;
    private String categoriaCNH;
    private Calendar dataVencimentoCNH;
    private boolean cursoCargaPerigosa;
    private boolean cursoTransportePassageiros;

    public FuncionarioMotorista(String nome, Calendar dataNascimento, String cpf, String numeroCNH, String categoriaCNH, Calendar dataVencimentoCNH, boolean cursoCargaPerigosa, boolean cursoTransportePassageiros) {
        super(nome, dataNascimento, cpf);
        this.numeroCNH = numeroCNH;
        this.categoriaCNH = categoriaCNH;
        this.dataVencimentoCNH = dataVencimentoCNH;
        this.cursoCargaPerigosa = cursoCargaPerigosa;
        this.cursoTransportePassageiros = cursoTransportePassageiros;
    }

    
}
