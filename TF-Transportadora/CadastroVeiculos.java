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
            if (v instanceof VeiculoCargas){
                VeiculoCargas aux = (VeiculoCargas)v;
                System.out.println("\n\t"+v.getModelo()+" | Tipo: "+v.getClass().getName()+" | Placa: "+v.getPlaca()+" | Capacidade Carga: "+aux.getCapacidadeCarga()+" | Livre: "+v.isLivre());
            } else if (v instanceof VeiculoPassageiros){
                VeiculoPassageiros aux = (VeiculoPassageiros)v;
                System.out.println("\n\t"+v.getModelo()+" | Tipo: "+v.getClass().getName()+" | Placa: "+v.getPlaca()+" | Lotação Máxima: "+aux.getLotacaoMaxima()+" | Livre: "+v.isLivre());
            } else {
                System.out.println("\n\t"+v.getModelo()+" | Tipo: "+v.getClass().getName()+" | Placa: "+v.getPlaca()+" | Livre: "+v.isLivre());
            }
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
            sc.close();
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
                if (vL instanceof VeiculoCargas){
                    VeiculoCargas temp = (VeiculoCargas)vL;
                    System.out.println("\n\tVeiculo Livre: "+vL.getModelo()+" | Tipo: "+vL.getClass().getName()+" | Placa: "+vL.getPlaca()+" | Capacidade Carga: "+temp.getCapacidadeCarga());
                } else if (vL instanceof VeiculoPassageiros){
                    VeiculoPassageiros temp = (VeiculoPassageiros)vL;
                    System.out.println("\n\tVeiculo Livre: "+vL.getModelo()+" | Tipo: "+vL.getClass().getName()+" | Placa: "+vL.getPlaca()+" | Lotação Máxima: "+temp.getLotacaoMaxima());
                } else {
                    System.out.println("\n\tVeiculo Livre: "+vL.getModelo()+" | Tipo: "+vL.getClass().getName()+" | Placa: "+vL.getPlaca());
                }
                    
            });
            
    }
}
