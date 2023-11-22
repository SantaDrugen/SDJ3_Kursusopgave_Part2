package dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.SlaughterBusinessServer;

import dk.via.sdj3_kursusopgave_part2.*;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.AnimalCut;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Farm;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component("SlaughterBusinessClient")
@Scope("singleton")
public class SlaughterBusinessClient implements ISlaughterBusinessClient {


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
        for (dk.via.sdj3_kursusopgave_part2.AnimalCutMessage o : response.getAnimalCutsList()) {
            animalCuts.add(new AnimalCut(o.getCutId()));
        }

        channel.shutdown();

        return animalCuts;
    }

    @Override
    public String slaughterAnimal(String id) {
        ManagedChannel channel = getChannel();

        SlaughterServiceGrpc.SlaughterServiceBlockingStub stub
                = SlaughterServiceGrpc.newBlockingStub(channel);

        SlaughterAnimalRequest request = SlaughterAnimalRequest
                .newBuilder()
                .setId(id)
                .build();

        SlaughterAnimalResponse response = stub.slaughterAnimal(request);

        Farm farm = new Farm(response.getAnimal().getFarm().getFarmName());
        farm.setFarmId(response.getAnimal().getFarm().getFarmId());

        Animal animalToSlaughter = new Animal(farm, response.getAnimal().getWeight());
        animalToSlaughter.setAnimalId(response.getAnimal().getSlaughterAnimalId());
        animalToSlaughter.setDate(response.getAnimal().getDate());

        return cutAnimalForSlaughtering(animalToSlaughter);
    }

    private String cutAnimalForSlaughtering(Animal animal) {
        ManagedChannel channel = getChannel();

        SlaughterServiceGrpc.SlaughterServiceBlockingStub stub
                = SlaughterServiceGrpc.newBlockingStub(channel);

        double currentWeight = animal.getWeight();
        int partCounter = 0;

        while (currentWeight > 0) {
            partCounter++;
            currentWeight -= 10;
        }

        ArrayList<AnimalCut> cuts = new ArrayList<>();

        for (int i = 0; i < partCounter; i++) {
            String cutId = String.valueOf(animal.getAnimalId());
            cutId += "-" + String.valueOf(i);
            cuts.add(new AnimalCut(cutId));
        }

        ArrayList<AnimalCutMessage> animalCutMessages = new ArrayList<>();

        for (AnimalCut cut : cuts) {
            animalCutMessages.add(AnimalCutMessage
                    .newBuilder()
                    .setCutId(cut.getCutId())
                    .build());
        }

        SaveAnimalCutRequest request = SaveAnimalCutRequest
                .newBuilder()
                .addAllAnimalCuts(animalCutMessages)
                .build();

        SaveAnimalCutResponse response = stub.saveAnimalCut(request);

        return response.getMessage();
    }

    private ManagedChannel getChannel() {
        return ManagedChannelBuilder
                .forAddress("localhost", 1234)
                .usePlaintext()
                .build();
    }
}
