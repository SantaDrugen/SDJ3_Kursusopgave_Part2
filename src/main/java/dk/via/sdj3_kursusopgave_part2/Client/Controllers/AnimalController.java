package dk.via.sdj3_kursusopgave_part2.Client.Controllers;

import dk.via.sdj3_kursusopgave_part2.AnimalServer.IServer;
import dk.via.sdj3_kursusopgave_part2.AnimalServer.Server;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.AnimalDto;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    private IServer server;

    public AnimalController() {
        this.server = new Server();
    }

    @GetMapping
    public ResponseEntity<Collection<Animal>> getAllAnimals()
    {
        return ResponseEntity.ok(server.getAllAnimals());
    }

    @PostMapping
    public ResponseEntity createAnimal(AnimalDto animal)
    {
        server.createAnimal(animal);
        return ResponseEntity.ok().build();
    }
}
