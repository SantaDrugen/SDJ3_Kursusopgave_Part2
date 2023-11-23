package dk.via.sdj3_kursusopgave_part2.Shared.DTOs;

import java.util.ArrayList;

public class ProductsOfAnimalDto {

    private String animalId;

    public ProductsOfAnimalDto(String animalId) {
        this.animalId = animalId;
    }

    public String getAnimalId() {
        return animalId;
    }
}
