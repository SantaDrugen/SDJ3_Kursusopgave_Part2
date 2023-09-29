package dk.via.sdj3_kursusopgave_part2.Shared.DTOs;

public class AnimalDto {

    private int farmId;
    private double weight;
    private String dateOfArrival;

    public AnimalDto(int farmId, double weight) {
        this.farmId = farmId;
        this.weight = weight;
    }

    public AnimalDto() {
    }

    public int getFarmId() {
        return farmId;
    }

    public double getWeight() {
        return weight;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDateOfArrival() {
        return dateOfArrival;
    }
}
