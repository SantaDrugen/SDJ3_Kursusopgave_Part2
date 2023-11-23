package dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryBusinessServer;

import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.AnimalIdsOfProductDto;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.ProductsOfAnimalDto;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("IFactoryBusinessClient")
public interface IFactoryBusinessClient {

    ArrayList<String> getAllAnimalsFromProduct(AnimalIdsOfProductDto animalIdsOfProductDto);

    ArrayList<Product> getAllProducts();

    java.lang.String createProduct();

    ArrayList<String> getAllProductsOfAnimal(ProductsOfAnimalDto productsOfAnimalDto);
}
