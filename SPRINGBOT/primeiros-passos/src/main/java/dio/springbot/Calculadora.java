package dio.springbot;

import org.springframework.stereotype.Component;

@Component
public class Calculadora {

    public int calcular(int num1, int num2){
        return num1 + num2;
    }
}
