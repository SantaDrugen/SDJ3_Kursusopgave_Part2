package dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.SlaughterBusinessServer;

import dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryBusinessServer.FactoryBusinessMain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SlaughterBusinessMain {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SlaughterBusinessMain.class);
        app.setAdditionalProfiles("SlaughterBusinessMain");
        app.run(args);
    }
}
