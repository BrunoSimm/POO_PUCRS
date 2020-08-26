public class App{
    public static void main(String args[]){
        Placa p1 = new Placa("Brasil","ABC1R23");
        Placa p2 = new Placa ("França","FRA2C54");
        
        Veiculo v2 = new Veiculo(p2);
        Veiculo v3 = new Veiculo(p2);

        System.out.println("Veiculo 2: "+ v2);
        System.out.println("Veiculo 3: "+ v3);
        System.out.println("----------------");
        v2.setPais("Alemanha");
        System.out.println("Veiculo 2: "+ v2);
        System.out.println("Veiculo 3: "+ v3);
        System.out.println("----------------");

        /*
         Por que as informações de ambos os veículos foram alteradas?
         R: Porque na construção de v2 e v3 é passado por parametro a posição na memória de
         uma instância de Placa (p2). Dessa forma, ao chamar v2.setPais() é alterado diretamente
         na posição de memória de p2.
        */
        Veiculo v = new Veiculo(p1);
        System.out.println("Dados do veiculo antes de abastecer:");
        System.out.println(v);
        System.out.println("----------------");

        v.abastece(65);
        System.out.println("Dados do veiculo depois de abastecer:");
        System.out.println(v);
        System.out.println("----------------");

        v.dirige(250);
        System.out.println("Dados do veiculo depois de percorrer 250Km:");
        System.out.println(v);
        System.out.println("----------------");
        }
}