public class FuncionarioSimples extends Funcionario{

	public FuncionarioSimples(String matricula, String nome, double salarioBruto) {
		super(matricula, nome, salarioBruto);
    }
    public double getSalarioLiquido(){
        return this.getSalarioBruto() - getINSS() - getImpRenda();
    }
    
}
