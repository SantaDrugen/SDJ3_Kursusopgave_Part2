package dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalDatabaseServer;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class DatabaseServerMain {
    public static void main(String[] args) {
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new DatabaseServer())
                .build();

        try {
            server.start();
            server.awaitTermination();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Server started");
    }
}
