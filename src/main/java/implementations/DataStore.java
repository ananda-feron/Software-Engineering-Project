package implementations;

import apis.*;

public class DataStore implements DataStoreAPI {

    private final DataStoreAPI dataStoreAPI;

    public DataStore(DataStoreAPI dataStoreAPI) {
        this.dataStoreAPI = dataStoreAPI;
    }

    public DataStoreReadResult read(InputConfig input){
        return dataStoreAPI.read(input);
    }

    public WriteResult appendSingleResult(OutputConfig output, String result, char delimiter){
        return dataStoreAPI.appendSingleResult(output, result, delimiter);
    }

}
