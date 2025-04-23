package server;

import apis.ComputeEngineAPI;
import implementations.ComputeEngine;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import remoteimps.old.RemoteComputationCoordinator;
import remoteimps.old.RemoteDataStore;

import java.io.IOException;

public class FastCoordinatorServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        ComputeEngineAPI computeEngine = new ComputeEngine();

        RemoteDataStore dataStore = new RemoteDataStore();

        Server fastServer = ServerBuilder.forPort(1010)
                .addService(new RemoteComputationCoordinator(computeEngine, dataStore))
                .build();

        System.out.println("starting fast server on port 1010...");
        fastServer.start();
        fastServer.awaitTermination();
        System.out.println("fast coordinator server stopped");
    }
}
