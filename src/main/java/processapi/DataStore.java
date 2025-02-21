package processapi;

import networkapi.OutputDestinationRequest;
import project.annotations.ProcessAPI;

@ProcessAPI
public interface DataStore {

    ReadResponse readFromInput(ReadInputRequest inputSourceRequest);

    WriteResponse writeToOutput(OutputDestinationRequest outputDestinationRequest);

}
