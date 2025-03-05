package integration;

import apis.*;
import implementations.DataStoreReadResultImpl;
import implementations.WriteResultImpl;

import java.util.List;

public class ListDataStore implements DataStoreAPI {
    @Override
    public DataStoreReadResult read(InputConfig input) {
        List<Integer> inputList = (List<Integer>) input.getInput(); //Is this good code practice?
        return new DataStoreReadResultImpl(DataStoreReadResult.Status.SUCCESS, inputList, "Successfully read list.");
    }


    @Override
    public WriteResult appendSingleResult(OutputConfig output, String result, char delimiter) {
        List<String> outputList = (List<String>) output.getOutput(); //ditto
        outputList.add(result);
        return new WriteResultImpl(WriteResult.WriteResultStatus.SUCCESS);
    }

}
