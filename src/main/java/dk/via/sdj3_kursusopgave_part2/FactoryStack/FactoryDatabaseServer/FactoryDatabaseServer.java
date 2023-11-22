package dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryDatabaseServer;

import dk.via.sdj3_kursusopgave_part2.*;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Animal;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.AnimalCut;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Product;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.Random;

public class FactoryDatabaseServer extends FactoryServiceGrpc.FactoryServiceImplBase {

    private ArrayList<Product> products;

    private ArrayList<AnimalCut> cutsForPackaging;

    public FactoryDatabaseServer() {
        products = new ArrayList<>(); // Load from database
        cutsForPackaging = new ArrayList<>(); // Load from database
    }

    @Override
    public void getAllProducts(GetAllProductsRequest request,
                               StreamObserver<ProductListMessage> responseObserver) {
        ProductListMessage.Builder builder = ProductListMessage.newBuilder();

        for (Product product : products) {
            ProductMessage.Builder productBuilder
                    = ProductMessage.newBuilder();

            for (AnimalCut animalCut : product.getAnimalCuts()) {
                CutProductMessage.Builder cutBuilder
                        = CutProductMessage.newBuilder();

                cutBuilder.setCutId(animalCut.getCutId());

                productBuilder.addCuts(cutBuilder);
            }

            productBuilder.setProductId(product.getProductId());

            builder.addProducts(productBuilder);
        }

        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void createProduct(CreateProductRequest request,
                              StreamObserver<CreateProductResponse> responseObserver)
    {

        Random random = new Random();
        int numberOfCuts = random.nextInt(6) + 1;

        ArrayList<AnimalCut> animalCuts = new ArrayList<>();

        for (int i = 0; i < numberOfCuts; i++) {
            animalCuts.add(cutsForPackaging.get(0));
            cutsForPackaging.remove(0);
        }


    }

    @Override
    public void createProductId(CreateProductIdRequest request,
                                StreamObserver<CreateProductIdResponse> responseObserver) {
        String productId = generateProductId();
        CreateProductIdResponse response = CreateProductIdResponse
                .newBuilder()
                .setProductId(productId)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void saveProductChanges(SaveProductChangesRequest request,
                                   StreamObserver<SaveProductChangesResponse> responseObserver) {
        Product product = new Product(new ArrayList<>());

        for (CutProductMessage cut : request.getProduct().getCutsList()) {
            product.getAnimalCuts().add(new AnimalCut(cut.getCutId()));
        }

        product.setProductId(request.getProduct().getProductId());

        products.add(product);

        //TODO save to database

        SaveProductChangesResponse response = SaveProductChangesResponse
                .newBuilder()
                .setMessage("Product saved")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private String generateProductId() {
        int currentHigestId = products.size();
        for (Product i : products) {
            if (Integer.parseInt(i.getProductId()) > currentHigestId) {
                currentHigestId = Integer.parseInt(i.getProductId());
            }
        }
        return String.valueOf(++currentHigestId);
    }

}
