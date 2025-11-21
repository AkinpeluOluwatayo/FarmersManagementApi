package enterprise.elroi.services;

import enterprise.elroi.dto.requests.AnimalHealthRecordRequest;
import enterprise.elroi.dto.responses.AnimalHealthRecordResponse;

public interface AnimalHealthRecordInterface {
    AnimalHealthRecordResponse enterDiseaseDiscription (AnimalHealthRecordRequest request);
    AnimalHealthRecordResponse deleteDiseaseDiscription (String id);
    AnimalHealthRecordResponse viewDiseaseDiscription (String id);
}
