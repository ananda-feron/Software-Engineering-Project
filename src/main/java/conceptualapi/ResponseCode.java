package conceptualapi;

public enum ResponseCode {
    SUCCESS(true),
    FAILURE(false);

    private boolean success;

    ResponseCode(boolean success) {
        this.success = success;
    }

    public boolean success() {
        return success;
    }
}

