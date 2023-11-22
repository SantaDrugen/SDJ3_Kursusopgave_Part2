package dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.SlaughterDBServer;

import io.grpc.Server;

import java.io.IOException;

public class SlaughterDatabaseMain {
    public static void main(String[] args) {
        Server server = io.grpc.ServerBuilder
                .forPort(1234)
                .addService(new SlaughterDatabaseServer())
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
