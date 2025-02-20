package processapi;

import project.annotations.ProcessAPI;

@ProcessAPI
public interface DataStore {
    ReadResponse readFromInput(ReadInputRequest inputSourceRequest);

    WriteResponse writeToOutput(SendOutputRequest sendOutputRequest);
}
