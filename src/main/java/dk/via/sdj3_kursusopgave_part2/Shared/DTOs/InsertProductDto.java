package dk.via.sdj3_kursusopgave_part2.Shared.DTOs;

import java.util.ArrayList;

public class InsertProductDto {

    private ArrayList<String> cutIds;

    public InsertProductDto(ArrayList<String> cutIds) {
        this.cutIds = cutIds;
    }

    public ArrayList<String> getCutIds() {
        return cutIds;
    }
}
