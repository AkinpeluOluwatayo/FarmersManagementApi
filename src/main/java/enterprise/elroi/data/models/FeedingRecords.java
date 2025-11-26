package enterprise.elroi.data.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FeedingRecords {
    @Id
    private String id;
    private String feedType;
    private String quantity;
    private LocalDateTime date;
    private String animal;
}
