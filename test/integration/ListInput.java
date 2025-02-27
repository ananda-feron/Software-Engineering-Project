package integration;

import apis.InputConfig;

import java.io.File;
import java.util.List;

public class ListInput implements InputConfig<File> {

    private final List<Integer> inputData;

    public ListInput(List<Integer> inputData) {
        this.inputData = inputData;
    }

    @Override
    public File getInput() {
        return (File) inputData;
    }
}
