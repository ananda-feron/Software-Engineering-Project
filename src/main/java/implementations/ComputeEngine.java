package implementations;

import apis.ComputeEngineAPI;

public class ComputeEngine implements ComputeEngineAPI {

    @Override
    public String compute(int value) {
        try {
            if (value <= 0) {
                return "Invalid input: " + value + ". Please provide a positive number.";
            }

            if (value > Integer.MAX_VALUE / 3) {
                return "Input value is too large and could cause overflow during computation.";
            }

            StringBuilder builder = new StringBuilder();

            builder.append(value);

            while (value != 1) {
                if (value % 2 == 0) {
                    value = value / 2;
                } else {
                    value = 3 * value + 1;
                }
                builder.append(",").append(value);
            }

            return builder.toString();
        } catch (Exception e){
         return "An error occurred: " + e.getMessage();
        }
    }
}
