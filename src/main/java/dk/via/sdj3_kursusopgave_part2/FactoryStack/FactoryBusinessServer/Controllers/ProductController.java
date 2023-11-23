package dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryBusinessServer.Controllers;


import dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryBusinessServer.IFactoryBusinessClient;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.AnimalIdsOfProductDto;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.ProductsOfAnimalDto;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/factory")
public class ProductController {

    private IFactoryBusinessClient server;

    @Autowired
    public ProductController(@Qualifier("FactoryBusinessClient")IFactoryBusinessClient server) {
        this.server = server;
    }

    @GetMapping
    public ResponseEntity<java.lang.String> getAllProducts(){
        ArrayList<Product> products = server.getAllProducts();
        return ResponseEntity.ok(products.toString());
    }

    @PostMapping
    public ResponseEntity<java.lang.String> createProduct(){
        java.lang.String message = server.createProduct();
        return ResponseEntity.ok("Product created: " + message);
    }

    @GetMapping()
    @RequestMapping( params = "productId" )
    public ResponseEntity<java.lang.String> getInfectedItems(@RequestParam String productId){
        ArrayList<String> animalIds = server.getAllAnimalsFromProduct(new AnimalIdsOfProductDto(productId));
        return ResponseEntity.ok(animalIds.toString());
    }

    @GetMapping()
    @RequestMapping( params = "animalId" )
    public ResponseEntity<String> getAllProductsOfAnimal(@RequestParam String animalId){
        ArrayList<String> productIds = server.getAllProductsOfAnimal(new ProductsOfAnimalDto(animalId));
        return ResponseEntity.ok(productIds.toString());
    }

}
