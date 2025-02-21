package networkapi;
import project.annotations.NetworkAPI;

@NetworkAPI
public interface ComputeEngine {

    InputSourceResponse requestInput(InputSourceRequest inputSourceRequest);

    DelimiterResponse requestDelimiter(DelimiterRequest delimiterRequest);

    OutputDestinationResponse requestOutputDestination(OutputDestinationRequest outputDestinationRequest);

    SendDataResponse sendData(InputSource inputSource, String delimiter, OutputDestination output);
}