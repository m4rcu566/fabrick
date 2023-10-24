package it.fabrick.test.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Debtor {

  private String name;

  private Account account;

  public Debtor name(String name) {
    this.name = name;
    return this;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Debtor account(Account account) {
    this.account = account;
    return this;
  }

  @JsonProperty("account")
  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Debtor debtor = (Debtor) o;
    return Objects.equals(this.name, debtor.name) &&
        Objects.equals(this.account, debtor.account);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Debtor {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
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

