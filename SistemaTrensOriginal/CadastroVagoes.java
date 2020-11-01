import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class CadastroVagoes {
	private ArrayList<Vagao> vagoes;

	public CadastroVagoes(){
		vagoes = new ArrayList<>();
	}

	public void cadastra(Vagao v){
		vagoes.add(v);
	}

	public int getQtdade(){
		return vagoes.size();
	}

	public Vagao getPorPosicao(int pos){
		if (pos>=0 && pos<vagoes.size()){
			return vagoes.get(pos);
		}else{
			return null;
		}
	}

	public Vagao getPorId(int id){
		for(Vagao vagao:vagoes){
			if (vagao.getIdentificador() == id){
				return vagao;
			}
		}
		return null;
	}

	public void carrega(){
		String fName = "./vagoes.txt";
        Path path = Paths.get(fName);
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
           while (sc.hasNext()){
               String linha = sc.nextLine();
               String dados[] = linha.split(",");
               int codigo = Integer.parseInt(dados[0]);
               double capCarga = Double.parseDouble(dados[1]);
			   int composicao = Integer.parseInt(dados[2]);
			   Vagao vagao = new Vagao(codigo,capCarga,composicao);
			   vagoes.add(vagao);
           }
        }catch (IOException x){
            System.err.format("Erro de E/S: %s%n", x);
        }
	}

	public void persiste(){
		String fName = "./vagoes.txt";
        Path path = Paths.get(fName);
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8))){
          for(Vagao vagao:vagoes){
				String linha = vagao.getIdentificador()+","+
					vagao.getCapacidadeCarga()+","+
					vagao.getComposicao();
                writer.println(linha);
            }
        }catch (IOException x){
          System.err.format("Erro de E/S: %s%n", x);
      }
	}
}
