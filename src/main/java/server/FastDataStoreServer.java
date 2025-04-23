package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import remoteimps.old.RemoteDataStore;

import java.io.IOException;

public class FastDataStoreServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        Server fastServer = ServerBuilder.forPort(3030)
                .addService(new RemoteDataStore())
                .build();

        System.out.println("starting fast datastore server on port 3030...");
        fastServer.start();
        fastServer.awaitTermination();
        System.out.println("fast datastore server stopped");
    }
}
