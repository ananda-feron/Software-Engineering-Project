package integration;

import apis.InputConfig;

import java.util.List;

public class ListInputImpl implements InputConfig {

    private final List<Integer> inputData;

    public ListInputImpl(List<Integer> inputData) {
        this.inputData = inputData;
    }

    @Override
    public List<Integer> getInputData() {
        return null;
    }
}
