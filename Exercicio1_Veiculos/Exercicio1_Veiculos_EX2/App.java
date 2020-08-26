import java.util.*;
import java.util.Scanner;

public class App{
    static ArrayList<Veiculo> vehicles = new ArrayList<Veiculo>(); // Create an ArrayList object

    public static Veiculo verificaPlaca (String placa){
        boolean temp = false;
        for (int i = 0; i < vehicles.size(); i++) {
            if ((vehicles.get(i).getPlaca().getCodigo()).equals(placa)){
                temp = true;
                return vehicles.get(i);
            }
            if(temp==true){break;}
        }
        return vehicles.get(0); //se não encontrar a placa buscada, retorna a placa "Base".
    }
    
    public static void main(String args[]){
        Scanner ler_dados = new Scanner(System.in);
        int choice = 0;
        String tempPlaca;
        double distancia;
        
        Placa p0 = new Placa("BASE","BAS0E00");
        Placa p1 = new Placa("Brasil","ABC1R23");
        Placa p2 = new Placa ("França","FRA2C54");
        Placa p3 = new Placa ("Alemanha","ALE5M65");
        Placa p4 = new Placa ("Uruguai","URU7G23");
        Placa p5 = new Placa ("Argentina","ARG8T09");


        Veiculo veiculoBase = new Veiculo(p0);
        Veiculo v1 = new Veiculo(p1);
        Veiculo v2 = new Veiculo(p2);
        Veiculo v3 = new Veiculo(p3);
        Veiculo v4 = new Veiculo(p4);
        Veiculo v5 = new Veiculo(p5);
        

        vehicles.add(veiculoBase);
        vehicles.add(v1);
        vehicles.add(v2);
        vehicles.add(v3);
        vehicles.add(v4);
        vehicles.add(v5);

        while (choice != 3) {
            System.out.println("Escolha uma opção:");
            System.out.println("1)Abastecer\n2)Dirigir\n3)Fim");
            choice = ler_dados.nextInt();

            if(choice == 1) {
                System.out.println("Digite a placa do Veiculo a ser abastecido:");
                tempPlaca = ler_dados.next();

                Veiculo tempVeiculo = verificaPlaca(tempPlaca); //Veiculo encontrado na verificação.

                if(tempVeiculo.getPlaca().getCodigo() == "BAS0E00"){
                    System.out.println("Veiculo não encontrado");
                    System.out.println("----------------\n");
                } else {
                    System.out.println("Digite a quantidade de combustível em Litros:");
                    double tempLitros = ler_dados.nextDouble();
                    System.out.println("Dados do veiculo depois de abastecer:");
                    System.out.println("Combustível disponível: "+tempVeiculo.abastece(tempLitros)+"L.");
                    System.out.println("----------------");
                }
            } else if (choice == 2){
                System.out.println("Digite a placa do Veiculo a ser dirigido:");
                tempPlaca = ler_dados.next();

                Veiculo tempVeiculo = verificaPlaca(tempPlaca); //Veiculo encontrado na verificação.
                System.out.println(tempVeiculo);
                if(tempVeiculo.getPlaca().getCodigo().equals("BAS0E00")){
                    System.out.println("Veiculo não encontrado");
                    System.out.println("----------------\n");
                } else {
                    System.out.println("Digite a distância a ser percorrida:");
                    distancia = ler_dados.nextDouble();
                    tempVeiculo.dirige(distancia);
                    System.out.println("Dados do veiculo depois de percorrer "+ distancia+" Quilometros");
                    System.out.println(tempVeiculo);
                    System.out.println("----------------");
                }
            } else if (choice == 3){
                vehicles.forEach((n) -> System.out.println(n)); 
            }
            
        }
        

        
        }
}