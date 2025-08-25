package banco;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco Digital XPTO");

        Cliente ana = new Cliente("Ana Souza", "111.222.333-44");
        Cliente bruno = new Cliente("Bruno Lima", "555.666.777-88");

        ContaCorrente ccAna = new ContaCorrente(ana);
        ContaPoupanca cpBruno = new ContaPoupanca(bruno);

        banco.adicionarConta(ccAna);
        banco.adicionarConta(cpBruno);

        // Operações
        ccAna.depositar(1000);
        ccAna.cobrarTarifaMensal();

        cpBruno.depositar(500);
        cpBruno.renderJuros();

        ccAna.transferir(200, cpBruno);

        // Extratos
        ccAna.imprimirExtrato();
        cpBruno.imprimirExtrato();

        // Polimorfismo (tratando ambas como Conta)
        for (Conta c : banco.getContas()) {
            System.out.printf("%s -> Saldo: R$ %.2f%n", c.resumo(), c.getSaldo());
        }
    }
}
