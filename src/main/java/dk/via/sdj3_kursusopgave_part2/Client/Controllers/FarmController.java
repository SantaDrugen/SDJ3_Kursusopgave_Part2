package dk.via.sdj3_kursusopgave_part2.Client.Controllers;

import dk.via.sdj3_kursusopgave_part2.AnimalServer.IServer;
import dk.via.sdj3_kursusopgave_part2.AnimalServer.Server;
import dk.via.sdj3_kursusopgave_part2.Client.Exceptions.FarmDoesNotExistException;
import dk.via.sdj3_kursusopgave_part2.Client.Exceptions.FarmNameCannotBeNullException;
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
    public ResponseEntity createFarm(@RequestBody FarmDto farm)
    {
        try {
            server.createFarm(farm);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            if(e.getMessage().equals("Farm name cannot be null"))
            {
                throw new FarmNameCannotBeNullException();
            }
        }
        return ResponseEntity.badRequest().build();
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
