package it.fabrick.test.impl.internal.controller;

import feign.FeignException;
import feign.Request;
import feign.Response;
import it.fabrick.test.BaseControllerTest;
import it.fabrick.test.autogen.external.dto.TransferInfos;
import it.fabrick.test.autogen.internal.dtos.Account;
import it.fabrick.test.autogen.internal.dtos.Creditor;
import it.fabrick.test.autogen.internal.dtos.Error;
import it.fabrick.test.autogen.internal.dtos.PaymentRequest;
import it.fabrick.test.implementations.external.feigninterface.FeignAccountApiInterface;
import it.fabrick.test.model.dtos.MoneryTransferResponse;
import it.fabrick.test.utils.JsonUtilsTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RequestMoneyTransferTest extends BaseControllerTest {
    @MockBean
    private FeignAccountApiInterface feignAccountApiInterface;

    @Test
    public void requestMoneyTransferOk() throws Exception {

        String feignResponseMocked = mockResponseFeign();

        MoneryTransferResponse mockResponseFeign = (MoneryTransferResponse) JsonUtilsTest.stringToObject(feignResponseMocked, MoneryTransferResponse.class, "payload");

        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setCreditor(new Creditor()
                .name("Marzio Rossi")
                .account(new Account().accountCode("code")));

        Mockito.when(feignAccountApiInterface.createMoneyTransfer(anyLong(), anyString(), anyString(), anyString(), any(TransferInfos.class)))
                .thenReturn(ResponseEntity.ok(feignResponseMocked));

        String mockResponse = mockMvc.perform(post("/api/test/account/{accountId}/payments/money-transfers", 14537780)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(JsonUtilsTest.objectToString(paymentRequest)))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        MoneryTransferResponse moneryTransferResponse = (MoneryTransferResponse) JsonUtilsTest.stringToObject(mockResponse, MoneryTransferResponse.class, "payload");

        assertNotNull(moneryTransferResponse);
        assertEquals(mockResponseFeign.getCreditor().getName(), moneryTransferResponse.getCreditor().getName());

    }

    @Test
    public void requestMoneyTransferKoErrorNotPermitted() throws Exception {

        String aspectErroreCode = "API000";

        Mockito.when(feignAccountApiInterface.createMoneyTransfer(anyLong(), anyString(), anyString(), anyString(), any(TransferInfos.class)))
                .thenThrow(FeignException.errorStatus("Method Name", Response.builder()
                        .status(400)
                        .reason("Bad Request")
                        .request(Request
                                .create(Request.HttpMethod.GET, "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers", new HashMap<>(), null, null, null))
                        .body(mockResponseFeignError().getBytes())
                        .build()));

        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setCreditor(new Creditor()
                .name("Marzio Rossi")
                .account(new Account().accountCode("code")));

        String mockResponse = mockMvc.perform(post("/api/test/account/{accountId}/payments/money-transfers", 14537780)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(JsonUtilsTest.objectToString(paymentRequest)))
                .andExpect(status().is4xxClientError())
                .andReturn()
                .getResponse()
                .getContentAsString();

        List<Error> errors = Arrays.asList((Error[]) JsonUtilsTest.stringToObjectArray(mockResponse, Error[].class, "errors"));

        assertNotNull(errors);
        errors.stream().forEach(a->assertEquals(aspectErroreCode, a.getCode()));
    }

    private String mockResponseFeign() {
        return "{\n" +
                "    \"status\": \"OK\",\n" +
                "    \"errors\": [],\n" +
                "    \"payload\": {\n" +
                "        \"moneyTransferId\": \"488830304\",\n" +
                "        \"cro\": \"8771316910703268\",\n" +
                "        \"trn\": \"\",\n" +
                "        \"status\": \"BOOKED\",\n" +
                "        \"uri\": \"NOTPROVIDED\",\n" +
                "        \"direction\": \"OUTGOING\",\n" +
                "        \"debtor\": {\n" +
                "            \"name\": \"LUCA TERRIBILE\",\n" +
                "            \"account\": {\n" +
                "                \"accountCode\": \"IT40L0326822311052923800661\",\n" +
                "                \"bicCode\": null\n" +
                "            }\n" +
                "        },\n" +
                "        \"creditor\": {\n" +
                "            \"name\": \"JOHN DOE\",\n" +
                "            \"account\": {\n" +
                "                \"accountCode\": \"IT52K0300203280422651138253\",\n" +
                "                \"bicCode\": \"UNCRITMMXXX\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"feeAccountId\": \"14537780\",\n" +
                "        \"description\": \"PAYMENT INVOICE 75/2017\",\n" +
                "        \"createdDatetime\": \"2023-10-18T09:00:23.136+0200\",\n" +
                "        \"accountedDatetime\": \"\",\n" +
                "        \"debtorValueDate\": \"2023-10-19\",\n" +
                "        \"creditorValueDate\": \"2023-10-20\",\n" +
                "        \"amount\": {\n" +
                "            \"debtorAmount\": 10,\n" +
                "            \"debtorCurrency\": \"EUR\",\n" +
                "            \"creditorAmount\": 10,\n" +
                "            \"creditorCurrency\": \"EUR\",\n" +
                "            \"creditorCurrencyDate\": \"\",\n" +
                "            \"currencyRatio\": 1\n" +
                "        },\n" +
                "        \"isUrgent\": false,\n" +
                "        \"isInstant\": false,\n" +
                "        \"feeType\": \"SHA\",\n" +
                "        \"fees\": [],\n" +
                "        \"hasTaxRelief\": false\n" +
                "    }\n" +
                "}";
    }

    private String mockResponseFeignError() {
        return "{\n" +
                "    \"status\": \"KO\",\n" +
                "    \"errors\": [\n" +
                "        {\n" +
                "            \"code\": \"API000\",\n" +
                "            \"description\": \"Errore tecnico  La condizione BP049 non e' prevista per il conto id 14537780\",\n" +
                "            \"params\": \"\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"payload\": {}\n" +
                "}";
    }
}
