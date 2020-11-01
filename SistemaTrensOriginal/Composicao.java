import java.util.ArrayList;

public class Composicao {
	private ArrayList<Vagao> vagoes;
	private ArrayList<Locomotiva> locomotivas;
	private int identificador;

	public Composicao(int identificador){
		this.identificador = identificador;
		vagoes = new ArrayList<>();
		locomotivas = new ArrayList<>();
	}

	public int getIdentificador() {
		return identificador;
	}

	public int getQtdadeLocomotivas() {
		return locomotivas.size();
	}

	public Locomotiva getLocomotiva(int posicao) {
		if (posicao >= 0 && posicao < locomotivas.size()) {
			return locomotivas.get(posicao);
		} else {
			return null;
		}
	}

	public int getQtdadeVagoes() {
		return vagoes.size();
	}

	public Vagao getVagao(int posicao) {
		if (posicao >= 0 && posicao < vagoes.size()) {
			return vagoes.get(posicao);
		} else {
			return null;
		}
	}

	public boolean engataLocomotiva(Locomotiva locomotiva) {
		if (vagoes.size() != 0 || locomotiva.getComposicao() != -1) {
			return false;
		} else {
			locomotiva.setComposicao(this);
			locomotivas.add(locomotiva);
			return true;
		}
	}

	private int maxVagoesNaComposicao() {
		int qtdade = 0;
		for (Locomotiva l : locomotivas) {
			qtdade += l.getQtdadeMaxVagoes();
		}
		return (int) (qtdade * (1 - (0.1 * locomotivas.size())));
	}

	private double pesoMaxNaComposicao() {
		double peso = 0.0;
		for (Locomotiva l : locomotivas) {
			peso += l.getPesoMaximo();
		}
		return (int) (peso * (1 - (0.1 * locomotivas.size())));
	}

	private double pesoAtualDaComposicao() {
		double peso = 0.0;
		for (Vagao v : vagoes) {
			peso += v.getCapacidadeCarga();
		}
		return peso;
	}

	public boolean engataVagao(Vagao vagao) {
		if (locomotivas.size() == 0 || vagao.getComposicao() != -1) {
			return false;
		} else {
			if (vagoes.size() < maxVagoesNaComposicao()
					&& pesoAtualDaComposicao() + vagao.getCapacidadeCarga() <= pesoMaxNaComposicao()) {
				vagao.setComposicao(this);
				vagoes.add(vagao);
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean desengataLocomotiva() {
		if (locomotivas.size() > 0) {
			if (vagoes.size() > 0) {
				return false;
			} else {
				Locomotiva aux = locomotivas.remove(locomotivas.size() - 1);
				aux.setComposicao(null);
				return true;
			}
		}else{
			return false;
		}
	}

	public boolean desengataVagao() {
		if (vagoes.size() > 0) {
			Vagao aux = vagoes.remove(vagoes.size() - 1);
			aux.setComposicao(null);
			return true;
		} else {
			return false;
		}
	}

	public String toLineFile(){
		String aux = "";
		aux += this.getIdentificador() +",";
		aux += this.getQtdadeLocomotivas()+",";
		for(int i=0;i<this.getQtdadeLocomotivas();i++){
			aux += this.getLocomotiva(i).toLineFile()+",";
		}
		aux += this.getQtdadeVagoes()+",";
		for(int i=0;i<this.getQtdadeVagoes();i++){
			aux += this.getVagao(i).toLineFile();
			if (i<this.getQtdadeVagoes()-1){
				aux += ",";
			}
		}
		return aux;
	}
}
