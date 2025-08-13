//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        OrdenacaoNumeros numeros = new OrdenacaoNumeros();

        numeros.adicionarNumero(1);
        numeros.adicionarNumero(5);
        numeros.adicionarNumero(2);
        numeros.adicionarNumero(4);
        numeros.adicionarNumero(3);


        numeros.ordenarDescendente();
        numeros.ordenarAscendente();




    }
}