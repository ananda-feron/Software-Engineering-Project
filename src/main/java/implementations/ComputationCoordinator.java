package implementations;

import apis.ComputeEngineAPI;
import apis.ComputeRequest;
import apis.DataStoreAPI;
import implementations.AbstractComputationCoordinator;

public class ComputationCoordinator extends AbstractComputationCoordinator {
    public ComputationCoordinator(ComputeEngineAPI computeEngine, DataStoreAPI dataStore) {
        super(computeEngine, dataStore);
    }

    @Override
    public ComputeResult compute(ComputeRequest request) {
        return super.compute(request); // Use shared logic for single-threaded
    }
}
