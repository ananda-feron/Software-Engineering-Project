package integration;

import apis.OutputConfig;

import java.io.File;
import java.util.List;

public class ListOutput implements OutputConfig<File> {

    private final List<String> output;

    public ListOutput(List<String> output) {
        this.output = output;
    }

    @Override
    public File getOutput() {
        return (File) output;
    }

}
