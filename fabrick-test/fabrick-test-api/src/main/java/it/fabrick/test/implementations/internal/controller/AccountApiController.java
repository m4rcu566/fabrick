package it.fabrick.test.implementations.internal.controller;

import it.fabrick.test.autogen.internal.api.AccountOperationsApi;
import it.fabrick.test.autogen.internal.dtos.Error;
import it.fabrick.test.autogen.internal.dtos.ModelApiResponse;
import it.fabrick.test.autogen.internal.dtos.PaymentRequest;
import it.fabrick.test.model.dtos.Balance;
import feign.FeignException;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class AccountApiController implements AccountOperationsApi {

    private final Logger logger = LoggerFactory.getLogger(AccountApiController.class);

    private final String JSON_PAYLOAD_FIELD_EXTRACT = "payload";
    private final String JSON_ERRORS_FIELD_EXTRACT = "errors";

    @Autowired
    private AccountOperationsServiceImpl accountOperationService;

    @Autowired
    private EntityService entityService;

    @Override
    public ResponseEntity<ModelApiResponse> getBalance(Long accountId, String xTimeZone, String authSchema, String apikey) {

        try {
            logger.info("Request balance for: {} account", accountId);

            String response = accountOperationService.getBalance(accountId, xTimeZone, authSchema, apikey);

            Balance balance = (Balance) JsonUtils.stringToObject(response, Balance.class, JSON_PAYLOAD_FIELD_EXTRACT);

            ModelApiResponse modelApiResponse = new ModelApiResponse()
                    .errors(new ArrayList<>())
                    .status(HttpStatus.OK.toString())
                    .payload(balance);

            return ResponseEntity.ok(modelApiResponse);
        } catch (FeignException fe) {

            String responseBody;

            if(fe.responseBody().isPresent()) {
                byte[] responseBodyBytes = fe.responseBody().get().array();
                responseBody = new String(responseBodyBytes);                
            } else {
                responseBody = "Generic error";
            }

            List<Error> response = new ArrayList<>();

            try {
                response = Arrays.asList((Error[]) JsonUtils.stringToObjectArray(responseBody, Error[].class, JSON_ERRORS_FIELD_EXTRACT));
            } catch (Exception e) {
                logger.warn("Error parse object response: {} ", responseBody);
            }

            int numberHttpStatus = fe.status() == -1 ? 400 : fe.status();

            ModelApiResponse modelApiResponse = new ModelApiResponse()
                    .errors(response)
                    .status(HttpStatus.valueOf(numberHttpStatus).toString());

            logger.error("Error code: {} - Error details: {}", numberHttpStatus, responseBody);
            
            return ResponseEntity.badRequest().body(modelApiResponse);
        } catch (Exception e) {
            List<Error> response = new ArrayList<>();
            response.add(new Error().description(e.getMessage()));
            ModelApiResponse modelApiResponse = new ModelApiResponse()
                    .errors(response);

            logger.error("Error code: {} - Error details: {}", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());

            return ResponseEntity.internalServerError().body(modelApiResponse);
        }
    }

    @Override
    public ResponseEntity<ModelApiResponse> getHistoryTransaction(Long accountId, LocalDate fromDate, LocalDate toDate, String xTimeZone, String authSchema, String apikey) {

        try {
            logger.info("Request history transaction for: {} account", accountId);

            String serviceResponse = accountOperationService.getHistoryTransaction(accountId, fromDate, toDate, xTimeZone, authSchema, apikey);

            String jsonHistoryList = JsonUtils.stringToString(serviceResponse, JSON_PAYLOAD_FIELD_EXTRACT);
            List<HistoryTransaction> histories = Arrays.asList((HistoryTransaction[]) JsonUtils.stringToObjectArray(jsonHistoryList, HistoryTransaction[].class, "list"));

            entityService.saveAllHistoryTransaction(histories);

            ModelApiResponse modelApiResponse = new ModelApiResponse()
                    .errors(new ArrayList<>())
                    .status(HttpStatus.OK.toString())
                    .payload(histories);

            return ResponseEntity.ok(modelApiResponse);
        } catch (FeignException fe) {
            String responseBody;

            if(fe.responseBody().isPresent()) {
                byte[] responseBodyBytes = fe.responseBody().get().array();
                responseBody = new String(responseBodyBytes);               
            } else {
                responseBody = "Generic error";
            }

            List<Error> response = new ArrayList<>();

            try {
                response = Arrays.asList((Error[]) JsonUtils.stringToObjectArray(responseBody, Error[].class, JSON_ERRORS_FIELD_EXTRACT));
            } catch (Exception e) {
                logger.warn("Error parse object response: {} ", responseBody);
            }

            int numberHttpStatus = fe.status() == -1 ? 400 : fe.status();

            ModelApiResponse modelApiResponse = new ModelApiResponse()
                    .errors(response)
                    .status(HttpStatus.valueOf(numberHttpStatus).toString());

            logger.error("Error code: {} - Error details: {}", numberHttpStatus, responseBody);
            
            return ResponseEntity.badRequest().body(modelApiResponse);
        } catch (Exception e) {
            List<Error> response = new ArrayList<>();
            response.add(new Error().description(e.getMessage()));
            ModelApiResponse modelApiResponse = new ModelApiResponse()
                    .errors(response);

            logger.error("Error code: {} - Error details: {}", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());

            return ResponseEntity.internalServerError().body(modelApiResponse);
        }
    }

    @Override
    public ResponseEntity<ModelApiResponse> requestMoneyTransfer(Long accountId, String xTimeZone, String authSchema, String apikey, PaymentRequest paymentRequest) {
        try {
            logger.info("Request money transfer for account: {}", accountId);

            String response = accountOperationService.requestMoneyTransfer(accountId, xTimeZone, authSchema, apikey, paymentRequest);

            MoneryTransferResponse moneryTransferResponse = (MoneryTransferResponse)JsonUtils.stringToObject(response, MoneryTransferResponse.class, JSON_PAYLOAD_FIELD_EXTRACT);

            ModelApiResponse modelApiResponse = new ModelApiResponse()
                    .errors(new ArrayList<>())
                    .status(HttpStatus.OK.toString())
                    .payload(moneryTransferResponse);

            return ResponseEntity.ok(modelApiResponse);

        } catch (FeignException fe) {
            String responseBody = "";

            if(fe.responseBody().isPresent()) {
                byte[] responseBodyBytes = fe.responseBody().get().array();
                responseBody = new String(responseBodyBytes);                
            } else {
                responseBody = "Generic error";
            }
            List<Error> response = new ArrayList<>();

            try {
                response = Arrays.asList((Error[]) JsonUtils.stringToObjectArray(responseBody, Error[].class, JSON_ERRORS_FIELD_EXTRACT));
            } catch (Exception e) {
                logger.warn("Error parse object response: {} ", responseBody);
            }

            int numberHttpStatus = fe.status() == -1 ? 400 : fe.status();

            ModelApiResponse modelApiResponse = new ModelApiResponse()
                    .errors(response)
                    .status(HttpStatus.valueOf(numberHttpStatus).toString());

            logger.error("Error code: {} - Error details: {}", fe.status(), responseBody);

            return ResponseEntity.badRequest().body(modelApiResponse);
        } catch (Exception e) {
            List<Error> response = new ArrayList<>();
            response.add(new Error().description(e.getMessage()));
            ModelApiResponse modelApiResponse = new ModelApiResponse()
                    .errors(response);

            logger.error("Error code: {} - Error details: {}", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());

            return ResponseEntity.internalServerError().body(modelApiResponse);
        }
    }

}
