//package enterprise.elroi.services;
//
//import enterprise.elroi.data.models.Animal;
//import enterprise.elroi.data.repositories.AnimalHealthRecordRepository;
//import enterprise.elroi.dto.requests.AnimalRequest;
//import enterprise.elroi.dto.responses.AnimalResponse;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(MockitoExtension.class)
//class AnimalServicesTest {
//
//    @Mock
//    private AnimalHealthRecordRepository repository;
//
//    @InjectMocks
//    private AnimalServices animalServices;
//
//    @Test
//    void registerAnimal() {
//        AnimalRequest request = AnimalRequest.builder()
//                .name("Ndama")
//                .animalType("Cow")
//                .build();
//
//        AnimalResponse response = animalServices.registerAnimal(request);
//
//        assertNotNull(response);
//        assertEquals("Ndama", response.getName());
//        assertEquals("Cow", response.getAnimalType());
//        assertEquals("Animal Registered successfully", response.getMessage());
//
//
//
//    }
//}