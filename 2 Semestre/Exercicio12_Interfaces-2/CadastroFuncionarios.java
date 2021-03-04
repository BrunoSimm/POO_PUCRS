import java.util.ArrayList;

public class CadastroFuncionarios{
    private ArrayList<Funcionario> funcionarios;

    private void carregaFuncionarios(){
        funcionarios.add(new Funcionario("A3212","Huguinho Pato",1890.0));
        funcionarios.add(new Funcionario("A3312","Zezinho Pato",3720.0));
        funcionarios.add(new Funcionario("A3412","Luizinho Pato",8940.0));
        funcionarios.add(new Funcionario("B9931","Lala Pata",4220.0));
        funcionarios.add(new Funcionario("B9932","Lele Pata",1283.0));
        funcionarios.add(new Funcionario("B9933","Lili Pata",12438.0));
        funcionarios.add(new FuncionarioAreaRisco("B1","BRuno", 1000, "PROGRAMADOR"));
        funcionarios.add(new FuncionarioAreaRisco("B2","Katlen", 1000, "PROGRAMADOR"));
        funcionarios.add(new FuncionarioAreaRisco("B3","Samu", 1000, "PROGRAMADOR"));
        funcionarios.add(new FuncionarioPesquisador("B4","FULANO",10000,2));
        funcionarios.add(new FuncionarioPesquisador("B5","CICLANO",5000,1));
        funcionarios.add(new FuncionarioPesquisador("B6","BELTRANO",3200,3));

    }

    public CadastroFuncionarios(){
        funcionarios = new ArrayList<>();
        carregaFuncionarios();
    }

    public void cadastraFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }

    public Funcionario recuperaPorMatricula(String matricula){
        for(Funcionario func:funcionarios){
            if (func.getMatricula().equals(matricula)){
                return func;
            }
        }
        return null;
    }
}