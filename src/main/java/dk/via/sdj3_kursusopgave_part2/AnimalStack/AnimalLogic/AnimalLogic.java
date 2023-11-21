package dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalLogic;

import dk.via.sdj3_kursusopgave_part2.AnimalStack.RabbitMQ.AnimalStackSend;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;

import java.util.Collection;

public class AnimalLogic {

    AnimalStackSend sender = new AnimalStackSend();

    public void getAllAnimalsFromDate(Collection<Animal> allAnimalsByDateOfArrival) {
        for (Animal animal: allAnimalsByDateOfArrival) {
            System.out.println("Sending animal to slaughterhouse");
            sendAnimal(animal);
        }
    }

    public void sendAnimal(Animal animal) {
        Thread thread = new Thread(sender);
        sender.setAnimal(animal);
        thread.start();
    }

}
