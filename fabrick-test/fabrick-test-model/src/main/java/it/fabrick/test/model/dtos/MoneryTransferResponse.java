package it.fabrick.test.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MoneryTransferResponse {

  private String moneyTransferId;

  private String cro;

  private String trn;

  private String status;

  private String uri;

  private String direction;

  private Debtor debtor;

  private Creditor creditor;

  private String feeAccountId;

  private String description;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdDatetime;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime accountedDatetime;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate debtorValueDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate creditorValueDate;

  private Amount amount;

  private Boolean urgent;

  private Boolean instant;

  private String feeType;

  private List<String> fees;

  private Boolean hasTaxRelief;

  public MoneryTransferResponse moneyTransferId(String moneyTransferId) {
    this.moneyTransferId = moneyTransferId;
    return this;
  }

  @JsonProperty("moneyTransferId")
  public String getMoneyTransferId() {
    return moneyTransferId;
  }

  public void setMoneyTransferId(String moneyTransferId) {
    this.moneyTransferId = moneyTransferId;
  }

  public MoneryTransferResponse cro(String cro) {
    this.cro = cro;
    return this;
  }

  @JsonProperty("cro")
  public String getCro() {
    return cro;
  }

  public void setCro(String cro) {
    this.cro = cro;
  }

  public MoneryTransferResponse trn(String trn) {
    this.trn = trn;
    return this;
  }

  @JsonProperty("trn")
  public String getTrn() {
    return trn;
  }

  public void setTrn(String trn) {
    this.trn = trn;
  }

  public MoneryTransferResponse status(String status) {
    this.status = status;
    return this;
  }

  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public MoneryTransferResponse uri(String uri) {
    this.uri = uri;
    return this;
  }

  @JsonProperty("uri")
  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public MoneryTransferResponse direction(String direction) {
    this.direction = direction;
    return this;
  }

  @JsonProperty("direction")
  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public MoneryTransferResponse debtor(Debtor debtor) {
    this.debtor = debtor;
    return this;
  }

  @JsonProperty("debtor")
  public Debtor getDebtor() {
    return debtor;
  }

  public void setDebtor(Debtor debtor) {
    this.debtor = debtor;
  }

  public MoneryTransferResponse creditor(Creditor creditor) {
    this.creditor = creditor;
    return this;
  }

  @JsonProperty("creditor")
  public Creditor getCreditor() {
    return creditor;
  }

  public void setCreditor(Creditor creditor) {
    this.creditor = creditor;
  }

  public MoneryTransferResponse feeAccountId(String feeAccountId) {
    this.feeAccountId = feeAccountId;
    return this;
  }

  @JsonProperty("feeAccountId")
  public String getFeeAccountId() {
    return feeAccountId;
  }

  public void setFeeAccountId(String feeAccountId) {
    this.feeAccountId = feeAccountId;
  }

  public MoneryTransferResponse description(String description) {
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

  public MoneryTransferResponse createdDatetime(OffsetDateTime createdDatetime) {
    this.createdDatetime = createdDatetime;
    return this;
  }

  @JsonProperty("createdDatetime")
  public OffsetDateTime getCreatedDatetime() {
    return createdDatetime;
  }

  public void setCreatedDatetime(OffsetDateTime createdDatetime) {
    this.createdDatetime = createdDatetime;
  }

  public MoneryTransferResponse accountedDatetime(OffsetDateTime accountedDatetime) {
    this.accountedDatetime = accountedDatetime;
    return this;
  }

  @JsonProperty("accountedDatetime")
  public OffsetDateTime getAccountedDatetime() {
    return accountedDatetime;
  }

  public void setAccountedDatetime(OffsetDateTime accountedDatetime) {
    this.accountedDatetime = accountedDatetime;
  }

  public MoneryTransferResponse debtorValueDate(LocalDate debtorValueDate) {
    this.debtorValueDate = debtorValueDate;
    return this;
  }

  @JsonProperty("debtorValueDate")
  public LocalDate getDebtorValueDate() {
    return debtorValueDate;
  }

  public void setDebtorValueDate(LocalDate debtorValueDate) {
    this.debtorValueDate = debtorValueDate;
  }

  public MoneryTransferResponse creditorValueDate(LocalDate creditorValueDate) {
    this.creditorValueDate = creditorValueDate;
    return this;
  }

  @JsonProperty("creditorValueDate")
  public LocalDate getCreditorValueDate() {
    return creditorValueDate;
  }

  public void setCreditorValueDate(LocalDate creditorValueDate) {
    this.creditorValueDate = creditorValueDate;
  }

  public MoneryTransferResponse amount(Amount amount) {
    this.amount = amount;
    return this;
  }

  @JsonProperty("amount")
  public Amount getAmount() {
    return amount;
  }

  public void setAmount(Amount amount) {
    this.amount = amount;
  }

  public MoneryTransferResponse urgent(Boolean urgent) {
    this.urgent = urgent;
    return this;
  }

  @JsonProperty("isUrgent")
  public Boolean getUrgent() {
    return urgent;
  }

  public void setUrgent(Boolean urgent) {
    this.urgent = urgent;
  }

  public MoneryTransferResponse instant(Boolean instant) {
    this.instant = instant;
    return this;
  }

  @JsonProperty("isInstant")
  public Boolean getInstant() {
    return instant;
  }

  public void setInstant(Boolean instant) {
    this.instant = instant;
  }

  public MoneryTransferResponse feeType(String feeType) {
    this.feeType = feeType;
    return this;
  }

  @JsonProperty("feeType")
  public String getFeeType() {
    return feeType;
  }

  public void setFeeType(String feeType) {
    this.feeType = feeType;
  }

  public MoneryTransferResponse fees(List<String> fees) {
    this.fees = fees;
    return this;
  }

  public MoneryTransferResponse addFeesItem(String feesItem) {
    if (this.fees == null) {
      this.fees = new ArrayList<>();
    }
    this.fees.add(feesItem);
    return this;
  }

  @JsonProperty("fees")
  public List<String> getFees() {
    return fees;
  }

  public void setFees(List<String> fees) {
    this.fees = fees;
  }

  public MoneryTransferResponse hasTaxRelief(Boolean hasTaxRelief) {
    this.hasTaxRelief = hasTaxRelief;
    return this;
  }

  @JsonProperty("hasTaxRelief")
  public Boolean getHasTaxRelief() {
    return hasTaxRelief;
  }

  public void setHasTaxRelief(Boolean hasTaxRelief) {
    this.hasTaxRelief = hasTaxRelief;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MoneryTransferResponse moneryTransferResponse = (MoneryTransferResponse) o;
    return Objects.equals(this.moneyTransferId, moneryTransferResponse.moneyTransferId) &&
        Objects.equals(this.cro, moneryTransferResponse.cro) &&
        Objects.equals(this.trn, moneryTransferResponse.trn) &&
        Objects.equals(this.status, moneryTransferResponse.status) &&
        Objects.equals(this.uri, moneryTransferResponse.uri) &&
        Objects.equals(this.direction, moneryTransferResponse.direction) &&
        Objects.equals(this.debtor, moneryTransferResponse.debtor) &&
        Objects.equals(this.creditor, moneryTransferResponse.creditor) &&
        Objects.equals(this.feeAccountId, moneryTransferResponse.feeAccountId) &&
        Objects.equals(this.description, moneryTransferResponse.description) &&
        Objects.equals(this.createdDatetime, moneryTransferResponse.createdDatetime) &&
        Objects.equals(this.accountedDatetime, moneryTransferResponse.accountedDatetime) &&
        Objects.equals(this.debtorValueDate, moneryTransferResponse.debtorValueDate) &&
        Objects.equals(this.creditorValueDate, moneryTransferResponse.creditorValueDate) &&
        Objects.equals(this.amount, moneryTransferResponse.amount) &&
        Objects.equals(this.urgent, moneryTransferResponse.urgent) &&
        Objects.equals(this.instant, moneryTransferResponse.instant) &&
        Objects.equals(this.feeType, moneryTransferResponse.feeType) &&
        Objects.equals(this.fees, moneryTransferResponse.fees) &&
        Objects.equals(this.hasTaxRelief, moneryTransferResponse.hasTaxRelief);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MoneryTransferResponse {\n");
    sb.append("    moneyTransferId: ").append(toIndentedString(moneyTransferId)).append("\n");
    sb.append("    cro: ").append(toIndentedString(cro)).append("\n");
    sb.append("    trn: ").append(toIndentedString(trn)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    debtor: ").append(toIndentedString(debtor)).append("\n");
    sb.append("    creditor: ").append(toIndentedString(creditor)).append("\n");
    sb.append("    feeAccountId: ").append(toIndentedString(feeAccountId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    createdDatetime: ").append(toIndentedString(createdDatetime)).append("\n");
    sb.append("    accountedDatetime: ").append(toIndentedString(accountedDatetime)).append("\n");
    sb.append("    debtorValueDate: ").append(toIndentedString(debtorValueDate)).append("\n");
    sb.append("    creditorValueDate: ").append(toIndentedString(creditorValueDate)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    urgent: ").append(toIndentedString(urgent)).append("\n");
    sb.append("    instant: ").append(toIndentedString(instant)).append("\n");
    sb.append("    feeType: ").append(toIndentedString(feeType)).append("\n");
    sb.append("    fees: ").append(toIndentedString(fees)).append("\n");
    sb.append("    hasTaxRelief: ").append(toIndentedString(hasTaxRelief)).append("\n");
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

