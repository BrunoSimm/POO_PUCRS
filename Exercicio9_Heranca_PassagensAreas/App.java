public class App {
    public static void main(String[] args) {
        Passagem p1 = new Passagem("04057357076", "bruno", "4F", 498);
        System.out.println(p1);
        int[] pesos = {2,3,1};
        p1.custoBagagem(3, pesos);
        System.out.println(p1.custoTotal);
        p1.defineAssento("4F2");
        System.out.println(p1);

        Passagem p2 = new Economy("123123", "Economy", "2A", 250);
        p2.custoBagagem(3, pesos);
        p2.defineAssento("2A2");

        Passagem p3 = new Executive("323232", "Executive", "3A", 350);
        p3.custoBagagem(3, pesos);
        p3.defineAssento("3A2");

        Passagem p4 = new Premier("43434343", "Premier", "4A", 500);
        p4.custoBagagem(3, pesos);
        p4.defineAssento("4A2");

        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);



    }
}
