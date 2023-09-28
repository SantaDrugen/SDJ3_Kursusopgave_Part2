package dk.via.sdj3_kursusopgave_part2.Shared.Domain;

import java.io.Serializable;

public class Animal implements Serializable {

    private Farm farm;
    private double weight;
    private int animalId;
    private String date;

    public Animal(Farm farm, double weight) {
        this.farm = farm;
        this.weight = weight;
    }

    public Animal() {
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

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
