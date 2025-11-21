package enterprise.elroi.data.repositories;

import enterprise.elroi.data.models.AnimalHealthRecord;
import enterprise.elroi.dto.requests.AnimalHealthRecordRequest;
import enterprise.elroi.dto.responses.AnimalHealthRecordResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnimalHealthRecordRepository extends MongoRepository<AnimalHealthRecord, String> {
}
