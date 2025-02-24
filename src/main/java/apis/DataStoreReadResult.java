package apis;

import javax.annotation.Nullable;

public interface DataStoreReadResult {

    public static enum Status {
        SUCCESS,
        FAILURE;
    }

    @Nullable
    public Iterable<Integer> getResults();

    public Status getStatus();
}
