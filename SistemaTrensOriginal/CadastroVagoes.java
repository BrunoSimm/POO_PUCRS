import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
//Classe refatorada para aceitar cadastro de vagões de carga e de passageiros. 
public class CadastroVagoes {
	private ArrayList<VagaoCarga> vagoesCarga;
	private ArrayList<VagaoPassageiros> vagoesPassageiros;

	public CadastroVagoes(){
		vagoesCarga = new ArrayList<>();
		vagoesPassageiros = new ArrayList<>();
	}

	public void cadastraVagaoCarga(VagaoCarga v){
		vagoesCarga.add(v);
	}
	public void cadastraVagaoPassageiros(VagaoPassageiros v){
		vagoesPassageiros.add(v);
	}

	public int getQtdade(String tipoDeVagao){
		if(tipoDeVagao.equals("VagaoPassageiros")){
			return vagoesPassageiros.size();
		} else if (tipoDeVagao.equals("VagaoCarga")){
			return vagoesCarga.size();
		} else return -1;
	}

	public ElementoDeComposicao getPorPosicao(String tipoDeVagao,int pos){
		if(tipoDeVagao.equals("VagaoPassageiros")){
			if (pos>=0 && pos<vagoesPassageiros.size()){
				return vagoesPassageiros.get(pos);
			}else{
				return null;
			}
		} else if (tipoDeVagao.equals("VagaoCarga")){
			if (pos>=0 && pos<vagoesCarga.size()){
				return vagoesCarga.get(pos);
			}else{
				return null;
			}
		}else {
			return null;
		}
	}
	public ElementoDeComposicao getPorId(String tipoDeVagao,int id){
		if(tipoDeVagao.equals("VagaoPassageiros")){
			for(VagaoPassageiros vagao:vagoesPassageiros){
				if (vagao.getIdentificador() == id){
					return vagao;
				}
			}
			return null;
		} else if (tipoDeVagao.equals("VagaoCarga")){
			for(VagaoCarga vagao:vagoesCarga){
				if (vagao.getIdentificador() == id){
					return vagao;
				}
			}
			return null;
		}else {
			return null;
		}
	}

	public void carrega(String tipoDeVagao){
		if(tipoDeVagao.equals("VagaoPassageiros")){ //Fazer implementação para Passageiros
			String fName = "./vagoesPassageiro.txt";
			Path path = Paths.get(fName);
			try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
			   while (sc.hasNext()){
				   String linha = sc.nextLine();
				   String dados[] = linha.split(",");
				   int codigo = Integer.parseInt(dados[0]);
				   int qtdPassageiros = Integer.parseInt(dados[1]);
				   double pesoVagao = qtdPassageiros * 70;
				   int composicao = Integer.parseInt(dados[2]);
				   VagaoPassageiros vagao = new VagaoPassageiros(qtdPassageiros,pesoVagao,codigo,composicao);
				   vagoesPassageiros.add(vagao);
			   }
			}catch (IOException x){
				System.err.format("Erro de E/S: %s%n", x);
			}
		}else if (tipoDeVagao.equals("VagaoCarga")){
			String fName = "./vagoesCarga.txt";
			Path path = Paths.get(fName);
			try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
			   while (sc.hasNext()){
				   String linha = sc.nextLine();
				   String dados[] = linha.split(",");
				   int codigo = Integer.parseInt(dados[0]);
				   double capCarga = Double.parseDouble(dados[1]);
				   int composicao = Integer.parseInt(dados[2]);
				   VagaoCarga vagao = new VagaoCarga(codigo,capCarga,composicao);
				   vagoesCarga.add(vagao);
			   }
			}catch (IOException x){
				System.err.format("Erro de E/S: %s%n", x);
			}
		}
	}

	public void persiste(String tipoDeVagao){
		if(tipoDeVagao.equals("VagaoPassageiros")){ //Fazer implementação para Passageiros
			String fName = "./vagoesPassageiro.txt";
			Path path = Paths.get(fName);
			try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8))){
			for(VagaoPassageiros vagao:vagoesPassageiros){
					String linha = vagao.getIdentificador()+","+
						vagao.getQtdPassageiros()+","+
						vagao.getComposicao();
					writer.println(linha);
				}
			}catch (IOException x){
			System.err.format("Erro de E/S: %s%n", x);
			}
		}else if (tipoDeVagao.equals("VagaoCarga")){
			String fName = "./vagoesCarga.txt";
			Path path = Paths.get(fName);
			try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8))){
			for(VagaoCarga vagao:vagoesCarga){
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
}
