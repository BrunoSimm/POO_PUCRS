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
        System.out.println("-------------------------");

        System.out.println("\nRealizando operações com o estoque:");
        System.out.println("\nQuantidade em estoque de "+estoque1.getProduto(1).getDescricao()+" : "+ estoque1.getQuantidade(1));
        estoque1.baixaEstoque(1, 5);
        System.out.println("Quantidade em estoque de "+estoque1.getProduto(1).getDescricao()+" : " + estoque1.getQuantidade(1));
        estoque1.reposicaoEstoque(1, 50);
        System.out.println("Quantidade em estoque de "+estoque1.getProduto(1).getDescricao()+" : "+ estoque1.getQuantidade(1)+"\n");


        //Instânciando novo histórico de vendas.
        HistoricoVendas historicoVendas = new HistoricoVendas();

        System.out.println("-----------------------------------");
        System.out.println("Realizando operações com a VENDA 1:\n");

        //Instanciando nova venda e adicionando itens de venda.
        Venda venda1 = new Venda(historicoVendas);
        venda1.insereItem(catalogo1.getProduto(1), 50, estoque1);
        venda1.insereItem(catalogo1.getProduto(2), 21, estoque1);
        venda1.insereItem(catalogo1.getProduto(3), 10, estoque1);
        venda1.concluirVenda(historicoVendas, estoque1,venda1); //Onde irei guardar a venda e de qual estoque irei remover os itens.


        System.out.println("-----------------------------------");
        System.out.println("Realizando operações com a VENDA 2:\n");
        Venda venda2 = new Venda (historicoVendas);
        venda2.insereItem(catalogo1.getProduto(1), 5, estoque1);
        venda2.insereItem(catalogo1.getProduto(2), 3, estoque1);
        venda2.insereItem(catalogo1.getProduto(3), 2, estoque1);
        venda2.insereItem(catalogo1.getProduto(4), 8, estoque1);
        venda2.removeItem(catalogo1.getProduto(1));
        venda2.concluirVenda(historicoVendas, estoque1, venda2);
        
        //venda1.imprimeRecibo();
        historicoVendas.getUltimasVendas(2);
        
    }   
}