package it.fabrick.test.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "history_transaction")
public class HistoryTransactionEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="transaction_id", unique = true)
    private String transactionId;
    @Column(name="operation_id")
    private String operationId;
    @Column(name="accounting_date")
    private LocalDate accountingDate;
    @Column(name="value_date")
    private LocalDate valueDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_type")
    private HistoryTransactionTypeEntity type;
    @Column(name="amount")
    private Float amount;
    @Column(name="currency")
    private String currency;
    @Column(name="description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public LocalDate getAccountingDate() {
        return accountingDate;
    }

    public void setAccountingDate(LocalDate accountingDate) {
        this.accountingDate = accountingDate;
    }

    public LocalDate getValueDate() {
        return valueDate;
    }

    public void setValueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HistoryTransactionTypeEntity getType() {
        return type;
    }

    public void setType(HistoryTransactionTypeEntity type) {
        this.type = type;
    }
}
