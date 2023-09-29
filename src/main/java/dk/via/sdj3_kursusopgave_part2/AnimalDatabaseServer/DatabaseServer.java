package dk.via.sdj3_kursusopgave_part2.AnimalDatabaseServer;

import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.AnimalDto;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.FarmDto;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Farm;
import org.springframework.format.datetime.DateFormatter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

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
        farmToAdd.setFarmId(createFarmId());
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
        if ( getFarmById(animal.getFarmId() ) == null)
        {
            throw new IllegalArgumentException("FarmId does not exist");
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
