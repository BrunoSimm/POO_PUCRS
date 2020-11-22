import java.time.LocalDate;

public class FuncionarioManobrista extends Funcionario {
    private String numeroCNH;
    private String categoriaCNH;
    private LocalDate dataVencimentoCNH;

    public FuncionarioManobrista(String nome, LocalDate dataNascimento, String cpf, String numeroCNH, String categoriaCNH,LocalDate dataVencimentoCNH) {
        super(nome, dataNascimento, cpf);
        this.numeroCNH = numeroCNH;
        this.categoriaCNH = categoriaCNH;
        this.dataVencimentoCNH = dataVencimentoCNH;
    }


}
