package processapi;

import project.annotations.ProcessAPIPrototype;

public class PrototypeComputeStorage {

	@ProcessAPIPrototype
    public void prototype(DataStore dataStore) {

        //read from compute engine output
        ReadInputResponse readResponse = dataStore.readFromInput(new ReadInputRequest());

        //write to user specified output
        WriteOutputResponse writeResponse = dataStore.writeToOutput(new WriteOutputRequest());

    }

}