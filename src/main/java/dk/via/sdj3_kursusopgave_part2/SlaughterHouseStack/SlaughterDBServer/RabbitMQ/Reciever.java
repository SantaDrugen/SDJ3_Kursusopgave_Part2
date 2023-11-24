package dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.SlaughterDBServer.RabbitMQ;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.SlaughterDBServer.SlaughterDatabaseServer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static org.springframework.util.SerializationUtils.deserialize;

public class Reciever {
    private final static String QUEUE_NAME = "animal_queue";
    private SlaughterDatabaseServer server;

    public Reciever(SlaughterDatabaseServer server) {
        this.server = server;
    }

    public void recieve() {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println(" [*] Waiting for animals...");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                byte[] message = delivery.getBody();
                Animal animal = (Animal) deserializeAnimal(message);
                System.out.println(" [x] Received '" + animal + "'");
                SlaughterDatabaseServer.addAnimal(animal);
            };
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    private static Animal deserializeAnimal(byte[] message) {
        ObjectMapper mapper = new ObjectMapper();
        String jSon = new String(message);
        try {
            return mapper.readValue(jSon, Animal.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
