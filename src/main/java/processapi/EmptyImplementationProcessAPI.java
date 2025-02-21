package processapi;

import conceptualapi.InputStream;
import networkapi.OutputDestinationRequest;


public class EmptyImplementationProcessAPI implements DataStore{

    private InputStream inputStream;

    private EmptyImplementationProcessAPI(InputStream inputStream){
        this.inputStream = inputStream;
    }

    @Override
    public ReadInputResponse readFromInput(ReadInputRequest inputSourceRequest){
        return null;
    }

    @Override
    public WriteOutputResponse writeToOutput(WriteOutputRequest sendOutputRequest) {
        return null;
    }

}