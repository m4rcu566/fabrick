package it.fabrick.test.service.impl;

import it.fabrick.test.autogen.external.dto.TransferInfos;
import it.fabrick.test.autogen.internal.dtos.PaymentRequest;
import it.fabrick.test.implementations.external.feigninterface.FeignAccountApiInterface;
import it.fabrick.test.service.AccountOperationsService;
import it.fabrick.test.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AccountOperationsServiceImpl implements AccountOperationsService {

    @Autowired
    private FeignAccountApiInterface feignAccountApiInterface;

    @Override
    public String getBalance(Long accountId, String xTimeZone, String authSchema, String apikey) {

        return feignAccountApiInterface.getBalance(accountId, xTimeZone, authSchema, apikey).getBody();
    }

    @Override
    public String getHistoryTransaction(Long accountId, LocalDate fromDate, LocalDate toDate, String xTimeZone, String authSchema, String apikey){

      return feignAccountApiInterface.getTransactions(accountId, fromDate, toDate, xTimeZone, authSchema, apikey).getBody();
    }

    @Override
    public String requestMoneyTransfer(Long accountId, String xTimeZone, String authSchema, String apikey, PaymentRequest paymentRequest) {

        TransferInfos transferInfos = MapperUtils.paymentRequestToTransferInfos(paymentRequest);

        String responseTransfer = feignAccountApiInterface.createMoneyTransfer(accountId, xTimeZone, authSchema, apikey, transferInfos).getBody();
        return responseTransfer;
    }
}
