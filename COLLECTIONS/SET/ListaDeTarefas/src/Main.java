

public class Main {
    public static void main(String[] args) {

        ListaTarefas lista = new ListaTarefas();
        lista.adicionarTarefa("Assinar Documento");
        lista.adicionarTarefa("Abastecer Carro");
        lista.adicionarTarefa("Pagar Documento");
        lista.adicionarTarefa("Assinar Documento");


        lista.exibirTarefas();

        System.out.println(lista.contarTarefas());



    }
}