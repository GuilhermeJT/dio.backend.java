package frete;

public class Pedido {
    private double peso;
    private FreteStrategy frete;

    public Pedido(double peso, FreteStrategy frete) {
        this.peso = peso;
        this.frete = frete;
    }

    public double calcularFrete() {
        return frete.calcular(peso);
    }
}
