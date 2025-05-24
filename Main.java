import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja();
        Scanner sc = new Scanner(System.in);

        int opcaoPrincipal = 0;

        while (opcaoPrincipal != 3) {
            // aqui fiz o menu principal: ou é cliente, ou admin, ou sai
            System.out.println("\n** QuickShop **");
            System.out.println("1) Sou Cliente (Login ou Cadastro)");
            System.out.println("2) Sou Administrador (Cadastrar Produto)");
            System.out.println("3) Sair");
            System.out.print("Selecione uma opção: ");
            opcaoPrincipal = sc.nextInt();
            sc.nextLine();

            if (opcaoPrincipal == 1) {
                Cliente cliente;

                // pergunta se já tem ID ou quer se cadastrar
                System.out.print("Já possui ID de cliente? (s/n): ");
                char temId = sc.next().charAt(0);
                sc.nextLine();

                if (temId == 's' || temId == 'S') {
                    System.out.print("Digite seu ID: ");
                    int idCliente = sc.nextInt();
                    sc.nextLine();

                    cliente = loja.buscarCliente(idCliente);

                    if (cliente == null) {
                        System.out.println("Cliente não encontrado.");
                        continue; // volta pro menu principal
                    }
                } else {
                    // cadastro de cliente
                    System.out.println("\n** Cadastro de Cliente **");
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();

                    cliente = loja.cadastrarCliente(nome, email, telefone, endereco);
                    System.out.println("Cadastro realizado com sucesso! Seu ID: " + cliente.getId());
                }

                int opcaoCliente = 0;

                // menu só pro cliente, bem separado
                while (opcaoCliente != 4) {
                    System.out.println("\n** QuickShop **");
                    System.out.println("Bem-vindo, " + cliente.getNome() + "!");
                    System.out.println("1) Ver Catálogo de Produtos");
                    System.out.println("2) Fazer Novo Pedido");
                    System.out.println("3) Ver Meus Pedidos");
                    System.out.println("4) Sair");
                    System.out.print("Selecione uma opção: ");
                    opcaoCliente = sc.nextInt();

                    if (opcaoCliente == 1) {
                        // só mostra todos os produtos
                        System.out.println("\n--- Catálogo de Produtos ---");
                        for (Produto p : loja.getProdutos()) {
                            System.out.println(p);
                        }
                    }

                    if (opcaoCliente == 2) {
                        // criar pedido
                        Pedido pedido = new Pedido(cliente);
                        char mais = 's';

                        do {
                            System.out.print("Código do Produto: ");
                            int codigo = sc.nextInt();

                            Produto prod = loja.buscarProduto(codigo);
                            if (prod == null) {
                                System.out.println("Produto não encontrado.");
                                continue;
                            }

                            System.out.print("Quantidade: ");
                            int qtd = sc.nextInt();

                            if (qtd <= 0 || qtd > prod.getEstoque()) {
                                System.out.println("Quantidade inválida ou insuficiente.");
                                continue;
                            }

                            // adiciona o item e já atualiza o estoque
                            Item item = new Item(prod, qtd);
                            pedido.adicionarItem(item);
                            prod.setEstoque(prod.getEstoque() - qtd);

                            System.out.print("Adicionar outro item? (s/n): ");
                            mais = sc.next().charAt(0);

                        } while (mais == 's' || mais == 'S');

                        loja.adicionarPedido(pedido);
                        System.out.println("Pedido realizado com sucesso.");
                    }

                    if (opcaoCliente == 3) {
                        System.out.println("\n--- Meus Pedidos ---");
                        for (Pedido p : loja.pedidosDoCliente(cliente)) {
                            System.out.println(p);
                            System.out.println("------------------");
                        }
                    }
                }

            } else if (opcaoPrincipal == 2) {
                // cadastro de produto só pro admin
                System.out.println("\n** Cadastro de Produto **");

                System.out.print("Fabricante: ");
                String fabricante = sc.nextLine();

                System.out.print("Descrição: ");
                String descricao = sc.nextLine();

                System.out.print("Preço unitário: ");
                double preco = sc.nextDouble();

                System.out.print("Quantidade em estoque: ");
                int estoque = sc.nextInt();

                if (preco <= 0 || estoque < 0) {
                    System.out.println("Erro: preço e estoque devem ser positivos.");
                } else {
                    Produto novoProduto = loja.cadastrarProduto(fabricante, descricao, preco, estoque);
                    System.out.println("Produto cadastrado com sucesso! Código: " + novoProduto.getCodigo());
                }
            }
        }

        System.out.println("Sistema encerrado.");
        sc.close();
    }
}