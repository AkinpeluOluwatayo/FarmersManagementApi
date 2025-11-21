package enterprise.elroi.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@Data

public class Animal {
    @Id
    @MongoId(FieldType.STRING)
    private String id;

    private String name;
    private String animalType;
}
