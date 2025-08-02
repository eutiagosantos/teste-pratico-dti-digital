package dti.teste.pratico.strategy;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class CalculadorVaiRex implements CalculadorPrecoStrategy{

    @Override
    public Double calculate(int smallDogs, int bigDogs, LocalDate date) {
        Double priceBigDog = 50.0;
        Double priceSmallDog = 15.0;
        DayOfWeek day = date.getDayOfWeek();
        if(day == DayOfWeek.SUNDAY || day == DayOfWeek.SATURDAY){
            priceSmallDog = 20.0;
            priceBigDog = 55.0;
            return (smallDogs * priceSmallDog) + (bigDogs * priceBigDog);
        }
        return (smallDogs * priceSmallDog) + (bigDogs * priceBigDog);
    }
    
}
