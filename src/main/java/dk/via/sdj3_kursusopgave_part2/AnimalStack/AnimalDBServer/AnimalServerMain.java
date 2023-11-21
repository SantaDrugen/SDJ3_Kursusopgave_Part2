package dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalDBServer;

import io.grpc.Server;

import java.io.IOException;

public class AnimalServerMain {
    public static void main(String[] args) {
        Server server = io.grpc.ServerBuilder
                .forPort(2345)
                .addService(new AnimalDatabaseServer())
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
