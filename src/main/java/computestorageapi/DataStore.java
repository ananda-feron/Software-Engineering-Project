package computestorageapi;

import usercomputeapi.OutputDestinationRequest;

public interface DataStore {
    ReadResponse readFromInput(readInputRequest inputSourceRequest);

    WriteResponse writeToOutput(OutputDestinationRequest outputDestinationRequest);
}
