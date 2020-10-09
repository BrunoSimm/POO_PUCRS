public class Aluno implements Voluntario {
    private String matricula;
    private String nome;
    private boolean isVoluntario;
    private String codigoVoluntario;

    public Aluno(String matricula, String nome, boolean isVoluntario, String codigoVoluntario) {
        this.matricula = matricula;
        this.nome = nome;
        this.isVoluntario = isVoluntario;
        this.codigoVoluntario = codigoVoluntario;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isVoluntario() {
        return isVoluntario;
    }

    public void setIsVoluntario(boolean novoStatus) {
        this.isVoluntario = novoStatus;
    }

    public String getCodigoVoluntario() {
        return codigoVoluntario;
    }

    public void setCodigoVoluntario(String codigoVoluntario) {
        this.codigoVoluntario = codigoVoluntario;
    }
    @Override
    public String getNomeVoluntario(){
        if (this.isVoluntario == true){
            return this.nome;
        } else return "Este Funcionário não é Voluntário";
    }
    @Override
    public boolean setCodigo(String codigo){//Código de duas letras
        if (codigo.length() == 2){
            this.codigoVoluntario = codigo;
            return true;
        } else return false;
    }
    
    
}
