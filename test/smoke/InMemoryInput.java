package smoke;

import networkapi.InputSource;
import networkapi.InputSourceResponse;

public class InMemoryInput implements InputSourceResponse {

    private final InputSource inputSource;

    public InMemoryInput(InputSource inputSource) {
        this.inputSource = inputSource;
    }

    @Override
    public InputSource getInputSource() {
        return inputSource;
    }
}
