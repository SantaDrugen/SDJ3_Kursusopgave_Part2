package dk.via.sdj3_kursusopgave_part2.AnimalDatabaseServer;

import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Farm;

import java.util.Collection;

public interface IFileIO {

    public void addFarm(Collection<Farm> farms);

    public Collection<Farm> loadFarms();

    public Collection<Animal> loadAnimals();

    public void addAnimals(Collection<Animal> animals);
}
