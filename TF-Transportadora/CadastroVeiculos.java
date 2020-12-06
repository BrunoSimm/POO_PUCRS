import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

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
            System.out.println("Modelo: "+v.getModelo() +" Fabricação:"+v.getAnoFabricacao()+" Placa:"+v.getPlaca() +" Livre: "+v.isLivre());
        }
    }

    public Veiculo getByPlaca(String placa){
        Veiculo temp = null;
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equals(placa)){
                temp = v;
            }
        }
        if (temp == null){
            Scanner sc = new Scanner(System.in);
            System.out.println("Veiculo não cadastrado. Digite uma placa para busca:");
            this.listarVeiculos();
            String placa1 = sc.nextLine();
            return getByPlaca(placa1);
        } else {
            return temp;
        }
    }

    public void listarVeiculosLivres(){
        System.out.println("\nVeiculos Livres:");
        veiculos.stream()
            .filter(v -> v.isLivre() == true)
            .forEach(vL -> {
                    System.out.println("Veiculo Livre: "+vL.getModelo()+" Tipo:"+vL.getClass().getName()+" Placa: "+vL.getPlaca());
            });
            
    }
}
