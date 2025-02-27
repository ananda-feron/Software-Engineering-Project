package implementations;

public class ComputeResult implements apis.ComputeResult {

    private final ComputeResultStatus computeResultStatus;
    private final String failureMessage;

    public ComputeResult(ComputeResultStatus computeResultStatus, String failureMessage) {
        this.computeResultStatus = computeResultStatus;
        this.failureMessage = failureMessage;
    }

    @Override
    public ComputeResultStatus getStatus() {
        return computeResultStatus;
    }

    @Override
    public String getFailureMessage() {
        return failureMessage;
    }
}
