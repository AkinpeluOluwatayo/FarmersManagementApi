package enterprise.elroi.dto.requests;

import enterprise.elroi.data.models.Animal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalHealthRecordRequest {
    @Id
    private String id;
    @NotBlank
    private String animal;

    @NotBlank
    private String description;

    @PastOrPresent
    private LocalDateTime date;


}
