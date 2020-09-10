public class App {
    public static void main(String[] args) {
        Produto p1 = new Produto (10,"iPhone",6000);
        System.out.println(p1);


        Catalogo catalogo1 = new Catalogo();
        catalogo1.cadastroProduto(p1);



        Estoque estoque1 = new Estoque ();
        //utilizar catalogo1 para cadastrar no estoque
        estoque1.cadastraProduto(catalogo1.getProdutos(10), 80);
        estoque1.cadastraProduto(p1, 100);
        System.out.println("Quantidade em estoque: "+ estoque1.getQuantidade(10));
        estoque1.baixaEstoque(10, 5);
        System.out.println("Quantidade em estoque: " + estoque1.getQuantidade(10));
        estoque1.reposicaoEstoque(10, 50);
        System.out.println("Quantidade em estoque: " + estoque1.getQuantidade(10));


        estoque1.cadastraProduto(new Produto(20,"TV 59",4500), 50);

    }
}