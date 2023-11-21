package dk.via.sdj3_kursusopgave_part2.AnimalStack.RabbitMQ;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Farm;
import org.springframework.util.SerializationUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class AnimalStackSend implements Runnable {

    Animal animal;

    public void sendAnimal(Animal animal) {
        System.out.println("Starting send animal thread");
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel())
        {
            channel.queueDeclare("SendAnimalToSlaughter", false, false, false, null);
            channel.basicPublish("", "SendAnimalToSlaughter", null, SerializationUtils.serialize(animal));
            System.out.println(" [x] Sent '" + animal.toString() + "'");
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

        @Override
        public void run() {
            sendAnimal(this.animal);
        }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
