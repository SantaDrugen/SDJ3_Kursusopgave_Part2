package dk.via.sdj3_kursusopgave_part2.Shared.Domain;

public class AnimalCut {

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
}
