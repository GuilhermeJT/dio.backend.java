package frete;

public class FreteCorreios implements FreteStrategy {
    @Override
    public double calcular(double peso) {
        return 10 + peso * 2; // base 10 + 2 por kg
    }
}

