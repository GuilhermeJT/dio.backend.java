
public class Main {
    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Arroz",10,2);
        carrinhoDeCompras.adicionarItem("Feijão",5,1);

        carrinhoDeCompras.calcularValorTotal();
        carrinhoDeCompras.infosItem();

        carrinhoDeCompras.removerItem("Arroz");
        carrinhoDeCompras.infosItem();
    }
}