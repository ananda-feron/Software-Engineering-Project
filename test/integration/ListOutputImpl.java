package integration;

import apis.OutputConfig;

import java.util.List;

public class ListOutputImpl implements OutputConfig {

    private final List<String> output;

    public ListOutputImpl(List<String> output) {
        this.output = output;
    }


    public void writeOutput(List<String> outputData) {

    }

}
