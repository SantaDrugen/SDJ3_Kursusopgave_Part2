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

    public synchronized Product insertProduct(InsertProductDto product) {
        String SQL = "INSERT INTO product(animalCuts) VALUES (?::text[])";

        try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {

            // Converting ArrayList<String> to String Array
            String[] cutIdsArray = new String[product.getCutIds().size()];
            cutIdsArray = product.getCutIds().toArray(cutIdsArray);

            // Setting Array to PreparedStatement
            pstmt.setArray(1, connection.createArrayOf("text", cutIdsArray));
            pstmt.executeUpdate();

            return getLastAddedProduct();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public synchronized ArrayList<Product> getAllProducts()
    {
        String sql = "SELECT * FROM Product";
        ArrayList<Product> products = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Array cutIdsArray = resultSet.getArray("animalCuts");
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

    private Product getLastAddedProduct()
    {
        String sql = "SELECT * FROM Product ORDER BY id DESC LIMIT 1";
        Product productToReturn = null;
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product = new Product(new ArrayList<>());
            while (resultSet.next())
            {
                int id = resultSet.getInt("id");
                Array cutIdsArray = resultSet.getArray("animalCuts");
                String[] cutIds = (String[]) cutIdsArray.getArray();

                for (String cutId : cutIds)
                {
                    product.addAnimalCut(cutId);
                }
                product.setProductId(String.valueOf(id));
                productToReturn = product;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return productToReturn;
    }
}
