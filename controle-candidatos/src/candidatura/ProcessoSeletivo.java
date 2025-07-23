package candidatura;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {

//    Scanner sc = new Scanner(System.in);
//
//    System.out.println("Qual salário pretendido pelo candidato: ");
//    double Salario = sc.nextDouble();
//
//    sc.close();
        selecaoCandidatos();
    }


    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }

    static  void selecaoCandidatos(){
        String[] candidatos = {"Ana", "Bruno", "Carla", "Daniel", "Eduarda", "Fernando", "Gabriela", "Henrique", "Isabela", "João"};
        String[] selecionados = new String[5];


        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;


        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato "+ candidato + ", Solicitou este valor de Salário " + salarioPretendido);

            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato "+ candidato+ " foi selecionado para a Vaga");
                selecionados[candidatoAtual] = candidato;
                candidatosSelecionados++;


            }
            candidatoAtual++;

        }

        int count = 0;
        System.out.println("Selecionados: ");
        for(String nome : selecionados){
            System.out.println(nome);

        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2000);
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
