import java.util.ArrayList;

public class Composicao {
	//private ArrayList<VagaoCarga> vagoesCargas;
	//private ArrayList<VagaoPassageiros> vagoesPassageiros;
	//private ArrayList<Locomotiva> locomotivas;
	private ArrayList<ElementoDeComposicao> elementosComposicao;
	private int identificador;

	public Composicao(int identificador,Locomotiva locomotivaInicial){//Utilizado na criação de novas composições
		if(locomotivaInicial != null){
			this.identificador = identificador;
			elementosComposicao = new ArrayList<>();
			elementosComposicao.add(locomotivaInicial);
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
				System.out.println("Encontrei no contains na Composicao");
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
		if ((vagoesCargas.size() + vagoesPassageiros.size()) != 0 || locomotiva.getComposicao() != -1) {
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
		for (VagaoCarga v : vagoesCargas) {
			peso += v.getCapacidadeCarga();
		}
		for(VagaoPassageiros p: vagoesPassageiros){
			peso += p.getQtdPassageiros()*70;
		}
		return peso;
	}

	public boolean engataVagao(VagaoCarga vagao) {
		if (locomotivas.size() == 0 || vagao.getComposicao() != -1) {
			return false;
		} else {
			if ((vagoesCargas.size()+vagoesPassageiros.size()) < maxVagoesNaComposicao()
					&& pesoAtualDaComposicao() + vagao.getCapacidadeCarga() <= pesoMaxNaComposicao()) {
				vagao.setComposicao(this);
				vagoesCargas.add(vagao);
				componentesTrem.add(vagao);
				return true;
			} else {
				return false;
			}
		}
	}
	public boolean engataVagao(VagaoPassageiros vagao){
		if (locomotivas.size() == 0 || vagao.getComposicao() != -1) {
			return false;
		} else {
			if ((vagoesCargas.size() + vagoesPassageiros.size()) < maxVagoesNaComposicao()
					&& pesoAtualDaComposicao() + (vagao.getQtdPassageiros()*70) <= pesoMaxNaComposicao()) {
				vagao.setComposicao(this);
				vagoesPassageiros.add(vagao);
				return true;
			} else {
				return false;
			}
		}
	}
	

	public boolean desengataLocomotiva() {
		if (locomotivas.size() > 0) {
			if (vagoesCargas.size() > 0 && vagoesPassageiros.size() > 0) {
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
		if (vagoesCargas.size() + vagoesPassageiros.size() > 0) {
			VagaoCarga aux = vagoes.remove(vagoes.size() - 1);
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
