package dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryDatabaseServer.Database;

import java.sql.Connection;

public class DatabaseSetupMain {

    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnection.connect();

//            String sql = "CREATE TABLE Product ( " +
//                    "id serial PRIMARY KEY, " +
//                    "animalCuts TEXT[] " +
//                    ");";
//
//            connection
//                    .createStatement()
//                    .execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
