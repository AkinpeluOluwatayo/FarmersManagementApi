package enterprise.elroi.dto.requests;

import enterprise.elroi.data.models.AnimalType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalRequest {


    @NotBlank
    private String name;

    @NotBlank
    private String animalType;


}
