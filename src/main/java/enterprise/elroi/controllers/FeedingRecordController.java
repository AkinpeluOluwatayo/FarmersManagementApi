package enterprise.elroi.controllers;


import enterprise.elroi.dto.requests.FeedingRecordRequest;
import enterprise.elroi.dto.responses.ApiResponse;
import enterprise.elroi.dto.responses.FeedingRecordResponse;
import enterprise.elroi.services.FeedingRecordInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feeding-records")
public class FeedingRecordController {

    private FeedingRecordInterface feedingRecordService;

    @Autowired
    public FeedingRecordController(FeedingRecordInterface feedingRecordService){
        this.feedingRecordService = feedingRecordService;
    }

    @PostMapping("/enter")
    public ResponseEntity<?> enterFeed(@RequestBody FeedingRecordRequest request){
        try {
            FeedingRecordResponse feedingRecordResponse = feedingRecordService.enterFeed(request);
            return new ResponseEntity<>(feedingRecordResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<?> viewFeed(@PathVariable String id){
        try {
            FeedingRecordResponse feedingRecordResponse = feedingRecordService.viewFeed(id);
            return new ResponseEntity<>(feedingRecordResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
