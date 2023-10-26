package it.fabrick.test.service;

import it.fabrick.test.autogen.internal.dtos.PaymentRequest;

import java.time.LocalDate;

public interface AccountOperationsService {

    String getBalance(Long accountId);

    String getHistoryTransaction(Long accountId, LocalDate fromDate, LocalDate toDate);

    String requestMoneyTransfer(Long accountId, PaymentRequest paymentRequest);
}
