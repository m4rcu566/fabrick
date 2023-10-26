package it.fabrick.test.service.impl;

import it.fabrick.test.autogen.external.dto.TransferInfos;
import it.fabrick.test.autogen.internal.dtos.PaymentRequest;
import it.fabrick.test.implementations.external.feigninterface.FeignAccountApiInterface;
import it.fabrick.test.properties.FabrickApiProperties;
import it.fabrick.test.service.AccountOperationsService;
import it.fabrick.test.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AccountOperationsServiceImpl implements AccountOperationsService {

    @Autowired
    private FeignAccountApiInterface feignAccountApiInterface;

    @Autowired
    private FabrickApiProperties fabrickApiProperties;

    @Override
    public String getBalance(Long accountId) {

        return feignAccountApiInterface.getBalance(accountId, fabrickApiProperties.getxTimeZone(), fabrickApiProperties.getAuthSchema(), fabrickApiProperties.getApiKey()).getBody();
    }

    @Override
    public String getHistoryTransaction(Long accountId, LocalDate fromDate, LocalDate toDate){

      return feignAccountApiInterface.getTransactions(accountId, fromDate, toDate, fabrickApiProperties.getxTimeZone(), fabrickApiProperties.getAuthSchema(), fabrickApiProperties.getApiKey()).getBody();
    }

    @Override
    public String requestMoneyTransfer(Long accountId, PaymentRequest paymentRequest) {

        TransferInfos transferInfos = MapperUtils.paymentRequestToTransferInfos(paymentRequest);

        return feignAccountApiInterface.createMoneyTransfer(accountId, fabrickApiProperties.getxTimeZone(), fabrickApiProperties.getAuthSchema(), fabrickApiProperties.getApiKey(), transferInfos).getBody();
    }
}
