package dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalServer;

import dk.via.sdj3_kursusopgave_part2.*;
import dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalDatabaseServer.DatabaseServer;
import dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalDatabaseServer.IDatabaseServer;
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

    private IDatabaseServer databaseServer;

    public BusinessServer() {
        databaseServer = new DatabaseServer();
    }

    public Farm createFarm(FarmDto farm) {
        if (farm.getFarmName() == null)
        {
            throw new IllegalArgumentException("Farm name cannot be null");
        }
        databaseServer.createFarm(farm);
        throw new RuntimeException(); //TODO
    }

    public void getAllFarms(GetAllFarmsRequest request,
                                        StreamObserver<GetAllFarmsResponse> responseObserver) {
        ArrayList<Farm> farms = new ArrayList<>();
        farms.addAll(databaseServer.getAllFarms());

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


    public Farm getFarm(int farmId) {
        return databaseServer.getFarm(farmId);
    }


    public Collection<Animal> getAllAnimals() {
        return databaseServer.getAllAnimals();
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


}
