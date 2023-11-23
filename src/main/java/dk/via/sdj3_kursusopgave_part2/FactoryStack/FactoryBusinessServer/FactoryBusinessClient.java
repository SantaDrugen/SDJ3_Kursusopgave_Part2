package dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryBusinessServer;

import dk.via.sdj3_kursusopgave_part2.*;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.AnimalIdsOfProductDto;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.ProductsOfAnimalDto;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.AnimalCut;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Product;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("FactoryBusinessClient")
@Scope("singleton")
public class FactoryBusinessClient implements IFactoryBusinessClient {


    @Override
    public ArrayList<String> getAllAnimalsFromProduct(AnimalIdsOfProductDto animalIdsOfProductDto) {
        ManagedChannel channel = getChannel();

        FactoryServiceGrpc.FactoryServiceBlockingStub stub
                = FactoryServiceGrpc.newBlockingStub(channel);

        GetInfectedItemsRequest request = GetInfectedItemsRequest
                .newBuilder()
                .setProductId(animalIdsOfProductDto.getProductId())
                .build();

        GetInfectedItemsResponse response = stub.getInfectedItems(request);

        ArrayList<java.lang.String> animalIds = new ArrayList<>();

        animalIds = (ArrayList<java.lang.String>) response.getAnimalIdsList();



        return animalIds;
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        ManagedChannel channel = getChannel();

        FactoryServiceGrpc.FactoryServiceBlockingStub stub
                = FactoryServiceGrpc.newBlockingStub(channel);

        GetAllProductsRequest request = GetAllProductsRequest
                .newBuilder()
                .build();

        ProductListMessage response = stub.getAllProducts(request);

        ArrayList<Product> products = new ArrayList<>();

        for (ProductMessage o : response.getProductsList()) {
            ArrayList<AnimalCut> animalCuts = new ArrayList<>();
            for (CutProductMessage c : o.getCutsList()) {
                animalCuts.add(new AnimalCut(c.getCutId()));
            }
            Product product = new Product(animalCuts);
            product.setProductId(o.getProductId());
            products.add(product);
        }

        return products;
    }

    @Override
    public java.lang.String createProduct() {
        ManagedChannel channel = getChannel();

        FactoryServiceGrpc.FactoryServiceBlockingStub stub
                = FactoryServiceGrpc.newBlockingStub(channel);

        CreateProductRequest request = CreateProductRequest
                .newBuilder()
                .build();

        CreateProductResponse response = stub.createProduct(request);

        ArrayList<AnimalCut> cutIds = new ArrayList<>();

        for (String o : response.getCutIdsList()) {
            cutIds.add(new AnimalCut(o));
        }

        Product productToCreate = new Product(cutIds);

        productToCreate.setProductId(createProductId());

        java.lang.String message = SaveProductChanges(productToCreate);

        return message;
    }

    @Override
    public ArrayList<String> getAllProductsOfAnimal(ProductsOfAnimalDto productsOfAnimalDto) {
        ManagedChannel channel = getChannel();

        FactoryServiceGrpc.FactoryServiceBlockingStub stub
                = FactoryServiceGrpc.newBlockingStub(channel);

        GetAllProductsOfAnimalRequest request = GetAllProductsOfAnimalRequest
                .newBuilder()
                .setAnimalId(productsOfAnimalDto.getAnimalId())
                .build();

        GetAllProductsOfAnimalResponse response = stub.getAllProductsOfAnimal(request);

        return (ArrayList<String>) response.getProductIdsList();
    }

    private java.lang.String createProductId() {

        //TODO: Set id type to int, and have postgreSQL generate ID.
        ManagedChannel channel = getChannel();

        FactoryServiceGrpc.FactoryServiceBlockingStub stub
                = FactoryServiceGrpc.newBlockingStub(channel);

        CreateProductIdRequest request = CreateProductIdRequest
                .newBuilder()
                .build();

        CreateProductIdResponse response = stub.createProductId(request);

        return response.getProductId();
    }


    public java.lang.String SaveProductChanges(Product product) {

        //TODO: Remove this method, and have postgreSQL generate ID.
        ManagedChannel channel = getChannel();

        FactoryServiceGrpc.FactoryServiceBlockingStub stub
                = FactoryServiceGrpc.newBlockingStub(channel);

        ProductMessage.Builder productBuilder = ProductMessage.newBuilder();

        productBuilder.setProductId(product.getProductId());

        for (AnimalCut animalCut : product.getAnimalCuts()) {
            CutProductMessage.Builder cutBuilder
                    = CutProductMessage.newBuilder();

            cutBuilder.setCutId(animalCut.getCutId());

            productBuilder.addCuts(cutBuilder);
        }

        SaveProductChangesRequest request = SaveProductChangesRequest
                .newBuilder()
                .setProduct(productBuilder)
                .build();


        SaveProductChangesResponse response = stub.saveProductChanges(request);

        return response.getMessage();
    }



    private ManagedChannel getChannel() {
        return ManagedChannelBuilder
                .forAddress("localhost", 4444)
                .usePlaintext()
                .build();
    }
}
