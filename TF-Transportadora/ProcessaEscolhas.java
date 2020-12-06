import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ProcessaEscolhas implements DateMatcher{
    CadastroFuncionarios cadastroFuncionarios;
    CadastroVeiculos cVeiculos;
    CadastroFretamentos cFretamentos;

    public ProcessaEscolhas(CadastroFuncionarios cadastroFuncionarios, CadastroVeiculos cVeiculos,
            CadastroFretamentos cFretamentos) {
        this.cadastroFuncionarios = cadastroFuncionarios;
        this.cVeiculos = cVeiculos;
        this.cFretamentos = cFretamentos;
    }

    public void processarEscolha(int escolha){
        int x = -1;
        Scanner sc = new Scanner(System.in);
        
        switch (escolha) {
            case 1:
                while (x != 0){
                    System.out.println("Digite o tipo de funcionário a ser adicionado:");
                    System.out.println("\t1 - Funcionario Administrativo");
                    System.out.println("\t2 - Funcionario Manobrista");
                    System.out.println("\t3 - Funcionario Motorista");
                    System.out.println("\t0 - Escolher outra funcionalidade.");
                    x = sc.nextInt();
                    switch (x) {
                        case 0:
                            x = 0;
                            break;
                        case 1:
                            System.out.println("Digite o nome:");
                            sc.nextLine();
                            String nome = sc.nextLine();
                            System.out.println("Digite a data de nascimento: (Ex:2020-12-25)");
                            String dataNascimento = sc.nextLine();
                            System.out.println("Digite o CPF:");
                            String cpf = sc.nextLine();
                            cadastroFuncionarios.cadastrar(new FuncionarioAdminstrativo(nome, validaData(dataNascimento), cpf));
                            break;
                        case 2:
                            System.out.println("Digite o nome:");
                            sc.nextLine();
                            String nomeMano = sc.nextLine();
                            System.out.println("Digite a data de nascimento: (Ex:2020-12-25)");
                            String dataNascimentoMano = sc.nextLine();
                            System.out.println("Digite o CPF:");
                            String cpfMano = sc.nextLine();
                            System.out.println("Digite o numero da CNH:");
                            String numeroCNH = sc.nextLine();
                            System.out.println("Digite a categoria da CNH(B,C,D,E):");
                            String categoriaCNH = sc.nextLine();
                            System.out.println("Digite a data de vencimento da CNH: (Ex:2020-12-25)");
                            String dataVencimentoCNH = sc.nextLine();
                            cadastroFuncionarios.cadastrar(new FuncionarioManobrista(nomeMano, validaData(dataNascimentoMano), cpfMano,numeroCNH,categoriaCNH,validaData(dataVencimentoCNH)));
                            break;
                        case 3:
                            System.out.println("Digite o nome:");
                            sc.nextLine();
                            String nomeMoto = sc.nextLine();
                            System.out.println("Digite a data de nascimento: (Ex:2020-12-25)");
                            String dataNascimentoMoto = sc.nextLine();
                            System.out.println("Digite o CPF:");
                            String cpfMoto = sc.nextLine();
                            System.out.println("Digite o numero da CNH:");
                            String numeroCNH_Moto = sc.nextLine();
                            System.out.println("Digite a categoria da CNH(B,C,D,E):");
                            String categoriaCNH_Moto = sc.nextLine();
                            System.out.println("Digite a data de vencimento da CNH: (Ex:2020-12-25)");
                            String dataVencimentoCNH_Moto = sc.nextLine();
                            System.out.println("Possui curso de carga perigosa? (Sim - True | Não - False");
                            Boolean cargaPerigosa = sc.nextBoolean();
                            System.out.println("Possui curso de transporte de Passageiros? (Sim - True | Não - False");
                            Boolean tPassageiros = sc.nextBoolean();
                            cadastroFuncionarios.cadastrar(new FuncionarioMotorista(nomeMoto, validaData(dataNascimentoMoto), cpfMoto,numeroCNH_Moto,categoriaCNH_Moto,validaData(dataVencimentoCNH_Moto),cargaPerigosa,tPassageiros));
                            break;
                        default:
                            break;
                    }
                }
            break;
            case 2:
                cadastroFuncionarios.listarFuncionarios();
            break;
            case 3:
                System.out.println("Digite o CPF que deseja buscar:");
                String cpf3 = sc.nextLine();
                Funcionario f = cadastroFuncionarios.getByCPF(cpf3);
                System.out.println(f == null ? "Funcionario não cadastrado." : ""+f.getNome()+" CPF:"+f.getCpf()+" | "+f.getClass().getName());
            break;
            case 4:
                while (x != 0){
                    System.out.println("Digite o tipo de veículo a ser adicionado:");
                    System.out.println("\t1 - Veiculo Carga");
                    System.out.println("\t2 - Veiculo Passageiros");
                    System.out.println("\t3 - Veiculo Passeio");
                    System.out.println("\t4 - Veiculo Utilitários");
                    System.out.println("\t0 - Escolher outra funcionalidade.");
                    x = sc.nextInt();
                    switch (x) {
                        case 0:
                            x = 0;
                            break;
                        case 1:
                            System.out.println("Digite a placa:");
                            sc.nextLine();
                            String placa = sc.nextLine();
                            System.out.println("Digite o modelo:");
                            String modelo = sc.nextLine();
                            System.out.println("Digite o ano de fabricação:");
                            int anoFabricacao = sc.nextInt();
                            System.out.println("Digite o peso:");
                            double peso = sc.nextDouble();
                            System.out.println("Digite a capacidade de Carga:");
                            double capacidadeCarga = sc.nextDouble();
                            System.out.println("Digite o numero de Eixos:");
                            int nrEixos = sc.nextInt();
                            System.out.println("Possui unidade acoplada? (Sim - True | Não - False");
                            boolean unidadeAcoplada = sc.nextBoolean();
                            cVeiculos.cadastrar(new VeiculoCargas(placa, modelo, anoFabricacao, peso, capacidadeCarga, nrEixos, unidadeAcoplada));
                        break;
                        case 2:
                            System.out.println("Digite a placa:");
                            sc.nextLine();
                            String placaP = sc.nextLine();
                            System.out.println("Digite o modelo:");
                            String modeloP = sc.nextLine();
                            System.out.println("Digite o ano de fabricação:");
                            int anoFabricacaoP = sc.nextInt();
                            System.out.println("Digite o peso:");
                            double pesoP = sc.nextDouble();
                            System.out.println("Digite a lotação Máxima do veiculo: (15,26,46)");
                            int lotacaoMaxima = sc.nextInt();
                            cVeiculos.cadastrar(new VeiculoPassageiros(placaP, modeloP, anoFabricacaoP, pesoP, lotacaoMaxima));
                        break;
                        case 3:
                            System.out.println("Digite a placa:");
                            sc.nextLine();
                            String placaPasseio = sc.nextLine();
                            System.out.println("Digite o modelo:");
                            String modeloPasseio = sc.nextLine();
                            System.out.println("Digite o ano de fabricação:");
                            int anoFabricacaoPasseio = sc.nextInt();
                            System.out.println("Digite o peso:");
                            double pesoPasseio = sc.nextDouble();
                            cVeiculos.cadastrar(new VeiculoPasseio(placaPasseio, modeloPasseio, anoFabricacaoPasseio, pesoPasseio));
                        break;
                        case 4:
                            System.out.println("Digite a placa:");
                            sc.nextLine();
                            String placaUtilitarios = sc.nextLine();
                            System.out.println("Digite o modelo:");
                            String modeloUtilitarios = sc.nextLine();
                            System.out.println("Digite o ano de fabricação:");
                            int anoFabricacaoUtilitarios = sc.nextInt();
                            System.out.println("Digite o peso:");
                            double pesoUtilitarios = sc.nextDouble();
                            cVeiculos.cadastrar(new VeiculoUtilitarios(placaUtilitarios, modeloUtilitarios, anoFabricacaoUtilitarios, pesoUtilitarios));
                        break;
                        default:
                        break;
                    }
                }
            break;
            case 5:
                cVeiculos.listarVeiculos();
            break;
            case 6:
                System.out.println("Digite a Placa que deseja buscar:");
                String placa = sc.nextLine();
                Veiculo f1 = cVeiculos.getByPlaca(placa);
                System.out.println(f1 == null ? "Veiculo não cadastrado." : "Resultado da busca:\n"+f1.getPlaca() +" - "+f1.getModelo()+" | "+f1.getAnoFabricacao()+" | Livre: "+f1.isLivre());
            break;
            case 7:
                while (x != 0){
                    System.out.println("Digite o tipo de frete a ser cadastrado:");
                    System.out.println("\t1 - Frete Passageiros");
                    System.out.println("\t2 - Frete Carga");
                    System.out.println("\t0 - Escolher outra funcionalidade.");
                    x = sc.nextInt();
                    switch (x) {
                        case 0:
                            x = 0;
                            break;
                        case 1:
                            cVeiculos.listarVeiculosLivres();
                            System.out.println("Digite a placa do veiculo de passageiros livre:");
                            sc.nextLine();
                            String placa1 = sc.nextLine();
                            cadastroFuncionarios.listarMotoristasLivres();
                            System.out.println("Digite o CPF do motorista com CNH 'D' e Livre:");
                            String cpf1 = sc.nextLine();
                            System.out.println("Digite a data de inicio do frete:(Ex:2020-12-25)");
                            String dataInicio1 = sc.nextLine();
                            System.out.println("Digite a data de termino do frete:(Ex:2020-12-28)");
                            String dataTermino1 = sc.nextLine();
                            System.out.println("Digite a distancia:");
                            double distancia1 = sc.nextDouble();
                            try {
                                cFretamentos.cadastrar(new FretamentoVeiculoPassageiros((cFretamentos.getNumeroFretes()+1),((VeiculoPassageiros)cVeiculos.getByPlaca(placa1)),(FuncionarioMotorista)cadastroFuncionarios.getByCPF(cpf1), validaData(dataInicio1), validaData(dataTermino1), distancia1));
                            } catch (Exception e) {
                                System.out.println("Erro. Condutor deve estar devidamente habilitado para conduzir este veiculo.Tente novamente.");
                                x = -1; //Reinicia a escolha.
                            }
                          
                        break;
                        case 2:
                            cVeiculos.listarVeiculosLivres();
                            System.out.println("Digite a placa do veiculo de Carga livre:");
                            sc.nextLine();
                            String placa2 = sc.nextLine();
                            cadastroFuncionarios.listarMotoristasLivres();
                            System.out.println("Digite o CPF do motorista com CNH 'D' e Livre:");
                            String cpf2 = sc.nextLine();
                            System.out.println("Digite a data de inicio do frete:(Ex:2020-12-25)");
                            String dataInicio2 = sc.nextLine();
                            System.out.println("Digite a data de termino do frete:(Ex:2020-12-28)");
                            String dataTermino2 = sc.nextLine();
                            System.out.println("Digite a distancia:");
                            double distancia2 = sc.nextDouble();
                            System.out.println("Carga perigosa? Sim -> Digite: True | Não -> Digite: False");
                            boolean is_cargaPerigosa = sc.nextBoolean();
                            try {
                                cFretamentos.cadastrar(new FretamentoVeiculoCarga((cFretamentos.getNumeroFretes()+1),(VeiculoCargas)cVeiculos.getByPlaca(placa2),(FuncionarioMotorista)cadastroFuncionarios.getByCPF(cpf2),validaData(dataInicio2),validaData(dataTermino2), distancia2, is_cargaPerigosa));
                            } catch (Exception e) {
                                System.out.println("ERRO!. Condutor deve estar devidamente habilitado para conduzir este veiculo.Tente novamente.\n");
                                x = -1; 
                            }
                        break;
                        default:
                        break;
                    }  
                }  
            break;
            case 8:
                cadastroFuncionarios.listarMotoristasLivres();
            break;
            case 9:
                cVeiculos.listarVeiculosLivres();
            break;
            case 10:
                cFretamentos.listarHistoricoFretamentos();
            break;
            case 11:
                cFretamentos.cincoMaisLucrativos();
            break;
            default:
                break;
        }
    }
    public LocalDate validaData(String data){
        //Ex:2020-12-25
        try {
            return LocalDate.parse(data);
        } catch (DateTimeParseException e) {
            int x = 0;
                while(x != 1){
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Formato de data inválido.\nDigite utilizando o padrão ANO-MÊS-DIA Ex: 2020-08-04");
                    String newData = sc.nextLine();
                    if (matches(newData) == true){
                        x = 1;
                        return LocalDate.parse(newData);
                    } else {
                        x=0;
                    }
                }
            return null;
        }
    }

    //Regex
    private static Pattern DATE_PATTERN = Pattern.compile(
      "^\\d{4}-\\d{2}-\\d{2}$");

    @Override
    public boolean matches(String date) {
        return DATE_PATTERN.matcher(date).matches();
    }
}
