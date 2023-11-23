package dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryDatabaseServer.Server;

import io.grpc.Server;

import java.io.IOException;

public class FactoryDatabaseServerMain {
    public static void main(String[] args) {
        Server server = io.grpc.ServerBuilder
                .forPort(4444)
                .addService(new FactoryDatabaseServer())
                .build();
        try {
            server.start();
            server.awaitTermination();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
