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
        System.out.println("Funcionario Manobrista adicionado!\n");
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


    

}
