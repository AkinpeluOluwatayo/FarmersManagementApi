package enterprise.elroi.dto.responses;

import enterprise.elroi.data.models.AnimalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalResponse {


    private String id;
    private String name;
    private String animalType;
    private String message;
}
