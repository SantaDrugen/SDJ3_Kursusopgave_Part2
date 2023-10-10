package dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalClient.Controllers;

import dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalServer.IServer;
import dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalServer.Server;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.FarmDto;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Farm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/farm")
public class FarmController {
    private IServer server;

    public FarmController() {
        server = new Server();
    }


    @GetMapping
    public Collection<Farm> readFarms()
    {
        return server.getAllfarms();
    }


    @PostMapping
    public void createFarm(@RequestBody FarmDto farm)
    {
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
