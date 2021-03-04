/**
 * Atenção: A leitura e gravação das composições foram modificadas. O arquivo composicoes.txt recebe apenas 
 * o identificador de cada composição. Como em locomotivas.txt e vagoesCarga.txt e vagoesPassageiros.txt temos a informação de qual composição cada um destes elementos pertence, desenvolvi o método em Cadastro de Composições chamado "alimentaComposicoes(cl,cv)". 
 * Este método irá varrer todas as locomotivas e todos os vagões e então associar estes elementos a sua respectiva composição.
*/
public class App {
    private static void imprimeComposicao(Composicao trem) {
        System.out.println("\tComposicao: " + trem.getIdentificador());
        System.out.println("\t\tNumero de Locomotivas: "+trem.getQtdadeLocomotivas());
        System.out.println("\t\tNumero de Vagoes: "+trem.getQtdadeVagoes());

       /* for (int i = 0; i < trem.getQtdadeLocomotivas(); i++) {
            System.out.println(trem.getLocomotiva(i));
        }
        for (int i = 0; i < trem.getQtdadeVagoes(); i++) {
            System.out.println(trem.getVagao("VagaoCarga",i));
        }
        */
    }

    public static void main(String args[]) {
        CadastroComposicoes cc = new CadastroComposicoes();
        cc.carrega();
        CadastroLocomotivas cl = new CadastroLocomotivas();
        cl.carrega();
        CadastroVagoes cv = new CadastroVagoes();
        cv.carrega("VagaoCarga");
        cv.carrega("VagaoPassageiros");

        cc.alimentaComposicoes(cl,cv); //Adiciona nas suas respectivas composições as locomotivas e vagoes.

        //Realizando testes de inserção, eliminação e edição de elementos em composições.

        //Adicionando novo vagão de carga em uma composição já criada. 
        System.out.println("Teste de inserção de Vagão de Carga: "+cc.getPorIdentificador(6656).engataVagao(cv.getPorId("VagaoCarga",70))+".\nStatus do vagão: "+cv.getPorId("VagaoCarga", 70)); 

        //Adicionando novo vagão de passageiros em uma composição já criada. 
        System.out.println("\nTeste de inserção de Vagão de Passageiros: "+cc.getPorIdentificador(6656).engataVagao(cv.getPorId("VagaoPassageiros",71))+".\nStatus do vagão: "+cv.getPorId("VagaoPassageiros",71));

        //Inserir locomotiva em Composição já criada.
        System.out.println("\nTeste de inserção de Locomotiva: "+cc.getPorIdentificador(6656).engataLocomotiva(cl.getPorId(30))+".\nStatus da Locomotiva: "+cl.getPorId(30));

        //Removendo ultimo elemento da composição
        System.out.println("\nTeste de remoção de ultimo elemento.\n\tNumero de vagões antes da remoção: "+cc.getPorIdentificador(9712).getQtdadeVagoes()+
        ".\n\tRemovendo ultimo elemento.Resultado: "+cc.getPorIdentificador(9712).removerUltimoElemento()+
        ".\n\tNumero de vagões depois da remoção:"+cc.getPorIdentificador(9712).getQtdadeVagoes()+".");

        //Listar locomotivas e vagões livres/ocupadas
        System.out.println("\nCadastro de Vagoes de Carga:");
            for (int i = 0; i < cv.getQtdade("VagaoCarga"); i++) {
                System.out.println("\t"+cv.getPorPosicao("VagaoCarga",i).toString());
            }
        System.out.println("\nCadastro de Vagões de Passageiros:");
            for (int i = 0; i < cv.getQtdade("VagaoPassageiros"); i++) {
                System.out.println("\t"+cv.getPorPosicao("VagaoPassageiros",i).toString());
            }
        System.out.println("\nCadastro de Locomotivas:");
            for (int i = 0; i < cl.getQtdade(); i++) {
                System.out.println("\t"+cl.getPorPosicao(i));
            }

        // Atencao: este trecho de código foi usado para criar as
        // composicoes que estao no arquivo composicoes.txt
        // Cuidado ao retirar os comentários !!
        //**IMPORTANTE: Caso queira testar a criação das composições é necessário alterar os valores de composição nos arquivos VagaoCarga,VagaoPassageiros e Locomotivas para -1.
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
            System.out.println("Locomotiva inicial deve ser diferente de nulo e precisa estar livre");
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
            System.out.println("Locomotiva inicial deve ser diferente de nulo e precisa estar livre");
        }
        
*/
        
        System.out.println("\nCadastro de Composicoes:");
            for (int i = 0; i < cc.getQtdade(); i++) {
                imprimeComposicao(cc.getPorPosicao(i));
            }
        
        cv.persiste("VagaoCarga");
        cv.persiste("VagaoPassageiros");
        cl.persiste();
        cc.persiste();

        System.out.println("Fim: dados salvos");

    }
}