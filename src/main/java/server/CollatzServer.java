package server;

import apis.ComputeEngineAPI;
import apis.DataStoreAPI;
import implementations.FileDataStore;
import implementations.ComputeEngine;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import remoteimps.RemoteComputationCoordinator;

import java.io.IOException;

public class CollatzServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        ComputeEngineAPI computeEngine = new ComputeEngine();

        DataStoreAPI dataStore = new FileDataStore();

        Server server = ServerBuilder.forPort(9090)
                .addService(new RemoteComputationCoordinator(computeEngine, dataStore))
                .build();

        System.out.println("starting server on port 9090...");
        server.start();
        server.awaitTermination();

        System.out.println("server stopped");
    }
}
