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
        System.out.println("Adicionei uma nova composição");
        composicoes.add(c);
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

    public boolean removePorId(int id) {
        for (Composicao c : composicoes) {
            if (c.getIdentificador() == id) {
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
                pos++;
                int qtdadeLoc = Integer.parseInt(dados[pos]);
                pos++;
                for (int i = 0; i < qtdadeLoc; i++) {
                    int id = Integer.parseInt(dados[pos]);
                    pos++;
                    double peso = Double.parseDouble(dados[pos]);
                    pos++;
                    int qtdade = Integer.parseInt(dados[pos]);
                    pos++;
                    int compId = Integer.parseInt(dados[pos]);
                    pos++;
                    Locomotiva l = new Locomotiva(id, peso, qtdade, compId);
                    c.engataLocomotiva(l);
                }
                int qtdadeVagoes = Integer.parseInt(dados[pos]);
                pos++;
                for (int i = 0; i < qtdadeVagoes; i++) {
                    int id = Integer.parseInt(dados[pos]);
                    pos++;
                    double cap = Double.parseDouble(dados[pos]);
                    pos++;
                    int compId = Integer.parseInt(dados[pos]);
                    pos++;
                    VagaoCarga v = new VagaoCarga(id, cap);
                    c.engataVagao(v);
                }
                this.cadastra(c);
            }
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }
}