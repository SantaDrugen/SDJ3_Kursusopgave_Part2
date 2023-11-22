package dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.SlaughterBusinessServer;

import dk.via.sdj3_kursusopgave_part2.Shared.Domain.AnimalCut;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component("IServer")
public interface ISlaughterBusinessClient {

    Collection<AnimalCut> getAllAnimalCuts();

    String slaughterAnimal(String id);
}
