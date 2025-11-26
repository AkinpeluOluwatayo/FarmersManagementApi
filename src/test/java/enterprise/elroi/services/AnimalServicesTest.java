package enterprise.elroi.services;

import enterprise.elroi.data.models.Animal;
import enterprise.elroi.data.repositories.AnimalRepository;
import enterprise.elroi.dto.requests.AnimalRequest;
import enterprise.elroi.dto.responses.AnimalResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AnimalServicesTest {

    @Autowired
    private AnimalRepository repository;

    @Autowired
    private AnimalServices service;

    @BeforeEach
    void setup() {
        repository.deleteAll();
    }

    @Test
    void testRegisterAnimal() {
        AnimalRequest request = AnimalRequest.builder()
                .name("Ndama")
                .animalType("Cow")
                .build();

        AnimalResponse response = service.registerAnimal(request);


        assertNotNull(response);
        assertEquals("Ndama", response.getName());
        assertEquals("Cow", response.getAnimalType());
        assertEquals("Animal Registered successfully", response.getMessage());

        assertFalse(repository.findAll().isEmpty());
    }

    @Test
    void testViewAnimal() {
        Animal animal = Animal.builder()
                .id("Muturu001")
                .name("Muturu")
                .animalType("cow")
                .build();

        repository.save(animal);

        AnimalResponse response = service.viewAnimal("Muturu001");

        assertEquals("Muturu", response.getName());
        assertEquals("cow", response.getAnimalType());
        assertEquals("Animal Retrieved successfully", response.getMessage());
    }
}
