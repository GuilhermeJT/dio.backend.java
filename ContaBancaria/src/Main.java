import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem vindo!");
        System.out.println("Vamos criar sua conta.\nInforme o saldo a ser depositado na hora da criação:");
        double saldo = sc.nextDouble();

        Conta conta = new Conta(saldo);

        System.out.println("==========================================");
        System.out.println("Conta criada com sucesso\n");


        var op = -1;
        do{
            System.out.println("=== MENU DE OPÇÕES ===");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - consultar cheque especial");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - Sacar dinheiro");
            System.out.println("5 - Pagar um boleto");
            System.out.println("6- Verificar se a conta está usando cheque especial");
            System.out.println("7 - Sair");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Saldo Atual: "+conta.consultarSaldo());
                    break;

                case 2:
                    System.out.println("Saldo Cheque Especial: "+conta.consultarChequeEspecial());
                    break;

                case 3:
                    System.out.println("Qual valor deseja depositar: ");
                    double deposito = sc.nextDouble();
                    conta.depositar(deposito);
                    System.out.println("Deposito concluido com sucesso!");
                    break;

                case 4:
                    System.out.print("Qual valor deseja sacar? R$ ");
                    double valorSaque = sc.nextDouble();
                    conta.sacar(valorSaque);

                    System.out.println("Saldo Atual: R$ " + conta.consultarSaldo());
                    System.out.println("Cheque Especial Disponível: R$ "
                            + conta.consultarChequeEspecial());
                    break;
                case 5:
                    System.out.print("Digite o valor do boleto a ser pago: R$ ");
                    double valorBoleto = sc.nextDouble();
                    conta.pgtBoleto(valorBoleto);
                    
                    break;
                case 6:
                    System.out.println(
                            conta.estaUsandoChequeEspecial()
                                    ? "Você está usando cheque especial."
                                    : "Você não está usando cheque especial."
                    );
                    break;
                case 7:
                    System.out.println("Saindo…");
                    break;


                default:
                    System.out.println("Opção não encontrada, tente novamente!");
                    break;

            }
        }while(op != 7);

        sc.close();

    }
}