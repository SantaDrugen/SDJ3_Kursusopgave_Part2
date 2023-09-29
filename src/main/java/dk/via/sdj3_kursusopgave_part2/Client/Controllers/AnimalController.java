package dk.via.sdj3_kursusopgave_part2.Client.Controllers;

import dk.via.sdj3_kursusopgave_part2.AnimalServer.IServer;
import dk.via.sdj3_kursusopgave_part2.AnimalServer.Server;
import dk.via.sdj3_kursusopgave_part2.Client.Exceptions.FarmDoesNotExistException;
import dk.via.sdj3_kursusopgave_part2.Client.Exceptions.FarmIdCannotBeZeroOrNegativeException;
import dk.via.sdj3_kursusopgave_part2.Client.Exceptions.WeightCannotBeNegativeException;
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
        try{
            server.createAnimal(animal);
            return ResponseEntity.ok().build();
        }
        catch (Exception e)
        {
            if (e.getMessage().equals("Farm does not exist"))
            {
                throw new FarmDoesNotExistException();
            }
            else if (e.getMessage().equals("Weight cannot be negative")) {
                throw new WeightCannotBeNegativeException();
            } else if (e.getMessage().equals("FarmIdCannotBeZeroOrNegativeException")) {
                throw new FarmIdCannotBeZeroOrNegativeException();
            }

        }
        return ResponseEntity.badRequest().build();
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
