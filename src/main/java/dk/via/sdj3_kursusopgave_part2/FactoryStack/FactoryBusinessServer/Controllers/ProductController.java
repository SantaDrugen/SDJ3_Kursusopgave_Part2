package dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryBusinessServer.Controllers;


import dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryBusinessServer.FactoryBusinessClient;
import dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryBusinessServer.IFactoryBusinessClient;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<String> getAllProducts(){
        ArrayList<Product> products = server.getAllProducts();
        return ResponseEntity.ok(products.toString());
    }

    @PostMapping
    public ResponseEntity<String> createProduct(){
        String message = server.createProduct();
        return ResponseEntity.ok("Product created: " + message);
    }

}
