import java.time.LocalDate;

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

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public String getCategoriaCNH() {
        return categoriaCNH;
    }

    public void setCategoriaCNH(String categoriaCNH) {
        this.categoriaCNH = categoriaCNH;
    }

    public LocalDate getDataVencimentoCNH() {
        return dataVencimentoCNH;
    }

    public void setDataVencimentoCNH(LocalDate dataVencimentoCNH) {
        this.dataVencimentoCNH = dataVencimentoCNH;
    }

    public boolean isCursoCargaPerigosa() {
        return cursoCargaPerigosa;
    }

    public void setCursoCargaPerigosa(boolean cursoCargaPerigosa) {
        this.cursoCargaPerigosa = cursoCargaPerigosa;
    }

    public boolean isCursoTransportePassageiros() {
        return cursoTransportePassageiros;
    }

    public void setCursoTransportePassageiros(boolean cursoTransportePassageiros) {
        this.cursoTransportePassageiros = cursoTransportePassageiros;
    }

    
    
}
