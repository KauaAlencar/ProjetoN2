public class Cliente {
    private static int contadorId = 1; // criei esse contador pra gerar o ID automático
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;

    // aqui só armazeno os dados do cliente quando ele se cadastra
    public Cliente(String nome, String email, String telefone, String endereco) {
        this.id = contadorId++; // ID gerado sozinho, sem repetir
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    // só coloquei os getters pq preciso acessar esses dados em outras classes
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getEndereco() { return endereco; }

    // pra facilitar quando quiser imprimir o cliente
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Email: " + email + ", Telefone: " + telefone + ", Endereço: " + endereco;
    }
}
