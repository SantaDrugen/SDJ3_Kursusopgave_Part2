package dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryDatabaseServer.Database;

import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.InsertProductDto;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.allAnimalCutsInProductDto;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.AnimalCut;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Product;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    private Connection connection;

    public Database() {
        try
        {
            connection = DatabaseConnection.connect();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try
        {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public synchronized void insertProduct(InsertProductDto product) {
        String sql = "INSERT INTO Product (animalCuts) VALUES ('" + product.getCutIds() + "');";
        try
        {
            connection.createStatement().execute(sql);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public synchronized ArrayList<Product> getAllProducts()
    {
        String sql = "SELECT * FROM Product";
        ArrayList<Product> products = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Array cutIdsArray = resultSet.getArray("cutIds");
                String[] cutIds = (String[]) cutIdsArray.getArray();

                Product product = new Product(new ArrayList<>());
                for (String cutId : cutIds) {
                    product.addAnimalCut(cutId);
                }
                product.setProductId(String.valueOf(id));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
}