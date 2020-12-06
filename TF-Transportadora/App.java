import java.time.LocalDate;
import java.util.Scanner;

public class App {

    public static LocalDate validaData(String data){
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
    }
    public static void main(String[] args) {
        CadastroFuncionarios cadastroFuncionarios = new CadastroFuncionarios();
        CadastroVeiculos cVeiculos = new CadastroVeiculos();
        CadastroFretamentos cFretamentos = new CadastroFretamentos();
        mostraMenu(cadastroFuncionarios,cVeiculos,cFretamentos);
        
        
        
        //Cadastro de Funcionários - Base
        Funcionario f = new Funcionario("Ciclano",validaData("1995-08-05"),"54655");
        cadastroFuncionarios.cadastrar(f);
        cadastroFuncionarios.cadastrar(new Funcionario("bruno", validaData("1998-02-04"),"41111"));//Refazer, funcionario deve ser abstract
        cadastroFuncionarios.cadastrar(new Funcionario("aruno", validaData("1998-11-05"),"41111"));
        cadastroFuncionarios.cadastrar(new Funcionario("aaruno", validaData("1998-12-05"),"41111"));
        cadastroFuncionarios.cadastrar(new FuncionarioMotorista("Bruno",validaData("1998-08-05"),"04057357076","numeroCNH", "E", validaData("2020-08-05"),true,true));
        cadastroFuncionarios.listarFuncionarios();
        cadastroFuncionarios.listarMotoristasLivres();
        

        //Cadastro de Veiculos - Base
        cVeiculos.cadastrar(new VeiculoCargas("123abc", "1asdasd", 10, 800, 5000, 4, true));
        cVeiculos.cadastrar(new VeiculoCargas("123abc", "asdasd", 12, 800, 5000, 4, true));
        cVeiculos.cadastrar(new VeiculoCargas("123abcd", "asdasd", 8, 800, 5000, 4, true));
        cVeiculos.cadastrar(new VeiculoCargas("123abc", "asdasd", 45, 800, 5000, 4, true));
        cVeiculos.cadastrar(new VeiculoCargas("123abc", "asdasd", 1, 800, 5000, 4, true));
        VeiculoPassageiros v1 = new VeiculoPassageiros("1", "modelo", 2016, 10000, 15);
        VeiculoCargas v2 = new VeiculoCargas("placa", "modelo", 2012, 50000, 5000, 6, false);
        cVeiculos.cadastrar(v1);
        cVeiculos.cadastrar(v2);
        cVeiculos.listarVeiculos();
        cVeiculos.listarVeiculosLivres();

        //try {
        //Cadastro de Fretamentos - Base
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
        cFretamentos.cadastrar(freteCarga4);
        cFretamentos.listarfretamentosAtivos();
        cFretamentos.listarHistoricoFretamentos();
        cFretamentos.cincoMaisLucrativos();             
    }
}
