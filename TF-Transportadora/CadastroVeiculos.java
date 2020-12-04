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
        LinkedList<Veiculo> temp = new LinkedList<Veiculo>();
        temp = veiculos;
        Collections.sort(temp); //compareTo() implementado para a classe Veiculo

        System.out.println("\nVeiculos em ordem por ano de fabricação:");
        for (Veiculo v : temp) {
            System.out.println("Modelo: "+v.getModelo() +" Fabricação:"+v.getAnoFabricacao());
        }
    }

    public Veiculo getByPlaca(String placa){
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equals(placa)){
                return v;
            }
        }
        return null;
    }

    public void listarVeiculosLivres(){
        veiculos.stream()
            .filter(v -> v.isLivre() == true)
            .forEach(vL -> {
                    System.out.println("Veiculo Livre: "+vL.getModelo()+" Tipo:"+vL.getClass().getName()+" Placa: "+vL.getPlaca());
            });
            
    }
}
