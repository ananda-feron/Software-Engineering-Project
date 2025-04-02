package implementations;

import apis.*;

import java.util.concurrent.*;

public class MultiThreadedComputationCoordinator extends AbstractComputationCoordinator {
    
    ExecutorService executorService;
    private final int THREAD_LIMIT = 10;

    public MultiThreadedComputationCoordinator(ComputeEngineAPI computeEngine, DataStoreAPI datastore) {
        super(computeEngine, datastore);
        executorService = Executors.newFixedThreadPool(THREAD_LIMIT);
    }

    @Override
    public ComputeResult compute(ComputeRequest request) {
        return null;
    }
}

