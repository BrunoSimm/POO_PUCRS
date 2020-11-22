import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class App {

    public static LocalDate validaData(String data){
        //Fazer validação da string, caso errada solicitar digitar novamente. (while)
        return LocalDate.parse(data);
    }
    public static void main(String[] args) {
        LocalDate dataN = LocalDate.of(1998, 8, 5);

        //LocalDateTime -> https://www.youtube.com/watch?v=5WrIWclE_Gc&ab_channel=AlgaWorks
        Funcionario f = new Funcionario("teste",validaData("1995-08-05"),"54655");
    }
}
