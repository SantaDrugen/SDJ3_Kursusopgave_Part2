package dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.WebAPIClient;

import dk.via.sdj3_kursusopgave_part2.GetAllAnimalCutsRequest;
import dk.via.sdj3_kursusopgave_part2.GetAllAnimalCutsResponse;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.AnimalCut;
import dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.IServer;

import dk.via.sdj3_kursusopgave_part2.SlaughterServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component("WebAPI_GRPC_Client")
@Scope("singleton")
public class WebAPI_GRPC_Client implements IServer {


    @Override
    public Collection<AnimalCut> getAllAnimalCuts() {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 1234)
                .usePlaintext()
                .build();

        SlaughterServiceGrpc.SlaughterServiceBlockingStub stub
                = SlaughterServiceGrpc.newBlockingStub(channel);

        GetAllAnimalCutsRequest request = GetAllAnimalCutsRequest
                .newBuilder()
                .build();

        GetAllAnimalCutsResponse response = stub.getAllAnimalCuts(request);


        ArrayList<AnimalCut> animalCuts = new ArrayList<AnimalCut>();
        for (dk.via.sdj3_kursusopgave_part2.AnimalCut o:response.getAnimalCutsList()) {
            animalCuts.add(new AnimalCut(o.getCutId()));
        }

        channel.shutdown();

        return animalCuts;
    }
}
