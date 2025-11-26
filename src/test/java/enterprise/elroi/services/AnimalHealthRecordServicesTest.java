package enterprise.elroi.services;

import enterprise.elroi.data.models.AnimalHealthRecord;
import enterprise.elroi.data.repositories.AnimalHealthRecordRepository;
import enterprise.elroi.dto.requests.AnimalHealthRecordRequest;
import enterprise.elroi.dto.responses.AnimalHealthRecordResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AnimalHealthRecordServicesTest {

    @Autowired
    private AnimalHealthRecordRepository repository;

    @Autowired
    private AnimalHealthRecordServices service;

    @BeforeEach
    void setup() {
        repository.deleteAll();
    }

    @Test
    void testEnterDiseaseDescription() {
        AnimalHealthRecordRequest req = new AnimalHealthRecordRequest();
        req.setAnimal("Goat");
        req.setDescription("Coughing");

        AnimalHealthRecordResponse response = service.enterDiseaseDiscription(req);

        assertEquals("Coughing", response.getDescription());
        assertEquals("Health Record saved successfully", response.getMessage());
        assertNotNull(response.getDate());
        assertFalse(repository.findAll().isEmpty());
    }

    @Test
    void testViewDiseaseDescription() {
        AnimalHealthRecord record = AnimalHealthRecord.builder()
        .id("wad001")
        .animal("Goat")
        .description("Fever")
        .date(LocalDateTime.now())
        .build();

        repository.save(record);

        AnimalHealthRecordResponse response = service.viewDiseaseDiscription("wad001");

        assertEquals("Fever", response.getDescription());
        assertEquals("Animal Record Retrieved Successfully", response.getMessage());
    }

    @Test
    void testDeleteDiseaseDescription() {
        AnimalHealthRecord record = AnimalHealthRecord.builder()
                .id("ndama001")
                .animal("Cow")
                .description("Injury")
                .date(LocalDateTime.now())
                .build();

        repository.save(record);

        AnimalHealthRecordResponse response = service.deleteDiseaseDiscription("ndama001");

        assertEquals("Health Record deleted successfully", response.getMessage());
        assertTrue(repository.findById("ndama001").isEmpty());
    }

}
