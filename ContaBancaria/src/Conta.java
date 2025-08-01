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

    public double sacar(double valor){
        return this.saldo -= valor;
    }


    public void pgtBoleto(double valorBoleto){
        this.saldo -= valorBoleto;
        if(this.saldo >= valorBoleto){
            System.out.println("Boleto pago com suceso");
            System.out.println("Saldo Atual: "+ this.saldo);
        }
        else{
            System.out.println("Valor do boleto maior que saldo disponivel na conta");
        }

    }



}
