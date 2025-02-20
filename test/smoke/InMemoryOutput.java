package smoke;

import networkapi.OutputDestination;
import networkapi.OutputDestinationResponse;

public class InMemoryOutput implements OutputDestinationResponse {

    private final OutputDestination outputDestination;

    public InMemoryOutput(OutputDestination outputDestination) {
        this.outputDestination = outputDestination;
    }

    @Override
    public OutputDestination getOutputDestination() {
        return outputDestination;
    }
}
