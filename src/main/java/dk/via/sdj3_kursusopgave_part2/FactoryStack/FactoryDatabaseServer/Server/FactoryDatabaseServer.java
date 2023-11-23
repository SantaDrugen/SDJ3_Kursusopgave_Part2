package dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryDatabaseServer.Server;

import dk.via.sdj3_kursusopgave_part2.*;
import dk.via.sdj3_kursusopgave_part2.FactoryStack.FactoryDatabaseServer.Database.Database;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.AnimalCut;
import dk.via.sdj3_kursusopgave_part2.Shared.Domain.Product;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.Random;

public class FactoryDatabaseServer extends FactoryServiceGrpc.FactoryServiceImplBase {

    private ArrayList<Product> products;

    private ArrayList<AnimalCut> cutsForPackaging;

    private Database database;

    public FactoryDatabaseServer() {
        database = new Database();
        products = database.getAllProducts(); // Load from database
        cutsForPackaging = new ArrayList<>();
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
        java.lang.String productId = generateProductId();
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

    @Override
    public void getInfectedItems(GetInfectedItemsRequest request,
                                 StreamObserver<GetInfectedItemsResponse> responseObserver) {
        Product productRecieved = new Product(new ArrayList<>());
        for (Product product : products) {
            if (product.getProductId().equals(request.getProductId()))
            {
                productRecieved = product;
            }
            else
            {
                throw new IllegalArgumentException("Product not found");
            }
        }

        ArrayList<String> animalIds = extractAnimalIdsFromProduct(productRecieved);

        GetInfectedItemsResponse response = GetInfectedItemsResponse
                .newBuilder()
                .addAllAnimalIds(animalIds)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void getAllProductsOfAnimal(GetAllProductsOfAnimalRequest request,
                                    StreamObserver<GetAllProductsOfAnimalResponse> responseObserver) {
        ArrayList<String> productIdsOfAnimal = new ArrayList<>();
        for (Product product : products) {
            for (AnimalCut animalCut : product.getAnimalCuts()) {
                if (extractAnimalIdFromAnimalCutId(animalCut.getCutId()).equals(request.getAnimalId())) {
                    productIdsOfAnimal.add(product.getProductId());
                }
            }
        }

        GetAllProductsOfAnimalResponse response = GetAllProductsOfAnimalResponse
                .newBuilder()
                .addAllProductIds(productIdsOfAnimal)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }



    private ArrayList<java.lang.String> extractAnimalIdsFromProduct(Product product) {
        ArrayList<java.lang.String> animals = new ArrayList<>();
        for (AnimalCut animalCut : product.getAnimalCuts()) {
            animals.add(extractAnimalIdFromAnimalCutId(animalCut.getCutId()));
        }
        return animals;
    }

    private java.lang.String extractAnimalIdFromAnimalCutId(java.lang.String animalCutId) {
        int hyphenIndex = animalCutId.indexOf('-');
        if (hyphenIndex != -1) {
            // Extract the substring before the hyphen
            return animalCutId.substring(0, hyphenIndex);
        } else {
            // Return the original string if no hyphen is found
            return animalCutId;
        }
    }

    private java.lang.String generateProductId() {
        int currentHigestId = products.size();
        for (Product i : products) {
            if (Integer.parseInt(i.getProductId()) > currentHigestId) {
                currentHigestId = Integer.parseInt(i.getProductId());
            }
        }
        return java.lang.String.valueOf(++currentHigestId);
    }

}
