import java.util.ArrayList;

public class Loja {
    private ArrayList<Cliente> clientes;
    private ArrayList<Produto> produtos;
    private ArrayList<Pedido> pedidos;

    // aqui já deixei alguns clientes e produtos pré-cadastrados pra testar
    public Loja() {
        clientes = new ArrayList<Cliente>();
        produtos = new ArrayList<Produto>();
        pedidos = new ArrayList<Pedido>();

        clientes.add(new Cliente("Kauã", "kauã@email.com", "(11)99672-0228", "Rua Amigo Legal"));
        clientes.add(new Cliente("Cleiton", "cleiton@email.com", "(11)80028922", "Rua Amiga Bacana"));

        produtos.add(new Produto("Apple", "Iphone 15", 5500, 10));
        produtos.add(new Produto("Sansung", "TV", 7000, 5));
        produtos.add(new Produto("Lenovo", "Notebook", 4550, 20));
    }

    public ArrayList<Cliente> getClientes() { return clientes; }
    public ArrayList<Produto> getProdutos() { return produtos; }
    public ArrayList<Pedido> getPedidos() { return pedidos; }

    // busco o cliente pelo ID, bem simples
    public Cliente buscarCliente(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    // mesma coisa pra buscar produto
    public Produto buscarProduto(int codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) return p;
        }
        return null;
    }

    // adiciona pedido na lista
    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    // retorna todos os pedidos feitos por um cliente
    public ArrayList<Pedido> pedidosDoCliente(Cliente cliente) {
        ArrayList<Pedido> lista = new ArrayList<Pedido>();
        for (Pedido p : pedidos) {
            if (p.getCliente().equals(cliente)) lista.add(p);
        }
        return lista;
    }

    // método pra cadastrar cliente
    public Cliente cadastrarCliente(String nome, String email, String telefone, String endereco) {
        Cliente novo = new Cliente(nome, email, telefone, endereco);
        clientes.add(novo);
        return novo;
    }

    // método pra cadastrar produto
    public Produto cadastrarProduto(String fabricante, String descricao, double preco, int estoque) {
        Produto novo = new Produto(fabricante, descricao, preco, estoque);
        produtos.add(novo);
        return novo;
    }
}
