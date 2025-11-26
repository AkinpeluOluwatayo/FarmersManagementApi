package enterprise.elroi.data.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Builder
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalHealthRecord {
    @Id
    private String id;
    private String description;
    private LocalDateTime date ;
    private String animal;

}
