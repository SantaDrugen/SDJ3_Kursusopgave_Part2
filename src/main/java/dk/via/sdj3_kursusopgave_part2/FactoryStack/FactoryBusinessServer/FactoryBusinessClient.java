package dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryBusinessServer;

import dk.via.sdj3_kursusopgave_part2.*;
import dk.via.sdj3_kursusopgave_part2.Shared.DTOs.InfectedItemsDto;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
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
    public InfectedItemsDto getInfectedItems(String productId) {
        return null;
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
    public String createProduct() {
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

        String message = SaveProductChanges(productToCreate);

        return message;
    }

    private String createProductId() {
        ManagedChannel channel = getChannel();

        FactoryServiceGrpc.FactoryServiceBlockingStub stub
                = FactoryServiceGrpc.newBlockingStub(channel);

        CreateProductIdRequest request = CreateProductIdRequest
                .newBuilder()
                .build();

        CreateProductIdResponse response = stub.createProductId(request);

        return response.getProductId();
    }


    public String SaveProductChanges(Product product) {
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
