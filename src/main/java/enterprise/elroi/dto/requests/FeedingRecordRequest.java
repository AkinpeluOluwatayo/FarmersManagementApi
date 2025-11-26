package enterprise.elroi.dto.requests;

import enterprise.elroi.data.models.Animal;
import jakarta.validation.constraints.NotBlank;
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
public class FeedingRecordRequest {

    @NotBlank
    private String feedType;

    @NotBlank
    private String quantity;

    @NotBlank
    private String animal;
}
