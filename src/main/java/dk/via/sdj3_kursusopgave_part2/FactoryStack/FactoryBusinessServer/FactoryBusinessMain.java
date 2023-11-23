package dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryBusinessServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FactoryBusinessMain {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(FactoryBusinessMain.class);
        app.setAdditionalProfiles("FactoryBusinessMain");
        app.run(args);
    }
}
