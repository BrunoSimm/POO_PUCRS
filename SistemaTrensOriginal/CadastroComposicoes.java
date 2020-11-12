import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class CadastroComposicoes {
    private ArrayList<Composicao> composicoes;

    public CadastroComposicoes() {
        composicoes = new ArrayList<>();
    }

    public void cadastra(Composicao c) {
        composicoes.add(c);
    }
    /**
     * "Monta" novamente as composições. Isso permite adicionar/remover novos vagões e locomotivas de composições já criadas.
     * 
    */
    public void alimentaComposicoes(CadastroLocomotivas cl, CadastroVagoes cv){
        //Lendo todas as locomotivas e associando as respectivas composições.
        for (Composicao composicao : composicoes) {
            ArrayList<Locomotiva> aux = new ArrayList<Locomotiva>();
            aux = cl.getPorComposicao(composicao.getIdentificador());
            for (Locomotiva locomotiva : aux) {
                composicao.insereLocomotivas(locomotiva);
            }
        }

        //Lendo todas os vagoes (carga e passageiros) e associando as respectivas composições.
        for (Composicao composicao : composicoes) {
            ArrayList<Vagao> aux = new ArrayList<Vagao>();
            
            aux = cv.getPorComposicao(composicao.getIdentificador());
            if (aux.isEmpty()){
                
            }
            for (Vagao vagao : aux) {
                composicao.insereVagao(vagao);
            }
        }
    }

    public int getQtdade() {
        return composicoes.size();
    }

    public Composicao getPorPosicao(int pos) {
        if (pos >= 0 && pos < composicoes.size()) {
            return composicoes.get(pos);
        } else {
            return null;
        }
    }

    public Composicao getPorIdentificador(int id) {
        for (Composicao c : composicoes) {
            if (c.getIdentificador() == id) {
                return c;
            }
        }
        return null;
    }

    public boolean removeComposicaoPorId(int id) {
        for (Composicao c : composicoes) {
            if (c.getIdentificador() == id) {
                //Removendo os elementos da composição e editando suas composições.
                for (int i = 0; i < (c.getQtdadeLocomotivas()+c.getQtdadeVagoes()); i++) {
                    c.removerUltimoElemento();
                }
                composicoes.remove(c);
                return true;
            }
        }
        return false;
    }

    public void persiste() {
        String fName = "./composicoes.txt";
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir + "/" + fName;
        Path path = Paths.get(nameComplete);
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8))) {
            for (Composicao c : composicoes) {
                String linha = c.toLineFile();
                writer.println(linha);
            }
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }

    public void carrega() {
        String fName = "./composicoes.txt";
        Path path = Paths.get(fName);
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))) {
            while (sc.hasNext()) {
                String linha = sc.nextLine();
                String dados[] = linha.split(",");
                int pos = 0;
                int identificador = Integer.parseInt(dados[pos]);
                Composicao c = new Composicao(identificador);
                this.cadastra(c);
            }
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }
}