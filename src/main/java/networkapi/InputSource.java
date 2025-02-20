package networkapi;

import java.util.List;

public class InputSource {

    private final List<Integer> data;

    public InputSource(List<Integer> data) {
        this.data = data;
    }

    public List<Integer> getData() {
        return data;
    }
}
