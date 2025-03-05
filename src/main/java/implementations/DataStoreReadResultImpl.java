package implementations;

import apis.DataStoreReadResult;

import javax.annotation.Nullable;
import java.util.List;

public class DataStoreReadResultImpl implements DataStoreReadResult {

    private final Status status;
    private final List<Integer> results;
    private final String failureMessage;

    public DataStoreReadResultImpl(Status status, List<Integer> results, String failureMessage) {
        this.status = status;
        this.results = results;
        this.failureMessage = failureMessage;
    }

    @Nullable
    @Override
    public Iterable<Integer> getResults() {
        return results;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    public String getFailureMessage() {
        return failureMessage;
    }
}
