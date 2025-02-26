package apis;

public class ComputeEngineImpl implements ComputeEngineAPI {

    @Override
    public String compute(int value) {

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

//        System.out.println(builder);

        return builder.toString();
    }
}
