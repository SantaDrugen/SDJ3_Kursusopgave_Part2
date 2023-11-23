package dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.SlaughterDBServer;
import dk.via.sdj3_kursusopgave_part2.*;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.AnimalCut;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;

public class SlaughterDatabaseServer extends SlaughterServiceGrpc.SlaughterServiceImplBase {

    private IFileIO fileIO;

    private ArrayList<Animal> animalsToSlaughter;

    private ArrayList<AnimalCut> animalCuts;

    public SlaughterDatabaseServer()
    {
        this.fileIO = new FileIO();
        animalsToSlaughter = fileIO.loadAnimalsToSlaughter();
        animalCuts = fileIO.loadAnimalCuts();
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
                                 StreamObserver<SlaughterAnimalResponse> responseObserver)
    {
        //TODO RABBITMQGETANIMAL



        SlaughterAnimalMessage animalToReturn = SlaughterAnimalMessage
                .newBuilder()
                .setFarm(SlaughterFarmMessage
                        .newBuilder()
                        .setFarmName("Test")
                        .setFarmId(10)
                        .build())
                .setWeight(200)
                .setSlaughterAnimalId("1")
                .setDate("2021-05-05")
                .build();


        SlaughterAnimalResponse response = SlaughterAnimalResponse
                .newBuilder()
                .setAnimal(animalToReturn)
                .build();


        responseObserver.onNext(response);
        responseObserver.onCompleted();
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

        fileIO.addAnimalCuts(animalCuts);

        SaveAnimalCutResponse response = SaveAnimalCutResponse
                .newBuilder()
                .setMessage("Animal has been slaughtered and the cuts have been saved")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
