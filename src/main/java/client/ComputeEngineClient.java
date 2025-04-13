package client;

import java.util.concurrent.TimeUnit;

import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import yourpackage.ComputationCoordinatorAPIGrpc;
import yourpackage.NetworkAPI.ComputeRequest;
import yourpackage.NetworkAPI.ComputeResult;
import yourpackage.NetworkAPI.ComputeResultStatus;

public class ComputeEngineClient { // Change to your class name
    private final ComputationCoordinatorAPIGrpc.ComputationCoordinatorAPIBlockingStub blockingStub; // Update to your service's blocking stub

    public ComputeEngineClient(Channel channel) {
        blockingStub = ComputationCoordinatorAPIGrpc.newBlockingStub(channel);  // Update to your service's stub
    }

    // Client call logic
    public void compute() {
        ComputeRequest request = ComputeRequest.newBuilder()
                .setInputConfig(ComputeRequest.InputConfig.newBuilder().setFilePath("path/to/file"))
                .setOutputConfig(ComputeRequest.OutputConfig.newBuilder().setFilePath("path/to/output"))
                .setDelimiter(",") // Optional delimiter
                .build();

        ComputeResult response;
        try {
            response = blockingStub.compute(request);
        } catch (StatusRuntimeException e) {
            e.printStackTrace();
            return;
        }

        // Handle the response
        if (response.getStatus() == ComputeResultStatus.SUCCESS) {
            System.out.println("Computation succeeded!");
        } else {
            System.err.println("Computation failed: " + response.getFailureMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        String target = "localhost:50051";  // Make sure this matches your server address and port

        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        try {
            ComputeEngineClient client = new ComputeEngineClient(channel); // Use the updated client class name
            client.compute();
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}

