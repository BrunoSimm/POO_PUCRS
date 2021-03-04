import java.time.LocalDate;

public abstract class Funcionario {
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private boolean ocupado = false;

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

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

}