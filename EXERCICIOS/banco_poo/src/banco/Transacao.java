package banco;

import java.time.LocalDateTime;

public class Transacao {
    private final LocalDateTime dataHora = LocalDateTime.now();
    private final String descricao;
    private final double valor;    // positivo = crédito; negativo = débito
    private final double saldoApos;

    public Transacao(String descricao, double valor, double saldoApos) {
        this.descricao = descricao;
        this.valor = valor;
        this.saldoApos = saldoApos;
    }

    public LocalDateTime getDataHora() { return dataHora; }
    public String getDescricao() { return descricao; }
    public double getValor() { return valor; }
    public double getSaldoApos() { return saldoApos; }

    @Override
    public String toString() {
        String tipo = valor >= 0 ? "CRÉDITO" : "DÉBITO";
        return String.format("%s | %-7s | %s | Valor: R$ %.2f | Saldo: R$ %.2f",
                dataHora, tipo, descricao, valor, saldoApos);
    }
}
