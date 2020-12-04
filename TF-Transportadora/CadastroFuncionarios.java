import java.util.LinkedList;


public class CadastroFuncionarios {
    private LinkedList<Funcionario> funcionarios;

    public CadastroFuncionarios() {
        this.funcionarios = new LinkedList<Funcionario>();
    }

    public boolean cadastrar(Funcionario funcionario){
        if(funcionario != null){
            this.funcionarios.add(funcionario);
            return true;
        } else {
            return false;
        }
    }


    public void listarFuncionarios(){
        System.out.println("Funcionarios em ordem alfabética:");
        funcionarios.stream()
            .map(f -> f.getNome() +" CPF:"+ f.getCpf())
            .sorted() //Ordena em ordem alfabética
            .forEach(f -> {
                System.out.println(f);
            });
    }

    public Funcionario getByCPF(String cpf){
        return funcionarios.stream()
            .filter(fs -> fs.getCpf().equals(cpf))
            .findFirst()
            .orElse(null);
        /*
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)){
                return funcionario;
            }
        }
        return null;
        */
    }

    public boolean removerFuncionario(String cpf){
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)){
                funcionarios.remove(funcionario);
                return true;
            }
        }
        return false;
    }

    public void listarMotoristasLivres(){
        funcionarios.stream()//TODO!
    }
    
}
