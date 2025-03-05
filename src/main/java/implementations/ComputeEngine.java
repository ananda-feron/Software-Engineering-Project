package implementations;

import apis.ComputeEngineAPI;

public class ComputeEngine implements ComputeEngineAPI {

    @Override
    public String compute(int value) {

            if (value <= 0) {
                return "Error: Number cannot be negative";
            }

            if (value > Integer.MAX_VALUE / 3) {
                return "Error: Number is too large for computation";
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
                } catch (ArithmeticException e) {
                    return "An error occurred during computation: " + e.getMessage();
                } catch (Exception e) {
                    return "An unexpected error occurred: " + e.getMessage();
                }
            }

            return builder.toString();
    }
}