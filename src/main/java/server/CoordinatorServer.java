package server;

import apis.ComputeEngineAPI;
import apis.DataStoreAPI;
import implementations.FileDataStore;
import implementations.ComputeEngine;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import remoteimps.RemoteComputationCoordinator;
import remoteimps.RemoteDataStore;

import java.io.IOException;
import java.rmi.Remote;

public class CoordinatorServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        ComputeEngineAPI computeEngine = new ComputeEngine();

        RemoteDataStore dataStore = new RemoteDataStore();

        Server server = ServerBuilder.forPort(9090)
                .addService(new RemoteComputationCoordinator(computeEngine, dataStore))
                .build();

        System.out.println("starting server on port 9090...");
        server.start();
        server.awaitTermination();

        System.out.println("server stopped");
    }
}
