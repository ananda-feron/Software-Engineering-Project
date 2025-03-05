package implementations;

import apis.ComputeEngineAPI;

public class ComputeEngine implements ComputeEngineAPI {

    @Override
    public String compute(int value) {

            if (value <= 0) {
                throw new IllegalArgumentException("Number cannot be negative");
            }

            if (value > Integer.MAX_VALUE / 3) {
                throw new IllegalArgumentException("Number is too large for computation");
            }

            StringBuilder builder = new StringBuilder();

            builder.append(value);

            while (value != 1) {
                try {
                    if (value % 2 == 0) {
                        value = value / 2;
                    } else {
                        value = 3 * value + 1;
                    }
                    builder.append(",").append(value);
                } catch (Exception e){
                    return "An error occurred: " + e.getMessage();
                }
            }

            return builder.toString();
    }
}