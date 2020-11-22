import java.time.LocalDate;

public class Funcionario {
    private String nome;
    private LocalDate dataNascimento; //LocalDate https://www.youtube.com/watch?v=5WrIWclE_Gc&ab_channel=AlgaWorks
    // Calendar: https://www.devmedia.com.br/trabalhando-com-as-classes-date-calendar-e-simpledateformat-em-java/27401
    // API CALENDAR: https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/Calendar.html
    private String cpf;

    public Funcionario(String nome, LocalDate dataNascimento, String cpf) {
        this.nome = nome;
        this.dataNascimento =  dataNascimento; //yyyy-mm-dd
        this.cpf = cpf; //Fzer validação do CPF (regex?)
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    

}