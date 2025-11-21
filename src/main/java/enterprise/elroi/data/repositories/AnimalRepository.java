package enterprise.elroi.data.repositories;

import enterprise.elroi.data.models.Animal;
import enterprise.elroi.dto.requests.AnimalRequest;
import enterprise.elroi.dto.responses.AnimalResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnimalRepository extends MongoRepository<Animal, String> {

}
