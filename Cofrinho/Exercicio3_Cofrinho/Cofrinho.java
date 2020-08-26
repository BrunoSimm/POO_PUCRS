import java.util.ArrayList;

public class Cofrinho {
    private ArrayList<Moeda> moedas = new ArrayList<Moeda>();
    private int tamanhoCofre;

    public Cofrinho(int tamanho_newCofre){
        this.tamanhoCofre = tamanho_newCofre;
    }

    public void insereMoeda(Moeda novaMoeda){
        if (moedas.size() <= this.tamanhoCofre){
            moedas.add(novaMoeda);
        } else System.out.println("Numero limite de moedas atingido!");
    }

    public String retira_ultimaMoeda(){
        if (moedas.isEmpty() == true) {
            return null;
        } else {
            String temp = moedas.get(moedas.size()-1).toString();
            moedas.remove(moedas.size()-1);
            return temp;
        }
    }

    public int getQuantidadeMoedas(){
        return moedas.size();
    }

    public int getQuantidadeMoedasTipo(NomeMoeda nomeMoeda){
        int contador = 0;
        for (int i = 0; i < moedas.size(); i++) {
            if (moedas.get(i).getNomeMoeda() == nomeMoeda){
                contador++;
            }
        }
        return contador;
    }

    public int getValorTotalCentavos(){
        int contador = 0;
        for (int i = 0; i < moedas.size(); i++) {
            contador = contador + moedas.get(i).getValorCentavos();
        }
        return contador;
    }
    public double getValorTotalReais(){
        double contador = 0;
        for (int i = 0; i < moedas.size(); i++) {
            contador = contador + moedas.get(i).getValorReais();
        }
        return contador;
    }


}