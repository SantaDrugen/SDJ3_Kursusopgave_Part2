package dk.via.sdj3_kursusopgave_part2.Shared.Domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {

    private ArrayList<AnimalCut> animalCuts;
    private java.lang.String productId;

    public Product(ArrayList<AnimalCut> animalCuts) {
        this.animalCuts = animalCuts;
    }

    public Product(ArrayList<AnimalCut> animalCuts, String productId) {
        this.animalCuts = animalCuts;
        this.productId = productId;
    }

    public Product() {
    }

    public ArrayList<AnimalCut> getAnimalCuts() {
        return animalCuts;
    }

    public java.lang.String getProductId() {
        return productId;
    }

    public void setProductId(java.lang.String productId) {
        this.productId = productId;
    }

    public void addAnimalCut(String cutId) {
        animalCuts.add(new AnimalCut(cutId));
    }
}
