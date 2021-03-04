
public class Funcionario implements Atleta {
    private int matricula;
    private String nome;
	private float salario;
	private Modalidade modalidade;
   
	public Funcionario(int matricula, String nome, float salario, Modalidade m) {
		this.matricula = matricula;
		this.nome = nome;
		this.salario = salario;
		this.modalidade = m;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public int getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public Modalidade getModalidade() {
		return modalidade;
	}
	
}
