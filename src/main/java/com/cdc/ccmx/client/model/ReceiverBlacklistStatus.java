package com.cdc.ccmx.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
@JsonAdapter(ReceiverBlacklistStatus.Adapter.class)
public enum ReceiverBlacklistStatus {
  
  PRESUMED("presumed"),
  
  DISMISSED("dismissed"),
  
  DEFINITIVE("definitive"),
  
  FAVORABLE("favorable");
  private String value;
  ReceiverBlacklistStatus(String value) {
    this.value = value;
  }
  public String getValue() {
    return value;
  }
  @Override
  public String toString() {
    return String.valueOf(value);
  }
  public static ReceiverBlacklistStatus fromValue(String text) {
    for (ReceiverBlacklistStatus b : ReceiverBlacklistStatus.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
  public static class Adapter extends TypeAdapter<ReceiverBlacklistStatus> {
    @Override
    public void write(final JsonWriter jsonWriter, final ReceiverBlacklistStatus enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }
    @Override
    public ReceiverBlacklistStatus read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return ReceiverBlacklistStatus.fromValue(String.valueOf(value));
    }
  }
}
