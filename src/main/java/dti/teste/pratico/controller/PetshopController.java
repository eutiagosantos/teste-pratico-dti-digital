package dti.teste.pratico.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dti.teste.pratico.dto.PetshopDto;
import dti.teste.pratico.dto.PetshopResponse;
import dti.teste.pratico.service.PetshopService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/petshop")
public class PetshopController {
    private final PetshopService petshopService;

    public PetshopController(PetshopService petshopService){
        this.petshopService = petshopService;
    }

    @PostMapping
    public ResponseEntity<PetshopResponse> findBestPetshop(@RequestBody PetshopDto dto){
        var response = this.petshopService.findBestPetshop(dto.bigDog(), dto.smallDog(), dto.date());
        return ResponseEntity.ok(response);
    }
}
