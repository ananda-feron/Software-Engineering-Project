package server;

import apis.ComputeEngineAPI;
import implementations.ComputeEngine;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import remoteimps.old.RemoteComputationCoordinator;
import remoteimps.old.RemoteDataStore;

import java.io.IOException;

public class CoordinatorServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        ComputeEngineAPI computeEngine = new ComputeEngine();

        RemoteDataStore dataStore = new RemoteDataStore();

        Server slowServer = ServerBuilder.forPort(2020)
                .addService(new RemoteComputationCoordinator(computeEngine, dataStore))
                .build();

        System.out.println("starting slow server on port 2020...");
        slowServer.start();
        slowServer.awaitTermination();
        System.out.println("slow coordinator server stopped");
    }
}
