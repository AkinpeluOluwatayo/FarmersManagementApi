package enterprise.elroi.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class FeedingRecords {
    @Id
    private String id;
    private String feedType;
    private String quantity;
    private LocalDateTime date;
    private String animal;
}
