package it.fabrick.test.utils;

import it.fabrick.test.autogen.external.dto.Account;
import it.fabrick.test.autogen.external.dto.Creditor;
import it.fabrick.test.autogen.external.dto.TransferInfos;
import it.fabrick.test.autogen.internal.dtos.PaymentRequest;
import it.fabrick.test.model.dtos.HistoryTransaction;
import it.fabrick.test.model.entities.HistoryTransactionEntity;
import it.fabrick.test.model.entities.HistoryTransactionTypeEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class MapperUtils {

    public static TransferInfos paymentRequestToTransferInfos(PaymentRequest paymentRequest) {

        return new TransferInfos()
                .creditor(new Creditor()
                        .name(paymentRequest.getCreditor().getName())
                        .account(new Account().accountCode(paymentRequest.getCreditor().getAccount().getAccountCode())))
                .executionDate(LocalDate.now().plusDays(1))
                .description(paymentRequest.getDescription())
                .amount(paymentRequest.getAmount())
                .currency(paymentRequest.getCurrency());
    }

    public static List<HistoryTransactionEntity> historyDtoListToHistoryEntityList(List<HistoryTransaction> historyTransactions) {

        if(Objects.isNull(historyTransactions) || historyTransactions.isEmpty())
            return new ArrayList<>();
        else
            return historyTransactions.stream().map(MapperUtils::historyDtoToHistoryEntity).toList();
    }

    private static HistoryTransactionEntity historyDtoToHistoryEntity(HistoryTransaction historyTransaction) {

        HistoryTransactionTypeEntity historyTransactionTypeEntity = new HistoryTransactionTypeEntity();

        historyTransactionTypeEntity.setEnumeration(historyTransaction.getType().getEnumeration());
        historyTransactionTypeEntity.setValue(historyTransaction.getType().getValue());

        HistoryTransactionEntity historyTransactionEntity = new HistoryTransactionEntity();

        historyTransactionEntity.setTransactionId(historyTransaction.getTransactionId());
        historyTransactionEntity.setAmount(historyTransaction.getAmount());
        historyTransactionEntity.setCurrency(historyTransaction.getCurrency());
        historyTransactionEntity.setType(historyTransactionTypeEntity);
        historyTransactionEntity.setDescription(historyTransaction.getDescription());
        historyTransactionEntity.setCurrency(historyTransaction.getCurrency());
        historyTransactionEntity.setAccountingDate(historyTransaction.getAccountingDate());
        historyTransactionEntity.setValueDate(historyTransaction.getValueDate());

        return historyTransactionEntity;
    }
}
