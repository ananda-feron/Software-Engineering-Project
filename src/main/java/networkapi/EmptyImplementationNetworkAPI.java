package networkapi;

import conceptualapi.InputStream;

public class EmptyImplementationNetworkAPI implements ComputeEngine {

    //fields
    private InputStream inputStream;

    //constructor
    public EmptyImplementationNetworkAPI(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public InputSourceResponse requestInput(InputSourceRequest inputSourceRequest) {
        return null;
    }

    public DelimiterResponse requestDelimiter(DelimiterRequest delimiterRequest) {
        return null;
    }

    public OutputDestinationResponse requestOutputDestination(OutputDestinationRequest outputDestinationRequest) {
        return null;
    }
    public SendDataResponse sendData(InputSource inputSource, String delimiter, OutputDestination output) {
        return null;
    }
}
