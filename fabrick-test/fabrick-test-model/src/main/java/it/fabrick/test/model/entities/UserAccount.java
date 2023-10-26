package it.fabrick.test.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class UserAccount {

    @Id
    @Column(name="account_id")
    private Long accountId;

    /*
        any other attributes
     */

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
