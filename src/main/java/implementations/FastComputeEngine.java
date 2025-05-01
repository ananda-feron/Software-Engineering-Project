package implementations;

import apis.ComputeEngineAPI;

import java.util.HashMap;
import java.util.Map;

public class FastComputeEngine implements ComputeEngineAPI {

    private final Map<Integer, String> cache = new HashMap<>();

    @Override
    public String compute(int value) {

        if (value <= 0) {
            return "Number cannot be negative";
        }

        // Check cache first
        if (cache.containsKey(value)) {
            return cache.get(value); 
        }

        try {
            int original = value;
            StringBuilder builder = new StringBuilder();
            builder.append(value);

            while (value != 1) {
                if (value % 2 == 0) {
                    value = value / 2;
                } else {
                    value = 3 * value + 1;
                }

                builder.append(",").append(value);

                // If value is cached mid-sequence, append rest and break early
                if (cache.containsKey(value)) {
                    String cachedTail = cache.get(value);
                    String tail = cachedTail.substring(cachedTail.indexOf(",") + 1);
                    builder.append(",").append(tail);
                    break;
                }
            }

            String result = builder.toString();
            cache.put(original, result);
            return result;

        } catch (ArithmeticException e) {
            return "An error occurred during computation: " + e.getMessage();
        } catch (Exception e) {
            return "Unexpected runtime error: " + e.getMessage();
        }
    }
}
