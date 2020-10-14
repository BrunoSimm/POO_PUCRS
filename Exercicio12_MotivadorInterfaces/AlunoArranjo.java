
public class AlunoArranjo implements Aluno {
	private String nome;
	private int matricula;
	private float notas[];

	public AlunoArranjo(int matricula, String nome) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		notas = new float[3];
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
		nro--;
		if (nro >= 0 && nro <= 2) {
			notas[nro] = nota;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public float getNota(int nro) {
		nro--;
		if (nro >= 0 && nro <= 2) {
			return notas[nro];
		} else {
			return -1;
		}
	}

	@Override
	public float mediaFinal() {
		return (notas[0] + notas[1] + notas[2]) / 3;
	}

	@Override
	public boolean aprovado() {
		return mediaFinal() >= 7;
	}
}
