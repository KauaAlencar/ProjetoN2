public class Produto {
    private static int contadorCodigo = 1; // mesma ideia do ID, mas aqui pro código do produto
    private int codigo;
    private String fabricante;
    private String descricao;
    private double preco;
    private int estoque;

    // construtor pra inicializar tudo que o produto precisa
    public Produto(String fabricante, String descricao, double preco, int estoque) {
        this.codigo = contadorCodigo++; // código gerado automático também
        this.fabricante = fabricante;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
    }

    // getters e setters básicos
    public int getCodigo() { return codigo; }
    public String getFabricante() { return fabricante; }
    public String getDescricao() { return descricao; }
    public double getPreco() { return preco; }
    public int getEstoque() { return estoque; }
    public void setEstoque(int estoque) { this.estoque = estoque; }

    // pra imprimir o produto de forma rápida
    public String toString() {
        return "Código: " + codigo + ", " + descricao + ", Preço: R$" + preco + ", Estoque: " + estoque;
    }
}
