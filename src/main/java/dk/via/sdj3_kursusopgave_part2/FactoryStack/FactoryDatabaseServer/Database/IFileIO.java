package dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryDatabaseServer.Database;

import dk.via.sdj3_kursusopgave_part2.Shared.Domain.AnimalCut;

import java.util.ArrayList;

public interface IFileIO {

    public void addAnimalCutForPackaging(ArrayList<AnimalCut> animalCuts);

    public void removeAnimalCutForPackaging(AnimalCut animalCut);

    public ArrayList<AnimalCut> loadAnimalCutsForPackaging();
}
