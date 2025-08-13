//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ConjuntoPalavrasUnicas conjunto = new ConjuntoPalavrasUnicas();


        conjunto.adicionarPalavra("Java");
        conjunto.adicionarPalavra("Python");
        conjunto.adicionarPalavra("C++");

        conjunto.verificarPalavra("Java");
        conjunto.verificarPalavra("Ruby");


        conjunto.exibirPalavrasUnicas();

        }
    }
