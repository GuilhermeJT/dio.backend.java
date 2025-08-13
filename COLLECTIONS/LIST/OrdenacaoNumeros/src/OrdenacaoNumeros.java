import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> Numeros;

    public OrdenacaoNumeros() {
        Numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        Numeros.add(numero);
    }

    public void ordenarAscendente(){
        Collections.sort(Numeros);
        System.out.println("Ordem crescente: "+Numeros);
    }

    public void ordenarDescendente(){
        Collections.sort(Numeros, Collections.reverseOrder());
        System.out.println("Ordem decrescente: "+Numeros);
    }

}
