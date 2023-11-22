package dk.via.sdj3_kursusopgave_part2.Shared.Domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {

    private ArrayList<AnimalCut> animalCuts;
    private String productId;

    public Product(ArrayList<AnimalCut> animalCuts) {
        this.animalCuts = animalCuts;
    }

    public ArrayList<AnimalCut> getAnimalCuts() {
        return animalCuts;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
