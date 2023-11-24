package dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalDBServer.RabbitMQ;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static org.springframework.util.SerializationUtils.serialize;

public class Sender {
    private final static String QUEUE_NAME = "animal_queue";

    public static void send(Animal animal) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            byte[] message = serializeAnimal(animal);
            channel.basicPublish("", QUEUE_NAME, null, message);
            System.out.println(" [x] Sent '" + animal + "'");
            channel.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] serializeAnimal(Animal animal) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jSon = mapper.writeValueAsString(animal);
            return jSon.getBytes();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
