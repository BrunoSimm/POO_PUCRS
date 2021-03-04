import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {

        public static void imprimeAluno(Aluno aluno) {
                System.out.println("Nome: " + aluno.getNome());
        }

        public static void imprimeAlunos(List<Aluno> alunos) {
                for (Aluno aluno: alunos) {
                        System.out.println(aluno);
                }
        }

        public static int contaCorredores(List<Atleta> atletas) {
                int cont=0;
                for(int i=0;i<atletas.size();i++) {
                      if (atletas.get(i).getModalidade() == Modalidade.CORRIDA){
                           cont++;
                      }
                }
                return cont;
        }
              
        public static void main(String[] args) {
                
                /*
                List<Aluno> alunos = new ArrayList<Aluno>();
                //List<Aluno> alunos = new LinkedList<Aluno>();
        
                Aluno a1 = new AlunoArranjo(10, "Marcelo");
                System.out.println("Nome: " + a1.getNome());
                Aluno a2 = new AlunoArranjo(11, "Maria");
                System.out.println("Nome: " + a2.getNome());

                alunos.add(a1);
                alunos.add(a2);
                */
        
                List<Atleta> atletas = new ArrayList<Atleta>();

                Aluno a1 = new AlunoAtleta(10, "Marcelo", Modalidade.CORRIDA);
                Atleta a2 = (Atleta)a1;
                atletas.add(a2);

                Funcionario f1 = new Funcionario(100, "Maria", 1000, Modalidade.CORRIDA);
                atletas.add(f1);

                System.out.println("Corredores: " + contaCorredores(atletas));

        }

}
