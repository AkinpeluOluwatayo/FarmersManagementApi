package enterprise.elroi.controllers;

import enterprise.elroi.data.repositories.AnimalRepository;
import enterprise.elroi.dto.requests.AnimalRequest;
import enterprise.elroi.dto.responses.AnimalResponse;
import enterprise.elroi.dto.responses.ApiResponse;
import enterprise.elroi.services.AnimalInterface;
import enterprise.elroi.services.AnimalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//enterprise.elroi.dto.requests.AnimalRequest

@RestController
@RequestMapping("/api/animals")
public class AnimalServiceController {

    private AnimalInterface animalServices;

    @Autowired
    public AnimalServiceController(AnimalInterface animalServices) {
        this.animalServices = animalServices;
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerAnimal(@RequestBody AnimalRequest request) {
        try {
            AnimalResponse animalResponse = animalServices.registerAnimal(request);
            return new ResponseEntity<>(new ApiResponse(true, animalResponse), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<?> viewAnimal(@PathVariable("id") String id) {
        try {
            AnimalResponse animalResponse = animalServices.viewAnimal(id);
            return new ResponseEntity<>(new ApiResponse(true, animalResponse), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
