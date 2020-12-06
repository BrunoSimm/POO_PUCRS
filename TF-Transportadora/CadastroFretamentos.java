import java.util.Collections;
import java.util.LinkedList;

public class CadastroFretamentos{
    private LinkedList<Fretamento> fretamentosAtivos;
    private LinkedList<Fretamento> fretamentosHistorico;

    public CadastroFretamentos() {
        this.fretamentosAtivos = new LinkedList<Fretamento>();
        this.fretamentosHistorico = new LinkedList<Fretamento>();
    }
    
    public int getNumeroFretes(){
        return fretamentosHistorico.size();
    }
    public boolean cadastrar(Fretamento frete){
        if (frete != null){
            this.fretamentosAtivos.add(frete);
            this.fretamentosHistorico.add(frete);
            return true;
        } else {
            return false;
        }
    }

    public void listarfretamentosAtivos(){
        System.out.println("Fretes Ativos:");
        fretamentosAtivos.forEach(frete -> {
            System.out.println("\tFrete ID: "+ frete.getId()+ " | Placa do veiculo:"+frete.getVeiculo().getPlaca()+" | CPF Condutor:"+frete.getCondutor().getCpf());
            System.out.println("\t\tData de inicio:" + frete.getDataInicio()+" | Data Termino:"+frete.getDataTermino()+"\n");
        });
    }
    public void listarHistoricoFretamentos(){
        System.out.println("Histórico de Fretes:");
        fretamentosHistorico.forEach(frete -> {
            System.out.println("\tFrete ID: "+ frete.getId()+ " | Placa do veiculo:"+frete.getVeiculo().getPlaca()+" | CPF Condutor:"+frete.getCondutor().getCpf());
            System.out.println("\t\tData de inicio:" + frete.getDataInicio()+" | Data Termino:"+frete.getDataTermino()+" | Valor: R$"+frete.getValor()+"\n");
        });
    }


    public void cincoMaisLucrativos(){
        System.out.println("Top 5 Fretamentos mais Lucrativos:");
        fretamentosHistorico.stream()
            .map(f -> f.getValor() + " ID:"+f.getId())
            .sorted(Collections.reverseOrder())
            .limit(5)
            .forEach(f ->{
                System.out.println("R$"+f);
            });
    }

   

}
