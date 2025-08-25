package banco;

public class ContaPoupanca extends Conta {
    private double taxaRendimentoMensal = 0.006; // 0,6% a.m. (exemplo)

    public ContaPoupanca(Cliente titular) {
        super(titular);
    }

    public void renderJuros() {
        double juros = saldo * taxaRendimentoMensal;
        if (juros > 0) {
            saldo += juros;
            registrar("Rendimento mensal", juros);
        }
    }
}
