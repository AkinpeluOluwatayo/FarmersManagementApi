package enterprise.elroi.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class AnimalType {
    @Id
    private String id;
    private String typeName;
}
