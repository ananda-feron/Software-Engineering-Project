package computestorageapi;

import usercomputeapi.OutputDestinationRequest;

import project.annotations.ProcessAPIPrototype;

public class PrototypeComputeStorage {

	@ProcessAPIPrototype
    public void prototype(DataStore dataStore) {

        //read from compute engine output
        ReadResponse readResponse = dataStore.readFromInput(new ReadInputRequest());

        //write to user specified output
        WriteResponse writeResponse = dataStore.writeToOutput(new OutputDestinationRequest());

    }

}