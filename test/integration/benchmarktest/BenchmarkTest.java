package integration.benchmarktest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.Test;
import protobuf.ComputationCoordinatorAPIGrpc;
import protobuf.NetworkAPI;

public class BenchmarkTest {


    @Test
    public void benchmark() throws InterruptedException {

        /**
         * instructions:
         * start all four servers in src/java/server
         * run this file.
         */

        //connection to server,
        // port 1010 is faster version.
        ManagedChannel fastChannel = ManagedChannelBuilder.forAddress("localhost", 1010)
                .usePlaintext()
                .build();

        //port 2020 is slower version.
        ManagedChannel slowChannel = ManagedChannelBuilder.forAddress("localhost", 2020)
                .usePlaintext()
                .build();

        ComputationCoordinatorAPIGrpc.ComputationCoordinatorAPIBlockingStub fastBlockingStub = ComputationCoordinatorAPIGrpc.newBlockingStub(fastChannel);
        ComputationCoordinatorAPIGrpc.ComputationCoordinatorAPIBlockingStub slowBlockingStub = ComputationCoordinatorAPIGrpc.newBlockingStub(slowChannel);

        NetworkAPI.InputConfig inputConfig = NetworkAPI.InputConfig.newBuilder()
                .setFilePath("test/integration/benchmarktest/input.csv")
                .build();

        NetworkAPI.OutputConfig outputConfig = NetworkAPI.OutputConfig.newBuilder()
                .setFilePath("test/integration/benchmarktest/output.txt")
                .build();

        NetworkAPI.ComputeRequest computeRequest = NetworkAPI.ComputeRequest.newBuilder()
                .setInputConfig(inputConfig)
                .setOutputConfig(outputConfig)
                .setDelimiter(",")
                .build();

        //warmup phase
        for (int i = 0; i < 5; i++) {
            fastBlockingStub.compute(computeRequest);
            slowBlockingStub.compute(computeRequest);
        }

        long fastTime = timeCalculator(fastBlockingStub, computeRequest);
        System.out.println("Fast time: " + fastTime);
        long slowTime = timeCalculator(slowBlockingStub, computeRequest);
        System.out.println("Slow time: " + slowTime);

        System.out.println("percentage faster: " + ((slowTime - fastTime) / (1.0 * slowTime) * 100) + "%");

    }

    private long timeCalculator(ComputationCoordinatorAPIGrpc.ComputationCoordinatorAPIBlockingStub blockingStub, NetworkAPI.ComputeRequest request) throws InterruptedException {
        long timeStart = System.currentTimeMillis();

        int runs = 20;
        for (int i = 0; i < runs; i++) {
            blockingStub.compute(request);
        }

        long timeEnd = System.currentTimeMillis();
        return (timeEnd - timeStart);
    }
}
