package it.fabrick.test.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

public class Amount {

  private Float debtorAmount;

  private String debtorCurrency;

  private Float creditorAmount;

  private String creditorCurrency;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate creditorCurrencyDate;

  private Float currencyRatio;

  public Amount debtorAmount(Float debtorAmount) {
    this.debtorAmount = debtorAmount;
    return this;
  }

  @JsonProperty("debtorAmount")
  public Float getDebtorAmount() {
    return debtorAmount;
  }

  public void setDebtorAmount(Float debtorAmount) {
    this.debtorAmount = debtorAmount;
  }

  public Amount debtorCurrency(String debtorCurrency) {
    this.debtorCurrency = debtorCurrency;
    return this;
  }

  @JsonProperty("debtorCurrency")
  public String getDebtorCurrency() {
    return debtorCurrency;
  }

  public void setDebtorCurrency(String debtorCurrency) {
    this.debtorCurrency = debtorCurrency;
  }

  public Amount creditorAmount(Float creditorAmount) {
    this.creditorAmount = creditorAmount;
    return this;
  }

  @JsonProperty("creditorAmount")
  public Float getCreditorAmount() {
    return creditorAmount;
  }

  public void setCreditorAmount(Float creditorAmount) {
    this.creditorAmount = creditorAmount;
  }

  public Amount creditorCurrency(String creditorCurrency) {
    this.creditorCurrency = creditorCurrency;
    return this;
  }

  @JsonProperty("creditorCurrency")
  public String getCreditorCurrency() {
    return creditorCurrency;
  }

  public void setCreditorCurrency(String creditorCurrency) {
    this.creditorCurrency = creditorCurrency;
  }

  public Amount creditorCurrencyDate(LocalDate creditorCurrencyDate) {
    this.creditorCurrencyDate = creditorCurrencyDate;
    return this;
  }

  @JsonProperty("creditorCurrencyDate")
  public LocalDate getCreditorCurrencyDate() {
    return creditorCurrencyDate;
  }

  public void setCreditorCurrencyDate(LocalDate creditorCurrencyDate) {
    this.creditorCurrencyDate = creditorCurrencyDate;
  }

  public Amount currencyRatio(Float currencyRatio) {
    this.currencyRatio = currencyRatio;
    return this;
  }

  @JsonProperty("currencyRatio")
  public Float getCurrencyRatio() {
    return currencyRatio;
  }

  public void setCurrencyRatio(Float currencyRatio) {
    this.currencyRatio = currencyRatio;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Amount amount = (Amount) o;
    return Objects.equals(this.debtorAmount, amount.debtorAmount) &&
        Objects.equals(this.debtorCurrency, amount.debtorCurrency) &&
        Objects.equals(this.creditorAmount, amount.creditorAmount) &&
        Objects.equals(this.creditorCurrency, amount.creditorCurrency) &&
        Objects.equals(this.creditorCurrencyDate, amount.creditorCurrencyDate) &&
        Objects.equals(this.currencyRatio, amount.currencyRatio);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Amount {\n");
    sb.append("    debtorAmount: ").append(toIndentedString(debtorAmount)).append("\n");
    sb.append("    debtorCurrency: ").append(toIndentedString(debtorCurrency)).append("\n");
    sb.append("    creditorAmount: ").append(toIndentedString(creditorAmount)).append("\n");
    sb.append("    creditorCurrency: ").append(toIndentedString(creditorCurrency)).append("\n");
    sb.append("    creditorCurrencyDate: ").append(toIndentedString(creditorCurrencyDate)).append("\n");
    sb.append("    currencyRatio: ").append(toIndentedString(currencyRatio)).append("\n");
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

