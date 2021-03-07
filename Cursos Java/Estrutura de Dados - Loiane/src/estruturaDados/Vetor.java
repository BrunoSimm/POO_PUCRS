package src.estruturaDados;

public class Vetor {

    private String[] elementos;
    private int tamanho = 0;


    public Vetor(int capacidade){
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }


    public void adiciona(String elemento){
        if(tamanho < this.elementos.length){
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
        } else {
            System.out.println("Vetor cheio, não é possível adicionar novos elementos.");
        }
    }

    public void deleta(){

    }

}
