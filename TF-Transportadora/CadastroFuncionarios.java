import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

        List<String> nomes = funcionarios.stream()
            .map(f -> f.getNome() +" CPF:"+ f.getCpf())
            .sorted() //Ordena em orgem alfabética
            .collect(Collectors.toList());
            System.out.println("Funcionarios em ordem alfabética:");
            nomes.forEach(n -> {
                System.out.println(n);
            });
            System.out.println();
    }

    public Funcionario getByCPF(String cpf){
        /** 
        Map<String,List<Funcionario>> f = funcionarios.stream()
            .collect(Collectors.groupingBy(Funcionario::getNome));

        f.forEach((n,fc) -> {
            System.out.println(n+ "aaa"+fc);
        });

        funcionarios.stream()
            .filter(fs -> fs.getCpf().equals(cpf))
            .forEach(fs -> {
                System.out.println(fs.getNome() +" CPF:"+ fs.getCpf());
            });
        */

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
