package dk.via.sdj3_kursusopgave_part2.Shared.Domain;

import java.io.Serializable;

public class Farm implements Serializable {

    private String farmName;
    private int farmId;

    public Farm(String farmName) {
        this.farmName = farmName;
        farmId = 0;
    }

    public Farm() {
    }

    public int getFarmId() {
        return farmId;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }
}
