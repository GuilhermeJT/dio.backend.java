import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {

    private List<Numero> listNumeros;

    public SomaNumeros(){
        listNumeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        listNumeros.add(new Numero(numero));
    }

    public int calcularSoma(){
        int soma = 0;
        if(!listNumeros.isEmpty()){
            for(Numero n : listNumeros){
                soma += n.getNum();
            }
        }
        return soma;
    }

    public Numero encontrarMaiorNumero(){
        Numero num = new Numero(-1);

        if(!listNumeros.isEmpty()){
            for(Numero n : listNumeros){
                if(n.getNum() > num.getNum()){
                    num = n;
                }
            }
        }
        return num;
    }

    public Numero encontrarMenorNumero(){
        Numero num = new Numero(listNumeros.get(0).getNum());
        if(!listNumeros.isEmpty()){
            for(Numero n : listNumeros){
                if(n.getNum() < num.getNum()){
                    num = n;
                }
            }
        }
        return num;


    }

    public void exibirNumeros(){
        System.out.println(listNumeros);
    }




}
