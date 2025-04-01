package implementations;

import apis.*;
import apis.ComputeResult;

import java.util.*;
import java.util.concurrent.*;

public class MultiThreadedComputationCoordinator implements ComputationCoordinatorAPI {

    private final ComputeEngineAPI computeEngine;
    private final DataStoreAPI datastore;
    ExecutorService executorService;
    private final int THREAD_LIMIT = 10;

    public MultiThreadedComputationCoordinator(ComputeEngineAPI computeEngine, DataStoreAPI datastore) {
        this.computeEngine = computeEngine;
        this.datastore = datastore;
        executorService = Executors.newFixedThreadPool(THREAD_LIMIT);
    }

    @Override
    public ComputeResult compute(ComputeRequest request) {
        return null;
    }
}

