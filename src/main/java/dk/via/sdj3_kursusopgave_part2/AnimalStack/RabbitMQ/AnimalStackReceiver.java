package dk.via.sdj3_kursusopgave_part2.AnimalStack.RabbitMQ;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class AnimalStackReceiver {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try(Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            Scanner input = new Scanner(System.in))
        {
            channel.queueDeclare("AnimalStackSend", false, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
            channel.basicConsume("AnimalStackSend", true, (consumerTag, message) -> {
                String messageAsString = new String(message.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + messageAsString + "'");
            }, consumerTag -> {});
            input.nextLine();
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
