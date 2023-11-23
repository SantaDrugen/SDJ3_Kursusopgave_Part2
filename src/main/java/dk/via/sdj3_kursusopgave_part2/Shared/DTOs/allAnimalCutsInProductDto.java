package dk.via.sdj3_kursusopgave_part2.Shared.DTOs;

public class allAnimalCutsInProductDto {

    private String productId;

    public allAnimalCutsInProductDto(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}
