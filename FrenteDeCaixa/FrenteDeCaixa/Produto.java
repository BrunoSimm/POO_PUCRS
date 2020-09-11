public class Produto {
    private int codigo;
    private String descricao;
    private double preco;

    public Produto(int codigo, String descricao, double preco) {
        if (codigo < 0){
            this.codigo = 0;
        } else this.codigo = codigo;
        
        if (descricao.isEmpty() == true){
            this.descricao = "Inválido";
        } else this.descricao = descricao;

        if (preco >= 0){
            this.preco = preco;
        } else this.preco = 0;
    }
    public int getCodigo() {
        return this.codigo;
    }
    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String novaDescricao) {
        if (descricao.isEmpty() != true){
            this.descricao = novaDescricao;
        }
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        if (preco >= 0){
            this.preco = preco;
        }
    }

    @Override
    public String toString() {
        return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + "]";
    }
}
