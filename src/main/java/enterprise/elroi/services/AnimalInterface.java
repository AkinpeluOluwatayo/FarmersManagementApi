package enterprise.elroi.services;

import enterprise.elroi.data.models.Animal;
import enterprise.elroi.dto.requests.AnimalRequest;
import enterprise.elroi.dto.responses.AnimalResponse;

public interface AnimalInterface {
    AnimalResponse registerAnimal(AnimalRequest request);
    AnimalResponse viewAnimal(String id);


}
