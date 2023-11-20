package dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.WebAPIClient.Controllers;

import dk.via.sdj3_kursusopgave_part2.Shared.Domain.AnimalCut;
import dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.IServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/slaughter")
public class SlaughterController {

    private final IServer server;

    @Autowired
    public SlaughterController(@Qualifier("webAPI_grpc_client") IServer server){
        this.server = server;
    }

    @GetMapping
    public ResponseEntity<Collection<AnimalCut>> getAllAnimalCuts()
    {
        Collection<AnimalCut> body = server.getAllAnimalCuts();
        return ResponseEntity.ok().body(body);
    }
}
