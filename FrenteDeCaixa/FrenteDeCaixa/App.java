public class App {
    public static void main(String[] args) {
        //Instânciando novo Produto
        Produto p1 = new Produto (1,"iPhone",6000); 

        //Instânciando novo catalogo
        Catalogo catalogo1 = new Catalogo(); 
        catalogo1.cadastroProduto(p1);
        catalogo1.cadastroProduto(new Produto(2,"TV 59",3299.99));
        catalogo1.cadastroProduto(new Produto(2,"TV 79",4999)); //Código repetido, não será adicionado.
        catalogo1.cadastroProduto(new Produto(3,"Mouse",550));
        catalogo1.cadastroProduto(new Produto(4,"Monitor",1200));
        catalogo1.cadastroProduto(new Produto(5,"Teclado",399.99));

        catalogo1.getProdutos(); //Relação de todos os produtos cadastrados no catalogo.

        //Instânciando novo estoque e adicionando produtos do catalogo ao estoque.
        Estoque estoque1 = new Estoque ();
        System.out.println("\nAdicionando produtos e suas quantidades iniciais ao estoque:\n");
        estoque1.cadastraProduto(catalogo1.getProduto(1), 25); //Código do produto, qtd
        estoque1.cadastraProduto(catalogo1.getProduto(2), 15);
        estoque1.cadastraProduto(catalogo1.getProduto(3), 100);
        estoque1.cadastraProduto(catalogo1.getProduto(4), 30);
        estoque1.cadastraProduto(catalogo1.getProduto(5), 45);

        System.out.println("\nQuantidade em estoque: "+ estoque1.getQuantidade(1));
        estoque1.baixaEstoque(1, 5);
        System.out.println("Quantidade em estoque: " + estoque1.getQuantidade(1));
        estoque1.reposicaoEstoque(1, 50);
        System.out.println("Quantidade em estoque: " + estoque1.getQuantidade(1));


        estoque1.cadastraProduto(new Produto(20,"TV 59",4500), 50);

    }
}