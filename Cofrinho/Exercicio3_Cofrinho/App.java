public class App {
    public static void main(String args[]){
        Cofrinho cofrinho = new Cofrinho(12);

        cofrinho.insereMoeda(new Moeda(NomeMoeda.UmReal));
        cofrinho.insereMoeda(new Moeda(NomeMoeda.CinquentaCentavos));
        cofrinho.insereMoeda(new Moeda(NomeMoeda.VinteCincoCentavos));
        cofrinho.insereMoeda(new Moeda(NomeMoeda.UmReal));
        cofrinho.insereMoeda(new Moeda(NomeMoeda.CincoCentavos));
        cofrinho.insereMoeda(new Moeda(NomeMoeda.CinquentaCentavos));
        cofrinho.insereMoeda(new Moeda(NomeMoeda.UmReal));
        cofrinho.insereMoeda(new Moeda(NomeMoeda.DezCentavos));
        cofrinho.insereMoeda(new Moeda(NomeMoeda.UmCentavo));
        cofrinho.insereMoeda(new Moeda(NomeMoeda.VinteCincoCentavos));
        cofrinho.insereMoeda(new Moeda(NomeMoeda.UmReal));


        System.out.println("Quantidade de moedas inseridas: " + cofrinho.getQuantidadeMoedas());
        System.out.println("Quantidade de moedas de 1 real: " + cofrinho.getQuantidadeMoedasTipo(NomeMoeda.UmReal));
        System.out.println("Quantidade de moedas de 50 centavos: " + cofrinho.getQuantidadeMoedasTipo(NomeMoeda.CinquentaCentavos));
        System.out.println("Valor total em centavos: " + cofrinho.getValorTotalCentavos());
        System.out.println("Valor total em reais: " + cofrinho.getValorTotalReais());
        System.out.println("Moeda retirada: " + cofrinho.retira_ultimaMoeda());
        System.out.println("Moeda retirada: " + cofrinho.retira_ultimaMoeda());
        System.out.println("Valor total em centavos: " + cofrinho.getValorTotalCentavos());
    }
}