package computestorageapi;

import usercomputeapi.ComputeEngine;
import usercomputeapi.OutputDestination;
import usercomputeapi.OutputDestinationRequest;

public class EmptyImplementationProcessAPI implements DataStore{

    private DataStoreAPI dataStoreAPI;

    private EmptyImplementationProcessAPI(DataStoreAPI dataStoreAPI){
        this.dataStoreAPI = dataStoreAPI;
    }

    @Override
    ReadResponse readFromInput(ReadInputRequest InputSourceRequest){
        return null;
    }

    @Override
    WriteResponse writeToOutput(OutputDestinationRequest outputDestinationRequest){
        return null;
    }

}