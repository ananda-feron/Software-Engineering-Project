package apis;

public class ComputationCoordinatorImpl implements ComputationCoordinatorAPI {

    private final ComputeEngineAPI computeEngine;
    private final DataStoreAPI dataStoreAPI;

    public ComputationCoordinatorImpl(ComputeEngineAPI computeEngine, DataStoreAPI dataStoreAPI) {
        this.computeEngine = computeEngine;
        this.dataStoreAPI = dataStoreAPI;
    }

    @Override
    public ComputeResult compute(ComputeRequest request) {

        return null;

    }
}
