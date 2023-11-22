// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: FactoryService.proto

package dk.via.sdj3_kursusopgave_part2;

/**
 * Protobuf type {@code dk.via.sdj3_kursusopgave_part2.AnimalList}
 */
public  final class AnimalList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:dk.via.sdj3_kursusopgave_part2.AnimalList)
    AnimalListOrBuilder {
  // Use AnimalList.newBuilder() to construct.
  private AnimalList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AnimalList() {
    animalId_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private AnimalList(
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
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              animalId_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            animalId_.add(s);
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
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        animalId_ = animalId_.getUnmodifiableView();
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return dk.via.sdj3_kursusopgave_part2.FactoryServiceOuterClass.internal_static_dk_via_sdj3_kursusopgave_part2_AnimalList_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return dk.via.sdj3_kursusopgave_part2.FactoryServiceOuterClass.internal_static_dk_via_sdj3_kursusopgave_part2_AnimalList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            dk.via.sdj3_kursusopgave_part2.AnimalList.class, dk.via.sdj3_kursusopgave_part2.AnimalList.Builder.class);
  }

  public static final int ANIMALID_FIELD_NUMBER = 1;
  private com.google.protobuf.LazyStringList animalId_;
  /**
   * <code>repeated string animalId = 1;</code>
   */
  public com.google.protobuf.ProtocolStringList
      getAnimalIdList() {
    return animalId_;
  }
  /**
   * <code>repeated string animalId = 1;</code>
   */
  public int getAnimalIdCount() {
    return animalId_.size();
  }
  /**
   * <code>repeated string animalId = 1;</code>
   */
  public java.lang.String getAnimalId(int index) {
    return animalId_.get(index);
  }
  /**
   * <code>repeated string animalId = 1;</code>
   */
  public com.google.protobuf.ByteString
      getAnimalIdBytes(int index) {
    return animalId_.getByteString(index);
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
    for (int i = 0; i < animalId_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, animalId_.getRaw(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < animalId_.size(); i++) {
        dataSize += computeStringSizeNoTag(animalId_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getAnimalIdList().size();
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
    if (!(obj instanceof dk.via.sdj3_kursusopgave_part2.AnimalList)) {
      return super.equals(obj);
    }
    dk.via.sdj3_kursusopgave_part2.AnimalList other = (dk.via.sdj3_kursusopgave_part2.AnimalList) obj;

    boolean result = true;
    result = result && getAnimalIdList()
        .equals(other.getAnimalIdList());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getAnimalIdCount() > 0) {
      hash = (37 * hash) + ANIMALID_FIELD_NUMBER;
      hash = (53 * hash) + getAnimalIdList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static dk.via.sdj3_kursusopgave_part2.AnimalList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dk.via.sdj3_kursusopgave_part2.AnimalList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dk.via.sdj3_kursusopgave_part2.AnimalList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dk.via.sdj3_kursusopgave_part2.AnimalList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dk.via.sdj3_kursusopgave_part2.AnimalList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dk.via.sdj3_kursusopgave_part2.AnimalList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dk.via.sdj3_kursusopgave_part2.AnimalList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static dk.via.sdj3_kursusopgave_part2.AnimalList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static dk.via.sdj3_kursusopgave_part2.AnimalList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static dk.via.sdj3_kursusopgave_part2.AnimalList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static dk.via.sdj3_kursusopgave_part2.AnimalList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static dk.via.sdj3_kursusopgave_part2.AnimalList parseFrom(
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
  public static Builder newBuilder(dk.via.sdj3_kursusopgave_part2.AnimalList prototype) {
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
   * Protobuf type {@code dk.via.sdj3_kursusopgave_part2.AnimalList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:dk.via.sdj3_kursusopgave_part2.AnimalList)
      dk.via.sdj3_kursusopgave_part2.AnimalListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return dk.via.sdj3_kursusopgave_part2.FactoryServiceOuterClass.internal_static_dk_via_sdj3_kursusopgave_part2_AnimalList_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return dk.via.sdj3_kursusopgave_part2.FactoryServiceOuterClass.internal_static_dk_via_sdj3_kursusopgave_part2_AnimalList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              dk.via.sdj3_kursusopgave_part2.AnimalList.class, dk.via.sdj3_kursusopgave_part2.AnimalList.Builder.class);
    }

    // Construct using dk.via.sdj3_kursusopgave_part2.AnimalList.newBuilder()
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
      animalId_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return dk.via.sdj3_kursusopgave_part2.FactoryServiceOuterClass.internal_static_dk_via_sdj3_kursusopgave_part2_AnimalList_descriptor;
    }

    public dk.via.sdj3_kursusopgave_part2.AnimalList getDefaultInstanceForType() {
      return dk.via.sdj3_kursusopgave_part2.AnimalList.getDefaultInstance();
    }

    public dk.via.sdj3_kursusopgave_part2.AnimalList build() {
      dk.via.sdj3_kursusopgave_part2.AnimalList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public dk.via.sdj3_kursusopgave_part2.AnimalList buildPartial() {
      dk.via.sdj3_kursusopgave_part2.AnimalList result = new dk.via.sdj3_kursusopgave_part2.AnimalList(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        animalId_ = animalId_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.animalId_ = animalId_;
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
      if (other instanceof dk.via.sdj3_kursusopgave_part2.AnimalList) {
        return mergeFrom((dk.via.sdj3_kursusopgave_part2.AnimalList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(dk.via.sdj3_kursusopgave_part2.AnimalList other) {
      if (other == dk.via.sdj3_kursusopgave_part2.AnimalList.getDefaultInstance()) return this;
      if (!other.animalId_.isEmpty()) {
        if (animalId_.isEmpty()) {
          animalId_ = other.animalId_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureAnimalIdIsMutable();
          animalId_.addAll(other.animalId_);
        }
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
      dk.via.sdj3_kursusopgave_part2.AnimalList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (dk.via.sdj3_kursusopgave_part2.AnimalList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.LazyStringList animalId_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureAnimalIdIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        animalId_ = new com.google.protobuf.LazyStringArrayList(animalId_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string animalId = 1;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getAnimalIdList() {
      return animalId_.getUnmodifiableView();
    }
    /**
     * <code>repeated string animalId = 1;</code>
     */
    public int getAnimalIdCount() {
      return animalId_.size();
    }
    /**
     * <code>repeated string animalId = 1;</code>
     */
    public java.lang.String getAnimalId(int index) {
      return animalId_.get(index);
    }
    /**
     * <code>repeated string animalId = 1;</code>
     */
    public com.google.protobuf.ByteString
        getAnimalIdBytes(int index) {
      return animalId_.getByteString(index);
    }
    /**
     * <code>repeated string animalId = 1;</code>
     */
    public Builder setAnimalId(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureAnimalIdIsMutable();
      animalId_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string animalId = 1;</code>
     */
    public Builder addAnimalId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureAnimalIdIsMutable();
      animalId_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string animalId = 1;</code>
     */
    public Builder addAllAnimalId(
        java.lang.Iterable<java.lang.String> values) {
      ensureAnimalIdIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, animalId_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string animalId = 1;</code>
     */
    public Builder clearAnimalId() {
      animalId_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string animalId = 1;</code>
     */
    public Builder addAnimalIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureAnimalIdIsMutable();
      animalId_.add(value);
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


    // @@protoc_insertion_point(builder_scope:dk.via.sdj3_kursusopgave_part2.AnimalList)
  }

  // @@protoc_insertion_point(class_scope:dk.via.sdj3_kursusopgave_part2.AnimalList)
  private static final dk.via.sdj3_kursusopgave_part2.AnimalList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new dk.via.sdj3_kursusopgave_part2.AnimalList();
  }

  public static dk.via.sdj3_kursusopgave_part2.AnimalList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AnimalList>
      PARSER = new com.google.protobuf.AbstractParser<AnimalList>() {
    public AnimalList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new AnimalList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AnimalList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AnimalList> getParserForType() {
    return PARSER;
  }

  public dk.via.sdj3_kursusopgave_part2.AnimalList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

