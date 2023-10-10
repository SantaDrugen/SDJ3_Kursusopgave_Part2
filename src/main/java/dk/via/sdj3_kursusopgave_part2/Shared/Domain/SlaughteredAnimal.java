package dk.via.sdj3_kursusopgave_part2.Shared.Domain;

import java.util.ArrayList;

public class SlaughteredAnimal {

    int slaughtedAnimalId;
    ArrayList<AnimalCut> animalCutNumbers;

    public SlaughteredAnimal(int slaughtedAnimalId, ArrayList<AnimalCut> animalCutNumbers) {
        this.slaughtedAnimalId = slaughtedAnimalId;
        this.animalCutNumbers = animalCutNumbers;
    }

    public int getSlaughtedAnimalId() {
        return slaughtedAnimalId;
    }

    public ArrayList<AnimalCut> getAnimalCutNumbers() {
        return animalCutNumbers;
    }

    public void setAnimalCutNumbers(ArrayList<AnimalCut> animalCutNumbers) {
        this.animalCutNumbers = animalCutNumbers;
    }

    public void addAnimalCutNumber(AnimalCut animalCutNumber){
        animalCutNumbers.add(animalCutNumber);
    }
}
