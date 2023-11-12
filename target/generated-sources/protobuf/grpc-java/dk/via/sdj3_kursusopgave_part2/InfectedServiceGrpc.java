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
    comments = "Source: FactoryService.proto")
public final class InfectedServiceGrpc {

  private InfectedServiceGrpc() {}

  public static final String SERVICE_NAME = "dk.via.sdj3_kursusopgave_part2.InfectedService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest,
      dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalResponse> METHOD_GET_INFECTED_PRODUCT_AND_ANIMAL =
      io.grpc.MethodDescriptor.<dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest, dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "dk.via.sdj3_kursusopgave_part2.InfectedService", "getInfectedProductAndAnimal"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static InfectedServiceStub newStub(io.grpc.Channel channel) {
    return new InfectedServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InfectedServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new InfectedServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static InfectedServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new InfectedServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class InfectedServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getInfectedProductAndAnimal(dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest request,
        io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_INFECTED_PRODUCT_AND_ANIMAL, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_INFECTED_PRODUCT_AND_ANIMAL,
            asyncUnaryCall(
              new MethodHandlers<
                dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest,
                dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalResponse>(
                  this, METHODID_GET_INFECTED_PRODUCT_AND_ANIMAL)))
          .build();
    }
  }

  /**
   */
  public static final class InfectedServiceStub extends io.grpc.stub.AbstractStub<InfectedServiceStub> {
    private InfectedServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InfectedServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InfectedServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InfectedServiceStub(channel, callOptions);
    }

    /**
     */
    public void getInfectedProductAndAnimal(dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest request,
        io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_INFECTED_PRODUCT_AND_ANIMAL, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class InfectedServiceBlockingStub extends io.grpc.stub.AbstractStub<InfectedServiceBlockingStub> {
    private InfectedServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InfectedServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InfectedServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InfectedServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalResponse getInfectedProductAndAnimal(dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_INFECTED_PRODUCT_AND_ANIMAL, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class InfectedServiceFutureStub extends io.grpc.stub.AbstractStub<InfectedServiceFutureStub> {
    private InfectedServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InfectedServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InfectedServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InfectedServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalResponse> getInfectedProductAndAnimal(
        dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_INFECTED_PRODUCT_AND_ANIMAL, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_INFECTED_PRODUCT_AND_ANIMAL = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final InfectedServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(InfectedServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_INFECTED_PRODUCT_AND_ANIMAL:
          serviceImpl.getInfectedProductAndAnimal((dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest) request,
              (io.grpc.stub.StreamObserver<dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalResponse>) responseObserver);
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

  private static final class InfectedServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dk.via.sdj3_kursusopgave_part2.FactoryService.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (InfectedServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new InfectedServiceDescriptorSupplier())
              .addMethod(METHOD_GET_INFECTED_PRODUCT_AND_ANIMAL)
              .build();
        }
      }
    }
    return result;
  }
}
