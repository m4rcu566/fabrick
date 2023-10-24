package it.fabrick.test.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

@JsonTypeName("historyTransaction")
public class HistoryTransaction {

  private String transactionId;
  private String operationId;
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate accountingDate;
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate valueDate;
  private HistoryTransactionType type;
  private Float amount;
  private String currency;
  private String description;

  public HistoryTransaction transactionId(String transactionId) {
    this.transactionId = transactionId;
    return this;
  }

  @JsonProperty("transactionId")
  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public HistoryTransaction operationId(String operationId) {
    this.operationId = operationId;
    return this;
  }

  @JsonProperty("operationId")
  public String getOperationId() {
    return operationId;
  }

  public void setOperationId(String operationId) {
    this.operationId = operationId;
  }

  public HistoryTransaction accountingDate(LocalDate accountingDate) {
    this.accountingDate = accountingDate;
    return this;
  }

  @JsonProperty("accountingDate")
  public LocalDate getAccountingDate() {
    return accountingDate;
  }

  public void setAccountingDate(LocalDate accountingDate) {
    this.accountingDate = accountingDate;
  }

  public HistoryTransaction valueDate(LocalDate valueDate) {
    this.valueDate = valueDate;
    return this;
  }

  @JsonProperty("valueDate")
  public LocalDate getValueDate() {
    return valueDate;
  }

  public void setValueDate(LocalDate valueDate) {
    this.valueDate = valueDate;
  }

  public HistoryTransaction type(HistoryTransactionType type) {
    this.type = type;
    return this;
  }

  @JsonProperty("type")
  public HistoryTransactionType getType() {
    return type;
  }

  public void setType(HistoryTransactionType type) {
    this.type = type;
  }

  public HistoryTransaction amount(Float amount) {
    this.amount = amount;
    return this;
  }

  @JsonProperty("amount")
  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public HistoryTransaction currency(String currency) {
    this.currency = currency;
    return this;
  }

  @JsonProperty("currency")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public HistoryTransaction description(String description) {
    this.description = description;
    return this;
  }

  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HistoryTransaction historyTransaction = (HistoryTransaction) o;
    return Objects.equals(this.transactionId, historyTransaction.transactionId) &&
        Objects.equals(this.operationId, historyTransaction.operationId) &&
        Objects.equals(this.accountingDate, historyTransaction.accountingDate) &&
        Objects.equals(this.valueDate, historyTransaction.valueDate) &&
        Objects.equals(this.type, historyTransaction.type) &&
        Objects.equals(this.amount, historyTransaction.amount) &&
        Objects.equals(this.currency, historyTransaction.currency) &&
        Objects.equals(this.description, historyTransaction.description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HistoryTransaction {\n");
    sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
    sb.append("    operationId: ").append(toIndentedString(operationId)).append("\n");
    sb.append("    accountingDate: ").append(toIndentedString(accountingDate)).append("\n");
    sb.append("    valueDate: ").append(toIndentedString(valueDate)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

