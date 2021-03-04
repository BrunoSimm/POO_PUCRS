public class FuncionarioAreaRisco extends Funcionario{
    private String categoriaDeRisco;
    private final double INSALUBRIDADE = 1.25;

    public FuncionarioAreaRisco(String matricula, String nome, double salarioBruto, String categoriaDeRisco) {
        super(matricula, nome, salarioBruto);
        this.categoriaDeRisco = categoriaDeRisco;
    }
    @Override
    public double getImpRenda(){
        if (((getSalarioBruto() - getINSS()) * INSALUBRIDADE) <= LIM_ISENCAO_IR){
            return 0.0;
        }else{
            double aux = ((getSalarioBruto() - getINSS()) * INSALUBRIDADE) - LIM_ISENCAO_IR;
            double ir = aux * 0.2;
            return ir;
        }
    }

    @Override
    public double getSalarioLiquido(){
        return ((getSalarioBruto() - getINSS()) * INSALUBRIDADE) - getImpRenda();
    }

    public String getCategoriaDeRisco() {
        return categoriaDeRisco;
    }

    public void setCategoriaDeRisco(String categoriaDeRisco){
        this.categoriaDeRisco = categoriaDeRisco;
    }

    @Override
    public String toString() {
        String aux = "";
        aux += "Categoria: "+this.getClass().getName()+"\n";
        aux += "Matricula: "+this.getMatricula()+"\n";
        aux += "Nome: "+this.getNome()+"\n";
        aux += "Categoria de Risco: "+this.getCategoriaDeRisco()+"\n";
        aux += "Salario bruto: "+this.getSalarioBruto()+"\n";
        aux += "(-) INSS: "+this.getINSS()+"\n";
        aux += "(-) IR: "+this.getImpRenda()+"\n";
        aux += "Salario liquido: "+this.getSalarioLiquido()+"\n";
        aux += "----------";
        return aux;    
    }

}


