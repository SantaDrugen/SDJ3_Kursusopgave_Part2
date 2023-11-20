package dk.via.sdj3_kursusopgave_part2;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: AnimalService.proto")
public final class AnimalServiceGrpc {

  private AnimalServiceGrpc() {}

  public static final String SERVICE_NAME = "dk.via.sdj3_kursusopgave_part2.AnimalService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<dk.via.sdj3_kursusopgave_part2.CreateFarmRequest,
      dk.via.sdj3_kursusopgave_part2.CreateFarmResponse> METHOD_CREATE_FARM =
      io.grpc.MethodDescriptor.<dk.via.sdj3_kursusopgave_part2.CreateFarmRequest, dk.via.sdj3_kursusopgave_part2.CreateFarmResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "dk.via.sdj3_kursusopgave_part2.AnimalService", "createFarm"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              dk.via.sdj3_kursusopgave_part2.CreateFarmRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              dk.via.sdj3_kursusopgave_part2.CreateFarmResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<dk.via.sdj3_kursusopgave_part2.CreateAnimalRequest,
      dk.via.sdj3_kursusopgave_part2.CreateAnimalResponse> METHOD_CREATE_ANIMAL =
      io.grpc.MethodDescriptor.<dk.via.sdj3_kursusopgave_part2.CreateAnimalRequest, dk.via.sdj3_kursusopgave_part2.CreateAnimalResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "dk.via.sdj3_kursusopgave_part2.AnimalService", "CreateAnimal"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              dk.via.sdj3_kursusopgave_part2.CreateAnimalRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              dk.via.sdj3_kursusopgave_part2.CreateAnimalResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<dk.via.sdj3_kursusopgave_part2.GetAllFarmsRequest,
      dk.via.sdj3_kursusopgave_part2.GetAllFarmsResponse> METHOD_GET_ALL_FARMS =
      io.grpc.MethodDescriptor.<dk.via.sdj3_kursusopgave_part2.GetAllFarmsRequest, dk.via.sdj3_kursusopgave_part2.GetAllFarmsResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "dk.via.sdj3_kursusopgave_part2.AnimalService", "GetAllFarms"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              dk.via.sdj3_kursusopgave_part2.GetAllFarmsRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              dk.via.sdj3_kursusopgave_part2.GetAllFarmsResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<dk.via.sdj3_kursusopgave_part2.GetAllAnimalsRequest,
      dk.via.sdj3_kursusopgave_part2.GetAllAnimalsResponse> METHOD_GET_ALL_ANIMALS =
      io.grpc.MethodDescriptor.<dk.via.sdj3_kursusopgave_part2.GetAllAnimalsRequest, dk.via.sdj3_kursusopgave_part2.GetAllAnimalsResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "dk.via.sdj3_kursusopgave_part2.AnimalService", "GetAllAnimals"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              dk.via.sdj3_kursusopgave_part2.GetAllAnimalsRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              dk.via.sdj3_kursusopgave_part2.GetAllAnimalsResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<dk.via.sdj3_kursusopgave_part2.GetFarmRequest,
      dk.via.sdj3_kursusopgave_part2.FarmMessage> METHOD_GET_FARM =
      io.grpc.MethodDescriptor.<dk.via.sdj3_kursusopgave_part2.GetFarmRequest, dk.via.sdj3_kursusopgave_part2.FarmMessage>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "dk.via.sdj3_kursusopgave_part2.AnimalService", "GetFarm"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              dk.via.sdj3_kursusopgave_part2.GetFarmRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              dk.via.sdj3_kursusopgave_part2.FarmMessage.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<dk.via.sdj3_kursusopgave_part2.GetAnimalRequest,
      dk.via.sdj3_kursusopgave_part2.GetAnimalResponse> METHOD_GET_ANIMAL =
      io.grpc.MethodDescriptor.<dk.via.sdj3_kursusopgave_part2.GetAnimalRequest, dk.via.sdj3_kursusopgave_part2.GetAnimalResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "dk.via.sdj3_kursusopgave_part2.AnimalService", "GetAnimal"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              dk.via.sdj3_kursusopgave_part2.GetAnimalRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              dk.via.sdj3_kursusopgave_part2.GetAnimalResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromFarmRequest,
      dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromFarmResponse> METHOD_GET_ALL_ANIMALS_FROM_FARM =
      io.grpc.MethodDescriptor.<dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromFarmRequest, dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromFarmResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "dk.via.sdj3_kursusopgave_part2.AnimalService", "GetAllAnimalsFromFarm"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromFarmRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromFarmResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromDateRequest,
      dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromDateResponse> METHOD_GET_ALL_ANIMALS_FROM_DATE =
      io.grpc.MethodDescriptor.<dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromDateRequest, dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromDateResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "dk.via.sdj3_kursusopgave_part2.AnimalService", "GetAllAnimalsFromDate"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromDateRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromDateResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AnimalServiceStub newStub(io.grpc.Channel channel) {
    return new AnimalServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AnimalServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AnimalServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AnimalServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AnimalServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AnimalServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createFarm(dk.via.sdj3_kursusopgave_part2.CreateFarmRequest request,
        io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.CreateFarmResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_FARM, responseObserver);
    }

    /**
     */
    public void createAnimal(dk.via.sdj3_kursusopgave_part2.CreateAnimalRequest request,
        io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.CreateAnimalResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_ANIMAL, responseObserver);
    }

    /**
     */
    public void getAllFarms(dk.via.sdj3_kursusopgave_part2.GetAllFarmsRequest request,
        io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.GetAllFarmsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ALL_FARMS, responseObserver);
    }

    /**
     */
    public void getAllAnimals(dk.via.sdj3_kursusopgave_part2.GetAllAnimalsRequest request,
        io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.GetAllAnimalsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ALL_ANIMALS, responseObserver);
    }

    /**
     */
    public void getFarm(dk.via.sdj3_kursusopgave_part2.GetFarmRequest request,
        io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.FarmMessage> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_FARM, responseObserver);
    }

    /**
     */
    public void getAnimal(dk.via.sdj3_kursusopgave_part2.GetAnimalRequest request,
        io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.GetAnimalResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ANIMAL, responseObserver);
    }

    /**
     */
    public void getAllAnimalsFromFarm(dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromFarmRequest request,
        io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromFarmResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ALL_ANIMALS_FROM_FARM, responseObserver);
    }

    /**
     */
    public void getAllAnimalsFromDate(dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromDateRequest request,
        io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromDateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ALL_ANIMALS_FROM_DATE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CREATE_FARM,
            asyncUnaryCall(
              new MethodHandlers<
                dk.via.sdj3_kursusopgave_part2.CreateFarmRequest,
                dk.via.sdj3_kursusopgave_part2.CreateFarmResponse>(
                  this, METHODID_CREATE_FARM)))
          .addMethod(
            METHOD_CREATE_ANIMAL,
            asyncUnaryCall(
              new MethodHandlers<
                dk.via.sdj3_kursusopgave_part2.CreateAnimalRequest,
                dk.via.sdj3_kursusopgave_part2.CreateAnimalResponse>(
                  this, METHODID_CREATE_ANIMAL)))
          .addMethod(
            METHOD_GET_ALL_FARMS,
            asyncUnaryCall(
              new MethodHandlers<
                dk.via.sdj3_kursusopgave_part2.GetAllFarmsRequest,
                dk.via.sdj3_kursusopgave_part2.GetAllFarmsResponse>(
                  this, METHODID_GET_ALL_FARMS)))
          .addMethod(
            METHOD_GET_ALL_ANIMALS,
            asyncUnaryCall(
              new MethodHandlers<
                dk.via.sdj3_kursusopgave_part2.GetAllAnimalsRequest,
                dk.via.sdj3_kursusopgave_part2.GetAllAnimalsResponse>(
                  this, METHODID_GET_ALL_ANIMALS)))
          .addMethod(
            METHOD_GET_FARM,
            asyncUnaryCall(
              new MethodHandlers<
                dk.via.sdj3_kursusopgave_part2.GetFarmRequest,
                dk.via.sdj3_kursusopgave_part2.FarmMessage>(
                  this, METHODID_GET_FARM)))
          .addMethod(
            METHOD_GET_ANIMAL,
            asyncUnaryCall(
              new MethodHandlers<
                dk.via.sdj3_kursusopgave_part2.GetAnimalRequest,
                dk.via.sdj3_kursusopgave_part2.GetAnimalResponse>(
                  this, METHODID_GET_ANIMAL)))
          .addMethod(
            METHOD_GET_ALL_ANIMALS_FROM_FARM,
            asyncUnaryCall(
              new MethodHandlers<
                dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromFarmRequest,
                dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromFarmResponse>(
                  this, METHODID_GET_ALL_ANIMALS_FROM_FARM)))
          .addMethod(
            METHOD_GET_ALL_ANIMALS_FROM_DATE,
            asyncUnaryCall(
              new MethodHandlers<
                dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromDateRequest,
                dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromDateResponse>(
                  this, METHODID_GET_ALL_ANIMALS_FROM_DATE)))
          .build();
    }
  }

  /**
   */
  public static final class AnimalServiceStub extends io.grpc.stub.AbstractStub<AnimalServiceStub> {
    private AnimalServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AnimalServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnimalServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AnimalServiceStub(channel, callOptions);
    }

    /**
     */
    public void createFarm(dk.via.sdj3_kursusopgave_part2.CreateFarmRequest request,
        io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.CreateFarmResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_FARM, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createAnimal(dk.via.sdj3_kursusopgave_part2.CreateAnimalRequest request,
        io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.CreateAnimalResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_ANIMAL, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllFarms(dk.via.sdj3_kursusopgave_part2.GetAllFarmsRequest request,
        io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.GetAllFarmsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ALL_FARMS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllAnimals(dk.via.sdj3_kursusopgave_part2.GetAllAnimalsRequest request,
        io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.GetAllAnimalsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ALL_ANIMALS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getFarm(dk.via.sdj3_kursusopgave_part2.GetFarmRequest request,
        io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.FarmMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_FARM, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAnimal(dk.via.sdj3_kursusopgave_part2.GetAnimalRequest request,
        io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.GetAnimalResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ANIMAL, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllAnimalsFromFarm(dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromFarmRequest request,
        io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromFarmResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ALL_ANIMALS_FROM_FARM, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllAnimalsFromDate(dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromDateRequest request,
        io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromDateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ALL_ANIMALS_FROM_DATE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AnimalServiceBlockingStub extends io.grpc.stub.AbstractStub<AnimalServiceBlockingStub> {
    private AnimalServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AnimalServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnimalServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AnimalServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public dk.via.sdj3_kursusopgave_part2.CreateFarmResponse createFarm(dk.via.sdj3_kursusopgave_part2.CreateFarmRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_FARM, getCallOptions(), request);
    }

    /**
     */
    public dk.via.sdj3_kursusopgave_part2.CreateAnimalResponse createAnimal(dk.via.sdj3_kursusopgave_part2.CreateAnimalRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_ANIMAL, getCallOptions(), request);
    }

    /**
     */
    public dk.via.sdj3_kursusopgave_part2.GetAllFarmsResponse getAllFarms(dk.via.sdj3_kursusopgave_part2.GetAllFarmsRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ALL_FARMS, getCallOptions(), request);
    }

    /**
     */
    public dk.via.sdj3_kursusopgave_part2.GetAllAnimalsResponse getAllAnimals(dk.via.sdj3_kursusopgave_part2.GetAllAnimalsRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ALL_ANIMALS, getCallOptions(), request);
    }

    /**
     */
    public dk.via.sdj3_kursusopgave_part2.FarmMessage getFarm(dk.via.sdj3_kursusopgave_part2.GetFarmRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_FARM, getCallOptions(), request);
    }

    /**
     */
    public dk.via.sdj3_kursusopgave_part2.GetAnimalResponse getAnimal(dk.via.sdj3_kursusopgave_part2.GetAnimalRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ANIMAL, getCallOptions(), request);
    }

    /**
     */
    public dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromFarmResponse getAllAnimalsFromFarm(dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromFarmRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ALL_ANIMALS_FROM_FARM, getCallOptions(), request);
    }

    /**
     */
    public dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromDateResponse getAllAnimalsFromDate(dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromDateRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ALL_ANIMALS_FROM_DATE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AnimalServiceFutureStub extends io.grpc.stub.AbstractStub<AnimalServiceFutureStub> {
    private AnimalServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AnimalServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnimalServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AnimalServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dk.via.sdj3_kursusopgave_part2.CreateFarmResponse> createFarm(
        dk.via.sdj3_kursusopgave_part2.CreateFarmRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_FARM, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dk.via.sdj3_kursusopgave_part2.CreateAnimalResponse> createAnimal(
        dk.via.sdj3_kursusopgave_part2.CreateAnimalRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_ANIMAL, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dk.via.sdj3_kursusopgave_part2.GetAllFarmsResponse> getAllFarms(
        dk.via.sdj3_kursusopgave_part2.GetAllFarmsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ALL_FARMS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dk.via.sdj3_kursusopgave_part2.GetAllAnimalsResponse> getAllAnimals(
        dk.via.sdj3_kursusopgave_part2.GetAllAnimalsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ALL_ANIMALS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dk.via.sdj3_kursusopgave_part2.FarmMessage> getFarm(
        dk.via.sdj3_kursusopgave_part2.GetFarmRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_FARM, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dk.via.sdj3_kursusopgave_part2.GetAnimalResponse> getAnimal(
        dk.via.sdj3_kursusopgave_part2.GetAnimalRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ANIMAL, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromFarmResponse> getAllAnimalsFromFarm(
        dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromFarmRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ALL_ANIMALS_FROM_FARM, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromDateResponse> getAllAnimalsFromDate(
        dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromDateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ALL_ANIMALS_FROM_DATE, getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_FARM = 0;
  private static final int METHODID_CREATE_ANIMAL = 1;
  private static final int METHODID_GET_ALL_FARMS = 2;
  private static final int METHODID_GET_ALL_ANIMALS = 3;
  private static final int METHODID_GET_FARM = 4;
  private static final int METHODID_GET_ANIMAL = 5;
  private static final int METHODID_GET_ALL_ANIMALS_FROM_FARM = 6;
  private static final int METHODID_GET_ALL_ANIMALS_FROM_DATE = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AnimalServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AnimalServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_FARM:
          serviceImpl.createFarm((dk.via.sdj3_kursusopgave_part2.CreateFarmRequest) request,
              (io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.CreateFarmResponse>) responseObserver);
          break;
        case METHODID_CREATE_ANIMAL:
          serviceImpl.createAnimal((dk.via.sdj3_kursusopgave_part2.CreateAnimalRequest) request,
              (io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.CreateAnimalResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_FARMS:
          serviceImpl.getAllFarms((dk.via.sdj3_kursusopgave_part2.GetAllFarmsRequest) request,
              (io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.GetAllFarmsResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_ANIMALS:
          serviceImpl.getAllAnimals((dk.via.sdj3_kursusopgave_part2.GetAllAnimalsRequest) request,
              (io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.GetAllAnimalsResponse>) responseObserver);
          break;
        case METHODID_GET_FARM:
          serviceImpl.getFarm((dk.via.sdj3_kursusopgave_part2.GetFarmRequest) request,
              (io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.FarmMessage>) responseObserver);
          break;
        case METHODID_GET_ANIMAL:
          serviceImpl.getAnimal((dk.via.sdj3_kursusopgave_part2.GetAnimalRequest) request,
              (io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.GetAnimalResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_ANIMALS_FROM_FARM:
          serviceImpl.getAllAnimalsFromFarm((dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromFarmRequest) request,
              (io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromFarmResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_ANIMALS_FROM_DATE:
          serviceImpl.getAllAnimalsFromDate((dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromDateRequest) request,
              (io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.GetAllAnimalsFromDateResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class AnimalServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dk.via.sdj3_kursusopgave_part2.AnimalServiceOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AnimalServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AnimalServiceDescriptorSupplier())
              .addMethod(METHOD_CREATE_FARM)
              .addMethod(METHOD_CREATE_ANIMAL)
              .addMethod(METHOD_GET_ALL_FARMS)
              .addMethod(METHOD_GET_ALL_ANIMALS)
              .addMethod(METHOD_GET_FARM)
              .addMethod(METHOD_GET_ANIMAL)
              .addMethod(METHOD_GET_ALL_ANIMALS_FROM_FARM)
              .addMethod(METHOD_GET_ALL_ANIMALS_FROM_DATE)
              .build();
        }
      }
    }
    return result;
  }
}
