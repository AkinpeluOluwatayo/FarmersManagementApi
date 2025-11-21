package enterprise.elroi.util;

import enterprise.elroi.data.models.FeedingRecords;
import enterprise.elroi.dto.responses.FeedingRecordResponse;

import java.time.format.DateTimeFormatter;

public class EnterFeedMapper {

    public static FeedingRecordResponse mapEnter(FeedingRecords record) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        FeedingRecordResponse response = new FeedingRecordResponse();
        response.setFeedType(record.getFeedType());
        response.setQuantity(record.getQuantity());
        response.setDate(record.getDate().format(formatter));
        response.setMessage("Feeding Records saved successfully");

        return response;
    }
}
