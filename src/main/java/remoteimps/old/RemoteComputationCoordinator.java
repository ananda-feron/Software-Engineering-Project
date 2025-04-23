package remoteimps.old;

import implementations.FileInput;
import implementations.FileOutput;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import protobuf.ComputationCoordinatorAPIGrpc.ComputationCoordinatorAPIImplBase;
import protobuf.DataStoreAPIGrpc;
import protobuf.DataStoreAPIOuterClass;
import protobuf.NetworkAPI;

import apis.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class RemoteComputationCoordinator extends ComputationCoordinatorAPIImplBase {
    private final ExecutorService executor = Executors.newFixedThreadPool(10);;
    protected final ComputeEngineAPI computeEngine;
    protected final RemoteDataStore dataStore;

    public RemoteComputationCoordinator(ComputeEngineAPI computeEngine, RemoteDataStore dataStore) {
        this.computeEngine = computeEngine;
        this.dataStore = dataStore;
    }

    @Override
    public void compute(NetworkAPI.ComputeRequest request, StreamObserver<NetworkAPI.ComputeResult> responseObserver) {

        //open connection to DataStoreServer
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 4040)
                .usePlaintext()
                .build();
        DataStoreAPIGrpc.DataStoreAPIBlockingStub blockingStub = DataStoreAPIGrpc.newBlockingStub(channel);

        if (request == null) {
//            return new ComputeResult(ComputeResult.ComputeResultStatus.FAILURE, "Error: request is invalid");
            responseObserver.onNext(NetworkAPI.ComputeResult.newBuilder()
                    .setStatus(NetworkAPI.ComputeResultStatus.UNKNOWN) //TODO: fix these unknowns (add more enums)
                    .setFailureMessage("Error: request is invalid")
                    .build());
            responseObserver.onCompleted();
        }

        InputConfig inputConfig = new FileInput(request.getInputConfig().getFilePath());
        OutputConfig outputConfig = new FileOutput(request.getOutputConfig().getFilePath());
        String delimiter = request.getDelimiter();

        DataStoreAPIOuterClass.DataStoreReadResult readResult = blockingStub.read(request.getInputConfig());

        try {

            if (readResult.getStatus() != DataStoreAPIOuterClass.DataStoreReadResult.Status.SUCCESS) {
//                return new ComputeResult(ComputeResult.ComputeResultStatus.FAILURE, readResult.getFailureMessage());
                responseObserver.onNext(NetworkAPI.ComputeResult.newBuilder()
                        .setStatus(NetworkAPI.ComputeResultStatus.UNKNOWN) //TODO: fix these unknowns (add more enums)
                        .setFailureMessage(readResult.getFailureMessage())
                        .build());
                responseObserver.onCompleted();
            }

            List<Integer> numbers = readResult.getResultsList();
//            readResult.getResults().forEach(numbers::add);
            System.out.println(numbers);

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
                    DataStoreAPIOuterClass.AppendRequest appendRequest = DataStoreAPIOuterClass.AppendRequest.newBuilder()
                            .setResultToAppend(computedValue)
                            .setOutput(request.getOutputConfig())
                            .setDelimiter(delimiter)
                            .build();
                    DataStoreAPIOuterClass.WriteResult writeResult = blockingStub.appendSingleResult(appendRequest); //nothing is ever done with writeResult.

                } catch (InterruptedException | ExecutionException e) {
//                    return new implementations.ComputeResult(implementations.ComputeResult.ComputeResultStatus.FAILURE, "Computation error: " + e.getMessage());
                    responseObserver.onNext(NetworkAPI.ComputeResult.newBuilder()
                            .setStatus(NetworkAPI.ComputeResultStatus.COMPUTATION_FAILURE)
                            .setFailureMessage("Computation error:" + e.getMessage())
                            .build());
                    responseObserver.onCompleted();
                }
            }

//            return new implementations.ComputeResult(implementations.ComputeResult.ComputeResultStatus.SUCCESS, "Computation Successful");
            responseObserver.onNext(NetworkAPI.ComputeResult.newBuilder()
                    .setStatus(NetworkAPI.ComputeResultStatus.SUCCESS)
                    .build());
            responseObserver.onCompleted();

        } catch (Exception e) {
//            return new implementations.ComputeResult(ComputeResult.ComputeResultStatus.FAILURE, "Unexpected runtime error: " + e.getMessage());
            responseObserver.onNext(NetworkAPI.ComputeResult.newBuilder()
                    .setStatus(NetworkAPI.ComputeResultStatus.UNKNOWN) //TODO: fix these unknowns (add more enums)
                    .setFailureMessage(e.getMessage())
                    .build());
            responseObserver.onCompleted();
        }
    }
}
