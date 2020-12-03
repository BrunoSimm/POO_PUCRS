import java.time.LocalDate;

public abstract class Fretamento {
    private int id; //Refatorar para receber ID de acordo com fretes que tem no cadastroFretes.java (TO DO)
    private Veiculo veiculo;
    private Funcionario condutor;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private double distancia;
    private double valor;

    public Fretamento(int id,Veiculo veiculo, Funcionario condutor, LocalDate dataInicio, LocalDate dataTermino, double distancia) {
        this.veiculo = veiculo;
        this.condutor = condutor;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.distancia = distancia;
        this.id = id;
        this.valor = this.setValor();
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Funcionario getCondutor() {
        return condutor;
    }

    public void setCondutor(Funcionario condutor) {
        this.condutor = condutor;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getValor() {
        return valor;
    }

    abstract double setValor();

    public boolean setId(int id){
        this.id = id;
        return true;
    }

    public int getId(){
        return this.id;
    }
    
}
