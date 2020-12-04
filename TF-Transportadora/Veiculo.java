public abstract class Veiculo implements Comparable {
   private String placa;
   private String modelo;
   private int anoFabricacao;
   private double peso;
   private boolean isLivre = true;

   public Veiculo(String placa, String modelo, int anoFabricacao, double peso) {
       this.placa = placa;
       this.modelo = modelo;
       this.anoFabricacao = anoFabricacao;
       this.peso = peso;
   }

   @Override
   public int compareTo(Object veiculo) {
       if (veiculo instanceof Veiculo) {
           int comparaAno = ((Veiculo) veiculo).getAnoFabricacao();
           return this.anoFabricacao - comparaAno;
       } else return -1;
    }
   
   public String getPlaca() {
       return placa;
   }

   public void setPlaca(String placa) {
       this.placa = placa;
   }

   public String getModelo() {
       return modelo;
   }

   public void setModelo(String modelo) {
       this.modelo = modelo;
   }

   public int getAnoFabricacao() {
       return anoFabricacao;
   }

   public void setAnoFabricacao(int anoFabricacao) {
       this.anoFabricacao = anoFabricacao;
   }

   public double getPeso() {
       return peso;
   }

   public void setPeso(double peso) {
       this.peso = peso;
   }

   public boolean isLivre() {
       return isLivre;
   }

   public void setLivre(boolean isLivre) {
       this.isLivre = isLivre;
   }
   
    
}
