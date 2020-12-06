import java.time.LocalDate;

public abstract class Fretamento {
    private int id; //Refatorar para receber ID de acordo com fretes que tem no cadastroFretes.java (TO DO)
    private Veiculo veiculo;
    private Funcionario condutor;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private double distancia;
    private double valor;

    public Fretamento(int id,Veiculo veiculo, FuncionarioMotorista condutor, LocalDate dataInicio, LocalDate dataTermino, double distancia){
        if (validaCondutor(veiculo,condutor) == true){
            this.id = id;
            this.veiculo = veiculo;
            this.condutor = condutor;
            this.dataInicio = dataInicio;
            this.dataTermino = dataTermino;
            this.distancia = distancia;
            veiculo.setLivre(false);
            condutor.setOcupado(true);
        } else throw new IllegalArgumentException("Erro. Condutor deve estar devidamente habilitado para conduzir este veiculo.Tente novamente.");
    }

    private boolean validaCondutor(Veiculo veiculo, FuncionarioMotorista condutor){
        //Todos os veiculos de passageiros possuem mais de 8 passageiros.
        if (veiculo instanceof VeiculoPassageiros){ 
            if (condutor.getCategoriaCNH().equals("D") && (condutor.cursoTransportePassageiros() == true)){
                return true;
            } else return false;
        } else if (veiculo instanceof VeiculoCargas){
            VeiculoCargas vc = (VeiculoCargas)veiculo;

            if (veiculo.getPeso() <= 3500){
                if (condutor.getCategoriaCNH().equals("B") || condutor.getCategoriaCNH().equals("C")){
                    return true;
                } else return false;
            } else if (veiculo.getPeso() > 3500){
                if (condutor.getCategoriaCNH().equals("C") || condutor.getCategoriaCNH().equals("D")){
                    return true;
                } else return false;
            } else if (vc.unidadeAcoplada() == true && (vc.getPeso() >= 6000)){
                if(condutor.getCategoriaCNH().equals("E")){
                    return true;
                } else return false;
            } else return false;
        } else return false;
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

    protected void setValor(double valor){
        this.valor = valor;
    }

    abstract void calculaValor(Veiculo v,Fretamento f);

    public boolean setId(int id){
        this.id = id;
        return true;
    }

    public int getId(){
        return this.id;
    }
    
}
