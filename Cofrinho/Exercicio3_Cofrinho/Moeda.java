public class Moeda{
    private NomeMoeda nome;

    public Moeda(NomeMoeda nome){
        this.nome = nome;
    }

    public NomeMoeda getNomeMoeda(){
        return nome;
    }

    public int getValorCentavos(){
        switch(nome){
            case UmReal: return 100;
            case CinquentaCentavos: return 50;
            case VinteCincoCentavos: return 25;
            case DezCentavos: return 10;
            case CincoCentavos: return 5;
            case UmCentavo: return 1;
            default: return 0;
        }
    }

    public double getValorReais(){
        switch(nome){
            case UmReal: return 1.0;
            case CinquentaCentavos: return 0.5;
            case VinteCincoCentavos: return 0.25;
            case DezCentavos: return 0.1;
            case CincoCentavos: return 0.05;
            case UmCentavo: return 0.01;
            default: return 0.0;
        }
    }

    public String toString(){
        return nome.toString();
    }
}