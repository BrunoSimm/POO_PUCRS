public class VagaoPassageiros extends Vagao {
    private int qtdPassageiros;
    private double pesoVagao;

    public VagaoPassageiros(int qtdPassageiros, double pesoVagao,int identificador, int composicao) {
        this.composicao = composicao;
        this.identificador = identificador;
        this.qtdPassageiros = qtdPassageiros;
        this.pesoVagao = qtdPassageiros * 70;
    }

    @Override
    public String toString() {
        return "VagaoPassageiros [pesoVagao=" + pesoVagao + ", qtdPassageiros=" + qtdPassageiros + ", identificador "+ this.identificador + ", composição= "+ this.composicao+ "]";
    }

    public double getPesoVagao() {
        return pesoVagao;
    }

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

	@Override
	public String toLineFile(){
		return this.getIdentificador()+","+
			this.getQtdPassageiros()+","+
			this.getComposicao();
	}
}
