package banco;

public class ContaCorrente extends Conta {
    private double tarifaManutencao = 12.90;

    public ContaCorrente(Cliente titular) {
        super(titular);
    }

    public void cobrarTarifaMensal() {
        if (saldo < tarifaManutencao) {
            throw new IllegalArgumentException("Saldo insuficiente para tarifa de manutenção.");
        }
        saldo -= tarifaManutencao;
        registrar("Tarifa de manutenção", -tarifaManutencao);
    }
}
