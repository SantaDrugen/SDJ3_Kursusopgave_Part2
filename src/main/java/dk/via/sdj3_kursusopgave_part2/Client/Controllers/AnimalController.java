package dk.via.sdj3_kursusopgave_part2.Client.Controllers;

import dk.via.sdj3_kursusopgave_part2.AnimalServer.IServer;
import dk.via.sdj3_kursusopgave_part2.AnimalServer.Server;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.AnimalDto;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity createAnimal(@RequestBody AnimalDto animal)
    {
        server.createAnimal(animal);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @RequestMapping( params = "animalId" )
    public ResponseEntity<Animal> getAnimal(@RequestParam int animalId) {
        Animal animal = server.getAnimal(animalId);
        if (animal != null) {
            return ResponseEntity.ok(animal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @RequestMapping( params = "farmId" )
    public ResponseEntity<Collection<Animal>> getAnimalsFromFarm(@RequestParam int farmId) {
        Collection<Animal> animals = server.getAllAnimalsByFarmId(farmId);
        if (animals != null) {
            return ResponseEntity.ok(animals);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @RequestMapping( params = "dateOfArrival" )
    public ResponseEntity<Collection<Animal>> getAnimalsFromFarm(@RequestParam String dateOfArrival) {
        Collection<Animal> animals = server.getAllAnimalsByDateOfArrival(dateOfArrival);
        if (animals != null) {
            return ResponseEntity.ok(animals);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
