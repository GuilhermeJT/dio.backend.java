package banco;

public class Cliente {
    private String nome;
    private String documento; // CPF, por exemplo

    public Cliente(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }

    public String getNome() { return nome; }
    public String getDocumento() { return documento; }

    @Override
    public String toString() {
        return nome + " (" + documento + ")";
    }
}
