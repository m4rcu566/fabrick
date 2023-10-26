package it.fabrick.test.autogen.internal.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Account
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-26T17:25:55.234849500+02:00[Europe/Rome]")
public class Account {

  private String accountCode;

  private String bicCode;

  public Account() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Account(String accountCode) {
    this.accountCode = accountCode;
  }

  public Account accountCode(String accountCode) {
    this.accountCode = accountCode;
    return this;
  }

  /**
   * Get accountCode
   * @return accountCode
  */
  @NotNull 
  @Schema(name = "accountCode", requiredMode = Schema.RequiredMode.REQUIRED)
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

  /**
   * Get bicCode
   * @return bicCode
  */
  
  @Schema(name = "bicCode", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
  public int hashCode() {
    return Objects.hash(accountCode, bicCode);
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

