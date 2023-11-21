package dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalDBServer;

import dk.via.sdj3_kursusopgave_part2.*;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.AnimalDto;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.FarmDto;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Farm;
import io.grpc.stub.StreamObserver;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.format.datetime.DateFormatter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

@Component
@Scope("singleton")
public class AnimalDatabaseServer extends AnimalServiceGrpc.AnimalServiceImplBase {

    private Collection<Farm> farms;
    private Collection<Animal> animals;
    private IFileIO fileIO;

    public AnimalDatabaseServer() {
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

        for (Animal animal : animals) {
            FarmMessage farm = FarmMessage
                    .newBuilder()
                    .setFarmName(animal.getFarm().getFarmName())
                    .setId(animal.getFarm().getFarmId())
                    .build();

            animalMessages.add(
                    AnimalMessage.newBuilder()
                    .setId(animal.getAnimalId())
                    .setFarm(farm)
                    .setWeight(animal.getWeight())
                    .setDate(animal.getDate())
                    .build()
            );
        }

        responseObserver.onNext(
                GetAllAnimalsResponse.newBuilder()
                .addAllAnimals(animalMessages)
                .build()
        );

        responseObserver.onCompleted();
    }

    public void createAnimal(CreateAnimalRequest request,
                             StreamObserver<CreateAnimalResponse> responseObserver) {

        AnimalDto animal = new AnimalDto(request.getFarmId(), request.getWeight());
        //validateAnimal(animal);
        Animal animalToAdd = new Animal(getFarm(animal.getFarmId()), animal.getWeight());
        animalToAdd.setAnimalId(createAnimalId());
        animalToAdd.setDate(createDate());
        animals.add(animalToAdd);
        fileIO.addAnimals(animals);

        CreateAnimalResponse response = CreateAnimalResponse
                .newBuilder()
                .setMessage("Created, All OK")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    public Animal getAnimal(int animalId) {
        return null;
    }


    public Collection<Animal> getAllAnimalsByFarmId(int farmId) {
        return null;
    }


    public Collection<Animal> getAllAnimalsByDateOfArrival(String dateOfArrival) {
        return null;
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

    public String createAnimalId()
    {
        int currentHigestId = 0;
        for (Animal i : animals) {
            if (Integer.parseInt(i.getAnimalId()) > currentHigestId)
            {
                currentHigestId = Integer.parseInt(i.getAnimalId());
            }
        }
        return String.valueOf(++currentHigestId);
    }

    private String createDate()
    {
        DateFormatter dateFormatter = new DateFormatter();
        dateFormatter.setPattern("dd-MM-yyyy");
        return dateFormatter.print(new Date(), Locale.getDefault());
    }

    private Farm getFarm(int id)
    {
        Farm farmToGet = null;
        for (Farm i : farms) {
            if (i.getFarmId() == id)
            {
                farmToGet = i;
                break;
            }
        }
        return farmToGet;
    }
}
