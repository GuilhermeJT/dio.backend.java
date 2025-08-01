import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
        }while(op != 7);

    }
}