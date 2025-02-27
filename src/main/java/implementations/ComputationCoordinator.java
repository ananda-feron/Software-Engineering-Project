package implementations;

import apis.*;

import java.util.Iterator;

public class ComputationCoordinator implements ComputationCoordinatorAPI {

    private final ComputeEngineAPI computeEngine;
    private final DataStoreAPI dataStore;

    public ComputationCoordinator(ComputeEngineAPI computeEngine, DataStoreAPI dataStoreAPI) {
        this.computeEngine = computeEngine;
        this.dataStore = dataStoreAPI;
    }

    @Override
    public apis.ComputeResult compute(ComputeRequest request) {

        DataStoreReadResult readResult = dataStore.read(request.getInputConfig());

        if (readResult.getStatus() == DataStoreReadResult.Status.SUCCESS) {

            Iterator<Integer> iterator = readResult.getResults().iterator();

            while (iterator.hasNext()) {
                int value = iterator.next();
                String computedValue = computeEngine.compute(value);
                WriteResult writeResult = dataStore.appendSingleResult(request.getOutputConfig(), computedValue, request.getDelimiter()); //writes using same delimiter specified for input
                if (writeResult.getStatus() != WriteResult.WriteResultStatus.SUCCESS) {
                    return new ComputeResult(apis.ComputeResult.ComputeResultStatus.FAILURE, "Error writing data.");
                }
            }

        }
        return new ComputeResult(apis.ComputeResult.ComputeResultStatus.SUCCESS, "Computation Successful");
    }
}
