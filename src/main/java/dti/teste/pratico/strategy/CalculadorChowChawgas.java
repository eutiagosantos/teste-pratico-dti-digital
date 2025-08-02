package dti.teste.pratico.strategy;

import java.time.LocalDate;

public class CalculadorChowChawgas implements CalculadorPrecoStrategy {

    @Override
    public Double calculate(int smallDogs, int bigDogs, LocalDate date) {
        Double priceBigDog = 45.0;
        Double priceSmallDog = 30.0;

        return (smallDogs * priceSmallDog) + (bigDogs * priceBigDog);
    }
    
}
