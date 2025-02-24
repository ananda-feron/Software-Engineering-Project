package integration;

import apis.WriteResult;

public class WriteResultImpl implements WriteResult {

    private final WriteResultStatus writeResultStatus;

    public WriteResultImpl(WriteResultStatus writeResultStatus) {
        this.writeResultStatus = writeResultStatus;
    }

    @Override
    public WriteResultStatus getStatus() {
        return writeResultStatus;
    }
}
