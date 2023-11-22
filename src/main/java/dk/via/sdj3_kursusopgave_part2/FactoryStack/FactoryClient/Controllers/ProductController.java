package dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryClient.Controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping
    public ResponseEntity<String> getAllProducts(){

        return ResponseEntity.ok("Product");
    }

}
