package dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.SlaughterHouseRabbitMQ;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import org.springframework.util.SerializationUtils;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class SlaughterReceive {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try(Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            Scanner input = new Scanner(System.in))
        {
            channel.exchangeDeclare("SendAnimalToSlaughter", "direct");
            channel.queueDeclare("SendAnimalToSlaughter", false, false, false, null);
            channel.queueBind("SendAnimalToSlaughter", "SendAnimalToSlaughter", "get_all_animals_from_date");
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
            channel.basicConsume("SendAnimalToSlaughter", true, (consumerTag, message) -> {
                Animal animal = (Animal) SerializationUtils.deserialize(message.getBody());
                System.out.println(" [x] Received '" + animal.getClass() + " " + animal.getAnimalId() + " " + animal.getWeight() + "'");
            }, consumerTag -> {});
            input.nextLine();
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
