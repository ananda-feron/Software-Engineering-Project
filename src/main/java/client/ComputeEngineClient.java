package client;

import java.util.concurrent.TimeUnit;

import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;

// Updated imports to match the proto package structure
import protobuf.NetworkAPI.ComputeRequest;
import protobuf.NetworkAPI.ComputeResult;
import protobuf.NetworkAPI.ComputeResultStatus;
import protobuf.NetworkAPI.InputConfig;
import protobuf.NetworkAPI.OutputConfig;
import protobuf.ComputationCoordinatorAPIGrpc;

public class ComputeEngineClient {
    private final ComputationCoordinatorAPIGrpc.ComputationCoordinatorAPIBlockingStub blockingStub;

    public ComputeEngineClient(Channel channel) {
        blockingStub = ComputationCoordinatorAPIGrpc.newBlockingStub(channel);
    }

    // Client call logic
    public void compute() {
        // Create InputConfig and OutputConfig instances
        InputConfig inputConfig = InputConfig.newBuilder()
                .setFilePath("path/to/file")
                .build();

        OutputConfig outputConfig = OutputConfig.newBuilder()
                .setFilePath("path/to/output")
                .build();

        // Use the created configs in the ComputeRequest
        ComputeRequest request = ComputeRequest.newBuilder()
                .setInputConfig(inputConfig)
                .setOutputConfig(outputConfig)
                .setDelimiter(",")
                .build();

        ComputeResult response;
        try {
            response = blockingStub.compute(request);
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
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
            ComputeEngineClient client = new ComputeEngineClient(channel);
            client.compute();
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}

