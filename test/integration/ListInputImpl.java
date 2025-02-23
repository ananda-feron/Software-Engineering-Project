package integration;

import apis.InputConfig;

import java.util.List;

public class ListInputImpl implements InputConfig {

    private final List<Integer> input;

    public ListInputImpl(List<Integer> input) {
        this.input = input;
    }

    public List<Integer> getInputData() {
        return input;
    }
}
