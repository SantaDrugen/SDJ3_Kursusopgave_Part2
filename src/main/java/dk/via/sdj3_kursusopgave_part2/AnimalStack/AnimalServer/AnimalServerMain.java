package dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalServer;

import dk.via.sdj3_kursusopgave_part2.AnimalServiceGrpc;
import dk.via.sdj3_kursusopgave_part2.CreateFarmRequest;
import dk.via.sdj3_kursusopgave_part2.CreateFarmResponse;
import dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.BusinessServer_Actually_DB_Server.Server_GRPC_Client;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;

import java.io.IOException;

public class AnimalServerMain {
    public static void main(String[] args) {
        Server server = io.grpc.ServerBuilder
                .forPort(2345)
                .addService(new BusinessServer())
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
