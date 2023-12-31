package dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalBusinessServer;

import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.AnimalDto;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.FarmDto;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Farm;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component("AnimalStackServerInterface")
public interface AnimalBusinessServer {

    public Farm createFarm(FarmDto farm);

    public Collection<Farm> getAllfarms();

    public Farm getFarm(int farmId);

    public Collection<Animal> getAllAnimals();

    public String createAnimal(AnimalDto animal);

    public Animal getAnimal(String animalId);

    public Collection<Animal> GetAllAnimalsFromFarm(int farmId);

    public Collection<Animal> GetAllAnimalsFromDate(String dateOfArrival);
}
