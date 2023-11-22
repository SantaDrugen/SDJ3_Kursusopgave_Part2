package dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.SlaughterBusinessServer.Controllers;

import dk.via.sdj3_kursusopgave_part2.Shared.Domain.AnimalCut;
import dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.SlaughterBusinessServer.ISlaughterBusinessClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/slaughter")
public class SlaughterController {

    private final ISlaughterBusinessClient server;

    @Autowired
    public SlaughterController(@Qualifier("SlaughterBusinessClient") ISlaughterBusinessClient server){
        this.server = server;
    }

    @GetMapping
    public ResponseEntity<Collection<AnimalCut>> getAllAnimalCuts()
    {
        Collection<AnimalCut> body = server.getAllAnimalCuts();
        return ResponseEntity.ok().body(body);
    }

    @PostMapping
    public ResponseEntity<String> slaughterAnimal(@RequestBody String id)
    {
        String result = server.slaughterAnimal(id);
        return ResponseEntity.ok().body(result);
    }
}
