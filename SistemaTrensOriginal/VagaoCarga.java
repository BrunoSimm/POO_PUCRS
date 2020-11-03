public class VagaoCarga extends Vagao{
	private double capacidadeCarga;

	public VagaoCarga(int identificador, double capacidadeCarga) {
		this.identificador = identificador;
		this.capacidadeCarga = capacidadeCarga;
		this.composicao = -1;
	}

	public VagaoCarga(int identificador, double capacidadeCarga, int composicao) {
		this.identificador = identificador;
		this.capacidadeCarga = capacidadeCarga;
		this.composicao = composicao;
	}

	public double getCapacidadeCarga() {
		return capacidadeCarga;
	}

	@Override
	public String toLineFile(){
		return this.getIdentificador()+","+
			this.getCapacidadeCarga()+","+
			this.getComposicao();
	}

	@Override
	public String toString() {
		return "VagaoCarga [capacidadeCarga=" + capacidadeCarga + ", composicao=" + composicao + ", identificador="
				+ identificador + "]";
	}

}
