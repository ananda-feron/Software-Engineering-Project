package computestorageapi;

import usercomputeapi.OutputDestinationRequest;

public class PrototypeComputeStorage {

    public void prototype(DataStore dataStore) {

        //read from compute engine output
        ReadResponse readResponse = dataStore.readFromInput(new readInputRequest());

        //write to user specified output
        WriteResponse writeResponse = dataStore.writeToOutput(new OutputDestinationRequest());

    }

}