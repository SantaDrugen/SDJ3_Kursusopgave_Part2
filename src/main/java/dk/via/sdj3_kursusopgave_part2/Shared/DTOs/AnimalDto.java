package dk.via.sdj3_kursusopgave_part2.Shared.DTOs;

import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Farm;

public class AnimalDto {

    private Farm farm;
    private double weight;
    private String dateOfArrival;

    public AnimalDto(Farm farm, double weight) {
        this.farm = farm;
        this.weight = weight;
    }

    public Farm getFarm() {
        return farm;
    }

    public double getWeight() {
        return weight;
    }

    public String getDateOfArrival() {
        return dateOfArrival;
    }
}
