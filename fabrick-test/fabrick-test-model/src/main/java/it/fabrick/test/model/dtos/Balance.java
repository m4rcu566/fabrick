package it.fabrick.test.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

@JsonTypeName("balance")
public class Balance {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;
  private Float balance;
  private Float availableBalance;
  private String currency;

  public Balance date(LocalDate date) {
    this.date = date;
    return this;
  }

  @JsonProperty("date")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Balance balance(Float balance) {
    this.balance = balance;
    return this;
  }

  @JsonProperty("balance")
  public Float getBalance() {
    return balance;
  }

  public void setBalance(Float balance) {
    this.balance = balance;
  }

  public Balance availableBalance(Float availableBalance) {
    this.availableBalance = availableBalance;
    return this;
  }

  @JsonProperty("availableBalance")
  public Float getAvailableBalance() {
    return availableBalance;
  }

  public void setAvailableBalance(Float availableBalance) {
    this.availableBalance = availableBalance;
  }

  public Balance currency(String currency) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Balance balance = (Balance) o;
    return Objects.equals(this.date, balance.date) &&
        Objects.equals(this.balance, balance.balance) &&
        Objects.equals(this.availableBalance, balance.availableBalance) &&
        Objects.equals(this.currency, balance.currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Balance {\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
    sb.append("    availableBalance: ").append(toIndentedString(availableBalance)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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

