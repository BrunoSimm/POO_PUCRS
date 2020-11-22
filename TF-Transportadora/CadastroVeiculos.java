import java.util.Collections;
import java.util.LinkedList;

public class CadastroVeiculos {
    private LinkedList<Veiculo> veiculos;

    public CadastroVeiculos() {
        this.veiculos = new LinkedList<Veiculo>();
    }

    public boolean cadastrar(Veiculo veiculo){
        if(veiculo != null){
            this.veiculos.add(veiculo);
            return true;
        } else {
            return false;
        }
    }

    
    public void listarVeiculos(){
        LinkedList<Veiculo> temp = new LinkedList<Integer>();

        Collections.sort(veiculos); //WORDKEEEEEEED!

        for (Veiculo v : veiculos) {
            System.out.println(v.getAnoFabricacao());
        }
        /*
            //USAR compareTo que foi implementado
        for (Veiculo v : veiculos) {
            anos.add(v.getAnoFabricacao());
        }

        Collections.sort(veiculos);
        System.out.println("Veiculos em ordem de ano de fabrição:");
        for (int ano : anos) {
            System.out.println(ano);
        }
        */
    }
}
