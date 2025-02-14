package usercomputeapi;
import project.annotations.NetworkAPIPrototype;

public class PrototypeUserToCompute {
	@NetworkAPIPrototype
    public void prototype(ComputeEngine computeEngine) {

        //request input source
        InputSourceResponse inputSourceResponse = computeEngine.requestInput(new InputSourceRequest());

        //request delimiter
        DelimiterResponse delimiterResponse = computeEngine.requestDelimiter(new DelimiterRequest());
        String delimiter = delimiterResponse.getDelimiter();
        if (delimiterResponse.getDelimiter() == null || delimiterResponse.getDelimiter().isEmpty()) {
            delimiter = ",";
        }

        //request output destination
        OutputDestinationResponse outputDestinationResponse = computeEngine.requestOutputDestination(new OutputDestinationRequest());

        //send data
        SendDataResponse sendDataResponse = computeEngine.sendData(inputSourceResponse.getInputSource(), delimiter, outputDestinationResponse.getOutputDestination());

    }
}
