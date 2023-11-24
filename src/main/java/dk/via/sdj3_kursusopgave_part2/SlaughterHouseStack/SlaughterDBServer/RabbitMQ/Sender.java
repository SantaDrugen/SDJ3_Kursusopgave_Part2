package dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.SlaughterDBServer.RabbitMQ;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.AnimalCut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

public class Sender {
    private final static String QUEUE_NAME = "slaughter_queue";

    public static void send(ArrayList<AnimalCut> animalCuts) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            byte[] message = serializeCuts(animalCuts);
            channel.basicPublish("", QUEUE_NAME, null, message);
            System.out.println(" [x] Sent '" + animalCuts + "'");
            channel.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] serializeCuts(ArrayList<AnimalCut> animalCuts) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jSon = mapper.writeValueAsString(animalCuts);
            return jSon.getBytes();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
