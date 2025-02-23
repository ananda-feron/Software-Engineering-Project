package apis;

public class ComputationCoordinatorImpl implements ComputationCoordinatorAPI {

    private final ComputeEngineAPI computeEngine;

    public ComputationCoordinatorImpl(ComputeEngineAPI computeEngine) {
        this.computeEngine = computeEngine;
    }

    @Override
    public ComputeResult compute(ComputeRequest request) {

        return null;
    }
}
