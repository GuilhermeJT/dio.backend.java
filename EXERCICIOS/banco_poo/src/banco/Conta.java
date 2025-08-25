package banco;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements Imprimivel {
    private static int SEQUENCIAL = 1;

    protected final int agencia;
    protected final int numero;
    protected double saldo;
    protected final Cliente titular;
    protected final List<Transacao> extrato = new ArrayList<>();

    public Conta(Cliente titular) {
        this.agencia = 1;
        this.numero = SEQUENCIAL++;
        this.titular = titular;
        this.saldo = 0.0;
        registrar("Abertura de conta", 0);
    }

    public void depositar(double valor) {
        validarValorPositivo(valor, "Depósito");
        saldo += valor;
        registrar("Depósito", valor);
    }

    public void sacar(double valor) {
        validarValorPositivo(valor, "Saque");
        if (saldo < valor) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valor;
        registrar("Saque", -valor);
    }

    public void transferir(double valor, Conta destino) {
        if (this == destino) throw new IllegalArgumentException("Conta de destino inválida.");
        validarValorPositivo(valor, "Transferência");
        if (saldo < valor) throw new IllegalArgumentException("Saldo insuficiente para transferência.");

        this.saldo -= valor;
        this.registrar("Transferência para " + destino.resumo(), -valor);

        destino.saldo += valor;
        destino.registrar("Transferência de " + this.resumo(), valor);
    }

    protected void registrar(String descricao, double valor) {
        extrato.add(new Transacao(descricao, valor, saldo));
    }

    private void validarValorPositivo(double valor, String operacao) {
        if (valor <= 0) throw new IllegalArgumentException(operacao + " deve ser > 0.");
    }

    public String resumo() {
        return String.format("Ag %d Cc %d - %s", agencia, numero, titular.getNome());
    }

    public int getAgencia() { return agencia; }
    public int getNumero() { return numero; }
    public double getSaldo() { return saldo; }
    public Cliente getTitular() { return titular; }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== EXTRATO " + getClass().getSimpleName() + " ===");
        System.out.println(resumo());
        extrato.forEach(System.out::println);
        System.out.printf("Saldo atual: R$ %.2f%n%n", saldo);
    }
}
