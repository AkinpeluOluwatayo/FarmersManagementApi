package enterprise.elroi.util;

import enterprise.elroi.data.models.FeedingRecords;
import enterprise.elroi.dto.responses.FeedingRecordResponse;

import java.time.format.DateTimeFormatter;

public class EnterFeedMapper {

    public static FeedingRecordResponse mapEnter(FeedingRecords record) {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy hh:mm a");

        FeedingRecordResponse response = new FeedingRecordResponse();
        response.setFeedType(record.getFeedType());
        response.setQuantity(record.getQuantity());


        response.setDate(formatter.format(record.getDate()));

        response.setMessage("Feeding Records saved successfully");

        return response;
    }
}
