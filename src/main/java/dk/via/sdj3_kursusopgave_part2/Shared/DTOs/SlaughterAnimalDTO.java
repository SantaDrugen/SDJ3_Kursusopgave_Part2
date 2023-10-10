package dk.via.sdj3_kursusopgave_part2.Shared.DTOs;

public class SlaughterAnimalDTO {

    int animalId;
    double weight;

    public SlaughterAnimalDTO(int animalId, double weight) {
        this.animalId = animalId;
        this.weight = weight;
    }

    public int getAnimalId() {
        return animalId;
    }

    public double getWeight() {
        return weight;
    }
}
