package implementations;

import apis.WriteResult;

import java.io.File;
import java.util.List;

public class WriteResultImpl implements WriteResult {

    private final WriteResultStatus writeResultStatus;

    public WriteResultImpl(WriteResultStatus writeResultStatus ) {
        this.writeResultStatus = writeResultStatus;
    }

    @Override
    public WriteResultStatus getStatus() {
        return writeResultStatus;
    }
}
