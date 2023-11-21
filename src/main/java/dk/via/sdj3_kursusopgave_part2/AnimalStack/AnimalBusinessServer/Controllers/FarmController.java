package dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalBusinessServer.Controllers;

import dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalBusinessServer.AnimalBusinessServerImpl;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.FarmDto;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Farm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/farm")
public class FarmController {
    private AnimalBusinessServerImpl server;

    @Autowired
    public FarmController(@Qualifier("AnimalStackServer") AnimalBusinessServerImpl server) {
        this.server = server;
    }


    @GetMapping
    public Collection<Farm> readFarms()
    {
        return server.getAllfarms();
    }


    @PostMapping
    public void createFarm(@RequestBody FarmDto farm)
    {
        System.out.println(farm.getFarmName());
        server.createFarm(farm);
    }


    @GetMapping
    @RequestMapping( params = "farmId" )
    public ResponseEntity<Farm> getFarm(@RequestParam int farmId) {
        Farm farm = server.getFarm(farmId);
        if (farm != null) {
            return ResponseEntity.ok(farm);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
