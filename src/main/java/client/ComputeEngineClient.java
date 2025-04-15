package client;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import protobuf.ComputationCoordinatorAPIGrpc;
import protobuf.NetworkAPI;

import java.util.Scanner;

public class ComputeEngineClient {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String filepath = null;
//        int test = 0;
        String numbers = null;

        while (true) {
            System.out.println("1. upload file\n2.type in list");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("enter file path:");
                    filepath = scanner.next();
                    break;
                case 2:
                    System.out.println("enter numbers delimited by comma:");
                    numbers = scanner.next();
                    break;
                default:
                    System.err.println("invalid choice");
            }
            break;
        }


        //connection to server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        ComputationCoordinatorAPIGrpc.ComputationCoordinatorAPIBlockingStub blockingStub = ComputationCoordinatorAPIGrpc.newBlockingStub(channel);

        //input config
        NetworkAPI.InputConfig inputConfig = NetworkAPI.InputConfig.newBuilder()
                .setFilePath(filepath)
                .build();

        //output config
        NetworkAPI.OutputConfig outputConfig = NetworkAPI.OutputConfig.newBuilder()
                .setFilePath("/src/main/resources/output.txt")
                .build();

        NetworkAPI.ComputeRequest computeRequest = NetworkAPI.ComputeRequest.newBuilder()
                .setInputConfig(inputConfig)
                .setOutputConfig(outputConfig)
                .setDelimiter(",")
                .build();

        NetworkAPI.ComputeResult result = blockingStub.compute(computeRequest);
    }





}
