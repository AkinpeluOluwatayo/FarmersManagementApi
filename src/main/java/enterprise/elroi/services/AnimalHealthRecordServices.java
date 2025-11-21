package enterprise.elroi.services;

import enterprise.elroi.data.models.Animal;
import enterprise.elroi.data.models.AnimalHealthRecord;
import enterprise.elroi.data.repositories.AnimalHealthRecordRepository;
import enterprise.elroi.dto.requests.AnimalHealthRecordRequest;
import enterprise.elroi.dto.responses.AnimalHealthRecordResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class AnimalHealthRecordServices  implements AnimalHealthRecordInterface{

    private AnimalHealthRecordRepository repository;

    @Autowired
    public AnimalHealthRecordServices(AnimalHealthRecordRepository repository){
        this.repository = repository;
    }

    @Override
    public AnimalHealthRecordResponse enterDiseaseDiscription(AnimalHealthRecordRequest request) {
        AnimalHealthRecord animalHealthRecord = new AnimalHealthRecord();

        animalHealthRecord.setDescription(request.getDescription());
        animalHealthRecord.setAnimal(request.getAnimal());
        animalHealthRecord.setDate(request.getDate());

        repository.save(animalHealthRecord);

        AnimalHealthRecordResponse response = new AnimalHealthRecordResponse();

        response.setDate(animalHealthRecord.getDate().toString());
        response.setDescription(animalHealthRecord.getDescription());
        response.setMessage("Health Record saved successfully");


        return response;
    }

    @Override
    public AnimalHealthRecordResponse deleteDiseaseDiscription(String id) {
        Optional<AnimalHealthRecord> record = repository.findById(id);
        if (record.isEmpty()) throw new RuntimeException("Animal Health Record Not Found");

         repository.deleteById(id);
         AnimalHealthRecordResponse response = new AnimalHealthRecordResponse();
         response.setMessage("Health Record deleted successfully");


        return response;
    }

    @Override
    public AnimalHealthRecordResponse viewDiseaseDiscription(String id) {
        Optional<AnimalHealthRecord> animalHealthRecord = repository.findById(id);
        if(animalHealthRecord.isEmpty()) throw new RuntimeException("Animal health Record Not found");
        AnimalHealthRecord viewedAnimal = animalHealthRecord.get();

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        AnimalHealthRecordResponse response = new AnimalHealthRecordResponse();
        response.setDate(viewedAnimal.getDate().format(formatter));
        response.setDescription(viewedAnimal.getDescription());
        response.setMessage("Animal Record Retrieved Successfully");


        return response;
    }
}
