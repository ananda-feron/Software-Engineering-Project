package client;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import protobuf.ComputationCoordinatorAPIGrpc;
import protobuf.NetworkAPI;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComputeEngineClient {

    public static void main(String[] args) throws IOException {
        //TODO: add exception handling here.

        Scanner scanner = new Scanner(System.in);
        String inputFilePath = null;
        String outputFilePath = null;
        List<Integer> numbers = new ArrayList<>();

        while (true) {
            System.out.println("1. upload file\n2.type in a list");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("enter input file path:");
                    inputFilePath = scanner.next();
                    System.out.println("enter output file path:");
                    outputFilePath = scanner.next();
                    break;
                case 2:
                    System.out.println("enter output file path:");
                    outputFilePath = scanner.next();
                    System.out.println("enter positive integers, type -1 to exit:");
                    while (true) {
                        int num = scanner.nextInt();
                        if (num == -1) {
                            break;
                        } else if (num < 0) {
                            System.err.println("enter positive integers, type -1 to exit:");
                            continue;
                        }
                        numbers.add(num);
                    }
                    break;
                default:
                    System.err.println("invalid choice");
            }
            break;
        }

        //connection to server (currently connected to slow server, port 2020.)
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 2020)
                .usePlaintext()
                .build();

        ComputationCoordinatorAPIGrpc.ComputationCoordinatorAPIBlockingStub blockingStub = ComputationCoordinatorAPIGrpc.newBlockingStub(channel);

        //input config
        NetworkAPI.InputConfig inputConfig;

        //if input type is a file
        if (inputFilePath != null) {
            inputConfig = NetworkAPI.InputConfig.newBuilder()
                    .setFilePath(inputFilePath)
                    .build();
        } else { //if input type is a typed list, make it into a temp file.
            File listTempFile = new File("src/main/resources/list-input.tmp");
            try (FileWriter fileWriter = new FileWriter(listTempFile.getAbsolutePath())) {
                for (Integer i : numbers) {
                    fileWriter.write(i + ",");
                }
            }

            inputConfig = NetworkAPI.InputConfig.newBuilder()
                    .setFilePath("src/main/resources/list-input.tmp")
                    .build();

            listTempFile.deleteOnExit();
        }

        //output config
        NetworkAPI.OutputConfig outputConfig = NetworkAPI.OutputConfig.newBuilder()
                .setFilePath(outputFilePath)
                .build();

        NetworkAPI.ComputeRequest computeRequest = NetworkAPI.ComputeRequest.newBuilder()
                .setInputConfig(inputConfig)
                .setOutputConfig(outputConfig)
                .setDelimiter(",")
                .build();

        NetworkAPI.ComputeResult result = blockingStub.compute(computeRequest);

        System.out.println("Status message: " + result.getStatus());

    }





}
