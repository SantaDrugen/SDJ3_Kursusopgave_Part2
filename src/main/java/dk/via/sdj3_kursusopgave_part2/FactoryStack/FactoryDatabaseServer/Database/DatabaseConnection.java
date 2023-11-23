package dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryDatabaseServer.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://cornelius.db.elephantsql.com/wenejnyd?currentSchema=sdj3_kursusopgave";
    private static final String USER = "wenejnyd";
    private static final String PASSWORD = "DFIxRXTfRD81tJvsr3xoP40rAObSD-7Q";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
