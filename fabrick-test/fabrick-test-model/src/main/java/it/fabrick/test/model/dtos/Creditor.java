package it.fabrick.test.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Creditor {

  private String name;

  private Account account;

  public Creditor name(String name) {
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

  public Creditor account(Account account) {
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
    Creditor creditor = (Creditor) o;
    return Objects.equals(this.name, creditor.name) &&
        Objects.equals(this.account, creditor.account);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Creditor {\n");
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

