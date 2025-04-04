package integration.list;

import apis.InputConfig;

import java.util.List;

public class ListInput implements InputConfig {

    private final List<Integer> inputData;

    public ListInput(List<Integer> inputData) {
        this.inputData = inputData;
    }

    @Override
    public List<Integer> getInput() {
        return inputData;
    }
}
