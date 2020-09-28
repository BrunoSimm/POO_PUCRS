public class FuncionarioPesquisador extends Funcionario {
    private int categoriaDeEspecializacao;

	public FuncionarioPesquisador(String matricula, String nome, double salarioBruto,
			int categoriaDeEspecializacao) {
		super(matricula, nome, salarioBruto);
		this.categoriaDeEspecializacao = categoriaDeEspecializacao;
	}

    public int getCategoriaDeEspecializacao() {
        return categoriaDeEspecializacao;
    }

    public void setCategoriaDeEspecializacao(int categoriaDeEspecializacao) {
        this.categoriaDeEspecializacao = categoriaDeEspecializacao;
    }
    @Override
    public double getSalarioLiquido(){
        double aux;
        switch(categoriaDeEspecializacao){
            case 1: aux = 1.05; break;
            case 2: aux = 1.10; break;
            case 3: aux = 1.20; break;
            default: aux = 1;
        }
        return (getSalarioBruto() - getINSS() - getImpRenda()) * aux;
    }
    @Override
    public String toString() {
        String aux = "";
        aux += "Categoria: "+this.getClass().getName()+"\n";
        aux += "Matricula: "+this.getMatricula()+"\n";
        aux += "Nome: "+this.getNome()+"\n";
        aux += "Categoria de Pesquisa: "+this.getCategoriaDeEspecializacao()+"\n";
        aux += "Salario bruto: "+this.getSalarioBruto()+"\n";
        aux += "(-) INSS: "+this.getINSS()+"\n";
        aux += "(-) IR: "+this.getImpRenda()+"\n";
        aux += "Salario liquido: "+this.getSalarioLiquido()+"\n";
        aux += "----------";
        return aux;    
    }

}
