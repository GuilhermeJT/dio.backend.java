public class Conta {
    private double saldo;

    private double saldoChequeEspecial;

    public Conta(double saldo) {
        this.saldo = saldo;
        this.saldoChequeEspecial = calcularChequeEspecial(saldo);

    }

    public double calcularChequeEspecial(double deposito){
        double especial = 0;
        if(deposito <= 500){
            especial = 50;
        }
        else{
            especial = deposito / 2;
        }
        return especial;
    }

    public double consultarChequeEspecial(){
        return this.saldoChequeEspecial;
    }

    public double consultarSaldo(){
        return this.saldo;
    }

    public double depositar(double valor){
        return this.saldo += valor;
    }

    public boolean estaUsandoChequeEspecial() {
        return this.saldo < 0;
    }

    public double sacar(double valor) {
        if (valor <= this.saldo) {
            // cabe no saldo normal
            this.saldo -= valor;
        } else {
            // usa tudo do saldo
            double restante = valor - this.saldo;
            this.saldo = 0;

            // aplica no cheque especial
            this.saldoChequeEspecial -= restante;

            // taxa de 20% sobre o que saiu do cheque
            double taxa = restante * 0.2;
            this.saldoChequeEspecial -= taxa;

            System.out.printf(
                    "Usado R$ %.2f do cheque especial e cobrada taxa de R$ %.2f%n",
                    restante, taxa
            );
        }
        return this.saldo;
    }

    public void pgtBoleto(double valorBoleto) {
        if (this.saldo + this.saldoChequeEspecial >= valorBoleto) {
            System.out.println("Pagando boleto de R$ " + valorBoleto);
            sacar(valorBoleto);
            System.out.printf(
                    "Saldo restante: R$ %.2f, Cheque especial restante: R$ %.2f%n",
                    this.saldo, this.saldoChequeEspecial
            );
        } else {
            System.out.println(
                    "Valor do boleto maior que saldo + cheque especial disponíveis"
            );
        }
    }



}
