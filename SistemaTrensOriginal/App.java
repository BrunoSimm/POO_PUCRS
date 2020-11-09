public class App {
    private static void imprimeComposicao(Composicao trem) {
        System.out.println("Composicao: " + trem.getIdentificador());
        System.out.println(trem);

        for (int i = 0; i < trem.getQtdadeLocomotivas(); i++) {
            System.out.println(trem.getLocomotiva(i));
        }
        for (int i = 0; i < trem.getQtdadeVagoes(); i++) {
            System.out.println(trem.getVagao("VagaoCarga",i));
        }
    }

    public static void main(String args[]) {
        CadastroVagoes cv = new CadastroVagoes();
        cv.carrega("VagaoCarga");
        cv.carrega("VagaoPassageiros");
        CadastroLocomotivas cl = new CadastroLocomotivas();
        cl.carrega();
        //CadastroComposicoes cc = new CadastroComposicoes();
        //cc.carrega();

        System.out.println("Cadastro de vagoes de Carga:");
            for (int i = 0; i < cv.getQtdade("VagaoCarga"); i++) {
                System.out.println(cv.getPorPosicao("VagaoCarga",i).toString());
            }
        System.out.println("Cadastro de vagoes de Passageiros:");
            for (int i = 0; i < cv.getQtdade("VagaoPassageiros"); i++) {
                System.out.println(cv.getPorPosicao("VagaoPassageiros",i).toString());
            }
        System.out.println("Cadastro de locomotivas:");
            for (int i = 0; i < cl.getQtdade(); i++) {
                System.out.println(cl.getPorPosicao(i));
            }

        // Atencao: este trecho de código foi usado para criar as
        // composicoes que estao no arquivo composicoes.txt
        // Cuidado ao retirar os comentários !!
        /*
        try{
            Composicao t1 = new Composicao(6656,cl.getPorId(20));//Associando uma locomotiva incial
            t1.engataVagao(cv.getPorId("VagaoCarga",30)); 
            t1.engataVagao(cv.getPorId("VagaoCarga",40));
            t1.engataVagao(cv.getPorId("VagaoCarga",50));
            t1.engataVagao(cv.getPorId("VagaoPassageiros",51));
            cc.cadastra(t1);
            System.out.println(cc.getPorIdentificador(6656).getQtdadeVagoes());
        } catch(NullPointerException e){
            System.out.println("Locomotiva inicial deve ser diferente de nulo e precisa estar livre1");
        }
        try {
            Composicao t2 = new Composicao(9712,cl.getPorId(10)); //Associando uma locomotiva inicial
            t2.engataLocomotiva(cl.getPorId(50)); 
            t2.engataVagao(cv.getPorId("VagaoCarga",100));
            t2.engataVagao(cv.getPorId("VagaoCarga",110));
            t2.engataVagao(cv.getPorId("VagaoCarga",120));
            t2.engataVagao(cv.getPorId("VagaoCarga",130));
            t2.engataVagao(cv.getPorId("VagaoPassageiros",11));
            cc.cadastra(t2);
        } catch (NullPointerException e) {
            System.out.println("Locomotiva inicial deve ser diferente de nulo e precisa estar livre2");
        }
        */

        /*
        System.out.println("Cadastro de composicoes:");
            for (int i = 0; i < cc.getQtdade(); i++) {
                imprimeComposicao(cc.getPorPosicao(i));
            }
*/

        
        cv.persiste("VagaoCarga");
        cv.persiste("VagaoPassageiros");
        cl.persiste();
        //cc.persiste();

        System.out.println("Fim: dados salvos");

    }
}