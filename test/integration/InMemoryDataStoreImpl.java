package integration;

import apis.*;

import java.util.List;

public class InMemoryDataStoreImpl implements DataStoreAPI {
    @Override
    public DataStoreReadResult read(InputConfig input) {
        List<Integer> inputList = (List<Integer>) input.getInput(); //Is this good code practice?
        return new DataStoreReadResultImpl(DataStoreReadResult.Status.SUCCESS, inputList);
    }


    @Override
    public WriteResult appendSingleResult(OutputConfig output, String result, char delimiter) {
        List<String> outputList = (List<String>) output.getOutput(); //ditto
        outputList.add(result);
        return new WriteResultImpl(WriteResult.WriteResultStatus.SUCCESS);
    }

}
