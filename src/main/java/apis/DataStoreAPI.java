package apis;

import project.annotations.ProcessAPI;

@ProcessAPI
public interface DataStoreAPI {

    DataStoreReadResult read(InputConfig input);
    WriteResult appendSingleResult(OutputConfig output, String result, char delimiter);

}
