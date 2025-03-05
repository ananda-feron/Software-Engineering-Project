package implementations;

import apis.WriteResult;

public class WriteResultImpl implements WriteResult {

    private final WriteResultStatus writeResultStatus;
    private final String errorMessage;

    public WriteResultImpl(WriteResultStatus writeResultStatus, String errorMessage) {
        this.writeResultStatus = writeResultStatus;
        this.errorMessage = errorMessage;
    }

    @Override
    public WriteResultStatus getStatus() {
        return writeResultStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
