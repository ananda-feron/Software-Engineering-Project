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
    public ComputeResult compute(ComputeRequest request) {
      
        if (request == null) {
            return new ComputeResult(apis.ComputeResult.ComputeResultStatus.FAILURE, "Error: request is invalid");
        }
        try {

            DataStoreReadResult readResult = dataStore.read(request.getInputConfig());

            if (readResult.getStatus() == DataStoreReadResult.Status.SUCCESS) {

                Iterator<Integer> iterator = readResult.getResults().iterator();

                while (iterator.hasNext()) {

                    int value = iterator.next();

                    String computedValue = computeEngine.compute(value);

                    WriteResult writeResult;
                    try {
                        writeResult = dataStore.appendSingleResult(request.getOutputConfig(), computedValue, request.getDelimiter()); //writes using same delimiter specified for input

                    } catch (Exception e) {
                        return new ComputeResult(apis.ComputeResult.ComputeResultStatus.WRITE_FAILURE, "Error writing to output file: " + e.getMessage());
                    }

                }
            }
            else {
                return new ComputeResult(apis.ComputeResult.ComputeResultStatus.FAILURE, readResult.getFailureMessage());
            }

            return new ComputeResult(apis.ComputeResult.ComputeResultStatus.SUCCESS, "Computation Successful");

        } catch (Exception e) {
            return new ComputeResult(apis.ComputeResult.ComputeResultStatus.FAILURE, "Unexpected runtime error: " + e.getMessage());
        }
    }
}
