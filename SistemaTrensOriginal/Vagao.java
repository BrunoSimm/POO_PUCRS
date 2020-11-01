public class Vagao {
	private int identificador;
	private double capacidadeCarga;
	private int composicao;

	public Vagao(int identificador, double capacidadeCarga) {
		this.identificador = identificador;
		this.capacidadeCarga = capacidadeCarga;
		this.composicao = -1;
	}

	public Vagao(int identificador, double capacidadeCarga, int composicao) {
		this.identificador = identificador;
		this.capacidadeCarga = capacidadeCarga;
		this.composicao = composicao;
	}

	public int getIdentificador() {
		return identificador;
	}

	public double getCapacidadeCarga() {
		return capacidadeCarga;
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
			this.getCapacidadeCarga()+","+
			this.getComposicao();
	}

	@Override
	public String toString() {
		return "Vagao [capacidadeCarga=" + capacidadeCarga + ", composicao=" + composicao + ", identificador="
				+ identificador + "]";
	}

}
