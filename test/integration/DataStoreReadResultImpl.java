package integration;

import apis.DataStoreReadResult;

import javax.annotation.Nullable;
import java.util.List;

public class DataStoreReadResultImpl implements DataStoreReadResult {

    private final Status status;
    private final List<Integer> results;

    public DataStoreReadResultImpl(Status status, List<Integer> results) {
        this.status = status;
        this.results = results;
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
}
