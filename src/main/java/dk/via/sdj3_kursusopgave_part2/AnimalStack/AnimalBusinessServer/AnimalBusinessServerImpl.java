package dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalBusinessServer;

import dk.via.sdj3_kursusopgave_part2.*;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.AnimalDto;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.FarmDto;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Farm;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;


@Component("AnimalStackServer")
@Scope("singleton")
public class AnimalBusinessServerImpl implements AnimalBusinessServer {
    @Override
    public Farm createFarm(FarmDto farm) {
        ManagedChannel channel = getChannel();

        AnimalServiceGrpc.AnimalServiceBlockingStub stub
                = AnimalServiceGrpc.newBlockingStub(channel);

        CreateFarmRequest request = CreateFarmRequest
                .newBuilder()
                .setFarmName(farm.getFarmName())
                .build();

        CreateFarmResponse response = stub.createFarm(request);

        Farm farmToReturn = new Farm(response.getFarmMessage().getFarmName());
        farmToReturn.setFarmId(response.getFarmMessage().getId());

        channel.shutdown();

        return farmToReturn;
    }

    @Override
    public Collection<Farm> getAllfarms() {
        ManagedChannel channel = getChannel();

        AnimalServiceGrpc.AnimalServiceBlockingStub stub
                = AnimalServiceGrpc.newBlockingStub(channel);

        GetAllFarmsRequest request = GetAllFarmsRequest
                .newBuilder()
                .build();

        GetAllFarmsResponse response = stub.getAllFarms(request);

        ArrayList<Farm> farms = new ArrayList<>();

        for (FarmMessage farmMessage : response.getFarmsList()) {
            Farm farm = new Farm(farmMessage.getFarmName());
            farm.setFarmId(farmMessage.getId());
            farms.add(farm);
        }

        channel.shutdown();

        return farms;
    }

    @Override
    public Farm getFarm(int farmId) {
        ManagedChannel channel = getChannel();

        AnimalServiceGrpc.AnimalServiceBlockingStub stub
                = AnimalServiceGrpc.newBlockingStub(channel);

        GetFarmRequest request = GetFarmRequest
                .newBuilder()
                .setId(farmId)
                .build();

        FarmMessage response = stub.getFarm(request);

        Farm farm = new Farm(response.getFarmName());
        farm.setFarmId(response.getId());

        channel.shutdown();

        return farm;
    }

    @Override
    public Collection<Animal> getAllAnimals() {
        ManagedChannel channel = getChannel();

        AnimalServiceGrpc.AnimalServiceBlockingStub stub
                = AnimalServiceGrpc.newBlockingStub(channel);

        GetAllAnimalsRequest request = GetAllAnimalsRequest
                .newBuilder()
                .build();

        GetAllAnimalsResponse response = stub.getAllAnimals(request);

        ArrayList<Animal> animals = new ArrayList<>();

        for (AnimalMessage animalMessage : response.getAnimalsList()) {
            Animal animal = new Animal();
            animal.setAnimalId(animalMessage.getId());
            animal.setWeight(animalMessage.getWeight());
            animal.setDate(animalMessage.getDate());
            animal.setFarm(new Farm(animalMessage.getFarm().getFarmName()));
            animals.add(animal);
        }

        return animals;
    }

    @Override
    public String createAnimal(AnimalDto animal) {
        ManagedChannel channel = getChannel();

        AnimalServiceGrpc.AnimalServiceBlockingStub stub
                = AnimalServiceGrpc.newBlockingStub(channel);

        CreateAnimalRequest request = CreateAnimalRequest
                .newBuilder()
                .setWeight(animal.getWeight())
                .setFarmId(animal.getFarmId())
                .build();

        CreateAnimalResponse response = stub.createAnimal(request);

        channel.shutdown();

        return response.getMessage();
    }

    @Override
    public Animal getAnimal(String animalId) {
        ManagedChannel channel = getChannel();

        AnimalServiceGrpc.AnimalServiceBlockingStub stub
                = AnimalServiceGrpc.newBlockingStub(channel);

        GetAnimalRequest request = GetAnimalRequest
                .newBuilder()
                .setId(animalId)
                .build();

        GetAnimalResponse response = stub.getAnimal(request);

        Animal animal = new Animal();
        animal.setAnimalId(response.getAnimal().getId());
        animal.setWeight(response.getAnimal().getWeight());
        animal.setDate(response.getAnimal().getDate());
        Farm farm = new Farm(response.getAnimal().getFarm().getFarmName());
        farm.setFarmId(response.getAnimal().getFarm().getId());
        animal.setFarm(farm);

        channel.shutdown();

        return animal;
    }

    @Override
    public Collection<Animal> GetAllAnimalsFromFarm(int farmId) {
        ManagedChannel channel = getChannel();

        AnimalServiceGrpc.AnimalServiceBlockingStub stub
                = AnimalServiceGrpc.newBlockingStub(channel);

        GetAllAnimalsFromFarmRequest request = GetAllAnimalsFromFarmRequest
                .newBuilder().setFarmId(farmId)
                .build();

        GetAllAnimalsFromFarmResponse response = stub.getAllAnimalsFromFarm(request);

        ArrayList<Animal> animals = new ArrayList<>();
        for (AnimalMessage animalMessage : response.getAnimalsList()) {
            Animal animal = new Animal();
            animal.setAnimalId(animalMessage.getId());
            animal.setWeight(animalMessage.getWeight());
            animal.setDate(animalMessage.getDate());
            Farm farm = new Farm(animalMessage.getFarm().getFarmName());
            farm.setFarmId(animalMessage.getFarm().getId());
            animal.setFarm(farm);
            animals.add(animal);
        }

        channel.shutdown();

        return animals;
    }

    @Override
    public Collection<Animal> GetAllAnimalsFromDate(String dateOfArrival) {
        ManagedChannel channel = getChannel();

        AnimalServiceGrpc.AnimalServiceBlockingStub stub
                = AnimalServiceGrpc.newBlockingStub(channel);

        GetAllAnimalsFromDateRequest request = GetAllAnimalsFromDateRequest
                .newBuilder()
                .setDate(dateOfArrival)
                .build();

        GetAllAnimalsFromDateResponse response = stub.getAllAnimalsFromDate(request);

        ArrayList<Animal> animals = new ArrayList<>();
        for (AnimalMessage animalMessage : response.getAnimalsList()) {
            Animal animal = new Animal();
            animal.setAnimalId(animalMessage.getId());
            animal.setWeight(animalMessage.getWeight());
            animal.setDate(animalMessage.getDate());
            Farm farm = new Farm(animalMessage.getFarm().getFarmName());
            farm.setFarmId(animalMessage.getFarm().getId());
            animal.setFarm(farm);
            animals.add(animal);
        }

        return animals;
    }


    private ManagedChannel getChannel() {
        return ManagedChannelBuilder
                .forAddress("localhost", 2345)
                .usePlaintext()
                .build();
    }
}
