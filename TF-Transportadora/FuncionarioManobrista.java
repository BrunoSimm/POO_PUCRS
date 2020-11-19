import java.util.Calendar;

public class FuncionarioManobrista extends Funcionario {
    private String numeroCNH;
    private String categoriaCNH;
    private Calendar dataVencimentoCNH;

    public FuncionarioManobrista(String nome, Calendar dataNascimento, String cpf, String numeroCNH, String categoriaCNH,Calendar dataVencimentoCNH) {
        super(nome, dataNascimento, cpf);
        this.numeroCNH = numeroCNH;
        this.categoriaCNH = categoriaCNH;
        this.dataVencimentoCNH = dataVencimentoCNH;
    }


}
