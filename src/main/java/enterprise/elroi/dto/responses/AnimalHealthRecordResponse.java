package enterprise.elroi.dto.responses;

import enterprise.elroi.data.models.Animal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnimalHealthRecordResponse {

    private String description;
    private String date;
    private String message;

}
