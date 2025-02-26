package apis;

public interface ComputeResult {

    public ComputeResult SUCCESS = new ComputeResult() {

        public ComputeResultStatus getStatus() {
            return ComputeResultStatus.SUCCESS; //TODO: does this always return a successful getStatus?
        }

        public String getFailureMessage() {
            return "";
        }

    };

    ComputeResultStatus getStatus();
    String getFailureMessage();

    public static enum ComputeResultStatus {
        SUCCESS(true),
        INVALID_REQUEST(false), //TODO:
        FAILURE(false);

        private final boolean success;

        private ComputeResultStatus(boolean success) {
            this.success = success;
        }

        public boolean isSuccess() {
            return success;
        }
    }
}
