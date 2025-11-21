package enterprise.elroi.data.repositories;

import enterprise.elroi.data.models.FeedingRecords;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedingRecordRepository  extends MongoRepository<FeedingRecords, String> { }
