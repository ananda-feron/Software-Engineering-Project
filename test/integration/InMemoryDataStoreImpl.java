package integration;

import apis.*;

import java.util.List;

public class InMemoryDataStoreImpl implements DataStoreAPI {
    @Override
    public DataStoreReadResult read(InputConfig input) {
        List<Integer> data = input.getInputData();
        return new DataStoreReadResultImpl(DataStoreReadResult.Status.SUCCESS, data);
    }


    @Override
    public WriteResult appendSingleResult(OutputConfig output, String result, char delimiter) {
        output.writeOutput(result);
        return new WriteResultImpl(WriteResult.WriteResultStatus.SUCCESS);
    }

}
