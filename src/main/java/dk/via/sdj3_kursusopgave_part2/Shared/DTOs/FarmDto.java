package dk.via.sdj3_kursusopgave_part2.Shared.DTOs;

public class FarmDto {

    private String farmName;

    public FarmDto(String farmName) {
        this.farmName = farmName;
    }

    public FarmDto() {
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }
}
