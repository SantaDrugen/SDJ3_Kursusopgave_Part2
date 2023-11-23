package dk.via.sdj3_kursusopgave_part2.Shared.Domain;

import java.io.Serializable;
import java.util.Objects;

public class AnimalCut implements Serializable {

    private String cutId;

    public AnimalCut(String cutId) {
        this.cutId = cutId;
    }

    public String getCutId() {
        return cutId;
    }

    public void setCutId(String cutId) {
        this.cutId = cutId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalCut animalCut = (AnimalCut) o;
        return Objects.equals(cutId, animalCut.cutId);
    }
}
