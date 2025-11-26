package enterprise.elroi.dto.responses;

import enterprise.elroi.data.models.Animal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedingRecordResponse {
    private String animal;
    private String feedType;
    private String quantity;
    private String date;
    private String message;
}
