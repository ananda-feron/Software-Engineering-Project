package implementations;

import apis.*;

import java.util.*;
import java.util.concurrent.*;

public class MultithreadedComputationCoordinator extends AbstractComputationCoordinator {
    private final ExecutorService executor;
    private final int THREAD_NUMBER = 10;

    public MultithreadedComputationCoordinator(ComputeEngineAPI computeEngine, DataStoreAPI dataStore) {
        super(computeEngine, dataStore);
        this.executor = Executors.newFixedThreadPool(THREAD_NUMBER);
    }

    @Override
    public ComputeResult compute(ComputeRequest request) {
        if (request == null) {
            return new ComputeResult(ComputeResult.ComputeResultStatus.FAILURE, "Error: request is invalid");
        }

        try {
            DataStoreReadResult readResult = dataStore.read(request.getInputConfig());
            if (readResult.getStatus() != DataStoreReadResult.Status.SUCCESS) {
                return new ComputeResult(ComputeResult.ComputeResultStatus.FAILURE, readResult.getFailureMessage());
            }

            List<Integer> numbers = new ArrayList<>();
            readResult.getResults().forEach(numbers::add);
            List<Future<String>> futureResults = new ArrayList<>();

            // Submit computation tasks to the thread pool
            for (int value : numbers) {
                futureResults.add(executor.submit(() -> computeEngine.compute(value)));
            }

            // Collect results after all threads finish
            for (Future<String> future : futureResults) {
                try {
                    String computedValue = future.get(); // Blocks until computation is done
                    dataStore.appendSingleResult(request.getOutputConfig(), computedValue, request.getDelimiter());
                } catch (InterruptedException | ExecutionException e) {
                    return new ComputeResult(ComputeResult.ComputeResultStatus.FAILURE, "Computation error: " + e.getMessage());
                }
            }

            return new ComputeResult(ComputeResult.ComputeResultStatus.SUCCESS, "Computation Successful");

        } catch (Exception e) {
            return new ComputeResult(ComputeResult.ComputeResultStatus.FAILURE, "Unexpected runtime error: " + e.getMessage());
        }
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}



