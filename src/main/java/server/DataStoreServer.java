package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import remoteimps.old.RemoteDataStore;

import java.io.IOException;

public class DataStoreServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        Server slowServer = ServerBuilder.forPort(4040)
                .addService(new RemoteDataStore())
                .build();

        System.out.println("starting slow datastore server on port 4040...");
        slowServer.start();
        slowServer.awaitTermination();
        System.out.println("slow datastore server stopped");
    }
}
