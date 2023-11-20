package dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.BusinessServer_Actually_DB_Server;

import io.grpc.Server;

import java.io.IOException;

public class Slaughter_Business_Server {
    public static void main(String[] args) {
        Server server = io.grpc.ServerBuilder
                .forPort(1234)
                .addService(new Server_GRPC_Client())
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
