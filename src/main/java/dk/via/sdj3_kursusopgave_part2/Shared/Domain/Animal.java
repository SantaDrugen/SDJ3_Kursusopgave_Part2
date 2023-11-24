package dk.via.sdj3_kursusopgave_part2.Shared.Domain;

import java.io.Serializable;
import java.util.Objects;

public class Animal implements Serializable {

    private Farm farm;
    private double weight;
    private String animalId;
    private String date;

    private Boolean isSlaughtered;

    public Animal(Farm farm, double weight) {
        this.farm = farm;
        this.weight = weight;
        this.isSlaughtered = false;
    }

    public Animal() {
    }

    public void setIsSlaughtered(Boolean isSlaughtered) {
        this.isSlaughtered = isSlaughtered;
    }

    public Boolean getIsSlaughtered() {
        return isSlaughtered;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getAnimalId() {
        return animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Double.compare(weight, animal.weight) == 0 && Objects.equals(farm, animal.farm) && Objects.equals(animalId, animal.animalId) && Objects.equals(date, animal.date) && Objects.equals(isSlaughtered, animal.isSlaughtered);
    }

}
