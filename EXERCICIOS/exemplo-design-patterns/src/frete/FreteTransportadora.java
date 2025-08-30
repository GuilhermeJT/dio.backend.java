package frete;

public class FreteTransportadora implements FreteStrategy {
    @Override
    public double calcular(double peso) {
        return 20 + peso * 1.5; // base 20 + 1.5 por kg
    }
}
