package apis;

public interface WriteResult {

    public static enum WriteResultStatus {
        SUCCESS,
        FAILURE;
    }

    WriteResultStatus getStatus();

}
