package apis;

public class ComputeEngineImpl implements ComputeEngineAPI {

    @Override
    public String compute(int value) {

        //I think we should rename "compute" to "computeCollatzSequence"
        //Also I know this won't pass the test. Adjust the code here so it
        //passes it.

        /*
        if (value <= 0) {
            throw new IllegalArgumentException("Value must be a positive integer.");
        }

        (Maybe we need an exception?)
        */

        StringBuilder builder = new StringBuilder();

        while(value != 1) {
            builder.append(value).append(" -> ");
            if(value % 2 == 0) {
                value = value / 2;
            } else {
                value = 3 * value + 1;
            }
        }

        builder.append("1");

        return builder.toString();
    }
}
