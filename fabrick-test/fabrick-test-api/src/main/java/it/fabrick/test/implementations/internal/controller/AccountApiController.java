package it.fabrick.test.implementations.internal.controller;

import it.fabrick.test.autogen.internal.api.AccountOperationsApi;
import it.fabrick.test.autogen.internal.dtos.ModelApiResponse;
import it.fabrick.test.autogen.internal.dtos.PaymentRequest;
import it.fabrick.test.model.dtos.Balance;
import it.fabrick.test.model.dtos.HistoryTransaction;
import it.fabrick.test.model.dtos.MoneryTransferResponse;
import it.fabrick.test.service.impl.AccountOperationsServiceImpl;
import it.fabrick.test.service.impl.EntityService;
import it.fabrick.test.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping(value = "/api/test/v1/account")
public class AccountApiController implements AccountOperationsApi {

    private final Logger logger = LoggerFactory.getLogger(AccountApiController.class);

    private final String JSON_PAYLOAD_FIELD_EXTRACT = "payload";

    @Autowired
    private AccountOperationsServiceImpl accountOperationService;

    @Autowired
    private EntityService entityService;


    @Override
    public ResponseEntity<ModelApiResponse> getBalance(Long accountId) {

        logger.info("Request balance for: {} account", accountId);

        String response = accountOperationService.getBalance(accountId);

        Balance balance = new Balance();
        try {
            balance = (Balance) JsonUtils.stringToObject(response, Balance.class, JSON_PAYLOAD_FIELD_EXTRACT);
        } catch (Exception e) {
            logger.error("Error to parse response object");
        }

        ModelApiResponse modelApiResponse = new ModelApiResponse()
                .errors(new ArrayList<>())
                .status(HttpStatus.OK.toString())
                .payload(balance);

        return ResponseEntity.ok(modelApiResponse);

    }

    @Override
    public ResponseEntity<ModelApiResponse> getHistoryTransaction(Long accountId, LocalDate fromDate, LocalDate toDate) {

        logger.info("Request history transaction for: {} account", accountId);

        String serviceResponse = accountOperationService.getHistoryTransaction(accountId, fromDate, toDate);
        List<HistoryTransaction> histories = new ArrayList<>();
        try {
            histories = Arrays.asList((HistoryTransaction[]) JsonUtils.
                    stringToObjectArray(JsonUtils.stringToString(serviceResponse, JSON_PAYLOAD_FIELD_EXTRACT), HistoryTransaction[].class, "list"));
        } catch (Exception e) {
            logger.error("Error to parse response object");
        }
        entityService.saveAllHistoryTransaction(histories, accountId);

        ModelApiResponse modelApiResponse = new ModelApiResponse()
                .errors(new ArrayList<>())
                .status(HttpStatus.OK.toString())
                .payload(histories);

        return ResponseEntity.ok(modelApiResponse);

    }

    @Override
    public ResponseEntity<ModelApiResponse> requestMoneyTransfer(Long accountId, PaymentRequest paymentRequest) {

        logger.info("Request money transfer for account: {}", accountId);

        String response = accountOperationService.requestMoneyTransfer(accountId, paymentRequest);
        MoneryTransferResponse moneryTransferResponse = new MoneryTransferResponse();
        try {
            moneryTransferResponse = (MoneryTransferResponse) JsonUtils.stringToObject(response, MoneryTransferResponse.class, JSON_PAYLOAD_FIELD_EXTRACT);
        } catch (Exception e) {
            logger.error("Error to parse response object");
        }
        ModelApiResponse modelApiResponse = new ModelApiResponse()
                .errors(new ArrayList<>())
                .status(HttpStatus.OK.toString())
                .payload(moneryTransferResponse);

        return ResponseEntity.ok(modelApiResponse);


    }

}
