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
            return new ComputeResult(apis.ComputeResult.ComputeResultStatus.FAILURE, "Request is null.");
        }
        try {

            DataStoreReadResult readResult = dataStore.read(request.getInputConfig());

            if (readResult == null) {
                return new ComputeResult(apis.ComputeResult.ComputeResultStatus.FAILURE, "Error reading input file: " + request.getInputConfig().getInput().toString());
            }

            if (readResult.getStatus() == DataStoreReadResult.Status.SUCCESS) {

                Iterator<Integer> iterator = readResult.getResults().iterator();

                while (iterator.hasNext()) {

                    int value = iterator.next();

                    String computedValue;
                    try {
                        computedValue = computeEngine.compute(value);
                    } catch (Exception e) {
                        return new ComputeResult(apis.ComputeResult.ComputeResultStatus.COMPUTATION_FAILURE, "Error computing value: " + e.getMessage());
                    }

                    WriteResult writeResult;
                    try {
                        writeResult = dataStore.appendSingleResult(request.getOutputConfig(), computedValue, request.getDelimiter()); //writes using same delimiter specified for input
                    } catch (Exception e) {
                        return new ComputeResult(apis.ComputeResult.ComputeResultStatus.WRITE_FAILURE, "Error writing to output file: " + e.getMessage());
                    }

                }
            }

            return new ComputeResult(apis.ComputeResult.ComputeResultStatus.SUCCESS, "Computation Successful");

        } catch (Exception e) {
            return new ComputeResult(apis.ComputeResult.ComputeResultStatus.FAILURE, "Unexpected runtime error: " + e.getMessage());
        }
    }
}
