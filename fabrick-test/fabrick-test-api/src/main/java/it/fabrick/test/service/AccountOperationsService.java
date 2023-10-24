package it.fabrick.test.service;

import it.fabrick.test.autogen.internal.dtos.PaymentRequest;

import java.time.LocalDate;

public interface AccountOperationsService {

    String getBalance(Long accountId, String xTimeZone, String authSchema, String apikey);

    String getHistoryTransaction(Long accountId, LocalDate fromDate, LocalDate toDate, String xTimeZone, String authSchema, String apikey);

    String requestMoneyTransfer(Long accountId, String xTimeZone, String authSchema, String apikey, PaymentRequest paymentRequest);
}
