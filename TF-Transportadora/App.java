import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class App {

    public static LocalDate validaData(String data){
        //Fazer validação da string, caso errada solicitar digitar novamente. (while)
        return LocalDate.parse(data);
    }
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        /**
        System.out.print("Digite uma data (ex: 23/11/2020): ");
        String str = sc.nextLine();
        LocalDate firstDate = LocalDate.parse(str, formatter);
        System.out.println(firstDate);
        System.out.println("Primeira data: " + formatter.format(firstDate));
        System.out.println(firstDate);
        System.out.print("Digite outra data: ");
        str = sc.nextLine();
        LocalDate secondDate = LocalDate.parse(str, formatter);
        System.out.println("Segunda data: " + formatter.format(secondDate));
        /* calcula a diferença em dias 
        long days = ChronoUnit.DAYS.between(firstDate, secondDate);
        System.out.println("Diferença entre as datas: " + days + " dias");
        */
        
        //LocalDateTime -> https://www.youtube.com/watch?v=5WrIWclE_Gc&ab_channel=AlgaWorks
        Funcionario f = new Funcionario("teste",validaData("1995-08-05"),"54655");
        CadastroFuncionarios c1 = new CadastroFuncionarios();
        c1.cadastrar(f);
        c1.cadastrar(new Funcionario("bruno", validaData("1998-02-04"),"41111"));//Refazer, funcionario deve ser abstract
        c1.cadastrar(new Funcionario("aruno", validaData("1998-11-05"),"41111"));
        c1.cadastrar(new Funcionario("aaruno", validaData("1998-12-05"),"41111"));
        c1.listarFuncionarios();
        System.out.println(c1.getByCPF("54655").getNome());
        
        CadastroVeiculos cv = new CadastroVeiculos();
        cv.cadastrar(new VeiculoCargas("123abc", "1asdasd", 10, 800, 5000, 4, true));
        cv.cadastrar(new VeiculoCargas("123abc", "asdasd", 12, 800, 5000, 4, true));
        cv.cadastrar(new VeiculoCargas("123abcd", "asdasd", 8, 800, 5000, 4, true));
        cv.cadastrar(new VeiculoCargas("123abc", "asdasd", 45, 800, 5000, 4, true));
        cv.cadastrar(new VeiculoCargas("123abc", "asdasd", 1, 800, 5000, 4, true));
        cv.listarVeiculos();
        System.out.println(cv.getByPlaca("123abcd").getAnoFabricacao());
        


    }
}
