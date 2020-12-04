import java.time.LocalDate;
import java.util.Scanner;

public class App {

    public static LocalDate validaData(String data){
        //Fazer validação da string, caso errada solicitar digitar novamente. (while)
        return LocalDate.parse(data);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        
        //Cadastro de Funcionários - Base
        Funcionario f = new Funcionario("teste",validaData("1995-08-05"),"54655");
        CadastroFuncionarios c1 = new CadastroFuncionarios();
        c1.cadastrar(f);
        c1.cadastrar(new Funcionario("bruno", validaData("1998-02-04"),"41111"));//Refazer, funcionario deve ser abstract
        c1.cadastrar(new Funcionario("aruno", validaData("1998-11-05"),"41111"));
        c1.cadastrar(new Funcionario("aaruno", validaData("1998-12-05"),"41111"));
        c1.cadastrar(new FuncionarioMotorista("Bruno",validaData("1998-08-05"),"04057357076","numeroCNH", "A", validaData("2020-08-05"),true,true));
        c1.listarFuncionarios();
        

        //Cadastro de Veiculos - Base
        CadastroVeiculos cv = new CadastroVeiculos();
        cv.cadastrar(new VeiculoCargas("123abc", "1asdasd", 10, 800, 5000, 4, true));
        cv.cadastrar(new VeiculoCargas("123abc", "asdasd", 12, 800, 5000, 4, true));
        cv.cadastrar(new VeiculoCargas("123abcd", "asdasd", 8, 800, 5000, 4, true));
        cv.cadastrar(new VeiculoCargas("123abc", "asdasd", 45, 800, 5000, 4, true));
        cv.cadastrar(new VeiculoCargas("123abc", "asdasd", 1, 800, 5000, 4, true));
        VeiculoPassageiros v1 = new VeiculoPassageiros("1", "modelo", 2016, 10000, 15);
        VeiculoCargas v2 = new VeiculoCargas("placa", "modelo", 2012, 50000, 5000, 6, false);
        cv.cadastrar(v1);
        cv.cadastrar(v2);
        cv.listarVeiculos();


        //Cadastro de Fretamentos - Base
        Fretamento ftPassageiros = new FretamentoVeiculoPassageiros(1,v1,(FuncionarioMotorista)c1.getByCPF("04057357076"),validaData("2020-08-05"),validaData("2020-08-07"),100);
        Fretamento ftCarga = new FretamentoVeiculoCarga(2, v2, (FuncionarioMotorista)c1.getByCPF("04057357076"), validaData("2020-08-05"),validaData("2020-08-07"), 300, true);

        FretamentoVeiculoCarga freteCarga = new FretamentoVeiculoCarga(3, v2,c1.getByCPF("04057357076"),validaData("2020-08-05"),validaData("2020-08-07"), 300, false);
        
        
    }
}
