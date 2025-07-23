package candidatura;

import java.util.Scanner;

public class ProcessoSeletivo {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Qual salário pretendido pelo candidato: ");
    double Salario = sc.nextDouble();

    sc.close();

    analisar(Salario);

    }

    static void analisar(double salarioPretendido){
        double salarioBase = 2000.0;

        if(salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");

        }
        else if( salarioBase == salarioPretendido ){
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        }
        else{
            System.out.println("AGUARDANDO RESULTADO DEMAIS CANDIDATOS");
        }
    }
}
