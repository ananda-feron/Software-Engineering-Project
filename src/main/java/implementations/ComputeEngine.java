package implementations;

import apis.ComputeEngineAPI;

public class ComputeEngine implements ComputeEngineAPI {

    @Override
    public String compute(int value) {

        if(value <= 0){
            throw new IllegalArgumentException("Error: value most be positive. Your input: " + value);
        }

        StringBuilder builder = new StringBuilder();

        builder.append(value);

        while(value != 1) {
            if(value % 2 == 0) {
                value = value / 2;
            } else {
                value = 3 * value + 1;
            }
            builder.append(",").append(value);
        }

        return builder.toString();
    }
}
