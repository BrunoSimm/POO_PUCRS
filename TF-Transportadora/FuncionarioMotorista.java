import java.time.LocalDate;
import java.util.Calendar;

public class FuncionarioMotorista extends Funcionario {
    private String numeroCNH;
    private String categoriaCNH;
    private LocalDate dataVencimentoCNH;
    private boolean cursoCargaPerigosa;
    private boolean cursoTransportePassageiros;

    public FuncionarioMotorista(String nome, LocalDate dataNascimento, String cpf, String numeroCNH, String categoriaCNH, LocalDate dataVencimentoCNH, boolean cursoCargaPerigosa, boolean cursoTransportePassageiros) {
        super(nome, dataNascimento, cpf);
        this.numeroCNH = numeroCNH;
        this.categoriaCNH = categoriaCNH;
        this.dataVencimentoCNH = dataVencimentoCNH;
        this.cursoCargaPerigosa = cursoCargaPerigosa;
        this.cursoTransportePassageiros = cursoTransportePassageiros;
    }

    
}
