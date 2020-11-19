import java.util.Calendar;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        Date agora = new Date(); //Depreciado.
        System.out.println(agora);

        Calendar c = Calendar.getInstance();
        c.set(1998,8,5);
        System.out.println(System.currentTimeMillis());

        //LocalDateTime -> https://www.youtube.com/watch?v=5WrIWclE_Gc&ab_channel=AlgaWorks
        Funcionario f = new Funcionario("teste",c.getInstance(),"54655");
        System.out.println(f.getNome());
        System.out.println("mymy"+f.getDataNascimento());
    }
}
