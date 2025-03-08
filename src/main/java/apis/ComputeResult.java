package apis;

public interface ComputeResult {

    public ComputeResult SUCCESS = new ComputeResult() {

        public ComputeResultStatus getStatus() {
            return ComputeResultStatus.SUCCESS;
        }

        public String getFailureMessage() {
            return "";
        }

    };

    ComputeResultStatus getStatus();
    String getFailureMessage();

    public static enum ComputeResultStatus {
        SUCCESS(true),
        FAILURE(false),
        COMPUTATION_FAILURE(false),
        WRITE_FAILURE(false);

        private final boolean success;

        private ComputeResultStatus(boolean success) {
            this.success = success;
        }

        public boolean isSuccess() {
            return success;
        }
    }
}
