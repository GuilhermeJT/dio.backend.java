package frete;

public class FreteRetiradaLoja implements FreteStrategy {
    @Override
    public double calcular(double peso) {
        return 0; // retirada = grátis
    }
}
