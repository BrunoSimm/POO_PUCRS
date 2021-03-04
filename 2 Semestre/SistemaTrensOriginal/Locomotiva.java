public class Locomotiva extends ElementoDeComposicao{
	private double pesoMaximo;
	private int qtdadeMaxVagoes;

	public Locomotiva(int identificador, double pesoMaximo, int qtdadeVagoes) {
		this.identificador = identificador;
		this.pesoMaximo = pesoMaximo;
		this.qtdadeMaxVagoes = qtdadeVagoes;
		this.composicao = -1;
	}

	public Locomotiva(int identificador, double pesoMaximo, int qtdadeVagoes, int composicao) {
		this.identificador = identificador;
		this.pesoMaximo = pesoMaximo;
		this.qtdadeMaxVagoes = qtdadeVagoes;
		this.composicao = composicao;
	}

	public double getPesoMaximo() {
		return pesoMaximo;
	}

	public int getQtdadeMaxVagoes() {
		return qtdadeMaxVagoes;
	}
	
	@Override
	public String toLineFile(){
		return this.getIdentificador()+","+
			this.getPesoMaximo()+","+
			this.getQtdadeMaxVagoes()+","+
			this.getComposicao();
	}
	
	@Override
	public String toString() {
		return "Locomotiva [composicao=" + composicao + ", identificador=" + identificador + ", pesoMaximo="
				+ pesoMaximo + ", qtdadeMaxVagoes=" + qtdadeMaxVagoes + "]";
	}
}
