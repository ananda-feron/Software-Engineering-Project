package computestorageapi;

import usercomputeapi.OutputDestinationRequest;

public class ProcessAPIPrototype {

	@project.annotations.ProcessAPIPrototype
    public void prototype(DataStore dataStore) {

        //read from compute engine output
        ReadResponse readResponse = dataStore.readFromInput(new ReadInputRequest());

        //write to user specified output
        WriteResponse writeResponse = dataStore.writeToOutput(new OutputDestinationRequest());

    }

}