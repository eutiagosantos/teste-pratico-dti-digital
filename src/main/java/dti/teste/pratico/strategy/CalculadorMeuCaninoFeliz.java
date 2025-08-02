package dti.teste.pratico.strategy;

import java.time.DayOfWeek;
import java.time.LocalDate;


public class CalculadorMeuCaninoFeliz implements CalculadorPrecoStrategy{

    @Override
    public Double calculate(int smallDogs, int bigDogs, LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        Double priceSmallDogs = 20.0;
        Double priceBigDogs = 40.0;
        if(day == DayOfWeek.SUNDAY || day == DayOfWeek.SATURDAY){
            Double newPriceBig = priceBigDogs + (priceBigDogs * 0.20);
            Double newPriceSmall = priceSmallDogs + (priceSmallDogs * 0.20);
            return (smallDogs * newPriceSmall) + (bigDogs * newPriceBig);
        }
        return (smallDogs * priceSmallDogs) + (bigDogs * priceBigDogs);
    }
   
    
}
