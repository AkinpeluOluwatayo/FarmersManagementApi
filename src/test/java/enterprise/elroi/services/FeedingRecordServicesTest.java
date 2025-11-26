package enterprise.elroi.services;

import enterprise.elroi.data.models.FeedingRecords;
import enterprise.elroi.data.repositories.FeedingRecordRepository;
import enterprise.elroi.dto.requests.FeedingRecordRequest;
import enterprise.elroi.dto.responses.FeedingRecordResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FeedingRecordServicesTest {

    @Autowired
    private FeedingRecordRepository repository;

    @Autowired
    private FeedingRecordServices service;

    @BeforeEach
    void setup() {
        repository.deleteAll();
    }

    @Test
    void testEnterFeed() {
        FeedingRecordRequest request = FeedingRecordRequest.builder()
                .animal("Goat")
                .feedType("Hay")
                .quantity("5kg")
                .build();

        FeedingRecordResponse response = service.enterFeed(request);

        assertEquals("Goat", response.getAnimal());
        assertEquals("Hay", response.getFeedType());
        assertEquals("5kg", response.getQuantity());
        assertEquals("Feeding Records saved successfully", response.getMessage());
        assertNotNull(response.getDate());
        assertFalse(repository.findAll().isEmpty());
    }

    @Test
    void testViewFeed() {
        FeedingRecords feed = FeedingRecords.builder()
                .id("BlueCrown")
                .animal("Catfish")
                .feedType("Pellet")
                .quantity("10kg")
                .date(LocalDateTime.now())
                .build();


        repository.save(feed);

        FeedingRecordResponse response = service.viewFeed("BlueCrown");

        assertEquals("Catfish", response.getAnimal());
        assertEquals("Pellet", response.getFeedType());
        assertEquals("10kg", response.getQuantity());
        assertEquals("Feeding Records view successfully", response.getMessage());
    }
}
