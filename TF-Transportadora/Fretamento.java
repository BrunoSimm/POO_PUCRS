import java.time.LocalDate;
import java.time.LocalDateTime;

public class Fretamento {
    private Veiculo veiculo;
    private Funcionario condutor;
    private LocalDateTime dataInicio;
    private LocalDateTime dataTermino;
    private double distancia;
    private double valor;

    public Fretamento(Veiculo veiculo, Funcionario condutor, LocalDateTime dataInicio, LocalDateTime dataTermino, double distancia, double valor) {
        this.veiculo = veiculo;
        this.condutor = condutor;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.distancia = distancia;
        this.valor = valor;
    }

    public Veiculo getVeiculo() {
        return veiculo;
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

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDateTime dataTermino) {
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

    public void setValor(double valor) {
        this.valor = valor;
    }

    
}
