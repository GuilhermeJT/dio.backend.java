import java.util.Scanner;

public class ParImpar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um numero inicial: ");
        int numInicio = sc.nextInt();


        System.out.println("Digite um numero final: ");
        int numFinal = sc.nextInt();

        System.out.println("Quer ver os números pares ou Impares do intervado dos numeros informados? (P/I)");
        String op = sc.next();

        if( op.equalsIgnoreCase("P")){
            for(int i = numInicio; i <= numFinal; i++ ){
                if (i % 2 == 0){
                    System.out.println(i);
                }
            }
        }
        else if ( op.equalsIgnoreCase("I")){
            for(int i = numInicio; i <= numFinal; i++ ){
                if (i % 2 != 0){
                    System.out.println(i);
                }
            }
        }
        else{
            System.out.println("Opção inválida! Digite P para pares ou I para ímpares.");
        }


    }


}
