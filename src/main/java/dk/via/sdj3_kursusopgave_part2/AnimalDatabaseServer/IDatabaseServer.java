package dk.via.sdj3_kursusopgave_part2.AnimalDatabaseServer;

import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.AnimalDto;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.FarmDto;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Farm;

import java.util.Collection;

public interface IDatabaseServer {

    public void createFarm(FarmDto farm);

    public Collection<Farm> getAllfarms();

    public Farm getFarm(int farmId);

    public Collection<Animal> getAllAnimals();

    public void createAnimal(AnimalDto animal);
}