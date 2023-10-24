package it.fabrick.test.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "history_transaction_type")
public class HistoryTransactionTypeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_type")
    private Long idType;
    @Column(name="enumeration")
    private String enumeration;
    @Column(name="value_enum", unique = true)
    private String value;

    public Long getIdType() {
        return idType;
    }

    public void setIdType(Long idType) {
        this.idType = idType;
    }

    public String getEnumeration() {
        return enumeration;
    }

    public void setEnumeration(String enumeration) {
        this.enumeration = enumeration;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
