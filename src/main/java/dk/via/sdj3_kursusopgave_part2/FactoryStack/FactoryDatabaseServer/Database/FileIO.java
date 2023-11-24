package dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryDatabaseServer.Database;

import dk.via.sdj3_kursusopgave_part2.Shared.Domain.AnimalCut;

import java.io.*;
import java.util.ArrayList;

public class FileIO implements IFileIO{

    private final String FILEPATH = "src/main/java/dk/via/sdj3_kursusopgave_part2/FactoryStack/FactoryDatabaseServer/Database/Database.AnimalCutForPackaging.ser";

    private FileOutputStream fileOutputStream;
    private ObjectOutputStream animalCutOut;
    private FileInputStream fileInputStream;
    private ObjectInputStream animalCutIn;

    public FileIO() {
    }

    @Override
    public void addAnimalCutForPackaging(ArrayList<AnimalCut> animalCuts) {
        try {
            fileOutputStream = new FileOutputStream(FILEPATH);
            animalCutOut = new ObjectOutputStream(fileOutputStream);
            animalCutOut.writeObject(animalCuts);
            animalCutOut.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeAnimalCutForPackaging(AnimalCut animalCut) {
        ArrayList<AnimalCut> animalCuts = loadAnimalCutsForPackaging();
        animalCuts.remove(animalCut);
        addAnimalCutForPackaging(animalCuts);
    }

    @Override
    public ArrayList<AnimalCut> loadAnimalCutsForPackaging() {
        ArrayList<AnimalCut> animalCuts = new ArrayList<>();
        try {
            fileInputStream = new FileInputStream(FILEPATH);
            File file = new File(FILEPATH);
            if (file.length()==0) //null
            {
                return new ArrayList<AnimalCut>();
            }
            else
            {
                animalCutIn = new ObjectInputStream(fileInputStream);
                animalCuts = (ArrayList<AnimalCut>) animalCutIn.readObject();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return animalCuts;
    }

    @Override
    public void addAnimalCuts(ArrayList<AnimalCut> animalCuts) {
        try {
            fileOutputStream = new FileOutputStream(FILEPATH);
            animalCutOut = new ObjectOutputStream(fileOutputStream);
            animalCutOut.writeObject(animalCuts);
            animalCutOut.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
