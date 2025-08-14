import java.util.Scanner;

public class Divisao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o número inicial
        System.out.print("Informe o número inicial: ");
        int numeroInicial = scanner.nextInt();

        while (true) {
            System.out.print("Informe um número: ");
            int numero = scanner.nextInt();

            // Ignora números menores que o número inicial
            if (numero < numeroInicial) {
                System.out.println("Número ignorado (menor que o número inicial).");
                continue;
            }

            // Verifica se o número é divisível pelo número inicial
            if (numero % numeroInicial != 0) {
                System.out.println("Número não divisível. Encerrando programa.");
                break;
            }

            // Número válido e divisível
            System.out.println("Número válido e divisível.");
        }

        scanner.close();
    }
}
