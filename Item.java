public class Item {
    private Produto produto;
    private int quantidade;
    private double precoUnitario;

    // criei construtor pra já pegar o preço atual do produto
    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPreco(); // pego o preço na hora da compra
    }

    // métodos básicos
    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
    public double getPrecoUnitario() { return precoUnitario; }

    //método pra facilitar o cálculo total do item
    public double getTotal() {
        return precoUnitario * quantidade;
    }

    public String toString() {
        return produto.getDescricao() + " - Quantidade: " + quantidade + ", Preço: R$" + precoUnitario + ", Total: R$" + getTotal();
    }
}
