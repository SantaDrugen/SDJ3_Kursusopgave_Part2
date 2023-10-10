package dk.via.sdj3_kursusopgave_part2.Shared.DTOs;

import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Product;

import java.util.ArrayList;

public class InfectedItemsDto {

    private ArrayList<Animal> infectedAnimals;
    private ArrayList<Product> infectedProducts;

    public InfectedItemsDto(ArrayList<Animal> infectedAnimals, ArrayList<Product> infectedProducts) {
        this.infectedAnimals = infectedAnimals;
        this.infectedProducts = infectedProducts;
    }
}
