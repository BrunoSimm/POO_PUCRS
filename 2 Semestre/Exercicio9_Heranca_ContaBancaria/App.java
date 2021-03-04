public class App {
    public static void main(String[] args) {
        ContaBancaria c1 = new ContaBancaria(1, "ContaPadrão", 0);
        System.out.println(c1.getClass());
        c1.deposito(100);
        c1.retirada(29.99);
        System.out.println("Saldo da conta "+c1.getNroConta()+": R$"+c1.getSaldo());

        String nif = "aaa";
        

        ContaBancaria c2 = new ContaRemunerada(2, "ContaRemunerada", 0, 0.1);
        System.out.println("\n"+c2.getClass());
        c2.deposito(1000);
        System.out.println("Saldo da conta "+c2.getNroConta()+": R$"+c2.getSaldo());
        c2.retirada(200);
        System.out.println("Saldo da conta "+c2.getNroConta()+": R$"+c2.getSaldo());

        ContaBancaria c3 = new ContaComLimite(3, "Conta Com Limite", 0, 500, 0.05);
        c3.deposito(1000);
        c3.retirada(600);
        System.out.println("\n"+c3.getClass());
        System.out.println("Saldo da conta "+c3.getNroConta()+": R$"+c3.getSaldo());
        System.out.println("Juros: R$"+((ContaComLimite)c3).getJuros());
        ((ContaComLimite)c3).quitaJuros();
        System.out.println("Juros: R$"+((ContaComLimite)c3).getJuros());

    }
}
