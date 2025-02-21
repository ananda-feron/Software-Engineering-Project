package processapi;

import project.annotations.ProcessAPI;

@ProcessAPI
public interface DataStore {
    ReadInputResponse readFromInput(ReadInputRequest readInputRequest);

    WriteOutputResponse writeToOutput(WriteOutputRequest sendOutputRequest);

}
