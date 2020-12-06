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
            .map(f -> f.getNome() +" CPF:"+ f.getCpf()+" | "+f.getClass().getName())
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
        funcionarios.stream()
            .filter(f -> f instanceof FuncionarioMotorista)
            .filter(fm -> fm.isOcupado() == false)
            .forEach(fmL -> {
                FuncionarioMotorista temp = (FuncionarioMotorista)fmL;
                    System.out.println("Motorista Livre: "+fmL.getNome()+" CPF:"+fmL.getCpf()+" CNH Tipo:"+(temp.getCategoriaCNH())+"\n\tHabilitado para carga perigosa? "+temp.isCursoCargaPerigosa()+" | Habilitado para transporte de passageiros? "+temp.cursoTransportePassageiros());
            });
            
    }
    
}
