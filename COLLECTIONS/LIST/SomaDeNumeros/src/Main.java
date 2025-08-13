//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SomaNumeros listaNumeros = new SomaNumeros();


        listaNumeros.adicionarNumero(10);
        listaNumeros.adicionarNumero(2022);
        listaNumeros.adicionarNumero(202);
        listaNumeros.adicionarNumero(100);

        System.out.println(listaNumeros.calcularSoma());

        System.out.println(listaNumeros.encontrarMaiorNumero());

        System.out.println(listaNumeros.encontrarMenorNumero());

        listaNumeros.exibirNumeros();

    }
}