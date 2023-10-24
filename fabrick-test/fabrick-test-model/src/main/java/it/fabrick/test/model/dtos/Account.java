package it.fabrick.test.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Account {

  private String accountCode;

  private String bicCode;

  public Account accountCode(String accountCode) {
    this.accountCode = accountCode;
    return this;
  }

  @JsonProperty("accountCode")
  public String getAccountCode() {
    return accountCode;
  }

  public void setAccountCode(String accountCode) {
    this.accountCode = accountCode;
  }

  public Account bicCode(String bicCode) {
    this.bicCode = bicCode;
    return this;
  }

  @JsonProperty("bicCode")
  public String getBicCode() {
    return bicCode;
  }

  public void setBicCode(String bicCode) {
    this.bicCode = bicCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Account account = (Account) o;
    return Objects.equals(this.accountCode, account.accountCode) &&
        Objects.equals(this.bicCode, account.bicCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Account {\n");
    sb.append("    accountCode: ").append(toIndentedString(accountCode)).append("\n");
    sb.append("    bicCode: ").append(toIndentedString(bicCode)).append("\n");
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

