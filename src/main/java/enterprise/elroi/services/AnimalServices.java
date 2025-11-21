package enterprise.elroi.services;

import enterprise.elroi.data.models.Animal;
import enterprise.elroi.data.repositories.AnimalRepository;
import enterprise.elroi.dto.requests.AnimalRequest;
import enterprise.elroi.dto.responses.AnimalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnimalServices  implements AnimalInterface{
    private AnimalRepository repository;

    @Autowired
    public AnimalServices(AnimalRepository repository){
        this.repository = repository;
    }

    @Override
    public AnimalResponse registerAnimal(AnimalRequest request) {
        Animal animal = new Animal();
        animal.setName(request.getName());
        animal.setAnimalType(request.getAnimalType());

        repository.save(animal);

        AnimalResponse animalResponse = new AnimalResponse();
        animalResponse.setId(animal.getId());
        animalResponse.setName(animal.getName());
        animalResponse.setAnimalType(animal.getAnimalType());
        animalResponse.setMessage("Animal Registered successfully");

        return animalResponse;
    }

    @Override
    public AnimalResponse viewAnimal(String id) {
        Optional<Animal> animal = repository.findById(id);
        if (animal.isEmpty()) throw new RuntimeException("Animal Not Found");

        Animal viewedAnimal = animal.get();

        AnimalResponse response = new AnimalResponse();
        response.setId(viewedAnimal.getId());
        response.setName(viewedAnimal.getName());
        response.setAnimalType(viewedAnimal.getAnimalType());
        response.setMessage("Animal Retrieved successfully");

        return response;
    }
}
