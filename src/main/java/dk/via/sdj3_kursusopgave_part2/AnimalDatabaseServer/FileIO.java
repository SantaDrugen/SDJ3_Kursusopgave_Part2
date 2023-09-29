package dk.via.sdj3_kursusopgave_part2.AnimalDatabaseServer;

import com.fasterxml.jackson.databind.ObjectMapper;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Farm;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class FileIO implements IFileIO{

    private final String FILEPATHFARM = "src/main/java/dk/via/sdj3_kursusopgave_part2/AnimalDatabaseServer/Database.Farm.ser";
    private final String FILEPATHANIMAL = "src/main/java/dk/via/sdj3_kursusopgave_part2/AnimalDatabaseServer/Database.Animal.ser";

    private FileOutputStream fileOutputStreamFarm;
    private ObjectOutputStream farmOut;
    private FileInputStream fileInputStreamFarm;
    private ObjectInputStream farmIn;

    private FileOutputStream fileOutputStreamAnimal;
    private ObjectOutputStream animalOut;
    private FileInputStream fileInputStreamAnimal;
    private ObjectInputStream animalIn;

    public FileIO()
    {
    }

    public void addFarm(Collection<Farm> farms)
    {
        try {
            fileOutputStreamFarm = new FileOutputStream(FILEPATHFARM);
            farmOut = new ObjectOutputStream(fileOutputStreamFarm);
            farmOut.writeObject(farms);
            farmOut.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Collection<Farm> loadFarms()
    {
        ArrayList<Farm> farms = new ArrayList<>();
        try {
            fileInputStreamFarm = new FileInputStream(FILEPATHFARM);
            File file = new File(FILEPATHFARM);
            if (file.length()==0) //null
            {
                return new ArrayList<Farm>();
            }
            else
            {
                farmIn = new ObjectInputStream(fileInputStreamFarm);
                farms = (ArrayList<Farm>) farmIn.readObject();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return farms;
    }

    @Override
    public Collection<Animal> loadAnimals() {
        ArrayList<Animal> animals = new ArrayList<>();
        try {
            fileInputStreamAnimal = new FileInputStream(FILEPATHANIMAL);
            File file = new File(FILEPATHANIMAL);
            if (file.length()==0)
            {
                return new ArrayList<Animal>();
            }
            else
            {
                animalIn = new ObjectInputStream(fileInputStreamAnimal);
                animals = (ArrayList<Animal>) animalIn.readObject();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return animals;
    }

    @Override
    public void addAnimals(Collection<Animal> animals) {
        try {
            fileOutputStreamAnimal = new FileOutputStream(FILEPATHANIMAL);
            animalOut = new ObjectOutputStream(fileOutputStreamAnimal);
            animalOut.writeObject(animals);
            animalOut.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
