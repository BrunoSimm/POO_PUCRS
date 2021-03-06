import java.util.ArrayList;

public class Composicao {
	private ArrayList<ElementoDeComposicao> elementosComposicao;
	private int identificador;

	public Composicao(int identificador,Locomotiva locomotivaInicial){//Utilizado na criação de novas composições
		if(locomotivaInicial != null && locomotivaInicial.getComposicao() == -1){
			this.identificador = identificador;
			elementosComposicao = new ArrayList<>();
			elementosComposicao.add(locomotivaInicial);
			locomotivaInicial.setComposicao(this);
		} 
		if(locomotivaInicial == null){
			throw new NullPointerException();
		}
	}
	public Composicao(int identificador){ //Utilizado apenas no momento de carregar os arquivos.
			this.identificador = identificador;
			elementosComposicao = new ArrayList<>();
	}

	public int getIdentificador() {
		return identificador;
	}

	public int getQtdadeLocomotivas() {
		int cont = 0;
		for (ElementoDeComposicao elemento: elementosComposicao){
			if(elemento.getClass().getName().equals("Locomotiva")){
				cont++;
			}
		}
		return cont;
	}

	public ElementoDeComposicao getLocomotiva(int identificador){
		for (ElementoDeComposicao elemento: elementosComposicao){
			if(elemento.getIdentificador() == identificador){
				return elemento;
			}
		}
		return null;
	}

	public int getQtdadeVagoes() {
		int cont = 0;
		for (ElementoDeComposicao elemento: elementosComposicao){
			if(elemento.getClass().getName().contains("Vagao")){
				cont++;
			}
		}
		return cont;
	}

	public ElementoDeComposicao getVagao(String tipoDeVagao,int posicao) {
		if (tipoDeVagao.equals("VagaoCarga")){
			if (posicao >= 0 && posicao < elementosComposicao.size()) {
				return elementosComposicao.get(posicao);
			} else {
				return null;
			}
		} else if(tipoDeVagao.equals("VagaoPassageiros")){
			if (posicao >= 0 && posicao < elementosComposicao.size()) {
				return elementosComposicao.get(posicao);
			} else {
				return null;
			}
		} else return null;
		
	}

	public boolean engataLocomotiva(Locomotiva locomotiva) {
		if (locomotiva.getComposicao() != -1) {
			return false;
		} else if (elementosComposicao.get(elementosComposicao.size()-1).getClass().getName().contains("Vagao")){ //Já existe um vagão conectado na ultima posição do array, impedindo conexão de uma locomotiva.
			return false;
		} else {
			locomotiva.setComposicao(this);
			elementosComposicao.add(locomotiva);
			return true;
		}
	}
	/**
	 * Este método é utilizado apenas para associação da locomotiva a uma composição já existente.
	 * Utilizado no método "alimentaComposicoes()" da classe CadastroComposicoes.
	 * @param locomotiva
	 * @return boolean t/f
	*/
	public boolean insereLocomotivas(Locomotiva locomotiva){
		elementosComposicao.add(locomotiva);
		return true;
	}

	public boolean insereVagao(Vagao vagao){
		elementosComposicao.add(vagao);
		return true;
	}


	private int maxVagoesNaComposicao() {
		int qtdade = 0;
		int qtdLomotivasComposicao = 0;
		for (ElementoDeComposicao elemento : elementosComposicao) {
			if (elemento.getClass().getName() == "Locomotiva"){
				qtdade += ((Locomotiva)elemento).getQtdadeMaxVagoes();
				qtdLomotivasComposicao++;
			}
		}
		return (int) (qtdade * (1 - (0.1 * qtdLomotivasComposicao)));
	}

	private double pesoMaxNaComposicao() {
		double peso = 0.0;
		int qtdLomotivasComposicao = 0;
		for (ElementoDeComposicao elemento : elementosComposicao) {
			if (elemento.getClass().getName() == "Locomotiva"){
				peso += ((Locomotiva)elemento).getPesoMaximo();
				qtdLomotivasComposicao++;
			}
		}
		return (int) (peso * (1 - (0.1 * qtdLomotivasComposicao)));
	}

	private double pesoAtualDaComposicao() {
		double peso = 0.0;
		for (ElementoDeComposicao elemento : elementosComposicao) {
			if (elemento.getClass().getName() == "VagaoCarga"){
				peso += ((VagaoCarga)elemento).getCapacidadeCarga();
			} 
			if (elemento.getClass().getName() == "VagaoPassageiros"){
				peso += ((VagaoPassageiros)elemento).getPesoVagao();
			}
		}
		return peso;
	}

	public boolean engataVagao(Vagao vagao) {
		if (elementosComposicao.size() == 0 || vagao.getComposicao() != -1) {
			return false;
		} else {
			if (elementosComposicao.size() < maxVagoesNaComposicao()){
				if (vagao.getClass().getName().contains("VagaoCarga")){
					if(pesoAtualDaComposicao() + ((VagaoCarga)vagao).getCapacidadeCarga() <= 			pesoMaxNaComposicao()){
						vagao.setComposicao(this);
						elementosComposicao.add(vagao);
						return true;
					} else {
						return false;}
				} else {
					if(pesoAtualDaComposicao() + ((VagaoPassageiros)vagao).getPesoVagao() <= 			pesoMaxNaComposicao()){
						vagao.setComposicao(this);
						elementosComposicao.add(vagao);
						return true;
					} else {
						return false;}
				}
			} else {
				return false;
			}
		}
	}
	

	public boolean desengataLocomotiva() {
		if (elementosComposicao.size() > 0) {
			if (elementosComposicao.get(elementosComposicao.size()).getClass().getName().contains("Vagao")){
				return false;
			} else {
				ElementoDeComposicao aux = elementosComposicao.remove(elementosComposicao.size() - 1);
				aux.setComposicao(null);
				return true;
			}
		}else{
			return false;
		}
	}

	public boolean desengataVagao() {
		if (elementosComposicao.get(elementosComposicao.size()).getClass().getName().contains("Vagao")){
			ElementoDeComposicao aux = elementosComposicao.remove(elementosComposicao.size() - 1);
			aux.setComposicao(null);
			return true;
		} else {
			return false;
		}
	}

	public boolean removerUltimoElemento(){
		if(elementosComposicao.isEmpty()){
			return false;
		} else{
			elementosComposicao.get(elementosComposicao.size()-1).setComposicao(null);
			elementosComposicao.remove(elementosComposicao.size()-1);
			return true;
		}
		
	}

	public String toLineFile(){
		String aux = "";
		aux += this.getIdentificador();
		return aux;
	}

	@Override
	public String toString() {
		return "Composicao [elementosComposicao=" + elementosComposicao + ", identificador=" + identificador + "]";
	}
}
