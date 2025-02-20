package networkapi;

import conceptualapi.InputStream;

public class EmptyImplementationNetworkAPI implements ComputeEngine {

    //fields
    private InputStream inputStream;

    //constructor
    public EmptyImplementationNetworkAPI(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public InputSourceResponse requestInput(InputSourceRequest inputSourceRequest) {
        return null;
    }

    @Override
    public DelimiterResponse requestDelimiter(DelimiterRequest delimiterRequest) {
        return null;
    }

    @Override
    public OutputDestinationResponse requestOutputDestination(OutputDestinationRequest outputDestinationRequest) {
        return null;
    }

    @Override
    public SendDataResponse sendData(InputSource inputSource, String delimiter, OutputDestination output) {
        return null;
    }
}
