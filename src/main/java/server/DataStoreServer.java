package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import remoteimps.RemoteComputationCoordinator;
import remoteimps.RemoteDataStore;

import java.io.IOException;

public class DataStoreServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        Server server = ServerBuilder.forPort(8080)
                .addService(new RemoteDataStore())
                .build();

        System.out.println("starting server on port 8080...");
        server.start();
        server.awaitTermination();
    }
}
