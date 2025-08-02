package dti.teste.pratico.strategy;

import java.time.LocalDate;

public interface CalculadorPrecoStrategy {
    Double calculate(int smallDogs, int bigDogs, LocalDate date);
}
