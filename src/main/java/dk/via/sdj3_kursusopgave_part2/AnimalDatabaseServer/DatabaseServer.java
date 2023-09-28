package dk.via.sdj3_kursusopgave_part2.AnimalDatabaseServer;

import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.AnimalDto;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.FarmDto;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Farm;

import java.util.ArrayList;
import java.util.Collection;

public class DatabaseServer implements IDatabaseServer {

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
        farmToAdd.setFarmId(createId());
        farms.add(farmToAdd);
        fileIO.addFarm(farms);
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
        animals.add(new Animal(animal.getFarm(), animal.getWeight()));
        fileIO.addAnimals(animals);
    }

    public int createId()
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
}
