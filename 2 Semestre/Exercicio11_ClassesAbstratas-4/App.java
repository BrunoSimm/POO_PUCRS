public class App {
    public static boolean verificaDiferenciada(Embalagem embalagem){
        if ((embalagem.getClass().getName().equals("EmbalagemTroncoCone")) || (embalagem.getClass().getName().equals("EmbalagemConica"))){
            return true;
        } else return false;
    }
    public static void main(String[] args) {
        Embalagem e1 = new EmbalagemTroncoCone(1, "A1");
        System.out.println("Volume: "+((EmbalagemTroncoCone)e1).getVolume(5, 2, 4));
        System.out.println(e1);
        System.out.println("Embalagem Diferenciada: "+ verificaDiferenciada(e1));

        Embalagem.qtdade1();

        EmbalagemConica e2 = new EmbalagemTroncoCone(2, "codigoReferecia");
        
        System.out.println(e2.getCodigoReferecia());
        
        EmbalagemCaixa t = new EmbalagemCaixa(2,"as");
        System.out.println(t.getCodigoReferecia());
       
    }
}
