package dk.via.sdj3_kursusopgave_part2.Shared.Domain;

import java.util.ArrayList;

public class SlaughteredAnimal {


    ArrayList<AnimalCut> animalCutNumbers;

    public SlaughteredAnimal(ArrayList<AnimalCut> animalCutNumbers) {
        this.animalCutNumbers = animalCutNumbers;
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
