public class AlunoAtleta extends AlunoArranjo implements Atleta {
    Modalidade modalidade;

    public AlunoAtleta(int matricula, String nome, Modalidade m) {
        super(matricula, nome);
        modalidade = m;
    }

    @Override
    public Modalidade getModalidade() {
        return modalidade;
    }
}
