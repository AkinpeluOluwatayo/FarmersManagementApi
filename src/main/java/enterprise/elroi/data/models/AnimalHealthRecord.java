package enterprise.elroi.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class AnimalHealthRecord {
    @Id
    private String id;
    private String description;
    private LocalDateTime date;
    private String animal;

}
