package enterprise.elroi.controllers;

import enterprise.elroi.dto.requests.AnimalHealthRecordRequest;
import enterprise.elroi.dto.responses.AnimalHealthRecordResponse;
import enterprise.elroi.dto.responses.ApiResponse;
import enterprise.elroi.services.AnimalHealthRecordInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/animalHealth")
public class AnimalHealthRecordController {

    private AnimalHealthRecordInterface animalHealthRecordService;

    @Autowired
    public AnimalHealthRecordController(AnimalHealthRecordInterface animalHealthRecordService) {
        this.animalHealthRecordService = animalHealthRecordService;
    }

    @PostMapping("/enter")
    public ResponseEntity<?> enterDiseaseDiscription(@RequestBody AnimalHealthRecordRequest request) {
        try {
            AnimalHealthRecordResponse animalHealthRecordResponse = animalHealthRecordService.enterDiseaseDiscription(request);
            return new ResponseEntity<>(new ApiResponse(true, animalHealthRecordResponse), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDiseaseDiscription(@PathVariable("id") String id) {
        try {
            AnimalHealthRecordResponse animalHealthRecordResponse = animalHealthRecordService.deleteDiseaseDiscription(id);
            return new ResponseEntity<>(new ApiResponse(true, animalHealthRecordResponse), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<?> viewDiseaseDiscription (@PathVariable("id") String id) {
        try {
            AnimalHealthRecordResponse animalHealthRecordResponse = animalHealthRecordService.viewDiseaseDiscription(id);
            return new ResponseEntity<>(new ApiResponse(true, animalHealthRecordResponse), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }





}
