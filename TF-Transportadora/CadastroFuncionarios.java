import java.util.Collections;
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
        LinkedList<String> nomes = new LinkedList<String>();
        for (Funcionario f : funcionarios) {
            nomes.add(f.getNome());
        }

        Collections.sort(nomes);
        System.out.println("Funcionarios em orgem alfabética:");
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }

    public Funcionario getByCPF(String cpf){
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)){
                return funcionario;
            }
        }
        return null;
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
    
}
