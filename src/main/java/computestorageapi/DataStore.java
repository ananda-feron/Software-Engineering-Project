package computestorageapi;

import usercomputeapi.OutputDestinationRequest;

public interface DataStore {
    ReadResponse readFromInput(ReadInputRequest inputSourceRequest);

    WriteResponse writeToOutput(OutputDestinationRequest outputDestinationRequest);
}
