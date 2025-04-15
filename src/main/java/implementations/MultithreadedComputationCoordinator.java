package implementations;

import apis.*;

import java.util.*;
import java.util.concurrent.*;

public class MultithreadedComputationCoordinator extends AbstractComputationCoordinator {
    private final ExecutorService executor = Executors.newFixedThreadPool(10);

    public MultithreadedComputationCoordinator(ComputeEngineAPI computeEngine, DataStoreAPI dataStore) {
        super(computeEngine, dataStore);
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

            // Create a CountDownLatch to wait for all threads to finish
            CountDownLatch latch = new CountDownLatch(numbers.size());
            List<Future<String>> futureResults = new ArrayList<>();

            // Submit computation tasks to the thread pool
            for (int value : numbers) {
                futureResults.add(executor.submit(() -> {
                    String result = computeEngine.compute(value);
                    latch.countDown(); // Decrease the latch count once the task is done
                    return result;
                }));
            }

            // Wait for all tasks to complete
            latch.await();

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
}




