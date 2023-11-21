package dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalServer;

import dk.via.sdj3_kursusopgave_part2.*;
import dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalDatabaseServer.FileIO;
import dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalDatabaseServer.IDatabaseServer;
import dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalDatabaseServer.IFileIO;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.AnimalDto;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.FarmDto;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Farm;
import io.grpc.stub.StreamObserver;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
@Scope("singleton")
public class BusinessServer extends AnimalServiceGrpc.AnimalServiceImplBase {

    private IDatabaseServer databaseServer; //TODO: remove

    private Collection<Farm> farms;
    private Collection<Animal> animals;
    private IFileIO fileIO;

    public BusinessServer() {
        this.farms = new ArrayList<>();
        this.fileIO = new FileIO();
        farms = fileIO.loadFarms();
        animals = fileIO.loadAnimals();
    }

    public void createFarm(CreateFarmRequest request,
                           StreamObserver<CreateFarmResponse> responseObserver) {

        FarmDto farm = new FarmDto(request.getFarmName());
        validateFarm(farm);
        Farm farmToAdd = new Farm(farm.getFarmName());
        farmToAdd.setFarmId(createFarmId());
        farms.add(farmToAdd);
        fileIO.addFarm(farms);

        FarmMessage farmMessage = FarmMessage
                .newBuilder()
                .setFarmName(farm.getFarmName())
                .setId(farmToAdd.getFarmId())
                .build();

        CreateFarmResponse response = CreateFarmResponse
                .newBuilder()
                .setFarmMessage(farmMessage)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void getAllFarms(GetAllFarmsRequest request,
                                        StreamObserver<GetAllFarmsResponse> responseObserver) {

        ArrayList<FarmMessage> farmMessages = new ArrayList<>();

        for (Farm farm : farms) {
            farmMessages.add(
                    FarmMessage.newBuilder()
                    .setFarmName(farm.getFarmName())
                    .setId(farm.getFarmId())
                    .build()
            );
        }

        responseObserver.onNext(
                GetAllFarmsResponse.newBuilder()
                .addAllFarms(farmMessages)
                .build()
        );

        responseObserver.onCompleted();
    }


    public void getFarm(GetFarmRequest request,
                        StreamObserver<FarmMessage> responseObserver) {
        boolean exists = false;

        for (Farm farm : farms)
        {
            if (farm.getFarmId() == request.getId())
            {
                exists = true;
                responseObserver.onNext(
                        FarmMessage.newBuilder()
                        .setFarmName(farm.getFarmName())
                        .setId(farm.getFarmId())
                        .build()
                );
                responseObserver.onCompleted();
            }
        }
        if (!exists)
        {
            responseObserver.onError(new RuntimeException("Farm does not exist"));
        }
    }


    public void getAllAnimals(GetAllAnimalsRequest request,
                                            StreamObserver<GetAllAnimalsResponse> responseObserver) {

        ArrayList<AnimalMessage> animalMessages = new ArrayList<>();

//        for (Animal animal : animals) {
//            animalMessages.add(
//                    AnimalMessage.newBuilder()
//                    .setAnimalId(animal.getAnimalId())
//                    .setFarmId(animal.getFarmId())
//                    .setWeight(animal.getWeight())
//                    .setDateOfArrival(animal.getDateOfArrival())
//                    .build()
//            );
//        }
    }

    public void createAnimal(AnimalDto animal) {
        if (animal.getWeight() < 0)
        {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        else if (animal.getFarmId() < 1)
        {
            throw new IllegalArgumentException("FarmId cannot be 0 or negative");
        }
        else
        {
            databaseServer.createAnimal(animal);
        }
    }


    public Animal getAnimal(int animalId) {
        return databaseServer.getAnimal(animalId);
    }


    public Collection<Animal> getAllAnimalsByFarmId(int farmId) {
        return databaseServer.getAllAnimalsByFarmId(farmId);
    }


    public Collection<Animal> getAllAnimalsByDateOfArrival(String dateOfArrival) {
        return databaseServer.getAllAnimalsByDateOfArrival(dateOfArrival);
    }



    private int createFarmId()
    {
        int currentHighestId = 0;
        for (Farm i : farms) {
            if (i.getFarmId() > currentHighestId)
            {
                currentHighestId = i.getFarmId();
            }
        }
        return ++currentHighestId;
    }


    private void validateFarm(FarmDto farm) {
        if (farm.getFarmName().length() < 1)
        {
            throw new IllegalArgumentException("Farm name cannot be empty");
        }

        if (farm.getFarmName().length() > 32)
        {
            throw new IllegalArgumentException("Farm name cannot be longer than 32 characters");
        }

        if (farm.getFarmName() == null)
        {
            throw new IllegalArgumentException("Farm name cannot be null");
        }

        for (Farm obj : farms) {
            if (obj.getFarmName().equals(farm.getFarmName()))
            {
                throw new IllegalArgumentException("Farm name already exists");
            }
        }
    }
}
