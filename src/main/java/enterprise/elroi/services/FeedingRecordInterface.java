package enterprise.elroi.services;

import enterprise.elroi.dto.requests.FeedingRecordRequest;
import enterprise.elroi.dto.responses.FeedingRecordResponse;

public interface FeedingRecordInterface {
    FeedingRecordResponse enterFeed(FeedingRecordRequest request);
    FeedingRecordResponse viewFeed(String id);
}
