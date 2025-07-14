import java.util.Scanner;

public class IMC {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite sua altura em Metros: ");
        double altura = sc.nextFloat();

        System.out.println("Digite seu peso: ");
        double peso = sc.nextFloat();

        sc.close();

        double imc = peso / (altura * altura);

        if(imc <= 18.5){
            System.out.println("Abaixo do Peso!!");
        }
        else if (imc <= 24.9){
            System.out.println("Peso ideal!!");
        }
        else if(imc <= 29.9){
            System.out.println("Levemente acima do peso!!");
        }
        else if(imc <= 34.9){
            System.out.println("Obesidade grau I !!");
        }
        else if(imc <= 39.9){
            System.out.println("Obesidade grau II (Severa) !!");
        }
        else{
            System.out.println("Obesidade III (Mórbida)!!");
        }
    }

}
