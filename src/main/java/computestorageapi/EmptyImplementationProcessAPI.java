package computestorageapi;

import project.annotations.ConceptualAPI;
import usercomputeapi.ComputeEngine;
import usercomputeapi.OutputDestination;
import usercomputeapi.OutputDestinationRequest;

public class EmptyImplementationProcessAPI implements DataStore{

    private ConceptualAPI conceptualAPI;

    private EmptyImplementationProcessAPI(ConceptualAPI conceptualAPI){
        this.conceptualAPI = conceptualAPI;
    }

    @Override
    public ReadResponse readFromInput(ReadInputRequest InputSourceRequest){
        return null;
    }

    @Override
    public WriteResponse writeToOutput(OutputDestinationRequest outputDestinationRequest){
        return null;
    }

}
