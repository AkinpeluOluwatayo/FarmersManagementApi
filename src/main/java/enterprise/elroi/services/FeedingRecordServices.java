package enterprise.elroi.services;

import enterprise.elroi.data.models.FeedingRecords;
import enterprise.elroi.data.repositories.FeedingRecordRepository;
import enterprise.elroi.dto.requests.FeedingRecordRequest;
import enterprise.elroi.dto.responses.FeedingRecordResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class FeedingRecordServices  implements FeedingRecordInterface{

    private FeedingRecordRepository repository;

    @Autowired
    public FeedingRecordServices(FeedingRecordRepository repository){
        this.repository = repository;
    }

    @Override
    public FeedingRecordResponse enterFeed(FeedingRecordRequest request) {
         FeedingRecords feedingRecords = new FeedingRecords();
         feedingRecords.setAnimal(request.getAnimal());
         feedingRecords.setFeedType(request.getFeedType());
         feedingRecords.setQuantity(request.getQuantity());
         feedingRecords.setDate(request.getDate());

         repository.save(feedingRecords);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        FeedingRecordResponse response = new FeedingRecordResponse();

        response.setFeedType(feedingRecords.getFeedType());
        response.setQuantity(feedingRecords.getQuantity());
        response.setDate(feedingRecords.getDate().format(formatter));
        response.setMessage("Feeding Records saved successfully");


        return response;
    }

    @Override
    public FeedingRecordResponse viewFeed(String id) {
        Optional<FeedingRecords> feedingRecords = repository.findById(id);
        if(feedingRecords.isEmpty()) throw new RuntimeException("feeding records not found");
        FeedingRecords feed = feedingRecords.get();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        FeedingRecordResponse response = new FeedingRecordResponse();
        response.setAnimal(feed.getAnimal());
        response.setFeedType(feed.getFeedType());
        response.setQuantity(feed.getQuantity());
        response.setDate(feed.getDate().format(formatter));
        response.setMessage("Feeding Records view successfully");

        return response;
    }
}
