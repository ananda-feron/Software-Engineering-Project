package smoke;

import processapi.DataStore;
import processapi.ReadInputResponse;
import processapi.ReadInputRequest;
import processapi.WriteOutputRequest;
import processapi.WriteOutputResponse;

//import processapi.*;
//TODO NOT DONE. I will fix this at some point today.
//
public class InMemoryDataStore implements DataStore {
    @Override
    public ReadInputResponse readFromInput(ReadInputRequest readInputRequest) {
        return null;
    }

    @Override
    public WriteOutputResponse writeToOutput(WriteOutputRequest sendOutputRequest) {
        return null;
    }

}


