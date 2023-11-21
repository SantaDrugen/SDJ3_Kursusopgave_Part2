package dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack;

import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.SlaughterAnimalDTO;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.AnimalCut;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.SlaughteredAnimal;

import java.util.ArrayList;

public class SlaughterHouseDatabaseServer {

    ArrayList<SlaughteredAnimal> slaughteredAnimals = new ArrayList<>();

    public void slaughterAnimal(SlaughterAnimalDTO dto)
    {
        double currentWeight = dto.getWeight();
        int partCounter = 0;

        while (currentWeight > 0)
        {
            partCounter++;
            currentWeight -= 10;
        }

        ArrayList<AnimalCut> cuts = new ArrayList<>();

        for ( int i = 0; i < partCounter; i++)
        {
            String cutId = String.valueOf(dto.getAnimalId());
            cutId += "-" + String.valueOf(i);
            cuts.add(new AnimalCut(cutId));
        }

        SlaughteredAnimal newlySlaughteredAnimal = new SlaughteredAnimal(cuts);

        slaughteredAnimals.add(newlySlaughteredAnimal);
    }

    public ArrayList<SlaughteredAnimal> getAllSlaughteredAnimals()
    {
        return slaughteredAnimals;
    }

}
