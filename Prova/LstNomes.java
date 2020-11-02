import java.util.ArrayList;

public class LstNomes{

    public static final int MAX = 200;

    private static int cont;

    private String id;

    private ArrayList<String> nomes;

 

    public LstNomes(String id) {

        nomes = new ArrayList<>();

        this.id = id;

    }

 

    public void insereNome(String nome){

        nomes.add(nome);

        cont++;

    }

 

    public static int qtdade1(){

        return cont;

    }

 

    public int qtdade2(){

        return nomes.size();

    }

    @Override //x  - b,c,d
    public String toString() {
        System.out.println(id+":");
        for(int i=0;i<nomes.size();i++){
            System.out.println(nomes.get(i));
        }
     }

    
}