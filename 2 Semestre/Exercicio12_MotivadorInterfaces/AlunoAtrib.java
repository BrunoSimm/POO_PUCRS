
public class AlunoAtrib implements Aluno {
	private String nome;
	private int matricula;
	private float n1, n2, n3;

	public AlunoAtrib(int matricula, String nome) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		n1 = 0;
		n2 = 0;
		n3 = 0;
	}

	@Override
	public int getMatricula() {
		return matricula;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public boolean setNota(int nro, float nota) {
		switch (nro) {
		case 1:
			n1 = nota;
			break;
		case 2:
			n2 = nota;
			break;
		case 3:
			n3 = nota;
			break;
		default:
			return false;
		}
		return true;
	}

	@Override
	public float getNota(int nro) {
		switch (nro) {
		case 1:
			return n1;
		case 2:
			return n2;
		case 3:
			return n3;
		default:
			return -1;
		}
	}

	@Override
	public float mediaFinal() {
		return (n1 + n2 + n3) / 3;
	}

	@Override
	public boolean aprovado() {
		return mediaFinal() >= 7.0;
	}

}
