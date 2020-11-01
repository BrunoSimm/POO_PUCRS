public class App {
    private static void imprimeComposicao(Composicao trem) {
        System.out.println("Composicao: " + trem.getIdentificador());
        for (int i = 0; i < trem.getQtdadeLocomotivas(); i++) {
            System.out.println(trem.getLocomotiva(i));
        }
        for (int i = 0; i < trem.getQtdadeVagoes(); i++) {
            System.out.println(trem.getVagao(i));
        }
    }

    public static void main(String args[]) {
        CadastroVagoes cv = new CadastroVagoes();
        cv.carrega();
        CadastroLocomotivas cl = new CadastroLocomotivas();
        cl.carrega();
        CadastroComposicoes cc = new CadastroComposicoes();
        cc.carrega();

        System.out.println("Cadastro de vagoes:");
        for (int i = 0; i < cv.getQtdade(); i++) {
            System.out.println(cv.getPorPosicao(i));
        }
        System.out.println("Cadastro de locomotivas:");
        for (int i = 0; i < cl.getQtdade(); i++) {
            System.out.println(cl.getPorPosicao(i));
        }

        // Atencao: este trecho de código foi usado para criar as
        // composicoes que estao no arquivo composicoes.txt
        // Cuidado ao retirar os comentários !!
        /*
         * Composicao t1 = new Composicao(6656); t1.engataLocomotiva(cl.getPorId(20));
         * t1.engataVagao(cv.getPorId(30)); t1.engataVagao(cv.getPorId(40));
         * t1.engataVagao(cv.getPorId(50)); cc.cadastra(t1);
         * 
         * Composicao t2 = new Composicao(9712); t2.engataLocomotiva(cl.getPorId(10));
         * t2.engataLocomotiva(cl.getPorId(50)); t2.engataVagao(cv.getPorId(100));
         * t2.engataVagao(cv.getPorId(110)); t2.engataVagao(cv.getPorId(120));
         * t2.engataVagao(cv.getPorId(130)); t2.engataVagao(cv.getPorId(140));
         * cc.cadastra(t2);
         */

        System.out.println("Cadastro de composicoes:");
        for (int i = 0; i < cc.getQtdade(); i++) {
            imprimeComposicao(cc.getPorPosicao(i));
        }

        cv.persiste();
        cl.persiste();
        cc.persiste();

        System.out.println("Fim: dados salvos");

    }
}