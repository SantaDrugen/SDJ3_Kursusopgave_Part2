package dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.SlaughterDBServer;

import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.AnimalCut;

import java.util.ArrayList;

public interface IFileIO {

    void addAnimalCuts(ArrayList<AnimalCut> animalCuts);

    void addAnimalsToSlaughter(ArrayList<Animal> animalsToSlaughter);

    ArrayList<AnimalCut> loadAnimalCuts();

    ArrayList<Animal> loadAnimalsToSlaughter();

}
