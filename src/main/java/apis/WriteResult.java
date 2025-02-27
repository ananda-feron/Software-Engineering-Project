package apis;

import java.util.List;

public interface WriteResult {

    public static enum WriteResultStatus {
        SUCCESS,
        FAILURE;
    }

    WriteResultStatus getStatus();

}
