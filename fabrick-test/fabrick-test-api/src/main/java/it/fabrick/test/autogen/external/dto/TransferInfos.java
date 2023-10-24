package it.fabrick.test.autogen.external.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import it.fabrick.test.autogen.external.dto.Creditor;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * TransferInfos
 */

@JsonTypeName("transferInfos")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-23T13:11:51.228339100+02:00[Europe/Rome]")
public class TransferInfos {

  private Creditor creditor;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate executionDate;

  private String description;

  private Float amount;

  private String currency;

  public TransferInfos creditor(Creditor creditor) {
    this.creditor = creditor;
    return this;
  }

  /**
   * Get creditor
   * @return creditor
  */
  @Valid 
  @Schema(name = "creditor", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("creditor")
  public Creditor getCreditor() {
    return creditor;
  }

  public void setCreditor(Creditor creditor) {
    this.creditor = creditor;
  }

  public TransferInfos executionDate(LocalDate executionDate) {
    this.executionDate = executionDate;
    return this;
  }

  /**
   * Get executionDate
   * @return executionDate
  */
  @Valid 
  @Schema(name = "executionDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("executionDate")
  public LocalDate getExecutionDate() {
    return executionDate;
  }

  public void setExecutionDate(LocalDate executionDate) {
    this.executionDate = executionDate;
  }

  public TransferInfos description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  
  @Schema(name = "description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TransferInfos amount(Float amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  */
  
  @Schema(name = "amount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("amount")
  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public TransferInfos currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
  */
  
  @Schema(name = "currency", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currency")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransferInfos transferInfos = (TransferInfos) o;
    return Objects.equals(this.creditor, transferInfos.creditor) &&
        Objects.equals(this.executionDate, transferInfos.executionDate) &&
        Objects.equals(this.description, transferInfos.description) &&
        Objects.equals(this.amount, transferInfos.amount) &&
        Objects.equals(this.currency, transferInfos.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creditor, executionDate, description, amount, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransferInfos {\n");
    sb.append("    creditor: ").append(toIndentedString(creditor)).append("\n");
    sb.append("    executionDate: ").append(toIndentedString(executionDate)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

