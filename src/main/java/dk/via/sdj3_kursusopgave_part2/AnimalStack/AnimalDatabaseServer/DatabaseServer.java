package dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalDatabaseServer;

import dk.via.sdj3_kursusopgave_part2.AnimalServiceGrpc;
import dk.via.sdj3_kursusopgave_part2.CreateFarmRequest;
import dk.via.sdj3_kursusopgave_part2.CreateFarmResponse;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.AnimalDto;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.FarmDto;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Farm;
import io.grpc.stub.StreamObserver;
import org.springframework.format.datetime.DateFormatter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

public class DatabaseServer extends AnimalServiceGrpc.AnimalServiceImplBase implements IDatabaseServer {

    private Collection<Farm> farms;
    private Collection<Animal> animals;
    private IFileIO fileIO;

    public DatabaseServer() {
        this.farms = new ArrayList<>();
        this.fileIO = new FileIO();
        farms = fileIO.loadFarms();
        animals = fileIO.loadAnimals();
    }
    public void createFarm(FarmDto farm)
    {
        Farm farmToAdd = new Farm(farm.getFarmName());
        farmToAdd.setFarmId(createFarmId());
        farms.add(farmToAdd);
        fileIO.addFarm(farms);
    }

    public void createFarm(CreateFarmRequest request,
                           StreamObserver<CreateFarmResponse> responseObserver) {
        Farm farm = new Farm(request.getFarmName());
        farm.setFarmId(createFarmId());
        fileIO.addFarm(farms);
        farms.add(farm);
        CreateFarmResponse response = CreateFarmResponse.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public Collection<Farm> getAllfarms() {
        return farms;
    }

    @Override
    public Farm getFarm(int farmId) {
        Farm farmToGet = null;
        for (Farm i : farms) {
            if (i.getFarmId() == farmId)
            {
                farmToGet = i;
                break;
            }
        }
        return farmToGet;
    }

    @Override
    public Collection<Animal> getAllAnimals() {
        return animals;
    }

    @Override
    public void createAnimal(AnimalDto animal) {
        if ( getFarmById(animal.getFarmId() ) == null)
        {
            throw new RuntimeException("Farm does not exist");
        }
        else
        {
            Animal animalToAdd = new Animal(getFarmById(animal.getFarmId()), animal.getWeight());
            animalToAdd.setAnimalId(createAnimalId());
            animalToAdd.setDate(createDate());
            animals.add(animalToAdd);

            fileIO.addAnimals(animals);
        }
    }

    @Override
    public Animal getAnimal(int animalId) {
        Animal animalToGet = null;
        for (Animal i : animals) {
            if (i.getAnimalId() == animalId)
            {
                animalToGet = i;
                break;
            }
        }
        return animalToGet;
    }

    @Override
    public Collection<Animal> getAllAnimalsByFarmId(int farmId) {
        ArrayList<Animal> animalsToGet = new ArrayList<>();
        for (Animal i : animals) {
            if (i.getFarm().getFarmId() == farmId)
            {
                animalsToGet.add(i);
            }
        }
        return animalsToGet;
    }

    @Override
    public Collection<Animal> getAllAnimalsByDateOfArrival(String dateOfArrival) {
        ArrayList<Animal> animalsToGet = new ArrayList<>();
        for (Animal i : animals) {
            if (i.getDate().equals(dateOfArrival))
            {
                animalsToGet.add(i);
            }
        }
        return animalsToGet;
    }

    private Farm getFarmById(int id)
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

    public int createFarmId()
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

    public int createAnimalId()
    {
        int currentHigestId = 0;
        for (Animal i : animals) {
            if (i.getAnimalId() > currentHigestId)
            {
                currentHigestId = i.getAnimalId();
            }
        }
        return ++currentHigestId;
    }

    private String createDate()
    {
        DateFormatter dateFormatter = new DateFormatter();
        dateFormatter.setPattern("dd-MM-yyyy");
        return dateFormatter.print(new Date(), Locale.getDefault());
    }
}
