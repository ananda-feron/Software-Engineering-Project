package processapi;

import networkapi.OutputDestinationRequest;
import project.annotations.ConceptualAPI;

public class EmptyImplementationProcessAPI implements DataStore{

    private ConceptualAPI conceptualAPI;

    private EmptyImplementationProcessAPI(ConceptualAPI conceptualAPI){
        this.conceptualAPI = conceptualAPI;
    }

    @Override
    public ReadResponse readFromInput(ReadInputRequest inputSourceRequest){
        return null;
    }

    @Override
    public WriteResponse writeToOutput(OutputDestinationRequest outputDestinationRequest){
        return null;
    }

}