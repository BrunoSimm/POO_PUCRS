public class App {
    public static void main(String[] args) {
        //Instânciando novo Produto
        Produto p1 = new Produto (1,"iPhone",6000); 

        //Instânciando novo catalogo
        Catalogo catalogo1 = new Catalogo(); 
        catalogo1.cadastroProduto(p1);
        catalogo1.cadastroProduto(new Produto(2,"TV 59'",4500));
        catalogo1.cadastroProduto(new Produto(2,"TV 79'",4511)); //Código repetido, não será adicionado.
        catalogo1.cadastroProduto(new Produto(3,"Notebook i7'",6.459));
        catalogo1.cadastroProduto(new Produto(20,"TV 59'",4500));
        catalogo1.cadastroProduto(new Produto(20,"TV 59'",4500));

        catalogo1.getProdutos(); //Relação de todos os produtos cadastrados no catalogo.


        //Instânciando novo estoque e adicionando produtos do catalogo.
        Estoque estoque1 = new Estoque ();
        estoque1.cadastraProduto(catalogo1.getProduto(10), 80); //Código do produto, qtd
        estoque1.cadastraProduto(catalogo1.getProduto(20), 40);

        System.out.println("Quantidade em estoque: "+ estoque1.getQuantidade(1));
        estoque1.baixaEstoque(1, 5);
        System.out.println("Quantidade em estoque: " + estoque1.getQuantidade(1));
        estoque1.reposicaoEstoque(1, 50);
        System.out.println("Quantidade em estoque: " + estoque1.getQuantidade(1));


        estoque1.cadastraProduto(new Produto(20,"TV 59",4500), 50);

    }
}