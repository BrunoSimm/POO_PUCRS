
public interface Aluno {

	int getMatricula();

	String getNome();

	boolean setNota(int nro, float nota);

	float getNota(int nro);

	float mediaFinal();

	boolean aprovado();
}
