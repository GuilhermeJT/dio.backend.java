import java.util.Scanner;


public class ContaTerminal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor, digite o número da sua Conta: ");
        int num = sc.nextInt();
        sc.nextLine();

        System.out.println("Por favor, digite o número da Agência: ");
        String agencia = sc.nextLine();

        System.out.println("Por favor, digite seu Nome: ");
        String nome = sc.nextLine();

        System.out.println("Por favor, digite o saldo da Conta: ");
        float saldo = sc.nextFloat();


        System.out.println(String.format(
                "Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque.",
                nome, agencia, num, saldo
        ));




    }
}