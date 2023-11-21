package dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalDatabaseServer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import dk.via.sdj3_kursusopgave_part2.AnimalServiceGrpc;
import dk.via.sdj3_kursusopgave_part2.AnimalStack.AnimalLogic.AnimalLogic;
import dk.via.sdj3_kursusopgave_part2.AnimalStack.RabbitMQ.AnimalStackReceiver;
import dk.via.sdj3_kursusopgave_part2.AnimalStack.RabbitMQ.AnimalStackSend;
import dk.via.sdj3_kursusopgave_part2.CreateFarmRequest;
import dk.via.sdj3_kursusopgave_part2.CreateFarmResponse;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.AnimalDto;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.FarmDto;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Farm;
import io.grpc.stub.StreamObserver;
import org.springframework.format.datetime.DateFormatter;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeoutException;

public class DatabaseServer extends AnimalServiceGrpc.AnimalServiceImplBase implements IDatabaseServer, IDatabaseServerRabbitMQ {

    private Collection<Farm> farms;
    private Collection<Animal> animals = new ArrayList<>();
    private IFileIO fileIO;

    AnimalLogic animalLogic = new AnimalLogic();

    public DatabaseServer() {
        this.farms = new ArrayList<>();
/*        this.fileIO = new FileIO();
        farms = fileIO.loadFarms();
        animals = fileIO.loadAnimals();*/

        Animal animal1 = new Animal(new Farm("Farm1"), 100);
        animal1.setDate("01-01-1111");

        Animal animal2 = new Animal(new Farm("Farm2"), 200);
        animal2.setDate("02-02-2222");

        animals.add(animal1);
        animals.add(animal2);


        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try(Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            Scanner input = new Scanner(System.in))
        {
            channel.exchangeDeclare("AnimalStackExchange", "direct");
            channel.queueDeclare("AnimalStackSend", false, false, false, null);
            channel.queueBind("AnimalStackSend", "AnimalStackExchange", "get_all_animals_from_date");
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
            channel.basicConsume("AnimalStackSend", true, (consumerTag, message) -> {
                String messageAsString = new String(message.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + messageAsString + "'");
                animalLogic.getAllAnimalsFromDate(getAllAnimalsByDateOfArrival(messageAsString));
            }, consumerTag -> {});
            input.nextLine();
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }

    }

    public void createFarm(FarmDto farm) {
        Farm farmToAdd = new Farm(farm.getFarmName());
        farmToAdd.setFarmId(createFarmId());
        farms.add(farmToAdd);
        fileIO.addFarm(farms);
    }

    public void createFarm(CreateFarmRequest request,
                           StreamObserver<CreateFarmResponse> responseObserver) {
        Farm farm = new Farm(request.getFarmName());
        farm.setFarmId(createFarmId());
        farms.add(farm);
        fileIO.addFarm(farms);
        CreateFarmResponse response = CreateFarmResponse.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public Collection<Farm> getAllfarms() {
        return farms;
    }

    @Override
    public Farm getFarm(int farmId) {
        Farm farmToGet = null;
        for (Farm i : farms) {
            if (i.getFarmId() == farmId) {
                farmToGet = i;
                break;
            }
        }
        return farmToGet;
    }

    @Override
    public Collection<Animal> getAllAnimals() {
        return animals;
    }

    @Override
    public void createAnimal(AnimalDto animal) {
        if (getFarmById(animal.getFarmId()) == null) {
            throw new RuntimeException("Farm does not exist");
        } else {
            Animal animalToAdd = new Animal(getFarmById(animal.getFarmId()), animal.getWeight());
            animalToAdd.setAnimalId(createAnimalId());
            animalToAdd.setDate(createDate());
            animals.add(animalToAdd);

            fileIO.addAnimals(animals);
        }
    }

    @Override
    public Animal getAnimal(int animalId) {
        Animal animalToGet = null;
        for (Animal i : animals) {
            if (i.getAnimalId() == animalId) {
                animalToGet = i;
                break;
            }
        }
        return animalToGet;
    }

    @Override
    public Collection<Animal> getAllAnimalsByFarmId(int farmId) {
        ArrayList<Animal> animalsToGet = new ArrayList<>();
        for (Animal i : animals) {
            if (i.getFarm().getFarmId() == farmId) {
                animalsToGet.add(i);
            }
        }
        return animalsToGet;
    }

    @Override
    public Collection<Animal> getAllAnimalsByDateOfArrival(String dateOfArrival) {
        ArrayList<Animal> animalsToGet = new ArrayList<>();
        for (Animal i : animals) {
            if (i.getDate().equals(dateOfArrival)) {
                animalsToGet.add(i);
            }
        }
        return animalsToGet;
    }

    private Farm getFarmById(int id) {
        Farm farmToGet = null;
        for (Farm i : farms) {
            if (i.getFarmId() == id) {
                farmToGet = i;
                break;
            }
        }
        return farmToGet;
    }

    public int createFarmId() {
        int currentHighestId = 0;
        for (Farm i : farms) {
            if (i.getFarmId() > currentHighestId) {
                currentHighestId = i.getFarmId();
            }
        }
        return ++currentHighestId;
    }

    public int createAnimalId() {
        int currentHigestId = 0;
        for (Animal i : animals) {
            if (i.getAnimalId() > currentHigestId) {
                currentHigestId = i.getAnimalId();
            }
        }
        return ++currentHigestId;
    }

    private String createDate() {
        DateFormatter dateFormatter = new DateFormatter();
        dateFormatter.setPattern("dd-MM-yyyy");
        return dateFormatter.print(new Date(), Locale.getDefault());
    }

    @Override
    public void getAllAnimalsFromDate(String date) {
        animalLogic.getAllAnimalsFromDate(getAllAnimalsByDateOfArrival(date));
    }
}

