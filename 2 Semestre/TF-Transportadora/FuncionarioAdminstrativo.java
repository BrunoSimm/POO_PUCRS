import java.time.LocalDate;

public class FuncionarioAdminstrativo extends Funcionario {
    public FuncionarioAdminstrativo(String nome, LocalDate dataNascimento, String cpf) {
        super(nome, dataNascimento, cpf);
        System.out.println("Funcionario adminstrativo adicionado!\n");
    } 
}
