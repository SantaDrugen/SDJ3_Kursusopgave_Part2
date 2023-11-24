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

        ArrayList<String> animalIds = new ArrayList<>();

        for (String o : response.getAnimalIdsList()) {
            if (!animalIds.contains(o))
                animalIds.add(o);
        }

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
    public String createProduct() {
        ManagedChannel channel = getChannel();

        FactoryServiceGrpc.FactoryServiceBlockingStub stub
                = FactoryServiceGrpc.newBlockingStub(channel);

        CreateProductRequest request = CreateProductRequest
                .newBuilder()
                .build();

        CreateProductResponse response = stub.createProduct(request);

        return response.getProductId();
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

        ArrayList<String> productIds = new ArrayList<>();
        for(String o : response.getProductIdsList()) {
            if (!productIds.contains(o))
                productIds.add(o);
        }
        return productIds;
    }


    private ManagedChannel getChannel() {
        return ManagedChannelBuilder
                .forAddress("localhost", 4444)
                .usePlaintext()
                .build();
    }
}
