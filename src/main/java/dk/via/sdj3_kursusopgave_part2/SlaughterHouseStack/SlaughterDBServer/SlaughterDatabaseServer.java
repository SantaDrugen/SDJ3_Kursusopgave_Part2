package dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.SlaughterDBServer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dk.via.sdj3_kursusopgave_part2.*;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.AnimalCut;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.SlaughterDBServer.RabbitMQ.Reciever;
import dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.SlaughterDBServer.RabbitMQ.Sender;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;

public class SlaughterDatabaseServer extends SlaughterServiceGrpc.SlaughterServiceImplBase {

    private static IFileIO fileIO;

    private static ArrayList<Animal> animalsToSlaughter;

    private ArrayList<AnimalCut> animalCuts;

    public SlaughterDatabaseServer()
    {
        this.fileIO = new FileIO();
        animalsToSlaughter = fileIO.loadAnimalsToSlaughter();
        animalCuts = fileIO.loadAnimalCuts();

        new Thread(() -> {
            Reciever reciever = new Reciever(this);
            reciever.recieve();
        }).start();
    }

    public static void addAnimal(Animal animal) {
        animalsToSlaughter.add(animal);
        fileIO.addAnimalsToSlaughter(animalsToSlaughter);
    }

    public void getAllAnimalCuts (GetAllAnimalCutsRequest request,
                                  StreamObserver<GetAllAnimalCutsResponse> responseObserver)
    {

        ArrayList<AnimalCutMessage> animalCutMessages = new ArrayList<>();

        for (AnimalCut cut: animalCuts) {
            animalCutMessages.add(AnimalCutMessage
                    .newBuilder()
                    .setCutId(cut.getCutId())
                    .build());
        }

        GetAllAnimalCutsResponse response = GetAllAnimalCutsResponse
                .newBuilder()
                .addAllAnimalCuts(animalCutMessages)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void slaughterAnimal (SlaughterAnimalRequest request,
                                 StreamObserver<SlaughterAnimalResponse> responseObserver) {

        Animal animalToSlaughter = null;
        for (Animal animal : animalsToSlaughter) {
            if (animal.getAnimalId().equals(extractId(request.getId()))) {
                animalToSlaughter = animal;
            }
        }

        if (animalToSlaughter == null) {
            throw new RuntimeException("Animal not found");
        } else {
            animalsToSlaughter.remove(animalToSlaughter);
            SlaughterAnimalMessage animalToReturn = SlaughterAnimalMessage
                    .newBuilder()
                    .setFarm(SlaughterFarmMessage
                            .newBuilder()
                            .setFarmName(animalToSlaughter.getFarm().getFarmName())
                            .setFarmId(animalToSlaughter.getFarm().getFarmId())
                            .build())
                    .setWeight(animalToSlaughter.getWeight())
                    .setSlaughterAnimalId(animalToSlaughter.getAnimalId())
                    .setDate(animalToSlaughter.getDate())
                    .build();

            SlaughterAnimalResponse response = SlaughterAnimalResponse
                    .newBuilder()
                    .setAnimal(animalToReturn)
                    .build();


            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

    }

    @Override
    public void saveAnimalCut(SaveAnimalCutRequest request,
                              StreamObserver<SaveAnimalCutResponse> responseObserver)
    {
        ArrayList<AnimalCut> animalCutsToSave = new ArrayList<>();

        for (AnimalCutMessage cut: request.getAnimalCutsList()) {
            animalCutsToSave.add(new AnimalCut(cut.getCutId()));
        }

        animalCuts.addAll(animalCutsToSave);
        Sender.send(animalCutsToSave);

        fileIO.addAnimalCuts(animalCuts);

        SaveAnimalCutResponse response = SaveAnimalCutResponse
                .newBuilder()
                .setMessage("Animal has been slaughtered and the cuts have been saved")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private String extractId(String id) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            JsonNode node = mapper.readTree(id);
            return node.path("id").asText();
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
