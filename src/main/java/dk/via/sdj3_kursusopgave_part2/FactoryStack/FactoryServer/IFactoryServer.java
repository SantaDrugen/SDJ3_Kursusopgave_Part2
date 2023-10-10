package dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryServer;

import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.InfectedItemsDto;

public interface IFactoryServer {

    InfectedItemsDto getInfectedItems(String productId);

}
