package apis;

public class ComputeResultImpl implements ComputeResult {

    private final ComputeResultStatus computeResultStatus;
    private final String failureMessage;

    public ComputeResultImpl(ComputeResultStatus computeResultStatus, String failureMessage) {
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
