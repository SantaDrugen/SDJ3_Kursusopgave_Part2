package dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryBusinessServer;

import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.InfectedItemsDto;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("IFactoryBusinessClient")
public interface IFactoryBusinessClient {

    InfectedItemsDto getInfectedItems(String productId);

    ArrayList<Product> getAllProducts();

    String createProduct();
}
