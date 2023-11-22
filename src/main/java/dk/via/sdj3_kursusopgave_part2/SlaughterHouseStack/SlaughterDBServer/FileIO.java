package dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.SlaughterDBServer;

import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.AnimalCut;

import java.io.*;
import java.util.ArrayList;

public class FileIO implements IFileIO {

    private static final String FILEPATHANIMALCUTS = "src/main/java/dk/via/sdj3_kursusopgave_part2/SlaughterHouseStack/SlaughterDBServer/slaughteredAnimals.ser";

    private static final String FILEPATHANIMALSTOSLAUGHTER = "src/main/java/dk/via/sdj3_kursusopgave_part2/SlaughterHouseStack/SlaughterDBServer/animalsToSlaughter.ser";

    private FileOutputStream fileOutputStreamAnimalCuts;
    private ObjectOutputStream animalCutsOut;
    private FileInputStream fileInputStreamAnimalCuts;
    private ObjectInputStream animalCutsIn;

    private FileOutputStream fileOutputStreamAnimalsToSlaughter;
    private ObjectOutputStream animalsToSlaughterOut;
    private FileInputStream fileInputStreamAnimalsToSlaughter;
    private ObjectInputStream animalsToSlaughterIn;

    public FileIO() {
    }


    public void addAnimalCuts(ArrayList<AnimalCut> animalCuts) {
        try {
            fileOutputStreamAnimalCuts = new FileOutputStream(FILEPATHANIMALCUTS);
            animalCutsOut = new ObjectOutputStream(fileOutputStreamAnimalCuts);
            animalCutsOut.writeObject(animalCuts);
            animalCutsOut.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addAnimalsToSlaughter(ArrayList<Animal> animalsToSlaughter) {
        try {
            fileOutputStreamAnimalsToSlaughter = new FileOutputStream(FILEPATHANIMALSTOSLAUGHTER);
            animalsToSlaughterOut = new ObjectOutputStream(fileOutputStreamAnimalsToSlaughter);
            animalsToSlaughterOut.writeObject(animalsToSlaughter);
            animalsToSlaughterOut.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<AnimalCut> loadAnimalCuts() {
        ArrayList<AnimalCut> animalCuts = new ArrayList<>();
        try {
            fileInputStreamAnimalCuts = new FileInputStream(FILEPATHANIMALCUTS);
            File file = new File(FILEPATHANIMALCUTS);
            if (file.length() == 0)
            {
                return new ArrayList<AnimalCut>();
            }
            else
            {
                animalCutsIn = new ObjectInputStream(fileInputStreamAnimalCuts);
                animalCuts = (ArrayList<AnimalCut>) animalCutsIn.readObject();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return animalCuts;
    }

    public ArrayList<Animal> loadAnimalsToSlaughter() {
        ArrayList<Animal> animalsToSlaughter = new ArrayList<>();
        try {
            fileInputStreamAnimalsToSlaughter = new FileInputStream(FILEPATHANIMALSTOSLAUGHTER);
            File file = new File(FILEPATHANIMALSTOSLAUGHTER);
            if (file.length() == 0)
            {
                return new ArrayList<Animal>();
            }
            else
            {
                animalsToSlaughterIn = new ObjectInputStream(fileInputStreamAnimalsToSlaughter);
                animalsToSlaughter = (ArrayList<Animal>) animalsToSlaughterIn.readObject();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return animalsToSlaughter;
    }

}
