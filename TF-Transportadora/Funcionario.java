import java.util.Calendar;

public class Funcionario {
    private String nome;
    private Calendar dataNascimento; // Calendar: https://www.devmedia.com.br/trabalhando-com-as-classes-date-calendar-e-simpledateformat-em-java/27401
    // API CALENDAR: https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/Calendar.html
    private String cpf;

    public Funcionario(String nome, Calendar dataNascimento1, String cpf) {
        this.nome = nome;
        if (dataNascimento1 == null){
            System.out.println("aaa");
        }
        this.dataNascimento.setTime(dataNascimento1.getTime());
        this.cpf = cpf; //Fzer validação do CPF (regex?)
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    

}