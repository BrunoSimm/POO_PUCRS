public class Locomotiva {
	private int identificador;
	private double pesoMaximo;
	private int qtdadeMaxVagoes;
	private int composicao;

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

	public int getIdentificador() {
		return identificador;
	}

	public double getPesoMaximo() {
		return pesoMaximo;
	}

	public int getQtdadeMaxVagoes() {
		return qtdadeMaxVagoes;
	}

	public int getComposicao() {
		return composicao;
	}

	public void setComposicao(Composicao composicao) {
		if (composicao == null) {
			this.composicao = -1;
		} else {
			this.composicao = composicao.getIdentificador();
		}
	}

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
