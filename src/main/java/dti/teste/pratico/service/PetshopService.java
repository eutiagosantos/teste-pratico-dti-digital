package dti.teste.pratico.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dti.teste.pratico.dto.PetshopResponse;
import dti.teste.pratico.model.Petshop;
import dti.teste.pratico.strategy.CalculadorChowChawgas;
import dti.teste.pratico.strategy.CalculadorMeuCaninoFeliz;
import dti.teste.pratico.strategy.CalculadorVaiRex;

@Service
public class PetshopService {
    private List<Petshop> petshops;

    public PetshopService(){
        this.petshops = new ArrayList<Petshop>();
        CalculadorMeuCaninoFeliz calculadorMeuCaninoFeliz = new CalculadorMeuCaninoFeliz();
        CalculadorChowChawgas calculadorChowChawgas = new CalculadorChowChawgas();
        CalculadorVaiRex calculadorVaiRex = new CalculadorVaiRex();

        Petshop meuCaninoFeliz = new Petshop(new Long(1),"Meu Canino Feliz",2.0,calculadorMeuCaninoFeliz);
        Petshop chowChawgas = new Petshop(new Long(2), "Chow Chawgas",0.8, calculadorChowChawgas);
        Petshop vaiRex = new Petshop(new Long(3), "Vai Rex", 1.7,calculadorVaiRex);
        
        this.petshops.add(meuCaninoFeliz);
        this.petshops.add(chowChawgas);
        this.petshops.add(vaiRex);
    }

    public PetshopResponse findBestPetshop(int bigDog, int smallDog, LocalDate date){
        Petshop melhorPetshop = null;
        double menorPreco = Double.MAX_VALUE;

        for (Petshop petshop : this.petshops) {
            double preco = petshop.getPrecoStrategy().calculate(smallDog, bigDog, date);
            if (preco < menorPreco) {
                menorPreco = preco;
                melhorPetshop = petshop;
            } else if (preco == menorPreco) {
                if (petshop.getDistance() < melhorPetshop.getDistance()) {
                    melhorPetshop = petshop;
                }
            }
        }

        if (melhorPetshop == null) {
            System.out.println("melhor petshop nulo");
        }
        double precoFinal = melhorPetshop.getPrecoStrategy().calculate(smallDog, bigDog, date);
        PetshopResponse response = convertPetshoptoResponse(melhorPetshop);
        response.setTotalPrice(precoFinal);
        return response;
    }

    private PetshopResponse convertPetshoptoResponse(Petshop petshop) {
        if (petshop == null) {
            return null;
        }
        PetshopResponse response = new PetshopResponse();
        response.setName(petshop.getName());
        response.setDistance(petshop.getDistance());
        return response;
    }
}


