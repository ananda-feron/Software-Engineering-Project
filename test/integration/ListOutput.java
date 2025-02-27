package integration;

import apis.OutputConfig;

import java.util.List;

public class ListOutput implements OutputConfig {

    private final List<String> output;

    public ListOutput(List<String> output) {
        this.output = output;
    }

    @Override
    public List<String> getOutput() {
        return output;
    }

}
