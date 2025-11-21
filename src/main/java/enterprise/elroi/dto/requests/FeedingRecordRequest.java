package enterprise.elroi.dto.requests;

import enterprise.elroi.data.models.Animal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedingRecordRequest {
    @Id
    private String id;

    @NotBlank
    private String feedType;

    @NotBlank
    private String quantity;

    @PastOrPresent
    private LocalDateTime date;

    @NotBlank
    private String animal;
}
