import java.time.LocalDate;
import java.util.Scanner;

public class App {

    public static LocalDate validaData(String data){ // Remover!
        //Fazer validação da string, caso errada solicitar digitar novamente. (while)
        return LocalDate.parse(data);
    }

    public static void solicitaEscolhas(CadastroFuncionarios cadastroFuncionarios,CadastroVeiculos cVeiculos,CadastroFretamentos cFretamentos,int escolha){
        //Classe Utilizada para executar as escolhas de funções.
        ProcessaEscolhas pE = new ProcessaEscolhas(cadastroFuncionarios,cVeiculos,cFretamentos);
        if (escolha < 0 || escolha > 11){
            System.out.println("Opção inválida, tente novamente.");
        } else {
            switch (escolha) {
                case 0:
                    System.out.println("Encerrando o programa...\nObrigado!");
                    break;
                case 1:
                    pE.processarEscolha(escolha);
                    break;
                case 2:
                    pE.processarEscolha(escolha);
                    break;
                case 3:
                    pE.processarEscolha(escolha);
                    break;
                case 4:
                    pE.processarEscolha(escolha);
                    break;
                case 5:
                    pE.processarEscolha(escolha);
                    break;
                case 6:
                    pE.processarEscolha(escolha);
                    break;
                case 7:
                    pE.processarEscolha(escolha);
                    break;
                case 8:
                    pE.processarEscolha(escolha);
                    break;
                case 9:
                    pE.processarEscolha(escolha);
                    break;
                case 10:
                    pE.processarEscolha(escolha);
                    break;
                case 11:
                    pE.processarEscolha(escolha);
                    break;
                default:
                    break;
            }
        }
    }

    public static void mostraMenu(CadastroFuncionarios cadastroFuncionarios,CadastroVeiculos cVeiculos,CadastroFretamentos cFretamentos){
        int escolha = -1;
        Scanner sc = new Scanner(System.in);
        while (escolha != 0){
            System.out.println("\nEscolha uma das funcionalidades:");
            System.out.println("\t1 - Cadastrar funcionário");
            System.out.println("\t2 - Listar funcionários em ordem alfabética");
            System.out.println("\t3 - Buscar funcionário por CPF");
            System.out.println("\t4 - Cadastrar veículo");
            System.out.println("\t5 - Listar veículos em ordem de ano de fabricação");
            System.out.println("\t6 - Buscar veículo por placa");
            System.out.println("\t7 - Cadastrar fretamento de veículo");
            System.out.println("\t8 - Listar motoristas Livres");
            System.out.println("\t9 - Listar veículos livres");
            System.out.println("\t10 - Listar histórico de fretamentos");
            System.out.println("\t11 - Listar top 5 veículos mais lucrativos");
            System.out.println("\t0 - Finalizar programa.");
            escolha = sc.nextInt();
            solicitaEscolhas(cadastroFuncionarios,cVeiculos,cFretamentos,escolha);
        }
        sc.close();
    }
    public static void main(String[] args) {
        // Compilar utilizando "javac App.java -encoding UTF-8" para corrigir acentos.
        CadastroFuncionarios cadastroFuncionarios = new CadastroFuncionarios();
        CadastroVeiculos cVeiculos = new CadastroVeiculos();
        CadastroFretamentos cFretamentos = new CadastroFretamentos();


        //Cadastro de Funcionários - Base
        Funcionario f = new FuncionarioAdminstrativo("Ciclano",validaData("1995-08-05"),"13910460054");
        cadastroFuncionarios.cadastrar(f);
        cadastroFuncionarios.cadastrar(new FuncionarioAdminstrativo("Fulano", validaData("1998-02-04"),"46817068096"));
        cadastroFuncionarios.cadastrar(new FuncionarioManobrista("Beltrano", validaData("1998-11-05"),"26424255095","512315133","C",LocalDate.parse("2022-05-06")));
        cadastroFuncionarios.cadastrar(new FuncionarioMotorista("Bruno", LocalDate.parse("1998-12-05"),"69049646000","123156445","D",LocalDate.parse("2024-04-07"),true,true));
        cadastroFuncionarios.cadastrar(new FuncionarioMotorista("Simm",validaData("1998-08-05"),"27442982042","989545454", "E", validaData("2020-08-05"),true,true));

        //Cadastro de Veiculos - Base
        cVeiculos.cadastrar(new VeiculoPasseio("HPU8816", "Toyota Corolla", 2021, 1500.0));
        cVeiculos.cadastrar(new VeiculoUtilitarios("NEV7063", "Hyundai Tucson", 2014, 2100.0));
        cVeiculos.cadastrar(new VeiculoCargas("CRK0806", "FORD F4000", 2008, 2400, 5000, 4, true));
        cVeiculos.cadastrar(new VeiculoCargas("MRI6371", "Iveco DAILY 70 C 16", 2010, 2600, 5000, 4, false));
        cVeiculos.cadastrar(new VeiculoCargas("MVD7388", "Volks 8.120 EURO III", 2015, 3600, 10000, 8, true));
        VeiculoCargas v2 = new VeiculoCargas("JGY1384", "Truck", 2019, 13000, 28000, 6, false);
        cVeiculos.cadastrar(new VeiculoPassageiros("JYW2362", "Renault Master", 2013, 2450, 15));
        cVeiculos.cadastrar(new VeiculoPassageiros("TOI6872", "Ford Transit", 2020, 3600, 46));
        VeiculoPassageiros v1 = new VeiculoPassageiros("JUV5361", "Ford Transit", 2018, 3400, 26);
        cVeiculos.cadastrar(v1);
        cVeiculos.cadastrar(v2);

        //Cadastro de Fretamentos - Base
        /*
        Fretamento ftPassageiros = new FretamentoVeiculoPassageiros(1,v1,(FuncionarioMotorista)cadastroFuncionarios.getByCPF("04057357076"),validaData("2020-08-05"),validaData("2020-08-07"),100);
        Fretamento ftCarga = new FretamentoVeiculoCarga(2, v2, (FuncionarioMotorista)cadastroFuncionarios.getByCPF("04057357076"), validaData("2020-08-05"),validaData("2020-08-07"), 300, true);
        FretamentoVeiculoCarga freteCarga1 = new FretamentoVeiculoCarga(3, v2,(FuncionarioMotorista)cadastroFuncionarios.getByCPF("04057357076"),validaData("2020-08-05"),validaData("2020-08-07"), 300, false);
        FretamentoVeiculoCarga freteCarga2 = new FretamentoVeiculoCarga(3, v2,(FuncionarioMotorista)cadastroFuncionarios.getByCPF("04057357076"),validaData("2020-08-05"),validaData("2020-08-07"), 400, false);
        FretamentoVeiculoCarga freteCarga3 = new FretamentoVeiculoCarga(3, v2,(FuncionarioMotorista)cadastroFuncionarios.getByCPF("04057357076"),validaData("2020-08-05"),validaData("2020-08-07"), 500, true);
        FretamentoVeiculoCarga freteCarga4 = new FretamentoVeiculoCarga(3, v2,(FuncionarioMotorista)cadastroFuncionarios.getByCPF("04057357076"),validaData("2020-08-05"),validaData("2020-08-07"), 600, false);
        cFretamentos.cadastrar(ftCarga);
        cFretamentos.cadastrar(ftPassageiros);
        cFretamentos.cadastrar(freteCarga1);
        cFretamentos.cadastrar(freteCarga2);
        cFretamentos.cadastrar(freteCarga3);
        cFretamentos.cadastrar(freteCarga4);*/

        mostraMenu(cadastroFuncionarios,cVeiculos,cFretamentos);     
    }
}
