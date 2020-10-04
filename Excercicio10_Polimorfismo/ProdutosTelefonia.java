public class ProdutosTelefonia extends Produto {
    private boolean isImportado;

    public ProdutosTelefonia(int codigo, String descricao, double preco, boolean isImportado) {
        super(codigo, descricao, preco);
        this.isImportado = isImportado;
    }
    public boolean getIsImportado(){
        return isImportado;
    }

    @Override
    public double getImposto(){
        if (this.isImportado == true){
            return this.getPreco() * 0.5;
        } else {
            return this.getPreco() * 0.5;
        }
    }
    
}
