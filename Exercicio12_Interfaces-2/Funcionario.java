public class Funcionario implements Voluntario{
    public static final double LIM_ISENCAO_IR = 2000;
    private String matricula;
    private String nome;
    private double salarioBruto;
    private boolean isVoluntario;
    private String codigoVoluntario;
    
    public Funcionario(String matricula, String nome, double salarioBruto,boolean isVoluntario){
        this.matricula = matricula;
        this.nome = nome;
        this.salarioBruto = salarioBruto;
        this.isVoluntario = isVoluntario;
    }

	public String getMatricula() {
		return matricula;
	}
	
	public String getNome(){
		return nome;
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
    public String getCodigo(){//Código de duas letras
        return this.codigoVoluntario;
    } 

    public boolean getIsVoluntario() {
		return isVoluntario;
	}
	
	public void setIsVoluntario(boolean novoStatus) {
		this.isVoluntario = novoStatus;
	}
	
	public double getSalarioBruto() {
		return salarioBruto;
	}
    
    public double getINSS(){
        return salarioBruto*0.1;
    }

    public double getImpRenda(){
        if (salarioBruto <= LIM_ISENCAO_IR){
            return 0.0;
        }else{
            double aux = salarioBruto - LIM_ISENCAO_IR;
            double ir = aux * 0.2;
            return ir;
        }
    }

    public double getSalarioLiquido(){
        return salarioBruto - getINSS() - getImpRenda();
    }

    public String toString() {
        String aux = "";
        aux += "Categoria: "+this.getClass().getName()+"\n";
        aux += "Matricula: "+this.getMatricula()+"\n";
        aux += "Nome: "+this.getNome()+"\n";
        aux += "Salario bruto: "+this.getSalarioBruto()+"\n";
        aux += "(-) INSS: "+this.getINSS()+"\n";
        aux += "(-) IR: "+this.getImpRenda()+"\n";
        aux += "Salario liquido: "+this.getSalarioLiquido()+"\n";
        aux += "----------";
        return aux;    
    }
}