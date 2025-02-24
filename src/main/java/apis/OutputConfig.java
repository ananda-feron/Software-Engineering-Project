package apis;

import java.util.List;
public interface OutputConfig {

    void writeOutput(String newData); //not generic enough?

    List<String> getOutput();
// TODO: eventually remove void return type.

}
