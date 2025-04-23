package remoteimps.old;

import io.grpc.stub.StreamObserver;
import protobuf.DataStoreAPIOuterClass;
import protobuf.NetworkAPI;
import protobuf.DataStoreAPIGrpc.DataStoreAPIImplBase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoteDataStore extends DataStoreAPIImplBase {

    @Override
    public void read(NetworkAPI.InputConfig inputConfig, StreamObserver<DataStoreAPIOuterClass.DataStoreReadResult> responseObserver) {

        try {
            if (inputConfig == null) {
//                return new DataStoreReadResultImpl(DataStoreReadResult.Status.FAILURE, null, "Input is invalid.");
                responseObserver.onNext(DataStoreAPIOuterClass.DataStoreReadResult.newBuilder()
                        .setStatus(DataStoreAPIOuterClass.DataStoreReadResult.Status.FAILURE)
                        .setFailureMessage("Input is invalid")
                        .build());
                responseObserver.onCompleted();
            }

            List<Integer> integerList = new ArrayList<>();

            try {

                File inputFile = new File(inputConfig.getFilePath());
                Scanner scanner = new Scanner(inputFile);
                while (scanner.hasNextLine()) {
                    String[] values = scanner.nextLine().split(",");
                    //assumed to be .csv file
                    for (String value : values) {
                        try { //(validation)
                            integerList.add(Integer.parseInt(value));
                        } catch (NumberFormatException numberFormatException) {
                            System.err.println("skipping invalid number: " + value);
                        }
                    }
                }
            } catch (IOException ioException) {
//                return new DataStoreReadResultImpl(DataStoreReadResult.Status.FAILURE, null, "Error reading file: " + ioException.getMessage());
                responseObserver.onNext(DataStoreAPIOuterClass.DataStoreReadResult.newBuilder()
                        .setStatus(DataStoreAPIOuterClass.DataStoreReadResult.Status.FAILURE)
                        .setFailureMessage("Error reading file:" + ioException.getMessage())
                        .build());
                responseObserver.onCompleted();
            }

//            return new DataStoreReadResultImpl(DataStoreReadResult.Status.SUCCESS, integerList, "Successfully read file.");
            responseObserver.onNext(DataStoreAPIOuterClass.DataStoreReadResult.newBuilder()
                    .setStatus(DataStoreAPIOuterClass.DataStoreReadResult.Status.SUCCESS)
                    .addAllResults(integerList)
                    .build());
            responseObserver.onCompleted();
        } catch (Exception e){
//            return new DataStoreReadResultImpl(DataStoreReadResult.Status.FAILURE, null, "Unexpected runtime error: " + e.getMessage());
            responseObserver.onNext(DataStoreAPIOuterClass.DataStoreReadResult.newBuilder()
                    .setStatus(DataStoreAPIOuterClass.DataStoreReadResult.Status.FAILURE)
                    .setFailureMessage("Unexpected runtime error: " + e.getMessage())
                    .build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void appendSingleResult(DataStoreAPIOuterClass.AppendRequest appendRequest, StreamObserver<DataStoreAPIOuterClass.WriteResult> responseObserver) {
        try {
            if (appendRequest == null) {
//                return new WriteResultImpl(WriteResult.WriteResultStatus.FAILURE, "Output is invalid.");
                responseObserver.onNext(DataStoreAPIOuterClass.WriteResult.newBuilder()
                        .setFailureMessage("Output is invalid")
                        .setWriteResultStatus(DataStoreAPIOuterClass.WriteResult.WriteResultStatus.FAILURE)
                        .build());
                responseObserver.onCompleted();
            }
            try {
                File outputFile = new File(appendRequest.getOutput().getFilePath());
                if (!outputFile.exists()) {
                    System.out.println("Output file " + outputFile + " does not exist. creating it...");
                }
                FileWriter writer = new FileWriter(outputFile, true);
                writer.write(appendRequest.getResultToAppend() + appendRequest.getDelimiter() + "\n");
                writer.close();

            } catch (IOException ioException) {
//                return new WriteResultImpl(WriteResult.WriteResultStatus.FAILURE, "Error writing to file: " + ioException.getMessage());
                responseObserver.onNext(DataStoreAPIOuterClass.WriteResult.newBuilder()
                        .setFailureMessage("Error writing to file: " + ioException.getMessage())
                        .setWriteResultStatus(DataStoreAPIOuterClass.WriteResult.WriteResultStatus.FAILURE)
                        .build());
                responseObserver.onCompleted();
            }
//            return new WriteResultImpl(WriteResult.WriteResultStatus.SUCCESS, "Success writing to file.");
            responseObserver.onNext(DataStoreAPIOuterClass.WriteResult.newBuilder()
                    .setWriteResultStatus(DataStoreAPIOuterClass.WriteResult.WriteResultStatus.SUCCESS)
                    .build());
            responseObserver.onCompleted();

        } catch (Exception e){
//            return new WriteResultImpl(WriteResult.WriteResultStatus.FAILURE, "Unexpected runtime error: " + e.getMessage());
            responseObserver.onNext(DataStoreAPIOuterClass.WriteResult.newBuilder()
                    .setFailureMessage("Unexpected runtime error: " + e.getMessage())
                    .setWriteResultStatus(DataStoreAPIOuterClass.WriteResult.WriteResultStatus.FAILURE)
                    .build());
            responseObserver.onCompleted();
        }

    }
}
