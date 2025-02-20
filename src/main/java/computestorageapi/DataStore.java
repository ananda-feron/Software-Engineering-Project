package computestorageapi;

import usercomputeapi.OutputDestinationRequest;

import project.annotations.ProcessAPI;

@ProcessAPI
public interface DataStore {

    ReadResponse readFromInput(ReadInputRequest inputSourceRequest);

    WriteResponse writeToOutput(OutputDestinationRequest outputDestinationRequest);

}