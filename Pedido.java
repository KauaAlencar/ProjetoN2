import java.util.ArrayList;

public class Pedido {
    private static int contadorPedido = 1; // também gerei ID automático pro pedido
    private int idPedido;
    private Cliente cliente;
    private ArrayList<Item> itens;

    // quando crio o pedido, ele já fica ligado ao cliente e com lista vazia de itens
    public Pedido(Cliente cliente) {
        this.idPedido = contadorPedido++;
        this.cliente = cliente;
        this.itens = new ArrayList<Item>();
    }

    // adiciona item no pedido
    public void adicionarItem(Item item) {
        itens.add(item);
    }

    // soma todos os itens pra ter o valor total do pedido
    public double calcularTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getTotal();
        }
        return total;
    }

    public Cliente getCliente() { return cliente; }

    // pra imprimir bem bonito o pedido
    public String toString() {
        String texto = "Pedido ID: " + idPedido + ", Cliente: " + cliente.getNome() + "\nItens:\n";
        for (Item item : itens) {
            texto += item.toString() + "\n";
        }
        texto += "Total: R$" + calcularTotal();
        return texto;
    }
}
