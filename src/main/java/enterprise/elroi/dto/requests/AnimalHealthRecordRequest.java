package enterprise.elroi.dto.requests;

import enterprise.elroi.data.models.Animal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalHealthRecordRequest {
    @NotBlank
    private String animal;
    @NotBlank
    private String description;


}
