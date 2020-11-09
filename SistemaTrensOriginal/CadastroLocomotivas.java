import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CadastroLocomotivas {
	private ArrayList<Locomotiva> locomotivas;

	public CadastroLocomotivas() {
		locomotivas = new ArrayList<>();
	}

	public void cadastra(Locomotiva l) {
		locomotivas.add(l);
	}

	public int getQtdade() {
		return locomotivas.size();
	}

	public Locomotiva getPorPosicao(int pos) {
		if (pos >= 0 && pos < locomotivas.size()) {
			return locomotivas.get(pos);
		} else {
			return null;
		}
	}

	public ArrayList<Locomotiva> getPorComposicao(int composicao){
		ArrayList<Locomotiva> aux = new ArrayList<Locomotiva>();
		for (Locomotiva locomotiva: locomotivas){
			if (locomotiva.getComposicao()== composicao){
				aux.add(locomotiva);
			}
		}
		if(aux.isEmpty()){
			return null; //DEVE-SE TRATAR NA COMPOSIÇÃO
		} else{
			return aux;
		}
	}

	public Locomotiva getPorId(int id) {
		for (Locomotiva locomotiva : locomotivas) {
			if (locomotiva.getIdentificador() == id) {
				return locomotiva;
			}
		}
		return null;
	}

	public void carrega() {
		String fName = "./locomotivas.txt";
		Path path = Paths.get(fName);
		try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))) {
			while (sc.hasNext()) {
				String linha = sc.nextLine();
				String dados[] = linha.split(",");
				int codigo = Integer.parseInt(dados[0]);
				double pesoMax = Double.parseDouble(dados[1]);
				int qtdadeVagoes = Integer.parseInt(dados[2]);
				int composicao = Integer.parseInt(dados[3]);
				Locomotiva locomotiva = new Locomotiva(codigo, pesoMax, qtdadeVagoes, composicao);
				locomotivas.add(locomotiva);
			}
		} catch (IOException x) {
			System.err.format("Erro de E/S: %s%n", x);
		}
	}

	public void persiste() {
		String fName = "./locomotivas.txt";
		Path path = Paths.get(fName);
		try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8))) {
			for (Locomotiva locomotiva : locomotivas) {
				String linha = locomotiva.toLineFile();
				writer.println(linha);
			}
		} catch (IOException x) {
			System.err.format("Erro de E/S: %s%n", x);
		}
	}
}
