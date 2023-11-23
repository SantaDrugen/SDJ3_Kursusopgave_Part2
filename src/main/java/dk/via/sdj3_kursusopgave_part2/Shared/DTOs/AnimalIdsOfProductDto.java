package dk.via.sdj3_kursusopgave_part2.Shared.DTOs;

public class AnimalIdsOfProductDto {

    private String productId;

    public AnimalIdsOfProductDto(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
