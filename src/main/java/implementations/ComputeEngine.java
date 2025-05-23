package implementations;

import apis.ComputeEngineAPI;


public class ComputeEngine implements ComputeEngineAPI {

    @Override
    public String compute(int value) {

        try {
            if (value <= 0) {
                return "Number must be a positive integer.";
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

        } catch (Exception e){
            return "Unexpected runtime error: " + e.getMessage();
        }
    }
}