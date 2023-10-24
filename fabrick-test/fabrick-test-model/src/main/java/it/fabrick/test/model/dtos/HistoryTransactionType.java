package it.fabrick.test.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Objects;

@JsonTypeName("historyTransaction_type")
public class HistoryTransactionType {

  private String enumeration;

  private String value;

  public HistoryTransactionType enumeration(String enumeration) {
    this.enumeration = enumeration;
    return this;
  }

  @JsonProperty("enumeration")
  public String getEnumeration() {
    return enumeration;
  }

  public void setEnumeration(String enumeration) {
    this.enumeration = enumeration;
  }

  public HistoryTransactionType value(String value) {
    this.value = value;
    return this;
  }

  @JsonProperty("value")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HistoryTransactionType historyTransactionType = (HistoryTransactionType) o;
    return Objects.equals(this.enumeration, historyTransactionType.enumeration) &&
        Objects.equals(this.value, historyTransactionType.value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HistoryTransactionType {\n");
    sb.append("    enumeration: ").append(toIndentedString(enumeration)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

