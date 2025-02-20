package networkapi;

import java.util.List;

public class OutputDestination {

    private final List<String> outputDestination;

    public OutputDestination(List<String> outputDestination) {
        this.outputDestination = outputDestination;
    }

    public List<String> getOutputDestination() {
        return outputDestination;
    }
}
