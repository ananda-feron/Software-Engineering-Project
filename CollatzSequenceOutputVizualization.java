package implementations;

import apis.ComputeEngineAPI;
import java.util.ArrayList;
import java.util.List;

public class ComputeEngine implements ComputeEngineAPI {

    @Override

    //Compute sequence
    public String compute(int value) {

        try {
            if (value <= 0) {
                return "Number must be a positive integer.";
            }

            StringBuilder builder = new StringBuilder();
            List<Integer> sequence = new ArrayList<>();

            builder.append(value);
            sequence.add(value);

            while (value != 1) {
                try {
                    if (value % 2 == 0) {
                        value = value / 2;
                    } else {
                        value = 3 * value + 1;
                    }
                    builder.append(",").append(value);
                    sequence.add(value);
                } catch (ArithmeticException e) {
                    return "An error occurred during computation: " + e.getMessage();
                } catch (Exception e) {
                    return "An unexpected error occurred: " + e.getMessage();
                }
            }

            // Visualize the sequence
            CollatzChart.visualize(sequence);

            return builder.toString();

        } catch (Exception e){
            return "Unexpected runtime error: " + e.getMessage();
        }
    }

    // New method to get the sequence as a List<Integer>
    public List<Integer> computeSequence(int value) {
        List<Integer> sequence = new ArrayList<>();
        if (value <= 0) {
            throw new IllegalArgumentException("Number must be a positive integer.");
        }
        sequence.add(value);
        while (value != 1) {
            if (value % 2 == 0) {
                value = value / 2;
            } else {
                value = 3 * value + 1;
            }
            sequence.add(value);
        }
        return sequence;
    }
}
