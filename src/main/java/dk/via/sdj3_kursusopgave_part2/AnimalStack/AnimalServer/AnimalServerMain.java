package dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalServer;

import dk.via.sdj3_kursusopgave_part2.AnimalServiceGrpc;
import dk.via.sdj3_kursusopgave_part2.CreateFarmRequest;
import dk.via.sdj3_kursusopgave_part2.CreateFarmResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AnimalServerMain {
    public static void main(String[] args) {

        //Server server = new Server();

        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress("localhost", 1234)
                .usePlaintext()
                .build();

        AnimalServiceGrpc.AnimalServiceBlockingStub stub =
                AnimalServiceGrpc.newBlockingStub(managedChannel);

//        CreateFarmRequest request = CreateFarmRequest.newBuilder()
//                .setFarmName("Farm 1")
//                .build();
//
//        CreateFarmResponse farmResponse = stub.createFarm(request);
//
//        System.out.println(farmResponse);

        managedChannel.shutdown();
    }
}
