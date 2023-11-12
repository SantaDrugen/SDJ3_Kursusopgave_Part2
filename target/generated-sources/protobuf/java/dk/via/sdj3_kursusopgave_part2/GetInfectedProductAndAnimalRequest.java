// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: FactoryService.proto

package dk.via.sdj3_kursusopgave_part2;

/**
 * Protobuf type {@code dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest}
 */
public  final class GetInfectedProductAndAnimalRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest)
    GetInfectedProductAndAnimalRequestOrBuilder {
  // Use GetInfectedProductAndAnimalRequest.newBuilder() to construct.
  private GetInfectedProductAndAnimalRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetInfectedProductAndAnimalRequest() {
    animalId_ = "";
    productId_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private GetInfectedProductAndAnimalRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            animalId_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            productId_ = s;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return dk.via.sdj3_kursusopgave_part2.FactoryService.internal_static_dk_via_sdj3_kursusopgave_part2_GetInfectedProductAndAnimalRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return dk.via.sdj3_kursusopgave_part2.FactoryService.internal_static_dk_via_sdj3_kursusopgave_part2_GetInfectedProductAndAnimalRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest.class, dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest.Builder.class);
  }

  public static final int ANIMALID_FIELD_NUMBER = 1;
  private volatile java.lang.Object animalId_;
  /**
   * <code>string animalId = 1;</code>
   */
  public java.lang.String getAnimalId() {
    java.lang.Object ref = animalId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      animalId_ = s;
      return s;
    }
  }
  /**
   * <code>string animalId = 1;</code>
   */
  public com.google.protobuf.ByteString
      getAnimalIdBytes() {
    java.lang.Object ref = animalId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      animalId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PRODUCTID_FIELD_NUMBER = 2;
  private volatile java.lang.Object productId_;
  /**
   * <code>string productId = 2;</code>
   */
  public java.lang.String getProductId() {
    java.lang.Object ref = productId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      productId_ = s;
      return s;
    }
  }
  /**
   * <code>string productId = 2;</code>
   */
  public com.google.protobuf.ByteString
      getProductIdBytes() {
    java.lang.Object ref = productId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      productId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getAnimalIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, animalId_);
    }
    if (!getProductIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, productId_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getAnimalIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, animalId_);
    }
    if (!getProductIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, productId_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest)) {
      return super.equals(obj);
    }
    dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest other = (dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest) obj;

    boolean result = true;
    result = result && getAnimalId()
        .equals(other.getAnimalId());
    result = result && getProductId()
        .equals(other.getProductId());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ANIMALID_FIELD_NUMBER;
    hash = (53 * hash) + getAnimalId().hashCode();
    hash = (37 * hash) + PRODUCTID_FIELD_NUMBER;
    hash = (53 * hash) + getProductId().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest)
      dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return dk.via.sdj3_kursusopgave_part2.FactoryService.internal_static_dk_via_sdj3_kursusopgave_part2_GetInfectedProductAndAnimalRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return dk.via.sdj3_kursusopgave_part2.FactoryService.internal_static_dk_via_sdj3_kursusopgave_part2_GetInfectedProductAndAnimalRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest.class, dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest.Builder.class);
    }

    // Construct using dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      animalId_ = "";

      productId_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return dk.via.sdj3_kursusopgave_part2.FactoryService.internal_static_dk_via_sdj3_kursusopgave_part2_GetInfectedProductAndAnimalRequest_descriptor;
    }

    public dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest getDefaultInstanceForType() {
      return dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest.getDefaultInstance();
    }

    public dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest build() {
      dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest buildPartial() {
      dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest result = new dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest(this);
      result.animalId_ = animalId_;
      result.productId_ = productId_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest) {
        return mergeFrom((dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest other) {
      if (other == dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest.getDefaultInstance()) return this;
      if (!other.getAnimalId().isEmpty()) {
        animalId_ = other.animalId_;
        onChanged();
      }
      if (!other.getProductId().isEmpty()) {
        productId_ = other.productId_;
        onChanged();
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object animalId_ = "";
    /**
     * <code>string animalId = 1;</code>
     */
    public java.lang.String getAnimalId() {
      java.lang.Object ref = animalId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        animalId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string animalId = 1;</code>
     */
    public com.google.protobuf.ByteString
        getAnimalIdBytes() {
      java.lang.Object ref = animalId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        animalId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string animalId = 1;</code>
     */
    public Builder setAnimalId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      animalId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string animalId = 1;</code>
     */
    public Builder clearAnimalId() {
      
      animalId_ = getDefaultInstance().getAnimalId();
      onChanged();
      return this;
    }
    /**
     * <code>string animalId = 1;</code>
     */
    public Builder setAnimalIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      animalId_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object productId_ = "";
    /**
     * <code>string productId = 2;</code>
     */
    public java.lang.String getProductId() {
      java.lang.Object ref = productId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        productId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string productId = 2;</code>
     */
    public com.google.protobuf.ByteString
        getProductIdBytes() {
      java.lang.Object ref = productId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        productId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string productId = 2;</code>
     */
    public Builder setProductId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      productId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string productId = 2;</code>
     */
    public Builder clearProductId() {
      
      productId_ = getDefaultInstance().getProductId();
      onChanged();
      return this;
    }
    /**
     * <code>string productId = 2;</code>
     */
    public Builder setProductIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      productId_ = value;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest)
  }

  // @@protoc_insertion_point(class_scope:dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest)
  private static final dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest();
  }

  public static dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetInfectedProductAndAnimalRequest>
      PARSER = new com.google.protobuf.AbstractParser<GetInfectedProductAndAnimalRequest>() {
    public GetInfectedProductAndAnimalRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new GetInfectedProductAndAnimalRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetInfectedProductAndAnimalRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetInfectedProductAndAnimalRequest> getParserForType() {
    return PARSER;
  }

  public dk.via.sdj3_kursusopgave_part2.GetInfectedProductAndAnimalRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

