package dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalServer;

import dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalDatabaseServer.DatabaseServer;
import dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalDatabaseServer.IDatabaseServer;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.AnimalDto;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.FarmDto;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Farm;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Scope("singleton")
public class Server implements IServer {

    private IDatabaseServer databaseServer;

    public Server() {
        databaseServer = new DatabaseServer();
    }

    @Override
    public void createFarm(FarmDto farm) {
        if (farm.getFarmName() == null)
        {
            throw new IllegalArgumentException("Farm name cannot be null");
        }
        databaseServer.createFarm(farm);
    }

    @Override
    public Collection<Farm> getAllfarms() {
        return databaseServer.getAllfarms();
    }

    @Override
    public Farm getFarm(int farmId) {
        return databaseServer.getFarm(farmId);
    }

    @Override
    public Collection<Animal> getAllAnimals() {
        return databaseServer.getAllAnimals();
    }

    @Override
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

    @Override
    public Animal getAnimal(int animalId) {
        return databaseServer.getAnimal(animalId);
    }

    @Override
    public Collection<Animal> getAllAnimalsByFarmId(int farmId) {
        return databaseServer.getAllAnimalsByFarmId(farmId);
    }

    @Override
    public Collection<Animal> getAllAnimalsByDateOfArrival(String dateOfArrival) {
        return databaseServer.getAllAnimalsByDateOfArrival(dateOfArrival);
    }


}