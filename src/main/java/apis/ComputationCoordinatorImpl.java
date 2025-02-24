package apis;

import java.util.Iterator;

public class ComputationCoordinatorImpl implements ComputationCoordinatorAPI {

    private final ComputeEngineAPI computeEngine;
    private final DataStoreAPI dataStore;

    public ComputationCoordinatorImpl(ComputeEngineAPI computeEngine, DataStoreAPI dataStoreAPI) {
        this.computeEngine = computeEngine;
        this.dataStore = dataStoreAPI;
    }

    @Override
    public ComputeResult compute(ComputeRequest request) {

        DataStoreReadResult result = dataStore.read(request.getInputConfig());

        if (result.getStatus() == DataStoreReadResult.Status.SUCCESS) {

            Iterator<Integer> iterator = result.getResults().iterator();

            while (iterator.hasNext()) {
                int value = iterator.next();
                String computedValue = computeEngine.compute(value);
                WriteResult writeResult = dataStore.appendSingleResult(request.getOutputConfig(), computedValue, request.getDelimiter()); //writes using same delimiter specified for input
                if (writeResult.getStatus() != WriteResult.WriteResultStatus.SUCCESS) {
                    //return a ComputeResult with write error! TODO: (figure out how tf ComputeResult interface works)
                }
            }

        }

        return null; //null for now.

    }
}
