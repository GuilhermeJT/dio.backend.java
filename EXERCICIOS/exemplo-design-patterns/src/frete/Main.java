package frete;

public class Main {
    public static void main(String[] args) {
        Pedido pedido1 = new Pedido(5, new FreteCorreios());
        Pedido pedido2 = new Pedido(5, new FreteTransportadora());
        Pedido pedido3 = new Pedido(5, new FreteRetiradaLoja());

        System.out.println("Correios: R$ " + pedido1.calcularFrete());
        System.out.println("Transportadora: R$ " + pedido2.calcularFrete());
        System.out.println("Retirada Loja: R$ " + pedido3.calcularFrete());
    }
}
