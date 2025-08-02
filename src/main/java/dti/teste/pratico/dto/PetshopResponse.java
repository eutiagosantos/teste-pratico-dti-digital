package dti.teste.pratico.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetshopResponse {
    String name;
    Double totalPrice;
    Double distance;
}
