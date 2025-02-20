package smoke;

import networkapi.InputSourceResponse;
import networkapi.OutputDestinationRequest;
import networkapi.OutputDestinationResponse;
import processapi.*;

import java.util.List;

public class InMemoryDataStore implements DataStore {

    private final InputSourceResponse inputSourceResponse;
    private final OutputDestinationResponse outputDestinationResponse;

    public InMemoryDataStore(InputSourceResponse inputSourceResponse, OutputDestinationResponse outputDestinationResponse) {
        this.inputSourceResponse = inputSourceResponse;
        this.outputDestinationResponse = outputDestinationResponse;
    }

    public ReadResponse readFromInput(ReadInputRequest inputSourceRequest) {
        List<Integer> inputData = inputSourceResponse.getInputSource().getData();
        return () -> inputData; //lambda expression
    }

    public WriteResponse writeToOutput(SendOutputRequest sendOutputRequest) {
        //TODO 
        return null;
    }

}
