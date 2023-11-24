package dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryDatabaseServer.Server.RabbitMQ;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryDatabaseServer.Server.FactoryDatabaseServer;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.AnimalCut;
import dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.SlaughterDBServer.SlaughterDatabaseServer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

public class Receiver {
    private final static String QUEUE_NAME = "slaughter_queue";
    private FactoryDatabaseServer server;

    public Receiver(FactoryDatabaseServer server) {
        this.server = server;
    }

    public void receive() {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println(" [*] Waiting for cuts...");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                byte[] message = delivery.getBody();
                ArrayList<AnimalCut> animalCuts = deserializeCuts(message);
                System.out.println(" [x] Received '" + animalCuts + "'");
                FactoryDatabaseServer.addAnimalCuts(animalCuts);
            };
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<AnimalCut> deserializeCuts(byte[] message) {
        ObjectMapper mapper = new ObjectMapper();
        String jSon = new String(message);
        try {
            ArrayList<AnimalCut> jsons = mapper.readValue(jSon, new TypeReference<>() {
            });
            return jsons;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
